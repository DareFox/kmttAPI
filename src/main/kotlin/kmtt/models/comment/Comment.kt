/**
 * Osnova API
 *
 * Открытая документация API для [vc.ru](//vc.ru), [DTF](//dtf.ru) и [TJ](//tjournal.ru) ## Ограничения API ## * Не чаще 3-х запросов к API в секунду * Существуют также отдельные ограничения на отправку комментариев, лайков и др. ## Заголовки (headers) ## При запросе к API необходимо передавать поле `User-agent` в формате `{app_name}-app/{app_version} ({device_name}; {os_name}/{os_version}; {locale}; {screen_height}x{screen_width})`. Например: `dtf-app/2.2.0 (Pixel 2; Android/9; ru; 1980x1794)`. Некоторые запросы доступны только для авторизованных пользователей (методы обозначены замком). Для этого необходимо передавать авторизационный токен `X-Device-Token` в заголовку запроса. Он возвращается с сервера при авторизации. Для доступа к тестовым серверам необходимо поле `Authorization`. ## Авторизация по API-токену Как авторизоваться в API используя специальный токен со страницы настроек пользователя 1. Зайти в [свой профиль](https://tjournal.ru/u/me/settings) 2. В самом низу нажать на ссылку «Инструменты для разработчика» 3. Вы увидите токен, с которым можно обращаться к API      [https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba](https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba)  4. Можно использовать этот токен для отправки запросов к API от имени вашего аккаунта ## WebSocket ## `wss://ws.dtf.ru/chan/api`, `wss://ws.vc.ru/chan/api`, `wss://ws.tjournal.ru/chan/api`, `wss://ws.vc.ru/chan/api` - данные о лайках статей и комментариев. Модель отдельного элемента: [#/components/schemas/Websocket](#model-Websocket)  `wss://ws.dtf.ru/chan/content-hits-{entryId}`, `wss://ws.tjournal.ru/chan/content-hits-{entryId}`, `wss://ws.vc.ru/chan/content-hits-{entryId}` - просмотры записи (entryId - id записи)  `wss://ws.dtf.ru/chan/api:comments-{entryId}`, `wss://ws.tjournal.ru/chan/api:comments-{entryId}`, `wss://ws.vc.ru/chan/api:comments-{entryId}` - новые и отредактированные комментарии, оценки комментариев (entryId - id записи)
 *
 * The version of the OpenAPI document: 1.9.0
 * Contact: support@cmtt.ru
 */
package kmtt.models.comment

import kmtt.models.Author
import kmtt.models.EtcControls
import kmtt.models.Likes
import kmtt.models.Media
import kmtt.models.attach.Attach
import kmtt.models.entry.Entry
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param date
 * @param dateRFC
 * @param author
 * @param text текст комментария с html
 * @param textWoMd текст комментария с markdown
 * @param media
 * @param likes
 * @param entry
 * @param replyTo
 * @param isFavorited
 * @param isPinned
 * @param isEdited
 * @param level
 * @param sourceId С какой OS был написан комментарий:   * `0` - Other   * `1` - iOS   * `2` - Android
 * @param loadMore
 * @param attaches
 * @param etcControls
 */

@OptIn(ExperimentalSerializationApi::class)
@kotlinx.serialization.Serializable
data class Comment(

    @JsonNames("id")
    val id: Long? = null,

    @JsonNames("date")
    val date: Long? = null,

    @JsonNames("dateRFC")
    val dateRFC: String? = null,

    @JsonNames("author")
    val author: Author? = null,

    /* текст комментария с html */
    @JsonNames("text")
    val text: String? = null,

    /* текст комментария с markdown */
    @JsonNames("text_wo_md")
    val textWoMd: String? = null,

    @JsonNames("media")
    val media: List<Media>? = null,

    @JsonNames("likes")
    val likes: Likes? = null,

    @JsonNames("entry")
    val entry: Entry? = null,

    @JsonNames("replyTo")
    val replyTo: Int? = null,

    @JsonNames("isFavorited")
    val isFavorited: Boolean? = null,

    @JsonNames("is_pinned")
    val isPinned: Boolean? = null,

    @JsonNames("isEdited")
    val isEdited: Boolean? = null,

    @JsonNames("level")
    val level: Int? = null,

    /* С какой OS был написан комментарий:   * `0` - Other   * `1` - iOS   * `2` - Android  */
    @JsonNames("source_id")
    val sourceId: Int? = null,

    @JsonNames("load_more")
    val loadMore: CommentsLoadMore? = null,

    @JsonNames("attaches")
    val attaches: List<Attach>? = null,

    @JsonNames("etcControls")
    val etcControls: EtcControls? = null,

    )

