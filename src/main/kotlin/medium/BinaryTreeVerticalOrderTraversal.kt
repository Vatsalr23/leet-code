package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics
import common.TreeNode
import java.util.*

// Try again with BFS with no sorting

@Topics([Topic.BINARY_TREE, Topic.DFS, Topic.BFS, Topic.SORTING])
@LeetCodeUrl("https://leetcode.com/problems/binary-tree-vertical-order-traversal/")
class BinaryTreeVerticalOrderTraversal {
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        val map = sortedMapOf<Int, MutableList<Pair<Int, Int>>>()
        traverse(root, 0, map, 0)
        return map.map {
            val finalList = it.value
            finalList.sortBy {pair ->
                pair.first
            }
            return@map finalList.map { it.second }
        }
    }

    private fun traverse(
        root: TreeNode?,
        columnIndex: Int,
        map: SortedMap<Int, MutableList<Pair<Int, Int>>>,
        rowIndex: Int
    ) {
        if (root != null) {
            val pair = Pair(rowIndex, root.`val`)
            if (map.containsKey(columnIndex)) {
                map[columnIndex]?.add(pair)
            } else {
                map[columnIndex] = mutableListOf(pair)
            }

            traverse(root.left, columnIndex - 1, map, rowIndex + 1)
            traverse(root.right, columnIndex + 1, map, rowIndex + 1)
        }
    }
}

fun main() {
    val result = BinaryTreeVerticalOrderTraversal().verticalOrder(
        TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
    )
    println(result)
}
