package hard

import common.LeetCodeUrl
import common.Topic
import common.Topics
import java.util.Stack

@Topics([Topic.STRING, Topic.STACK])
@LeetCodeUrl("https://leetcode.com/problems/longest-valid-parentheses/")
class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val stack = Stack<Int>()
        stack.push(-1)
        var maxAns = 0
        s.forEachIndexed { index, c ->
            if (c == '(') {
                stack.push(index)
            } else {
                stack.pop()
                if (stack.isEmpty()) {
                    stack.push(index)
                } else {
                    maxAns = kotlin.math.max(maxAns, index - stack.peek())
                }
            }
        }
        return maxAns
    }
}

fun main() {
    LongestValidParentheses().longestValidParentheses(")()())")
}
