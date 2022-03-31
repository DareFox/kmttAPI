package kmtt.base.api.comment

import kmtt.base.models.enums.SortingType
import kmtt.common.Shared
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class CommentAPITest {
    private val api = CommentAPI(Shared.httpClient, Shared.baseUrl, Shared.token)

    @Test
    fun getEntryComments() {
        assertDoesNotThrow {
            runBlocking {
                api.getEntryComments(1123335, SortingType.ByDate)
                api.getEntryComments(1110947, SortingType.ByDate)
            }
        }
    }

    @Test
    fun getLevelComments() {
        assertDoesNotThrow {
            runBlocking {
                api.getLevelComments(1123335, SortingType.ByDate)
                api.getLevelComments(1110947, SortingType.ByDate)
            }
        }
    }

    @Test
    fun getThreadComments() {
        assertDoesNotThrow {
            runBlocking {
                api.getThreadComments(1123335, 16158631)
                api.getThreadComments(1110947, 15994992)
            }
        }
    }

    @Test
    fun getCommentVotes() {
        assertDoesNotThrow {
            runBlocking {
                api.getCommentVotes(16158631)
                api.getCommentVotes(15994992)
            }
        }
    }
}