package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.STRING])
@LeetCodeUrl("https://leetcode.com/problems/zigzag-conversion/")
class ZigZagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val result = StringBuilder()
        var currentRow = 1

        while (currentRow <= numRows) {
            var i = currentRow - 1
            var bottomGap = (numRows - currentRow) + (numRows - currentRow - 1)
            var topGap = (currentRow - 1) + (currentRow - 1 - 1)

            if (bottomGap <= 0) bottomGap = topGap
            if (topGap <= 0) topGap = bottomGap

            val rowString = StringBuilder()

            while (i < s.length) {
                rowString.append(s[i])
                i += if (rowString.length % 2 != 0) bottomGap + 1 else topGap + 1
            }

            result.append(rowString.toString())
            currentRow += 1
        }

        return result.toString()
    }
}

fun main() {
    ZigZagConversion().convert("A", 1)
}
