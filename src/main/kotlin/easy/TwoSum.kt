package easy

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.MAP])
@LeetCodeUrl("https://leetcode.com/problems/two-sum/")
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // Key would be the actual number & Value is going to be index
        val map = mutableMapOf<Int, Int>()

        // Loop through each number
        nums.forEachIndexed { i, num ->
            // Check if the remaining value to reach target has already been visited
            val remaining = target - num
            if (map.containsKey(remaining)) {
                return intArrayOf(map.getValue(remaining), i)
            }

            // Save the visited number with its index
            map[num] = i
        }

        return intArrayOf()
    }
}
