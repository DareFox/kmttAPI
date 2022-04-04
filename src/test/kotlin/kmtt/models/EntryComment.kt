package kmtt.models

import kmtt.base.models.enums.Website

data class EntryComment(val entryID: Long, val commentID: Long, val siteType: Website) {
    val entryURL = "https://${siteType.baseURL}/$entryID"
}