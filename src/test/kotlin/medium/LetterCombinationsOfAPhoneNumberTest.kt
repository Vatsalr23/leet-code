package medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LetterCombinationsOfAPhoneNumberTest {

    @Test
    fun `should return empty list for empty digits`() {
        val combinations = LetterCombinationsOfAPhoneNumber().letterCombinations("")
        assertEquals(combinations, emptyList<String>())
    }

    @Test
    fun `test digits - "2"`() {
        val combinations = LetterCombinationsOfAPhoneNumber().letterCombinations("2")
        assertEquals(combinations, listOf("a","b","c"))
    }

    @Test
    fun `test digits - "23"`() {
        val combinations = LetterCombinationsOfAPhoneNumber().letterCombinations("23")
        assertEquals(combinations, listOf("ad","ae","af","bd","be","bf","cd","ce","cf"))
    }
}