package medium

import common.LeetCodeUrl
import common.Topics
import common.Topic.*

@Topics([DYNAMIC_PROGRAMMING, STRING])
@LeetCodeUrl("https://leetcode.com/problems/longest-palindromic-substring/")
class LongestPalindromeSubstring {
    fun longestPalindrome(s: String): String {
        val dp = Array(s.length) { BooleanArray(s.length) }
        var maxLength = 1
        var result = Pair(0, 0)
        var i = s.lastIndex
        var j = s.lastIndex
        while (j >= 0 && i >= 0) {
            if (i == j) {
                dp[i][j] = true
                i -= 1
                j = s.lastIndex
                continue
            }

            if (j - i == 1) {
                dp[i][j] = s[i] == s[j]
            } else {
                dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
            }

            if (dp[i][j]) {
                if (j - i + 1 > maxLength) {
                    maxLength = j - i + 1
                    result = Pair(i, j)
                }
            }

            j -= 1
        }

        return s.substring(result.first, result.second + 1)
    }
}

fun main() {
    LongestPalindromeSubstring().longestPalindrome("babad")
}
