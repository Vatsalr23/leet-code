package hard

class `N-Queens` {

    fun solveNQueens(n: Int): List<List<String>> {
        val queen = Queen(n)
        val results = mutableListOf<List<String>>()
        backtrack(queen, results, 0)
        return results
    }

    private fun backtrack(queen: Queen, results: MutableList<List<String>>, row: Int) {
        if (row > queen.boardSize) return
        if (queen.queensPlaced == queen.boardSize) {
            results.add(queen.board.map { String(it) })
            return
        }

        repeat(queen.boardSize) { col ->
            if (queen.canPlace(row, col)) {
                queen.updatePosition(row, col, Queen.Move.PLACE)
                backtrack(queen, results, row + 1)
                queen.updatePosition(row, col, Queen.Move.REMOVE)
            }
        }
    }

    class Queen(val boardSize: Int) {

        var queensPlaced = 0
        var board = Array(boardSize) { CharArray(boardSize) { '.' } }

        enum class Move {
            PLACE,
            REMOVE
        }

        val mainDiagonals: BooleanArray = BooleanArray(2 * boardSize - 1) { false }
        val antiDiagonals: BooleanArray = BooleanArray(2 * boardSize - 1) { false }
        val cols: BooleanArray = BooleanArray(boardSize) { false }
        val rows: BooleanArray = BooleanArray(boardSize) { false }

        private fun updateBoard(row: Int, col: Int, move: Move) {
            board[row][col] = when (move) {
                Move.PLACE -> 'Q'
                Move.REMOVE -> '.'
            }
        }

        fun updatePosition(row: Int, col: Int, move: Move): Boolean {
            val positionBoolean = when(move) {
                Move.PLACE -> {
                    if (!canPlace(row, col)) {
                        return false
                    }
                    queensPlaced += 1
                    true
                }
                Move.REMOVE -> {
                    queensPlaced -= 1
                    false
                }
            }
            updateBoard(row, col, move)

            antiDiagonals[row + col] = positionBoolean
            cols[col] = positionBoolean
            rows[row] = positionBoolean
            mainDiagonals[col - row + (boardSize - 1)] = positionBoolean

            return true
        }

        fun canPlace(row: Int, col: Int): Boolean {
            return !antiDiagonals[row + col] &&
                !cols[col] &&
                !rows[row] &&
                !mainDiagonals[col - row + (boardSize - 1)]
        }
    }
}
