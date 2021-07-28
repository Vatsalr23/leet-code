package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.ARRAY, Topic.SORTING])
@LeetCodeUrl("https://leetcode.com/problems/merge-intervals/")
class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        intervals.sortBy { it[0] }
        var current = intervals.first()
        for (i in 1 until intervals.size) {
            if (current.last() >= intervals[i].first()) {
                current = intArrayOf(current.first(), kotlin.math.max(intervals[i].last(), current.last()))
            } else {
                result.add(current)
                current = intervals[i]
            }
        }
        result.add(current)

        return result.toTypedArray()
    }
}
