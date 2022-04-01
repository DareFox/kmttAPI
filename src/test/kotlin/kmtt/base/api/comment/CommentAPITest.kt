package kmtt.base.api.comment

import kmtt.base.models.enums.SortingType
import kmtt.base.models.enums.Vote
import kmtt.common.Shared
import kmtt.util.assertDoesNotThrow
import org.junit.jupiter.api.Test


internal class CommentAPITest {
    private val api = CommentAPI(Shared.httpClient, Shared.website, Shared.token)

    @Test
    fun getEntryComments() {
        Shared.comments.forEach { comment ->
            SortingType.values().forEach { type ->
                assertDoesNotThrow {
                    api.getEntryComments(comment.entryID, type)
                }
            }
        }
    }

    @Test
    fun getLevelComments() {
        Shared.comments.forEach { comment ->
            SortingType.values().forEach { type ->
                assertDoesNotThrow {
                    api.getLevelComments(comment.commentID, type)
                }
            }
        }
    }

    @Test
    fun getThreadComments() {
        Shared.comments.forEach {
            assertDoesNotThrow {
                api.getThreadComments(it.entryID, it.commentID)
            }
        }
    }

    @Test
    fun getCommentVotes() {
        Shared.comments.forEach {
            assertDoesNotThrow {
                api.getCommentVotes(it.entryID)
            }
        }
    }
}
