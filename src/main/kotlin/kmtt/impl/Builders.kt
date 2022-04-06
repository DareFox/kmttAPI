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

    // TODO: Remove code duplication and delegate builder cache functionality
    if (preventClientDuplication && authClients.containsKey(website to token)) {
        client = authClients[website to token]!!
    } else {
        client = AuthKmtt(website, token)
        authClients[website to token] = client
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
@Synchronized
fun publicKmtt(
    website: Website,
    preventClientDuplication: Boolean = true,
): IPublicKmtt {
    val client: IPublicKmtt

    // TODO: Remove code duplication and delegate builder cache functionality
    if (preventClientDuplication && publicClients.containsKey(website)) {
        client = publicClients[website]!!
    } else {
        client = PublicKmtt(website)
        publicClients[website] = client
    }

    return client
}

internal val publicClients: MutableMap<Website, IPublicKmtt> = ConcurrentHashMap<Website, IPublicKmtt>()
