package hard

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.STRING])
@LeetCodeUrl("https://leetcode.com/problems/text-justification/")
class TextJustification {

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()
        var i = 0

        while (i < words.size) {
            val numWordsCanFit = calculateNumberOfWordsFit(words, maxWidth, i)
            if (numWordsCanFit == 0) break
            result.add(generateJustifiedString(words, i, i + numWordsCanFit, maxWidth))
            i += numWordsCanFit
        }

        return result
    }

    private fun generateLeftJustifield(
        words: Array<String>,
        startIndex: Int,
        endIndexExclusive: Int,
        maxWidth: Int
    ): String {
        val string = StringBuilder()
        for (i in startIndex until endIndexExclusive) {
            string.append(words[i])
            if (i == endIndexExclusive - 1) break
            string.append(" ")
        }
        string.append(" ".repeat(maxWidth - string.length))
        return string.toString()
    }

    private fun generateJustifiedString(
        words: Array<String>,
        startIndex: Int,
        endIndexExclusive: Int,
        maxWidth: Int
    ): String {
        val numGaps = ((endIndexExclusive - startIndex) - 1)

        if (numGaps == 0 || (endIndexExclusive >= words.size)) {
            return generateLeftJustifield(words, startIndex, endIndexExclusive, maxWidth)
        }

        var spacesUsedByWords = 0
        for (i in startIndex until endIndexExclusive) {
            spacesUsedByWords += words[i].length
        }
        val leastSpaceCount = (maxWidth - spacesUsedByWords) / numGaps
        var unusedSpaces = (maxWidth - spacesUsedByWords) % numGaps

        val string = StringBuilder()
        for (i in startIndex until endIndexExclusive) {
            string.append(words[i])

            if (i == endIndexExclusive - 1) break

            if (unusedSpaces > 0) {
                unusedSpaces -= 1
                string.append(" ".repeat(leastSpaceCount + 1))
            } else {
                string.append(" ".repeat(leastSpaceCount))
            }
        }
        return string.toString()
    }

    private fun calculateNumberOfWordsFit(
        words: Array<String>,
        maxWidth: Int,
        startIndex: Int
    ): Int {
        var j = startIndex
        var wordsFitted = 0
        var widthRemaining = maxWidth
        while (j < words.size) {
            val wordLength = words[j].length
            if (widthRemaining == wordLength) {
                wordsFitted += 1
                break
            } else if (widthRemaining >= (wordLength + 1)) {
                widthRemaining -= (wordLength + 1)
            } else {
                break
            }

            wordsFitted += 1
            j += 1
        }

        return wordsFitted
    }
}

fun main() {
    val result = TextJustification().fullJustify(
        arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16
    )
    println(result)
}