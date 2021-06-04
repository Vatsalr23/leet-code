package medium

import common.ListNode

// Topic: Linked List, Header Linked List

// https://leetcode.com/problems/add-two-numbers/
class AddTwoNumbers {

    // Helper method to get value when ListNode is not null otherwise return 0
    private fun ListNode?.getValueOrZero() = this?.`val` ?: 0

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1Current: ListNode? = l1
        var l2Current: ListNode? = l2

        var carryOver = 0
        // Header node for easy addition
        val resultHead = ListNode(-1)
        var resultCurrent: ListNode? = resultHead

        while (l1Current != null || l2Current != null || carryOver != 0) {
            // Calculate the sum + carryOver and re-evaluate the carryOver
            val sum = l1Current.getValueOrZero() + l2Current.getValueOrZero() + carryOver
            val sumOnesDigit = sum % 10
            carryOver = sum / 10

            // Use the sum's ones digit to create a new node and assign it as next of resultCurrent list
            resultCurrent?.next = ListNode(sumOnesDigit)
            resultCurrent = resultCurrent?.next

            l1Current = l1Current?.next
            l2Current = l2Current?.next
        }

        // Remember to return the next of the header node
        return resultHead.next
    }
}