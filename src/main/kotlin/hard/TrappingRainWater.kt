package hard

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.STACK, Topic.DYNAMIC_PROGRAMMING])
@LeetCodeUrl("https://leetcode.com/problems/trapping-rain-water")
class TrappingRainWater {

    // Stack Solution (Don't really like this solution as the edge cases magically solves itself. Not very intuitive.)
    fun trap(height: IntArray): Int {
        var water = 0
        val stack = java.util.Stack<Int>()
        var current = 0
        while (current < height.size) {
            while (stack.isNotEmpty() && height[current] > height[stack.peek()]) {
                val previousTop = stack.pop()
                if (stack.isEmpty()) break

                val newTop = stack.peek()
                val distance = current - newTop - 1
                val boundedHeight = kotlin.math.min(height[current], height[newTop]) - height[previousTop]
                water += distance * boundedHeight
            }
            stack.push(current)
            current += 1
        }
        return water
    }

    // Dynamic Programming Solution
    // For a given index we can get the left max and the right max. Choose the min between left_max & right_max
    // and that will be our height bound. Water trapped at that index = (height_bound - height[current])
    fun trapDP(height: IntArray): Int {
        if (height.isEmpty()) return 0
        var water = 0

        val leftMax = IntArray(height.size) { 0 }
        leftMax[0] = height[0]
        val rightMax = IntArray(height.size) { 0 }
        rightMax[height.lastIndex] = height[height.lastIndex]

        for (i in 1..height.lastIndex) {
            leftMax[i] = kotlin.math.max(height[i], leftMax[i-1])
        }

        for (i in height.lastIndex - 1 downTo 0) {
            rightMax[i] = kotlin.math.max(height[i], rightMax[i+1])
        }

        height.forEachIndexed { index, height ->
            water += kotlin.math.min(leftMax[index], rightMax[index]) - height
        }

        return water
    }
}

fun main() {
    TrappingRainWater().trap(intArrayOf(3,1,2,1,4))
    TrappingRainWater().trapDP(intArrayOf(3,1,2,1,4))
}
