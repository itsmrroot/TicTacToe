package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean running = true;
    public static boolean stillRunning = true;
    public static boolean gameEnded = false;
    public static t_game game = new t_game();

    public static void main(String[] args) {

        printWelcome();


        while (stillRunning) {
            switch (menu()) {
                case 1: stillRunning = false; break;
                case 2: printGoodbye(); stillRunning = false; running = false; break;
                default:
                    System.out.println("Bitte geben Sie eine gültige Nummer ein.");
                    System.out.println();
                    break;
            }
        }

        while (running) {
            switch (userChoose()) {
                case 1:
                    switch (gameLevel()) {
                        case 1: normalLevel(); break;
                        case 2: expertLevel(); break;
                        case 3: printGoodbye(); running = false; break;
                        default:
                            System.out.println("Bitte geben Sie eine gültige Nummer ein.");
                            break;
                    }
                    break;
                case 2: playGame(); break;
                case 3: printGoodbye(); running = false; break;
                default:
                    System.out.println("Bitte geben Sie eine gültige Nummer ein.");
                    System.out.println();
                    break;
            }
        }
    }

    public static void printWelcome() {
        System.out.println("========================================");
        System.out.println("     Willkommen bei Tic-Tac-Toe!       ");
        System.out.println("========================================\n");
    }

    public static void printGoodbye() {
        System.out.println("\nVielen Dank fürs Spielen von Tic-Tac-Toe!");
        System.out.println("Bis zum nächsten Mal!");
    }

    public static int menu() {
        int option = 0;
        System.out.print("""
            (1) Neues Spiel
            (2) Spiel beenden
            Wählen Sie eine Option (1–2): """);
        try {
            String line = scanner.nextLine().trim();
            option = Integer.parseInt(line);
            if (option < 1 || option > 2)
                throw new IllegalArgumentException("Die Zahl muss zwischen 1 und 2 liegen.");
        } catch (NumberFormatException e) {
            System.out.println("\nFehler: Bitte geben Sie eine gültige Zahl ein.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
        return option;
    }

    public static int userChoose() {
        int choose = 0;
        System.out.print("""
           Wollen Sie gegen Computer oder Spieler spielen?:
            (1) Computer
            (2) Spieler
            (3) Spiel beenden
            Wähle eine Option (1–3): """);
        try {
            String line = scanner.nextLine().trim();
            choose = Integer.parseInt(line);
            if (choose < 1 || choose > 3)
                throw new IllegalArgumentException("Die Zahl muss zwischen 1 und 3 liegen.");
        } catch (NumberFormatException e) {
            System.out.println("\nFehler: Bitte geben Sie eine gültige Zahl ein.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
        return choose;
    }

    public static int gameLevel() {
        int level = 0;
        System.out.print("""
           Wähle den Schwierigkeitsgrad:
            (1) Normal
            (2) Experte
            (3) Spiel beenden
            Wähle eine Option (1–3): """);
        try {
            String line = scanner.nextLine().trim();
            level = Integer.parseInt(line);
            if (level < 1 || level > 3)
                throw new IllegalArgumentException("Die Zahl muss zwischen 1 und 3 liegen.");
        } catch (NumberFormatException e) {
            System.out.println("\nFehler: Bitte geben Sie eine gültige Zahl ein.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
        return level;
    }


    public static void playGame() {
        do {
            game.initializeBoard();
            game.setCurrentPlayer("X");
            gameEnded = false;

            while (!gameEnded) {
                game.printBoard();
                System.out.println("Spieler " + game.getCurrentPlayer() + ", du bist am Zug.");
                game.makeMove(scanner);

                String winner = game.checkWinner();
                if (!winner.isEmpty()) {
                    game.printBoard();
                    System.out.println("Spieler " + winner + " hat gewonnen!");
                    gameEnded = true;
                } else if (game.checkDraw()) {
                    game.printBoard();
                    System.out.println("Das Spiel endet unentschieden!");
                    gameEnded = true;
                } else {
                    game.switchPlayer();
                }
            }
        } while (playAgain());
    }


    public static void normalLevel() {
        do {
            game.initializeBoard();
            game.setCurrentPlayer("X");
            gameEnded = false;

            while (!gameEnded) {
                game.printBoard();
                System.out.println("Du bist am Zug (X).");
                game.makeMove(scanner);

                String winner = game.checkWinner();
                if (!winner.isEmpty()) {
                    game.printBoard();
                    System.out.println("Spieler " + winner + " hat gewonnen!");
                    gameEnded = true;
                } else if (game.checkDraw()) {
                    game.printBoard();
                    System.out.println("Das Spiel endet unentschieden!");
                    gameEnded = true;
                } else {
                    game.switchPlayer();
                    System.out.println("Der Computer denkt nach...");
                    game.computerMoveRandom();

                    String computerWinner = game.checkWinner();
                    if (!computerWinner.isEmpty()) {
                        game.printBoard();
                        System.out.println("Der Computer hat gewonnen!");
                        gameEnded = true;
                    } else if (game.checkDraw()) {
                        game.printBoard();
                        System.out.println("Das Spiel endet unentschieden!");
                        gameEnded = true;
                    } else {
                        game.switchPlayer();
                    }
                }
            }
        } while (playAgain());
    }


    public static void expertLevel() {
        do {
            game.initializeBoard();
            game.setCurrentPlayer("X");
            gameEnded = false;

            while (!gameEnded) {
                game.printBoard();
                System.out.println("Du bist am Zug (X).");
                game.makeMove(scanner);

                String winner = game.checkWinner();
                if (!winner.isEmpty()) {
                    game.printBoard();
                    System.out.println("Spieler " + winner + " hat gewonnen!");
                    gameEnded = true;
                } else if (game.checkDraw()) {
                    game.printBoard();
                    System.out.println("Das Spiel endet unentschieden!");
                    gameEnded = true;
                } else {
                    game.switchPlayer();
                    System.out.println("Der Computer denkt nach...");
                    game.computerMoveExpert();

                    String computerWinner = game.checkWinner();
                    if (!computerWinner.isEmpty()) {
                        game.printBoard();
                        System.out.println("Der Computer hat gewonnen!");
                        gameEnded = true;
                    } else if (game.checkDraw()) {
                        game.printBoard();
                        System.out.println("Das Spiel endet unentschieden!");
                        gameEnded = true;
                    } else {
                        game.switchPlayer();
                    }
                }
            }
        } while (playAgain());
    }

    public static boolean playAgain() {
        System.out.print("\nMöchten Sie noch einmal spielen? (j/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("j");
    }

    public static String validInput(String input) throws InvalidInputException {
        if (input == null || input.isBlank() || input.matches("^[a-zA-ZäöüÄÖÜß]+$")) {
            throw new InvalidInputException("Eingabe enthält ungültige Zeichen!");
        }
        return input;
    }
}