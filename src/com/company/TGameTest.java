package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TGameTest {

    private t_game game;

    @BeforeEach
    void setUp() {
        game = new t_game();
        game.initializeBoard();
    }

    @Test
    void detectsHorizontalWin() {
        char[][] board = game.getBoard();
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';

        assertEquals("X", game.checkWinner('X'));
    }

    @Test
    void detectsVerticalWin() {
        char[][] board = game.getBoard();
        board[0][1] = 'O';
        board[1][1] = 'O';
        board[2][1] = 'O';

        assertEquals("O", game.checkWinner('O'));
    }

    @Test
    void detectsDiagonalWin() {
        char[][] board = game.getBoard();
        board[0][0] = 'X';
        board[1][1] = 'X';
        board[2][2] = 'X';

        assertEquals("X", game.checkWinner('X'));
    }

    @Test
    void detectsAntiDiagonalWin() {
        char[][] board = game.getBoard();
        board[0][2] = 'O';
        board[1][1] = 'O';
        board[2][0] = 'O';

        assertEquals("O", game.checkWinner('O'));
    }

    @Test
    void noWinnerOnFreshBoard() {
        assertEquals("", game.checkWinner('X'));
        assertEquals("", game.checkWinner('O'));
    }

    @Test
    void detectsDrawWhenBoardIsFull() {
        char[][] board = game.getBoard();
        // Fill every cell with a letter (no winner, board just full)
        char[][] fullNonWinningBoard = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };
        game.setBoard(fullNonWinningBoard);

        assertTrue(game.checkDraw());
    }

    @Test
    void notADrawWhileEmptyCellsRemain() {
        // initializeBoard() leaves digit placeholders, meaning cells are "empty"
        assertFalse(game.checkDraw());
    }

    @Test
    void minimaxPicksWinningMoveForComputer() {
        // Computer ('O') can win immediately by playing the bottom-right corner
        char[][] board = {
                {'O', 'O', '9'},
                {'4', 'X', '6'},
                {'X', '2', '3'}
        };
        game.setBoard(board);

        game.computerMoveExpert();

        // After the expert move, the computer should have completed the top row
        assertEquals('O', game.getBoard()[0][2]);
    }
}
