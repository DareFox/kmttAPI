package kmtt.api.user

import kmtt.impl.publicKmtt
import kmtt.models.enums.Website

private suspend fun sampleEachOperation() {
    val api = publicKmtt(Website.DTF)

    // User with ID 68409 have a lot of comments
    // Because of API restrictions, kmttAPI will get them by chunks of 50 comments each
    // Before fetching new comments chunk, kmttAPI will run lambda with previous chunk

    // Schema of algorithm
    // - Get next 50 comments
    // - Provide them to lambda
    // - Wait for lambda to finish
    // - Fetch next comments
    // - Repeat algorithm until the end of comments
    api.user.getAllUserComments(68409L) { commentsChunk ->
        val last = commentsChunk.last()
        println("ID of last comment in chunk is ${last.id}")
    }


}