package kmtt.util

import kotlinx.coroutines.runBlocking

fun <T> assertDoesNotThrow(block: suspend () -> T) {
    org.junit.jupiter.api.assertDoesNotThrow {
        runBlocking {
            block()
        }
    }
}