package kmtt.base.api.entry

import kmtt.base.api.common.Authable
import kmtt.base.models.Likes
import kmtt.base.models.attach.Attach
import kmtt.base.models.entry.Entry
import kmtt.base.models.enums.OsnovaContentType
import kmtt.base.models.enums.Vote

interface IPublicEntryAPI {

    /** Получить запись по ID **/
    suspend fun getEntry(id: Long): Entry

    /** Получить статью по ссылке **/
    suspend fun getEntry(url: String): Entry

    /** Получить популярные записи для определенной записи **/
    suspend fun getPopularEntriesByEntry(id: Long): List<Entry>

    /**
     *  Получить данные для прикрепления Embed
     *
     *  @param embedURL
     *  Cсылка на embed.
     *
     *  Пример: `https://www.youtube.com/embed/s596l-aTDYI`
     **/
    // Not working with v1.9
//    suspend fun getAttachEmbedData(embedURL: String): Attach
}

interface IAuthEntryAPI: IPublicEntryAPI, Authable {
    // Not working with current API

//    /** Лайкнуть запись **/
//    suspend fun postLike(id: Long, type: OsnovaContentType, vote: Vote): Likes
//
//    /** Создать запись **/
//    suspend fun createEntry(title: String, text: String, subsiteID: Long, attachments: String): Likes
}