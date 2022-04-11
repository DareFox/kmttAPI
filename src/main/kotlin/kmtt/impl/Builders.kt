package kmtt.impl

import kmtt.models.enums.Website
import java.util.concurrent.ConcurrentHashMap

/**
 * Create object of [authenticated API][IAuthKmtt]
 *
 * @param preventClientDuplication
 *
 * Duplication of API objects can lead to rate-limit error.
 * By this parameter you can, instead of creating new objects, get already created objects.
 *
 * Default: **true**
 */
@Synchronized
fun authKmtt(
    website: Website,
    token: String,
    preventClientDuplication: Boolean = true,
): IAuthKmtt {
    val client: IAuthKmtt

    if (preventClientDuplication) {
        // Use double-check lock (https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java)
        client = authClients[website to token] ?: synchronized(publicClients) {
            authClients[website to token] ?: AuthKmtt(website, token).also {
                authClients[website to token] = it
            }
        }
    } else {
        client = AuthKmtt(website, token)
    }

    return client
}

internal val authClients: MutableMap<Pair<Website, String>, IAuthKmtt> = ConcurrentHashMap()


/**
 * Create object of [public API][IPublicKmtt]
 *
 * @param preventClientDuplication
 *
 * Duplication of API objects can lead to rate-limit error.
 * By this parameter you can, instead of creating new objects, get already created objects.
 *
 * Default: **true**
 */
fun publicKmtt(
    website: Website,
    preventClientDuplication: Boolean = true,
): IPublicKmtt {
    val client: IPublicKmtt

    if (preventClientDuplication) {
        // Use double-check lock (https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java)
        client = publicClients[website] ?: synchronized(publicClients) {
            publicClients[website] ?: PublicKmtt(website).also {
                publicClients[website] = it
            }
        }
    } else {
        client = PublicKmtt(website)
    }

    return client
}

internal val publicClients: MutableMap<Website, IPublicKmtt> = ConcurrentHashMap<Website, IPublicKmtt>()
