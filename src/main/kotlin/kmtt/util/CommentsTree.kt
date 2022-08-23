package kmtt.util

import kmtt.models.comment.Comment
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

fun Collection<Comment>.toTree(): List<CommentNode> {
    val replyMap = this.groupBy { it.replyTo }
    val topZeroComments = replyMap[0] ?: listOf()
    val topNullComments = replyMap[null] ?: listOf()
    val topLevelComments = topZeroComments + topNullComments

    return topLevelComments.map {
        createRecursiveNode(it, replyMap)
    }
}

private fun createRecursiveNode(value: Comment, replyMap: Map<Long?, List<Comment>>): CommentNode {
    val node = CommentNode(
        value = value
    )

    var currentLayer = replyMap[value.id]?.map {
        CommentNode(it)
    } ?: listOf()

    node.children = currentLayer

    while (currentLayer.isNotEmpty()) {
        val nextLayer = mutableListOf<CommentNode>()

        for (nodeParent in currentLayer) {
            val id = nodeParent.value.id
            val nodeChildren = if (id == null) listOf() else {
                replyMap[id]?.map {
                    CommentNode(it)
                } ?: listOf()
            }
            
            nodeParent.children = nodeChildren
            nextLayer += nodeChildren
        }

        currentLayer = nextLayer
    }

    return node
}

@Serializable
data class CommentNode(
    val value: Comment,
    @JsonNames("children")
    var children: List<CommentNode> = listOf<CommentNode>()
) {
    val nodeChildren: List<CommentNode>
        get() { return children }
}