package medium

import common.LeetCodeUrl
import common.Topic
import common.Topics

@Topics([Topic.DFS, Topic.ARRAY])
@LeetCodeUrl("https://leetcode.com/problems/number-of-islands/")
class NumberOfIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        // Visited 2D array can be avoided by simply modifying the grid value to 0 and skip those iterations.
        // This method would depend on the requirement whether grid can be modified.
        val visited = Array(grid.size) { BooleanArray(grid.first().size) }
        var islands = 0

        for (i in grid.indices) {
            for (j in grid.first().indices) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // Once the dfs search returns we have found 1 island and marked the corresponding land as visited.
                    dfs(i, j, visited, grid)
                    islands += 1
                }
            }
        }

        return islands
    }

    private fun dfs(m: Int, n: Int, visited: Array<BooleanArray>, grid: Array<CharArray>) {
        visited[m][n] = true

        val neighbors = listOf(
            Pair(m, n + 1),
            Pair(m, n - 1),
            Pair(m - 1, n),
            Pair(m + 1, n)
        ).filterNot {
            // Filter out of bound indices, indices that have been visited already & where grid position value is 0
            val (i, j) = it
            (i < 0 || i >= grid.size)
                    || (j < 0 || j >= grid.first().size)
                    || (visited[i][j])
                    || (grid[i][j] == '0')
        }

        for (neighbor in neighbors) {
            val (i, j) = neighbor
            dfs(i, j, visited, grid)
        }
    }
}

@Topics([Topic.DFS, Topic.ARRAY])
@LeetCodeUrl("https://leetcode.com/problems/number-of-islands/")
class NumberOfIslands2 {
    fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0

        for (i in grid.indices) {
            for (j in grid.first().indices) {
                if (grid[i][j] == '1') {
                    // Once the dfs search returns we have found 1 island and marked the corresponding land as visited.
                    dfs(i, j, grid)
                    islands += 1
                }
            }
        }

        return islands
    }

    private fun dfs(m: Int, n: Int, grid: Array<CharArray>) {
        // Mark grid value as 0 to note that it's visited
        grid[m][n] = '0'

        val neighbors = listOf(
            Pair(m, n + 1),
            Pair(m, n - 1),
            Pair(m - 1, n),
            Pair(m + 1, n)
        ).filterNot {
            // Filter out of bound indices & where grid position value is 0
            val (i, j) = it
            (i < 0 || i >= grid.size)
                    || (j < 0 || j >= grid.first().size)
                    || (grid[i][j] == '0')
        }

        for (neighbor in neighbors) {
            val (i, j) = neighbor
            dfs(i, j, grid)
        }
    }
}

fun main() {
    val sample = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println("Islands: " + NumberOfIslands().numIslands(sample))
}
