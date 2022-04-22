package kmtt.base.api.user

import kmtt.util.assertDoesNotThrow
import kmtt.api.user.AuthUserAPI
import kmtt.common.Shared
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AuthUserAPITest {
    val api = AuthUserAPI(Shared.httpClient, Shared.website, Shared.token)

    @Test
    fun getMe() {
        assertDoesNotThrow {
            api.getMe()
        }
    }

    @Test
    fun getMyNotifications() {
        assertDoesNotThrow {
            api.getMyNotifications()
        }
    }

    @Test
    fun getMyNotificationsCount() {
        assertDoesNotThrow {
            api.getMyNotificationsCount()
        }
    }

    @Test
    fun readNotificationsById() {
        assertDoesNotThrow {
            val notification = api.getMyNotifications().first()
            api.readNotificationsById(notification.id!!)
        }
    }

    @Test
    fun readAllNotifications() {
        assertDoesNotThrow {
            val readNotifications = api.readAllNotifications()
        }
    }

    @Test
    fun getMyComments() {
        assertDoesNotThrow {
            api.getMyComments(50, 0)
        }
    }

    @Test
    fun getMyEntries() {
        assertDoesNotThrow {
            api.getMyEntries(50, 0)
        }
    }

    @Test
    fun getMyFavoriteEntries() {
        assertDoesNotThrow {
            api.getMyFavoriteEntries(50, 0)
        }
    }

    @Test
    fun getMyFavoriteComments() {
        assertDoesNotThrow {
            api.getMyFavoriteEntries(50, 0)
        }
    }

    @Test
    fun getUserByID() {
        Shared.publicProfileID.forEach {
            assertDoesNotThrow {
                api.getUserByID(it.toLong())
            }
        }
    }

    @Test
    fun `Test private account with getUserByID`() {
        Shared.privateProfileID.forEach {
            assertDoesNotThrow {
                api.getUserByID(it.toLong())
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
    }

    @Test
    fun `Test private account with getUserComments`() {
        Shared.privateProfileID.forEach {
            assertDoesNotThrow {
                api.getUserComments(it.toLong(), 50, 0)
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
    }

    @Test
    fun `Test private account with getUserEntries`() {
        Shared.privateProfileID.forEach {
            assertDoesNotThrow {
                api.getUserEntries(it.toLong(), 50, 0)
            }
        }
    }
}