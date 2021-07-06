package easy

import common.LeetCodeUrl
import common.Topic
import common.Topics
import common.TreeNode

@Topics([Topic.BINARY_TREE])
@LeetCodeUrl("https://leetcode.com/problems/same-tree/")
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        return (p?.`val` == q?.`val`) && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}
