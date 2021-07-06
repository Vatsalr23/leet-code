package easy

import common.LeetCodeUrl
import common.Topic
import common.Topics
import common.TreeNode

@Topics([Topic.BINARY_TREE])
@LeetCodeUrl("https://leetcode.com/problems/symmetric-tree/")
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return areSubTreesSymmetric(root.left, root.right)
    }

    private fun areSubTreesSymmetric(leftRoot: TreeNode?, rightRoot: TreeNode?): Boolean {
        if (leftRoot == null && rightRoot == null) return true
        if (leftRoot?.`val` != rightRoot?.`val`) return false
        return areSubTreesSymmetric(leftRoot?.right, rightRoot?.left) &&
                areSubTreesSymmetric(rightRoot?.right, leftRoot?.left)
    }
}
