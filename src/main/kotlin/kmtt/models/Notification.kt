/**
 * Osnova API
 *
 * Открытая документация API для [vc.ru](//vc.ru), [DTF](//dtf.ru) и [TJ](//tjournal.ru) ## Ограничения API ## * Не чаще 3-х запросов к API в секунду * Существуют также отдельные ограничения на отправку комментариев, лайков и др. ## Заголовки (headers) ## При запросе к API необходимо передавать поле `User-agent` в формате `{app_name}-app/{app_version} ({device_name}; {os_name}/{os_version}; {locale}; {screen_height}x{screen_width})`. Например: `dtf-app/2.2.0 (Pixel 2; Android/9; ru; 1980x1794)`. Некоторые запросы доступны только для авторизованных пользователей (методы обозначены замком). Для этого необходимо передавать авторизационный токен `X-Device-Token` в заголовку запроса. Он возвращается с сервера при авторизации. Для доступа к тестовым серверам необходимо поле `Authorization`. ## Авторизация по API-токену Как авторизоваться в API используя специальный токен со страницы настроек пользователя 1. Зайти в [свой профиль](https://tjournal.ru/u/me/settings) 2. В самом низу нажать на ссылку «Инструменты для разработчика» 3. Вы увидите токен, с которым можно обращаться к API      [https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba](https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba)  4. Можно использовать этот токен для отправки запросов к API от имени вашего аккаунта ## WebSocket ## `wss://ws.dtf.ru/chan/api`, `wss://ws.vc.ru/chan/api`, `wss://ws.tjournal.ru/chan/api`, `wss://ws.vc.ru/chan/api` - данные о лайках статей и комментариев. Модель отдельного элемента: [#/components/schemas/Websocket](#model-Websocket)  `wss://ws.dtf.ru/chan/content-hits-{entryId}`, `wss://ws.tjournal.ru/chan/content-hits-{entryId}`, `wss://ws.vc.ru/chan/content-hits-{entryId}` - просмотры записи (entryId - id записи)  `wss://ws.dtf.ru/chan/api:comments-{entryId}`, `wss://ws.tjournal.ru/chan/api:comments-{entryId}`, `wss://ws.vc.ru/chan/api:comments-{entryId}` - новые и отредактированные комментарии, оценки комментариев (entryId - id записи)
 *
 * The version of the OpenAPI document: 1.9.0
 * Contact: support@cmtt.ru
 */
package kmtt.models

import kmtt.models.subsite.Subsite
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param id
 * @param type
 * @param date
 * @param dateRFC
 * @param users
 * @param text
 * @param commentText
 * @param url
 * @param icon Название иконки, которая подставляется вместо аватарки.
 */

@OptIn(ExperimentalSerializationApi::class)
@kotlinx.serialization.Serializable
data class Notification(

    @JsonNames("id")
    val id: Long? = null,

    @JsonNames("type")
    val type: Int? = null,

    @JsonNames("date")
    val date: Long? = null,

    @JsonNames("dateRFC")
    val dateRFC: String? = null,

    @JsonNames("users")
    val users: List<Subsite>? = null,

    @JsonNames("text")
    val text: String? = null,

    @JsonNames("comment_text")
    val commentText: String? = null,

    @JsonNames("url")
    val url: String? = null,

    /* Название иконки, которая подставляется вместо аватарки. */
    @JsonNames("icon")
    val icon: Icon? = null,

    ) {

    /**
     * Тип уведомления
     */
    @kotlinx.serialization.Serializable
    enum class Type(val value: Int) {
        @JsonNames("2")
        LIKE(2),
        @JsonNames("4")
        REPLY(4),
        @JsonNames("8")
        BANNED(8),
        @JsonNames("1")
        UNPUBLISH(16),
        @JsonNames("3")
        COMMENT(32),
        @JsonNames("6")
        SYSTEM(64),
        @JsonNames("18")
        VACANCY(128);
    }

    /**
     * Название иконки, которая подставляется вместо аватарки.
     */

    @kotlinx.serialization.Serializable
    enum class Icon() {
        @JsonNames("")
        AVATAR(),
        @JsonNames("rouble")
        DONATION(),
        @JsonNames("comment")
        COMMENT(),
        @JsonNames("mini_check")
        CHECKMARK(),
        @JsonNames("comments_added")
        COMMENTS_ADDED(),
        @JsonNames("comments_reply_to")
        COMMENTS_REPLY_TO(),
        @JsonNames("like_up")
        LIKE_UP(),
        @JsonNames("like_down")
        LIKE_DOWN(),
        @JsonNames("ui_chronograph")
        UI_CHRONOGRAPH(),
        @JsonNames("icon-unpublish-entry")
        ICON_MINUS_UNPUBLISH_MINUS_ENTRY(),
        @JsonNames("pencil")
        PENCIL(),
        @JsonNames("ui_archive")
        UI_ARCHIVE(),
        @JsonNames("reply")
        REPLY()
    }
}

