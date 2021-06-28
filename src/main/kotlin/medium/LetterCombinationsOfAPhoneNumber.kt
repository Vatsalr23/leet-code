package medium

import common.LeetCodeUrl
import common.Topic.*
import common.Topics

@Topics([BACKTRACKING, DFS, STRING])
@LeetCodeUrl("https://leetcode.com/problems/letter-combinations-of-a-phone-number/")
class LetterCombinationsOfAPhoneNumber {
    private val digitToLettersMap = mapOf(
        "2" to arrayOf("a", "b", "c"),
        "3" to arrayOf("d", "e", "f"),
        "4" to arrayOf("g", "h", "i"),
        "5" to arrayOf("j", "k", "l"),
        "6" to arrayOf("m", "n", "o"),
        "7" to arrayOf("p", "q", "r", "s"),
        "8" to arrayOf("t", "u", "v"),
        "9" to arrayOf("w", "x", "y", "z")
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val result = mutableListOf<String>()

        dfs(digits, result, StringBuilder(), 0)

        return result
    }

    private fun dfs(digits: String, result: MutableList<String>, string: StringBuilder, index: Int) {
        if (string.length == digits.length) {
            result.add(string.toString())
            return
        }

        val digit = digits[index]
        val letters = digitToLettersMap.getValue(digit.toString())

        for (letter in letters) {
            string.append(letter)
            dfs(digits, result, string, index + 1)
            string.deleteCharAt(string.lastIndex)
        }
    }
}
