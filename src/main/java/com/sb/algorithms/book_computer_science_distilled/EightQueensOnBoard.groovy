package com.sb.algorithms.book_computer_science_distilled

/*
Разместить 8 ферзей на доске так, чтобы они не были под атакой друг друга
 */
class EightQueensOnBoard {
    def board;
    def solution;

    public Object queens(board) {
        if (boardHasEightQueens()) {
            return board
        }
        foreach position in board.unattackedPositions {
            board.placeQueen(position)
            solution = queens(board)
            if (solution)
                return solution
            board.remiveQueen(position)
        }
        return false
    }
}
