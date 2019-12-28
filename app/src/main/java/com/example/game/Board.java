package com.example.game;

import java.util.Arrays;

public class Board {
    private int boardSize = 3;
    private ElState[][] board = new ElState[boardSize][boardSize];

    public Board() {
        for (int i =0; i< boardSize; i++) {
            Arrays.fill(board[i], ElState.E);
        }
    }

    public void setElement(int xIndex, int yIndex, ElState value) {
        board[xIndex][yIndex] = value;
    }

    public ElState getElement(int xIndex, int yIndex) {
        return board[xIndex][yIndex];
    }

    void print() {
        System.out.println("--- BOARD ---");
        for (int i=0; i<boardSize; i++) {
            System.out.println(board[i][0] + " " + board[i][1] + " " + board[i][2]);
        }
        System.out.println("--- BOARD ---");
    }
}
