package kmtt.base.api.entry

import kmtt.common.Shared
import org.junit.jupiter.api.Test
import kmtt.util.assertDoesNotThrow

internal class AuthEntryAPITest {
    private val api = AuthEntryAPI(Shared.httpClient, Shared.website, Shared.token)

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