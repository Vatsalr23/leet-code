package easy

import common.LeetCodeUrl
import common.Topic
import common.Topics
import common.TreeNode
import kotlin.math.max

@Topics([Topic.BINARY_TREE])
@LeetCodeUrl("https://leetcode.com/problems/maximum-depth-of-binary-tree/")
class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}
