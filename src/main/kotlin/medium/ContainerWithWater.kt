package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics
import kotlin.math.*

@Topics([Topic.TWO_POINTER])
@LeetCodeUrl("https://leetcode.com/problems/container-with-most-water")
class ContainerWithWater {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var start = 0
        var end = height.lastIndex

        while (start < end) {
            maxArea = max(maxArea, min(height[start], height[end]) * (end - start))
            if (height[start] < height[end]) {
                start += 1
            } else {
                end -= 1
            }
        }

        return maxArea
    }
}
