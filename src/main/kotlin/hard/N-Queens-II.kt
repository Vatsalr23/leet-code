package hard

class `N-Queens-II` {
    fun totalNQueens(n: Int): Int {
        val queen = Queen(n)
        return backtrack(queen, 0)
    }

    private fun backtrack(queen: Queen, row: Int): Int {
        if (row > queen.boardSize) return 0
        if (queen.queensPlaced == queen.boardSize) return 1

        var total = 0
        repeat(queen.boardSize) { col ->
            if (queen.canPlace(row, col)) {
                queen.updatePosition(row, col, Queen.Move.PLACE)
                total += backtrack(queen, row + 1)
                queen.updatePosition(row, col, Queen.Move.REMOVE)
            }
        }

        return total
    }

    class Queen(val boardSize: Int) {

        var queensPlaced = 0

        enum class Move {
            PLACE,
            REMOVE
        }

        val mainDiagonals: BooleanArray = BooleanArray(2 * boardSize - 1) { false }
        val antiDiagonals: BooleanArray = BooleanArray(2 * boardSize - 1) { false }
        val cols: BooleanArray = BooleanArray(boardSize) { false }

        fun updatePosition(row: Int, col: Int, move: Move) {
            val positionBoolean = when(move) {
                Move.PLACE -> {
                    if (!canPlace(row, col)) {
                        return
                    }
                    queensPlaced += 1
                    true
                }
                Move.REMOVE -> {
                    queensPlaced -= 1
                    false
                }
            }

            antiDiagonals[row + col] = positionBoolean
            cols[col] = positionBoolean
            mainDiagonals[col - row + (boardSize - 1)] = positionBoolean
        }

        fun canPlace(row: Int, col: Int): Boolean {
            return !antiDiagonals[row + col] &&
                    !cols[col] &&
                    !mainDiagonals[col - row + (boardSize - 1)]
        }
    }
}