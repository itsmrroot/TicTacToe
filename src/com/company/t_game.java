package com.company;

import java.util.Random;
import java.util.Scanner;

public class t_game {

    private String currentPlayer = "X";
    private char[][] board = new char[3][3];

    public char[][] getBoard() { return board; }
    public void setBoard(char[][] board) { this.board = board; }
    public String getCurrentPlayer() { return currentPlayer; }
    public void setCurrentPlayer(String currentPlayer) { this.currentPlayer = currentPlayer; }

    public void initializeBoard() {
        board[0][0] = '7'; board[0][1] = '8'; board[0][2] = '9';
        board[1][0] = '4'; board[1][1] = '5'; board[1][2] = '6';
        board[2][0] = '1'; board[2][1] = '2'; board[2][2] = '3';
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++)
                System.out.print("| " + board[i][j] + " ");
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public void makeMove(Scanner scanner) {
        int row = -1, col = -1;
        boolean flag = false;
        int option;

        while (!flag) {
            try {
                System.out.print("Bitte geben Sie eine Zahl (1-9) ein: ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen 1 und 9 ein.");
                option = -1;
            }

            switch (option) {
                case 1: row = 2; col = 0; break;
                case 2: row = 2; col = 1; break;
                case 3: row = 2; col = 2; break;
                case 4: row = 1; col = 0; break;
                case 5: row = 1; col = 1; break;
                case 6: row = 1; col = 2; break;
                case 7: row = 0; col = 0; break;
                case 8: row = 0; col = 1; break;
                case 9: row = 0; col = 2; break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen 1 und 9 ein.");
                    break;
            }

            if (row == -1 || col == -1) {
                continue;
            } else if (Character.isDigit(board[row][col])) {
                board[row][col] = currentPlayer.charAt(0);
                flag = true;
            } else {
                System.out.println("Ungültiger Zug. Das Feld ist bereits besetzt. Bitte wählen Sie ein anderes Feld.");
                row = -1; col = -1;
            }
        }
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public String checkWinner() {
        return checkWinner(currentPlayer.charAt(0));
    }

    public String checkWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return String.valueOf(symbol);
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return String.valueOf(symbol);
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return String.valueOf(symbol);
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return String.valueOf(symbol);
        return "";
    }

    public boolean checkDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (Character.isDigit(board[i][j])) return false;
        return true;
    }

    public void computerMoveRandom() {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (Character.isDigit(board[row][col])) {
                board[row][col] = currentPlayer.charAt(0);
                break;
            }
        }
    }

    public int minimax(boolean isComputerTurn) {
        if (checkWinner('O').equals("O")) return 10;
        if (checkWinner('X').equals("X")) return -10;
        if (checkDraw()) return 0;

        if (isComputerTurn) {
            int bestScore = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Character.isDigit(board[i][j])) {
                        char saved = board[i][j];   // save original digit
                        board[i][j] = 'O';
                        int score = minimax(false);
                        board[i][j] = saved;        // restore original digit
                        if (score > bestScore) bestScore = score;
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Character.isDigit(board[i][j])) {
                        char saved = board[i][j];   // save original digit
                        board[i][j] = 'X';
                        int score = minimax(true);
                        board[i][j] = saved;        // restore original digit
                        if (score < bestScore) bestScore = score;
                    }
                }
            }
            return bestScore;
        }
    }

    public void computerMoveExpert() {
        int bestScore = -1000;
        int bestRow = -1, bestCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.isDigit(board[i][j])) {
                    char saved = board[i][j];       // save original digit
                    board[i][j] = 'O';
                    int score = minimax(false);
                    board[i][j] = saved;            // restore original digit
                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }
        board[bestRow][bestCol] = 'O';
    }
}