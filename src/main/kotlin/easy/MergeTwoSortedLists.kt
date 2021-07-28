package easy

import common.LeetCodeUrl
import common.ListNode
import common.Topic
import common.Topics

@Topics([Topic.LINKED_LIST, Topic.RECURSION])
@LeetCodeUrl("https://leetcode.com/problems/merge-two-sorted-lists/submissions/")
class MergeTwoSortedLists {

    // Recursive method
    fun mergeTwoListsRecursive(l1: ListNode?, l2: ListNode?): ListNode? {
        return when {
            l1 == null -> l2
            l2 == null -> l1
            l1.`val` < l2.`val` -> {
                l1.next = mergeTwoListsRecursive(l1.next, l2)
                l1
            }
            else -> {
                l2.next = mergeTwoListsRecursive(l1, l2.next)
                l2
            }
        }
    }

    // Iterative method
    fun mergeTwoListsIterative(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1Current = l1
        var l2Current = l2
        val head = ListNode(-1)
        var current = head
        while (l1Current != null && l2Current != null) {
            if (l1Current.`val` > l2Current.`val`) {
                current.next = l2Current
                l2Current = l2Current.next
            } else {
                current.next = l1Current
                l1Current = l1Current.next
            }
            current = current.next!!
        }

        current.next = l1Current ?: l2Current
        return head.next
    }
}