package kmtt.impl

import kmtt.models.enums.Website
import java.util.concurrent.ConcurrentHashMap

/**
 * Create object of [authenticated API][IAuthKmtt]
 */
fun authKmtt(website: Website, token: String): IAuthKmtt = AuthKmtt(website, token)

internal val publicClients: MutableMap<Website, IPublicKmtt> = ConcurrentHashMap<Website, IPublicKmtt>()

/**
 * Create object of [public API][IPublicKmtt]
 *
 * @param preventClientDuplication
 *
 * Duplication of Public API objects can lead to rate-limit error.
 * By this parameter you can, instead of creating new objects, get already created objects.
 *
 * Default: **true**
 */
fun publicKmtt(
    website: Website,
    preventClientDuplication: Boolean = true,
): IPublicKmtt {
    val client: IPublicKmtt

    if (preventClientDuplication && publicClients.containsKey(website)) {
        client = publicClients[website]!!
    } else {
        client = PublicKmtt(website)
        publicClients[website] = client
    }

    return client
}