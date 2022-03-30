/**
 * Osnova API
 *
 * Открытая документация API для [vc.ru](//vc.ru), [DTF](//dtf.ru) и [TJ](//tjournal.ru) ## Ограничения API ## * Не чаще 3-х запросов к API в секунду * Существуют также отдельные ограничения на отправку комментариев, лайков и др. ## Заголовки (headers) ## При запросе к API необходимо передавать поле `User-agent` в формате `{app_name}-app/{app_version} ({device_name}; {os_name}/{os_version}; {locale}; {screen_height}x{screen_width})`. Например: `dtf-app/2.2.0 (Pixel 2; Android/9; ru; 1980x1794)`. Некоторые запросы доступны только для авторизованных пользователей (методы обозначены замком). Для этого необходимо передавать авторизационный токен `X-Device-Token` в заголовку запроса. Он возвращается с сервера при авторизации. Для доступа к тестовым серверам необходимо поле `Authorization`. ## Авторизация по API-токену Как авторизоваться в API используя специальный токен со страницы настроек пользователя 1. Зайти в [свой профиль](https://tjournal.ru/u/me/settings) 2. В самом низу нажать на ссылку «Инструменты для разработчика» 3. Вы увидите токен, с которым можно обращаться к API      [https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba](https://www.notion.so/dd3f2ae5a4bc4a7fbeb4598f86eb37aa#7734c1a41c834da5b7425eac905f39ba)  4. Можно использовать этот токен для отправки запросов к API от имени вашего аккаунта ## WebSocket ## `wss://ws.dtf.ru/chan/api`, `wss://ws.vc.ru/chan/api`, `wss://ws.tjournal.ru/chan/api`, `wss://ws.vc.ru/chan/api` - данные о лайках статей и комментариев. Модель отдельного элемента: [#/components/schemas/Websocket](#model-Websocket)  `wss://ws.dtf.ru/chan/content-hits-{entryId}`, `wss://ws.tjournal.ru/chan/content-hits-{entryId}`, `wss://ws.vc.ru/chan/content-hits-{entryId}` - просмотры записи (entryId - id записи)  `wss://ws.dtf.ru/chan/api:comments-{entryId}`, `wss://ws.tjournal.ru/chan/api:comments-{entryId}`, `wss://ws.vc.ru/chan/api:comments-{entryId}` - новые и отредактированные комментарии, оценки комментариев (entryId - id записи)
 *
 * The version of the OpenAPI document: 1.9.0
 * Contact: support@cmtt.ru
 */
package cmtt.base.models.entry

import kotlinx.serialization.json.JsonNames

/**
 * 
 *
 * @param message 
 * @param error 
 */

data class EntryComplaintError (

    @JsonNames("message")
    val message: String? = null,

    @JsonNames("error")
    val error: EntryComplaintErrorError? = null

)

