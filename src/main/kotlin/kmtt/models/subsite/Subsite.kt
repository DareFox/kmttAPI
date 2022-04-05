/**
 * Osnova API
 *
 * Открытая документация API для [vc.ru](//vc.ru), [DTF](//dtf.ru) и [TJ](//tjournal.ru) ## Ограничения API ## * Не чаще 3-х запросов к API в секунду * Существуют также отдельные ограничения на отправку комментариев, лайков и др. ## Заголовки (headers) ## При запросе к API необходимо передавать поле `User-agent` в формате `{app_name}-app/{app_version} ({device_name}; {os_name}/{os_version}; {locale}; {screen_height}x{screen_width})`. Например: `dtf-app/2.2.0 (Pixel 2; Android/9; ru; 1980x1794)`. Некоторые запросы доступны только для авторизованных пользователей (методы обозначены замком). Для этого необходимо передавать авторизационный токен `X-Device-Token` в заголовку запроса. Он возвращается с сервера при авторизации. Для доступа к тестовым серверам необходимо поле `Authorization`. ## Авторизация по API-токену Как авторизоваться в API используя специальный токен со страницы настроек пользователя 1. Зайти в [свой профиль](https://tjournal.ru/u/me/settings) 2. В самом низу нажать на ссылку «Инструменты для разработчика» 3. Вы увидите токен, с которым можно обращаться к API      [https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba](https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba)  4. Можно использовать этот токен для отправки запросов к API от имени вашего аккаунта ## WebSocket ## `wss://ws.dtf.ru/chan/api`, `wss://ws.vc.ru/chan/api`, `wss://ws.tjournal.ru/chan/api`, `wss://ws.vc.ru/chan/api` - данные о лайках статей и комментариев. Модель отдельного элемента: [#/components/schemas/Websocket](#model-Websocket)  `wss://ws.dtf.ru/chan/content-hits-{entryId}`, `wss://ws.tjournal.ru/chan/content-hits-{entryId}`, `wss://ws.vc.ru/chan/content-hits-{entryId}` - просмотры записи (entryId - id записи)  `wss://ws.dtf.ru/chan/api:comments-{entryId}`, `wss://ws.tjournal.ru/chan/api:comments-{entryId}`, `wss://ws.vc.ru/chan/api:comments-{entryId}` - новые и отредактированные комментарии, оценки комментариев (entryId - id записи)
 *
 * The version of the OpenAPI document: 1.9.0
 * Contact: support@cmtt.ru
 */
package kmtt.models.subsite

import kmtt.models.AdvancedAccess
import kmtt.models.Counters
import kmtt.models.SocialAccount
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param url
 * @param type
 * @param name
 * @param description
 * @param avatarUrl Аватарка профиля
 * @param cover
 * @param isSubscribed
 * @param isVerified
 * @param isUnsubscribable
 * @param subscribersCount
 * @param commentsCount
 * @param entriesCount
 * @param vacanciesCount
 * @param created
 * @param createdRFC
 * @param karma
 * @param socialAccounts Список прикрепленных аккаунтов
 * @param pushTopic Личный топик пользователя в Firebase Messaging
 * @param advancedAccess
 * @param counters
 * @param userHash Хеш ID пользователя. Используется для сравнения данных, где ID захеширован
 * @param contacts
 */

@OptIn(ExperimentalSerializationApi::class)
@kotlinx.serialization.Serializable

data class Subsite(

    @JsonNames("id")
    val id: Long? = null,

    @JsonNames("url")
    val url: String? = null,

    @JsonNames("type")
    val type: Long? = null,

    @JsonNames("name")
    val name: String? = null,

    @JsonNames("description")
    val description: String? = null,

    /* Аватарка профиля */
    @JsonNames("avatar_url")
    val avatarUrl: String? = null,

    @JsonNames("cover")
    val cover: SubsiteCover? = null,

    @JsonNames("is_subscribed")
    val isSubscribed: Boolean? = null,

    @JsonNames("is_verified")
    val isVerified: Boolean? = null,

    @JsonNames("is_unsubscribable")
    val isUnsubscribable: Boolean? = null,

    @JsonNames("subscribers_count")
    val subscribersCount: Int? = null,

    @JsonNames("comments_count")
    val commentsCount: Int? = null,

    @JsonNames("entries_count")
    val entriesCount: Int? = null,

    @JsonNames("vacancies_count")
    val vacanciesCount: Int? = null,

    @JsonNames("created")
    val created: Long? = null,

    @JsonNames("createdRFC")
    val createdRFC: String? = null,

    @JsonNames("karma")
    val karma: Long? = null,

    /* Список прикрепленных аккаунтов */
    @JsonNames("social_accounts")
    val socialAccounts: List<SocialAccount>? = null,

    /* Личный топик пользователя в Firebase Messaging */
    @JsonNames("push_topic")
    val pushTopic: String? = null,

    @JsonNames("advanced_access")
    val advancedAccess: AdvancedAccess? = null,

    @JsonNames("counters")
    val counters: Counters? = null,

    /* Хеш ID пользователя. Используется для сравнения данных, где ID захеширован */
    @JsonNames("user_hash")
    val userHash: String? = null,

    @JsonNames("contacts")
    val contacts: SubsiteContacts? = null,

    )

