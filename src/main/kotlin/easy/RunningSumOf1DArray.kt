package easy

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.ARRAY])
@LeetCodeUrl("https://leetcode.com/problems/running-sum-of-1d-array/")
class RunningSumOf1DArray {
    fun runningSum(nums: IntArray): IntArray {
        val sumList = IntArray(nums.size)
        sumList[0] = nums[0]

        for (i in 1 until sumList.size) {
            sumList[i] = sumList[i-1] + nums[i]
        }

        return sumList
    }
}