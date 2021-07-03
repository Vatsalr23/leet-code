package medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumPointsYouCanObtainFromCardsTest {

    @Test
    fun `example 1`() {
        val result = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(1,2,3,4,5,6,1), 3)
        assertEquals(result, 12)
    }

    @Test
    fun `example 2`() {
        val result = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(2,2,2), 2)
        assertEquals(result, 4)
    }

    @Test
    fun `example 3`() {
        val result = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(9,7,7,9,7,7,9), 7)
        assertEquals(result, 55)
    }

    @Test
    fun `example 4`() {
        val result = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(1,1000,1), 1)
        assertEquals(result, 1)
    }

    @Test
    fun `example 5`() {
        val result = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(1,79,80,1,1,1,200,1), 4)
        assertEquals(result, 281)
    }
}