package kmtt.util

import kotlinx.coroutines.runBlocking

fun <T> assertDoesNotThrow(block: suspend () -> T) {
    org.junit.jupiter.api.assertDoesNotThrow {
        runBlocking {
            val result = block()
            println(result)
            result
        }
    }
}