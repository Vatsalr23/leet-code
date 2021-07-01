package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.MATH, Topic.SIMULATION])
@LeetCodeUrl("https://leetcode.com/problems/prison-cells-after-n-days/")
class PrisonCellsAfterNDays {
    private val primes = listOf(2, 3, 5, 7, 11, 13, 17, 19)

    fun prisonAfterNDays(cells: IntArray, n: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        var currentDay = 0
        var fastForward = false
        while (currentDay < n) {
            val hash = hashCells(cells)
            if (!fastForward) {
                if (map.containsKey(hash)) {
                    fastForward = true
                    val repeatDay = map.getValue(hash)
                    val repeatLength = currentDay - repeatDay
                    val remainingDaysAfterFastTrack = (n - currentDay) % repeatLength

                    // Fast forward current day to beginning day after fast tracking
                    currentDay = n - (remainingDaysAfterFastTrack)
                } else {
                    map[hash] = currentDay
                }
            }

            if (currentDay < n) {
                convertToNextState(cells)
                currentDay += 1
            }
        }

        return cells
    }

    fun convertToNextState(cells: IntArray) {
        val oldCells = cells.copyOf()
        cells[0] = 0
        cells[cells.lastIndex] = 0
        for (i in 1 until cells.lastIndex) {
            if (oldCells[i-1] == oldCells[i+1]) {
                cells[i] = 1
            } else {
                cells[i] = 0
            }
        }
    }

    private fun hashCells(cells: IntArray): Int {
        return cells.foldIndexed(1) { index: Int, acc: Int, i: Int ->
            if (i == 1) {
                acc * primes[index]
            } else {
                acc
            }
        }
    }
}

fun main() {
    PrisonCellsAfterNDays().prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 16)
}