package medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PrisonCellsAfterNDaysTest {

    @Test
    fun `test state conversion to next`() {
        val oldState = intArrayOf(0, 1, 0, 1, 1, 0, 0, 1)
        val newState = oldState.copyOf()
        PrisonCellsAfterNDays().convertToNextState(newState)
        assertArrayEquals(newState, intArrayOf(0, 1, 1, 0, 0, 0, 0, 0))
    }

    @Test
    fun `test fast track for exact same day`() {
        val result = PrisonCellsAfterNDays().prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 15)
        val expectedResult = intArrayOf(0, 1, 1, 0, 0, 0, 0, 0)
        assertArrayEquals(result, expectedResult)
    }

    @Test
    fun `test fast track for exact same day + 1 day`() {
        val result = PrisonCellsAfterNDays().prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 16)
        assertArrayEquals(result, intArrayOf(0, 0, 0, 0, 1, 1, 1, 0))
    }

    @Test
    fun `test fast track for exact same day after 2 cycles`() {
        val result = PrisonCellsAfterNDays().prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 29)
        assertArrayEquals(result, intArrayOf(0, 1, 1, 0, 0, 0, 0, 0))
    }

    @Test
    fun `test fast track for exact same day after 2 cycles + 1 day`() {
        val result = PrisonCellsAfterNDays().prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 30)
        assertArrayEquals(result, intArrayOf(0, 0, 0, 0, 1, 1, 1, 0))
    }

    @Test
    fun `test should return the same state when n = 0`() {
        val result = PrisonCellsAfterNDays().prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 0)
        assertArrayEquals(result, intArrayOf(0, 1, 0, 1, 1, 0, 0, 1))
    }
}