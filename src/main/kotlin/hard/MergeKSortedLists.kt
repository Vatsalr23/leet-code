package hard

import common.LeetCodeUrl
import common.ListNode
import common.Topic
import common.Topics

@Topics([Topic.LINKED_LIST, Topic.RECURSION, Topic.DIVIDE_AND_CONQUER])
@LeetCodeUrl("https://leetcode.com/problems/merge-k-sorted-lists/")
class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        var j = 1
        while (j < lists.size) {
            var i = 0
            while (i < lists.size) {
                if (i+j <= lists.lastIndex) {
                    lists[i] = mergeTwoLists(lists[i], lists[i+j])
                }
                i += j * 2
            }
            j *= 2
        }
        return lists[0]
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
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

fun main() {
    val result = MergeKSortedLists().mergeKLists(
        IntRange(0, 2).asIterable().map{ ListNode(it) }.toTypedArray()
    )
    printListNode(result)
}

fun printListNode(l: ListNode?) {
    while (l != null) {
        if (l.next != null) {
            print("${l.`val`}, ")
        } else {
            print("${l.`val`}")
        }
    }
}
