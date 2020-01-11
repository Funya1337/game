package com.example.game;

import java.util.Arrays;

public class Board {
    public int boardSize = 3;

    private ElState[][] board = new ElState[boardSize][boardSize];

    public Board() {
        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(board[i], ElState.E);
        }
    }

    public void setElement(int xIndex, int yIndex, ElState value) {
        board[xIndex][yIndex] = value;
    }

    public ElState getElement(int xIndex, int yIndex) {
        return board[xIndex][yIndex];
    }

    public ElState checkRowsForWin(int xIndex, int yIndex, ElState value) {
        board[xIndex][yIndex] = value;

        for (int i = 0; i < board.length; i++) {
            int winnerCounterCross = 0;
            int winnerCounterZero = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ElState.X) {
                    winnerCounterCross += 1;
                }
                if (board[i][j] == ElState.O) {
                    winnerCounterZero += 1;
                }
            }
            if (winnerCounterCross == board.length) {
                return ElState.X;
            }
            if (winnerCounterZero == board.length) {
                return ElState.O;
            }
        }
        return ElState.E;
    }

    public ElState checkColForWin(int xIndex, int yIndex, ElState value) {
        board[xIndex][yIndex] = value;
        for (int i = 0; i < board.length; i++) {
            int winnerCounterCross = 0;
            int winnerCounterZero = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == ElState.X) {
                    winnerCounterCross += 1;
                }
                if (board[j][i] == ElState.O) {
                    winnerCounterZero += 1;
                }
            }
            if (winnerCounterCross == board.length) {
                return ElState.X;
            }
            if (winnerCounterZero == board.length) {
                return ElState.O;
            }
        }
        return ElState.E;
    }

    public ElState checkDiagForWin(int xIndex, int yIndex, ElState value) {
        board[xIndex][yIndex] = value;

        int winnerCounterCross = 0;
        int winnerCounterZero = 0;

        for (int i = 0; i < board.length; i++) {
            int diag2 = (board.length - 1) - i;
            if (board[i][i] == ElState.X || board[i][diag2] == ElState.X) {
                winnerCounterCross += 1;
            }
            if (board[i][i] == ElState.O || board[i][diag2] == ElState.O) {
                winnerCounterZero += 1;
            }
        }
        if (winnerCounterCross == board.length) {
            return ElState.X;
        }
        if (winnerCounterZero == board.length) {
            return ElState.O;
        }
        return ElState.E;
    }
    public ElState checkForWinner(int xIndex, int yIndex, ElState value) {
        board[xIndex][yIndex] = value;
        if (checkColForWin(xIndex, yIndex, value) == ElState.X || checkRowsForWin(xIndex, yIndex, value) == ElState.X || checkDiagForWin(xIndex, yIndex, value) == ElState.X) {
            System.out.println("CROSS IS WINNER");
            return ElState.X;
        }
        if (checkColForWin(xIndex, yIndex, value) == ElState.O || checkRowsForWin(xIndex, yIndex, value) == ElState.O || checkDiagForWin(xIndex, yIndex, value) == ElState.O) {
            System.out.println("ZERO IS WINNER");
            return ElState.O;
        }
        return ElState.E;
    }

    void print() {
        System.out.println("--- BOARD BEGIN ---");
        for (int i=0; i<boardSize; i++) {
            System.out.println(board[i][0] + " " + board[i][1] + " " + board[i][2]);
        }
        System.out.println("--- BOARD END ---");
    }
}
