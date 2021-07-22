package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics
import java.util.PriorityQueue

@Topics([Topic.HEAP, Topic.PRIORITY_QUEUE])
@LeetCodeUrl("https://leetcode.com/problems/kth-largest-element-in-an-array/")
class KthLargestElementInAnArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue { num1: Int, num2:Int -> -1 * (num1 - num2) }
        pq.addAll(nums.toList())
        repeat(k - 1) {
            pq.poll()
        }
        return pq.poll()
    }
}

fun main() {
    val result = KthLargestElementInAnArray().findKthLargest(intArrayOf(11,4,2,5,1,3,4,1,4,5,3,10), 2)
    println(result)
}
