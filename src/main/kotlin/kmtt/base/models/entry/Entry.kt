/**
 * Osnova API
 *
 * Открытая документация API для [vc.ru](//vc.ru), [DTF](//dtf.ru) и [TJ](//tjournal.ru) ## Ограничения API ## * Не чаще 3-х запросов к API в секунду * Существуют также отдельные ограничения на отправку комментариев, лайков и др. ## Заголовки (headers) ## При запросе к API необходимо передавать поле `User-agent` в формате `{app_name}-app/{app_version} ({device_name}; {os_name}/{os_version}; {locale}; {screen_height}x{screen_width})`. Например: `dtf-app/2.2.0 (Pixel 2; Android/9; ru; 1980x1794)`. Некоторые запросы доступны только для авторизованных пользователей (методы обозначены замком). Для этого необходимо передавать авторизационный токен `X-Device-Token` в заголовку запроса. Он возвращается с сервера при авторизации. Для доступа к тестовым серверам необходимо поле `Authorization`. ## Авторизация по API-токену Как авторизоваться в API используя специальный токен со страницы настроек пользователя 1. Зайти в [свой профиль](https://tjournal.ru/u/me/settings) 2. В самом низу нажать на ссылку «Инструменты для разработчика» 3. Вы увидите токен, с которым можно обращаться к API      [https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba](https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba)  4. Можно использовать этот токен для отправки запросов к API от имени вашего аккаунта ## WebSocket ## `wss://ws.dtf.ru/chan/api`, `wss://ws.vc.ru/chan/api`, `wss://ws.tjournal.ru/chan/api`, `wss://ws.vc.ru/chan/api` - данные о лайках статей и комментариев. Модель отдельного элемента: [#/components/schemas/Websocket](#model-Websocket)  `wss://ws.dtf.ru/chan/content-hits-{entryId}`, `wss://ws.tjournal.ru/chan/content-hits-{entryId}`, `wss://ws.vc.ru/chan/content-hits-{entryId}` - просмотры записи (entryId - id записи)  `wss://ws.dtf.ru/chan/api:comments-{entryId}`, `wss://ws.tjournal.ru/chan/api:comments-{entryId}`, `wss://ws.vc.ru/chan/api:comments-{entryId}` - новые и отредактированные комментарии, оценки комментариев (entryId - id записи)
 *
 * The version of the OpenAPI document: 1.9.0
 * Contact: support@cmtt.ru
 */
package kmtt.base.models.entry

import kmtt.base.models.subsite.Subsite
import kmtt.base.models.*
import kmtt.base.models.comment.Comment
import kotlinx.serialization.json.JsonNames

/**
 * 
 *
 * @param id 
 * @param title Заголовок статьи
 * @param webviewUrl Ссылка, которую нужно открыть вместо открытия статьи
 * @param entryContent 
 * @param date Дата создания статьи
 * @param dateRFC Дата создания статьи
 * @param lastModificationDate Дата последнего изменения статьи
 * @param author 
 * @param type Тип контента:   * `TYPE_ENTRY` - 1   * `TYPE_VACANCY` - 2   * `TYPE_STATICPAGE` - 3   * `TYPE_EVENT` - 4   * `TYPE_REPOST` - 5 
 * @param intro Подзаголовок статьи
 * @param cover 
 * @param introInFeed 
 * @param similar 
 * @param hitsCount Число просмотров
 * @param likes 
 * @param commentsPreview Список аватарок комментирующих для заглушки
 * @param commentsCount 
 * @param favoritesCount 
 * @param isFavorited 
 * @param isEnabledLikes 
 * @param isEnabledComments 
 * @param isEditorial Показывает, что это пост редакции
 * @param isPinned Показывает, закреплен ли пост
 * @param audioUrl Ссылка на mp3 файл с озвучкой статьи
 * @param badges 
 * @param commentatorsAvatars 
 * @param subsite 
 * @param hotness Значение хотнесса
 * @param subscribedToTreads Показывает, подписан ли пользователь на новые комментарии
 * @param blocks Список блоков для нативной статьи. Для каждого типа блока формат объекта data разный
 * @param canEdit Показывает, может ли пользователь редактировать материал
 * @param dateFavorite 
 * @param isRepost 
 * @param isPromoted 
 * @param repost 
 * @param commentsSeenCount 
 * @param etcControls 
 * @param isShowThanks 
 * @param isStillUpdating 
 * @param isFilledByEditors 
 * @param coAuthor 
 */

data class Entry (

    @JsonNames("id")
    val id: java.math.BigDecimal? = null,

    /* Заголовок статьи */
    @JsonNames("title")
    val title: String? = null,

    /* Ссылка, которую нужно открыть вместо открытия статьи */
    @JsonNames("webviewUrl")
    val webviewUrl: String? = null,

    @JsonNames("entryContent")
    val entryContent: EntryContent? = null,

    /* Дата создания статьи */
    @JsonNames("date")
    val date: java.math.BigDecimal? = null,

    /* Дата создания статьи */
    @JsonNames("dateRFC")
    val dateRFC: String? = null,

    /* Дата последнего изменения статьи */
    @JsonNames("lastModificationDate")
    val lastModificationDate: java.math.BigDecimal? = null,

    @JsonNames("author")
    val author: Author? = null,

    /* Тип контента:   * `TYPE_ENTRY` - 1   * `TYPE_VACANCY` - 2   * `TYPE_STATICPAGE` - 3   * `TYPE_EVENT` - 4   * `TYPE_REPOST` - 5  */
    @JsonNames("type")
    val type: Int? = null,

    /* Подзаголовок статьи */
    @JsonNames("intro")
    val intro: String? = null,

    @JsonNames("cover")
    val cover: Cover? = null,

    @JsonNames("introInFeed")
    val introInFeed: String? = null,

    @JsonNames("similar")
    val similar: List<Similar>? = null,

    /* Число просмотров */
    @JsonNames("hitsCount")
    val hitsCount: java.math.BigDecimal? = null,

    @JsonNames("likes")
    val likes: Likes? = null,

    /* Список аватарок комментирующих для заглушки */
    @JsonNames("commentsPreview")
    val commentsPreview: List<Comment>? = null,

    @JsonNames("commentsCount")
    val commentsCount: Int? = null,

    @JsonNames("favoritesCount")
    val favoritesCount: Int? = null,

    @JsonNames("isFavorited")
    val isFavorited: Boolean? = null,

    @JsonNames("isEnabledLikes")
    val isEnabledLikes: Boolean? = null,

    @JsonNames("isEnabledComments")
    val isEnabledComments: Boolean? = null,

    /* Показывает, что это пост редакции */
    @JsonNames("isEditorial")
    val isEditorial: Boolean? = null,

    /* Показывает, закреплен ли пост */
    @JsonNames("isPinned")
    val isPinned: Boolean? = null,

    /* Ссылка на mp3 файл с озвучкой статьи */
    @JsonNames("audioUrl")
    val audioUrl: String? = null,

    @JsonNames("badges")
    val badges: List<Badge>? = null,

    @JsonNames("commentatorsAvatars")
    val commentatorsAvatars: List<String>? = null,

    @JsonNames("subsite")
    val subsite: Subsite? = null,

    /* Значение хотнесса */
    @JsonNames("hotness")
    val hotness: Double? = null,

    /* Показывает, подписан ли пользователь на новые комментарии */
    @JsonNames("subscribedToTreads")
    val subscribedToTreads: Boolean? = null,

    /* Список блоков для нативной статьи. Для каждого типа блока формат объекта data разный */
    @JsonNames("blocks")
    val blocks: List<EntryBlock>? = null,

    /* Показывает, может ли пользователь редактировать материал */
    @JsonNames("canEdit")
    val canEdit: Boolean? = null,

    @JsonNames("date_favorite")
    val dateFavorite: java.math.BigDecimal? = null,

    @JsonNames("isRepost")
    val isRepost: Boolean? = null,

    @JsonNames("is_promoted")
    val isPromoted: Boolean? = null,

    @JsonNames("repost")
    val repost: EntryRepost? = null,

    @JsonNames("commentsSeenCount")
    val commentsSeenCount: EntryCommentsSeenCount? = null,

    @JsonNames("etcControls")
    val etcControls: EtcControls? = null,

    @JsonNames("is_show_thanks")
    val isShowThanks: Boolean? = null,

    @JsonNames("is_still_updating")
    val isStillUpdating: Boolean? = null,

    @JsonNames("is_filled_by_editors")
    val isFilledByEditors: Boolean? = null,

    @JsonNames("co_author")
    val coAuthor: Subsite? = null

)

