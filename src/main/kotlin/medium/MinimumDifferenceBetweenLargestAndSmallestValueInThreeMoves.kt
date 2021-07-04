package medium

import common.LeetCodeUrl
import common.Topics
import common.Topic.*
import kotlin.math.min

@Topics([MATH, SORTING, ARRAY])
@LeetCodeUrl("https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/")
class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    fun minDifference(nums: IntArray): Int {
        if (nums.size <= 4) return 0

        // [20, 75, 81, 82, 95]
        val sortedNums = nums.sort()

        // diff = 75
        var diff = nums.last() - nums[0]

        // Convert first 3 elements
        // [82, 82, 82, 82, 95]
        // diff = min(13, 75) = 13
        diff = min(nums.last() - nums[3], diff)

        // Convert first 2 elements and 1 last
        // [82, 82, 81, 82, 82]
        // diff = min(1, 13) = 1
        diff = min(nums[nums.lastIndex - 1] - nums[2], diff)

        // Convert first element and 2 last
        // [81, 75, 81, 81, 81]
        // diff = min(6, 1) = 1
        diff = min(nums[nums.lastIndex - 2] - nums[1], diff)

        // Convert last 3 elements
        // [20, 75, 75, 75, 75]
        // diff = min(55, 1) = 1
        diff = min(nums[nums.lastIndex - 3] - nums[0], diff)

        return diff
    }
}