package minesweeperw;

import java.util.Scanner;

public class Minesweeper.java {

    private static final int GRID_SIZE = 5;
    private static final int NUM_MINES = 5;
    private char[][] board;
    private boolean[][] mines;

    public Minesweeper() {
        board = new char[GRID_SIZE][GRID_SIZE];
        mines = new boolean[GRID_SIZE][GRID_SIZE];
        initializeBoard();
        placeMines();
    }

    private void initializeBoard() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void placeMines() {
        int placedMines = 0;
        while (placedMines < NUM_MINES) {
            int x = (int) (Math.random() * GRID_SIZE);
            int y = (int) (Math.random() * GRID_SIZE);
            if (!mines[x][y]) {
                mines[x][y] = true;
                placedMines++;
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("Welcome to Minesweeper!");
        while (gameRunning) {
            printBoard();
            System.out.print("Enter row and column (e.g., 0 1): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (mines[row][col]) {
                System.out.println("Boom! You hit a mine. Game Over.");
                gameRunning = false;
            } else {
                board[row][col] = 'O'; // O for Opened cell
                System.out.println("Safe! Keep going.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.startGame();
    }
}