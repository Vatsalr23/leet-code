package medium

import common.LeetCodeUrl
import common.Topic.*
import common.Topics
import kotlin.math.max

@Topics([SLIDING_WINDOW, ARRAY, MATH])
@LeetCodeUrl("https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/")
class MaximumPointsYouCanObtainFromCards {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var sumK = 0
        for (i in (cardPoints.size - k) until cardPoints.size) {
            sumK += cardPoints[i]
        }

        var maxScore = sumK
        for (i in 0 until k) {
            sumK = sumK + cardPoints[i] - cardPoints[cardPoints.size - k + i]
            maxScore = max(maxScore, sumK)
        }

        return maxScore
    }
}
