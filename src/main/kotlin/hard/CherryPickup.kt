package hard

import kotlin.math.max

// Incomplete
class CherryPickup {
    fun cherryPickup(grid: Array<IntArray>): Int {
        var n = grid.size
        var cherries = 0
        cherries += dp(0, 0, grid, mutableMapOf())
        for (i in grid.indices) {
            for (j in grid.indices) {
                print("${grid[i][j]}, ")
            }
            println()
        }
//        cherries += dpBackwards(n-1, n-1, grid, mutableMapOf())
        return cherries
    }

    fun dp(row: Int, col: Int, grid: Array<IntArray>, memo: MutableMap<Pair<Int, Int>, Int>): Int {
        if (row >= grid.size || row < 0 || col >= grid.size || col < 0 || grid[row][col] == -1) {
            return 0
        }
        if (memo.containsKey(Pair(row, col))) {
            return memo[Pair(row, col)]!!
        }

        var maxCherries = 0
        maxCherries = max(maxCherries, dp(row + 1, col, grid, memo) + grid[row][col])
        maxCherries = max(maxCherries, dp(row, col + 1, grid, memo) + grid[row][col])

        memo[Pair(row, col)] = maxCherries
        grid[row][col] = maxCherries

        return maxCherries
    }

    fun dpBackwards(row: Int, col: Int, grid: Array<IntArray>, memo: MutableMap<Pair<Int, Int>, Int>): Int {
        if (row >= grid.size || row < 0 || col >= grid.size || col < 0 || grid[row][col] == -1) {
            return 0
        }
        if (memo.containsKey(Pair(row, col))) {
            return memo[Pair(row, col)]!!
        }

        var maxCherries = 0
        maxCherries = max(maxCherries, dp(row - 1, col, grid, memo) + grid[row][col])
        maxCherries = max(maxCherries, dp(row, col - 1, grid, memo) + grid[row][col])

        memo[Pair(row, col)] = maxCherries
        grid[row][col] = 0

        return maxCherries
    }
}

fun main() {
    CherryPickup().cherryPickup(
        arrayOf(
            intArrayOf(0, 1, -1),
            intArrayOf(1, 0, -1),
            intArrayOf(1, 1, 1)
        )
    )
}
