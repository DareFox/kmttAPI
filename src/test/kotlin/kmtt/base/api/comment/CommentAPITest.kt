package kmtt.base.api.comment

import kmtt.api.comment.AuthCommentAPI
import kmtt.models.enums.SortingType
import kmtt.common.Shared
import kmtt.util.assertDoesNotThrow
import org.junit.jupiter.api.Test


internal class CommentAPITest {
    private val api = AuthCommentAPI(Shared.httpClient, Shared.website, Shared.token)

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
                    api.getLevelComments(comment.entryID, type)
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
                api.getCommentVotes(it.commentID)
            }
        }
    }

    // DOESN'T WORK WITH OFFICIAL API
//    @Test
//    fun postLike() {
//        Shared.comments.forEach {
//            assertDoesNotThrow {
//                api.postLike(it.commentID, OsnovaContentType.COMMENT, Vote.PLUS)
//            }
//        }
//    }
}
