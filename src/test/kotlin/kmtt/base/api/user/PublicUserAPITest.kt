package kmtt.base.api.user

import kmtt.api.user.PublicUserAPI
import kmtt.common.Shared
import kmtt.util.assertDoesNotThrow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class PublicUserAPITest {
    val api = PublicUserAPI(Shared.httpClient, Shared.website)

    @Test
    fun getUserByID() {
        Shared.publicProfileID.forEach {
            assertDoesNotThrow {
                api.getUserByID(it.toLong())
            }
        }
        Shared.privateProfileID.forEach {
            assertThrows<Exception> {
                runBlocking {
                    api.getUserByID(it.toLong())
                }
            }
        }
    }

    @Test
    fun getUserComments() {
        Shared.publicProfileID.forEach {
            assertDoesNotThrow {
                api.getUserComments(it.toLong(), 50, 0)
            }
        }

        Shared.privateProfileID.forEach {
            assertDoesNotThrow {
                api.getUserEntries(it.toLong(), 50, 0)
            }
        }
    }

    @Test
    fun getUserEntries() {
        Shared.publicProfileID.forEach {
            assertDoesNotThrow {
                api.getUserEntries(it.toLong(), 50, 0)
            }
        }
        Shared.privateProfileID.forEach {
            assertDoesNotThrow {
                api.getUserEntries(it.toLong(), 50, 0)
            }
        }
    }
}