package kmtt.util

import kmtt.models.comment.Comment

fun Collection<Comment>.toTree(): List<CommentNode> {
    val topLevelComments = this.filter { it.replyTo == 0L || it.replyTo == null }
    val replyMap = this.groupBy { it.replyTo }

    return topLevelComments.map {
        createRecursiveNode(it, replyMap)
    }
}

private fun createRecursiveNode(value: Comment, replyMap: Map<Long?, List<Comment>>, parent: CommentNode? = null): CommentNode {
    val childrenNodes = mutableListOf<CommentNode>()

    val node = CommentNode(
        parent = parent,
        nodeValue = value
    )

    replyMap[value.id]?.forEach { comment ->
        childrenNodes += createRecursiveNode(comment, replyMap, node)
    }

    // Add children nodes before return it
    return node.apply {
        _children = childrenNodes
    }
}


data class CommentNode(
    val parent: CommentNode?,
    val nodeValue: Comment,
) {
    internal var _children: List<CommentNode> = listOf()
    val children: List<CommentNode>
        get() = _children
}