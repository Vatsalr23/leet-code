package medium

import common.LeetCodeUrl
import common.Topics
import common.Topic.*

@Topics([STRING])
@LeetCodeUrl("https://leetcode.com/problems/sentence-screen-fitting/")
class SentenceScreenFitting {

    fun wordsTyping(sentence: Array<String>, rows: Int, cols: Int): Int {
        var fits = 0
        var rowsUsed = 0
        var colsRemaining = cols
        var i = 0
        while (rowsUsed < rows) {
            val word = sentence[i]
            i += 1

            if (word.length > cols) {
                return 0
            }

            if (word.length <= colsRemaining) {
                colsRemaining -= word.length + 1
            } else {
                rowsUsed += 1
                if (rowsUsed == rows) {
                    return fits
                }
                colsRemaining = cols - word.length - 1
            }

            if (i > sentence.lastIndex) {
                fits += 1
                i = 0
            }
        }
        return fits
    }
}

fun main() {
    val result = SentenceScreenFitting().wordsTyping(
        arrayOf("f","p","a"),
        2,
        7
    )

    print(result)
}