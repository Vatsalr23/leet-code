package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.MATRIX, Topic.MATH])
@LeetCodeUrl("https://leetcode.com/problems/rotate-image/")
class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        // Invert along the mid line
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix.size/2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][matrix.lastIndex - j]
                matrix[i][matrix.lastIndex - j] = temp
            }
        }

        // Invert along the anti-diagonal
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix.size) {
                if (i + j == (matrix.size - 1)) break
                val temp = matrix[i][j]
                matrix[i][j] = matrix[matrix.lastIndex - j][matrix.lastIndex - i]
                matrix[matrix.lastIndex - j][matrix.lastIndex - i] = temp
            }
        }
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9)
    )

    RotateImage().rotate(matrix)
}
