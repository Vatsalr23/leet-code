package easy

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.BST])
@LeetCodeUrl("https://leetcode.com/problems/search-insert-position/")
class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        return search(nums, 0, nums.lastIndex, target)
    }

    private fun search(nums: IntArray, first: Int, last: Int, target: Int): Int {
        var start = first
        var end = last

        while (start <= end) {
            val mid = (start + end) / 2

            if (nums[mid] == target) return mid

            if (nums[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return start
    }
}