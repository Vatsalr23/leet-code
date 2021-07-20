package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics
import kotlin.math.*

@Topics([Topic.MAP, Topic.SLIDING_WINDOW, Topic.STRING])
@LeetCodeUrl("https://leetcode.com/problems/longest-substring-without-repeating-characters")
class LongestSubstringWithoutRepeatingCharacter {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 0) {
            return 0
        }

        var maxLength = 0
        // Map to store where to start from when we see a repeated character
        val map = mutableMapOf<Char, Int>()
        var start = 0

        // Special cases: dvdf, abba
        for (end in 0 until s.length) {
            // When a repeated charater is found move start if and only if the repeated charater is ahead of start index.
            if (map.containsKey(s[end])) {
                start = max(start, map[s[end]]!!)
            }

            maxLength = max(end - start + 1, maxLength)
            map[s[end]] = end + 1
        }

        return maxLength
    }
}

fun main() {
    LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring("abba")
    LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring("dvdf")
}
