package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.ARRAY, Topic.TWO_POINTER, Topic.MATRIX])
@LeetCodeUrl("https://leetcode.com/problems/rotating-the-box/")
class RotateTheBox {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        box.forEach { list ->
            // Skip to the first stone
            var i = moveIndexToNextRock(-1, list)
            var j = i + 1

            while (j < list.size) {
                if (list[j] == '.') {
                    val temp = list[j]
                    list[j] = list[i]
                    list[i] = temp
                    i = moveIndexToNextRock(i, list)
                    j += 1
                } else if (list[j] == '*') {
                    i = j
                    i = moveIndexToNextRock(i, list)
                    j = i + 1
                } else {
                    j += 1
                }
            }
        }
        return rotate90Degrees(box)
    }

    private fun moveIndexToNextRock(current: Int, charArray: CharArray): Int {
        var newIndex = current + 1
        while (newIndex < charArray.size && charArray[newIndex] != '#') { newIndex += 1 }
        return newIndex
    }

    private fun rotate90Degrees(box: Array<CharArray>): Array<CharArray> {
        val resultBox = Array(box.first().size) { CharArray(box.size) }
        var col = resultBox.first().size - 1
        for (i in box.indices) {
            for (j in box.first().indices) {
                resultBox[j][col] = box[i][j]
            }
            col -= 1
        }
        return resultBox
    }
}

fun main() {
    RotateTheBox().rotateTheBox(
        arrayOf(
            charArrayOf('#','#','*','.','*','.'),
            charArrayOf('#','#','#','*','.','.'),
            charArrayOf('#','#','#','.','#','.')
        )
    )
}
