package easy

import common.LeetCodeUrl
import common.Topic
import common.Topics
import common.TreeNode

@Topics([Topic.BINARY_TREE])
@LeetCodeUrl("https://leetcode.com/problems/invert-binary-tree/")
class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return root

        // Invert left subtree
        val left = invertTree(root.left)

        // Invert right subtree
        val right = invertTree(root.right)

        // Swap the children
        root.right = left
        root.left = right

        return root
    }
}
