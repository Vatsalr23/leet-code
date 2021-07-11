package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.BACKTRACKING, Topic.STRING])
@LeetCodeUrl("https://leetcode.com/problems/generate-parentheses/")
class GenerateParenthesis {

    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        backtrack(n, result, StringBuilder(), 0, 0)
        return result
    }

    private fun backtrack(
        n: Int,
        result: MutableList<String>,
        string: StringBuilder,
        openBrackets: Int,
        closeBrackets: Int
    ) {
        if (string.length == 2 * n) {
            result.add(string.toString())
            return
        }

        if (openBrackets < n) {
            string.append("(")
            backtrack(n, result, string, openBrackets + 1, closeBrackets)
            string.deleteCharAt(string.lastIndex)
        }

        if (closeBrackets < openBrackets) {
            string.append(")")
            backtrack(n, result, string, openBrackets, closeBrackets + 1)
            string.deleteCharAt(string.lastIndex)
        }
    }
}
