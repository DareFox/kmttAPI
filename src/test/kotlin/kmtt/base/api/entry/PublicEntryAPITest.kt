package kmtt.base.api.entry

import kmtt.api.entry.AuthEntryAPI
import kmtt.api.entry.PublicEntryAPI
import kmtt.common.Shared
import org.junit.jupiter.api.Test
import kmtt.util.assertDoesNotThrow

internal class PublicEntryAPITest {
    private val api = PublicEntryAPI(Shared.httpClient, Shared.website)

    @Test
    fun getEntryByID() {
        Shared.comments.forEach { comment ->
            assertDoesNotThrow {
                api.getEntry(comment.entryID)
            }
        }
    }

    @Test
    fun getEntryByURL() {
        Shared.comments.forEach { comment ->
            assertDoesNotThrow {
                api.getEntry(comment.entryURL)
            }
        }
    }

    @Test
    fun getPopularEntriesByEntry() {
        Shared.comments.forEach { comment ->
            assertDoesNotThrow {
                api.getPopularEntriesByEntry(comment.entryID)
            }
        }
    }

//    @Test
//    fun getAttachEmbedData() {
//        assertDoesNotThrow {
//            api.getAttachEmbedData("https://www.youtube.com/embed/XdG-lCb2oTc")
//        }
//    }
}