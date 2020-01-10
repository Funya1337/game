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
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ElState.X) {
                    winnerCounterCross += 1;
                }
            }
            if (winnerCounterCross == board.length) {
                System.out.println("CROSS IS WINNER");
                return ElState.X;
            }
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
