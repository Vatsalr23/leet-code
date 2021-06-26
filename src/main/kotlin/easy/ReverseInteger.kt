package easy

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.MATH])
@LeetCodeUrl("https://leetcode.com/problems/reverse-integer/")
class ReverseInteger {
    companion object {
        // I prefer evaluating the last digits instead of remembering the values
        private const val INT_MAX_LAST_DIGIT = Int.MAX_VALUE % 10
        private const val INT_MIN_LAST_DIGIT = Int.MIN_VALUE % 10
        private const val INT_MAX_WITHOUT_LAST_DIGIT = Int.MAX_VALUE / 10
        private const val INT_MIN_WITHOUT_LAST_DIGIT = Int.MIN_VALUE / 10
    }

    fun reverse(x: Int): Int {
        var xCopy = x
        var result = 0
        while (xCopy != 0) {
            val onesDigit = xCopy % 10
            if (willOverflow(result, onesDigit)) {
                return 0
            }
            result = 10 * result + onesDigit
            xCopy /= 10
        }
        return result
    }

    // This is the special part of the question.
    private fun willOverflow(result: Int, onesDigit: Int): Boolean {
        return when {
            result == INT_MAX_WITHOUT_LAST_DIGIT && onesDigit > INT_MAX_LAST_DIGIT -> true
            result == INT_MIN_WITHOUT_LAST_DIGIT && onesDigit < INT_MIN_LAST_DIGIT -> true
            result > INT_MAX_WITHOUT_LAST_DIGIT || result < INT_MIN_WITHOUT_LAST_DIGIT -> true
            else -> false
        }
    }
}
