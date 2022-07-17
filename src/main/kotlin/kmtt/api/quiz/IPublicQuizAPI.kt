package kmtt.api.quiz

import kmtt.api.common.Authable
import kmtt.models.QuizResult

interface IPublicQuizAPI {
    suspend fun getResults(hash: String): QuizResult
}

interface IAuthQuizAPI: IPublicQuizAPI, Authable {
//    fun vote(hash: String, entryID: Int, itemID: String): QuizResult
//    fun resetVote(hash: String, entryID: Int): QuizResult
}
//
//fun IAuthQuizAPI.resetVote(hash: String, entry: Entry): QuizResult {
//    val id = entry.id
//
//    requireNotNull(id) {
//        "ID of entry $entry is null"
//    }
//    return resetVote(hash, id.toInt())
//}
//
//fun IAuthQuizAPI.vote(hash: String, entry: Entry, itemID: String): QuizResult {
//    val id = entry.id
//
//    requireNotNull(id) {
//        "ID of entry $entry is null"
//    }
//    return vote(hash, id.toInt(), itemID)
//}