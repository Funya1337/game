package com.example.game;

import org.junit.Test;
import static org.junit.Assert.*;

public class WinnerTest {
    Board board = new Board();
    @Test
    public void rowTest() {
        board.setElement(0,0, ElState.X);
        board.setElement(1,1, ElState.O);
        board.setElement(0,1, ElState.X);
        board.setElement(1,2, ElState.O);
        board.setElement(0,2, ElState.X);
        assertEquals(ElState.X, board.checkForWinner());
    }
    @Test
    public void columnTest() {
        board.setElement(0,0, ElState.X);
        board.setElement(0,1, ElState.O);
        board.setElement(1,0, ElState.X);
        board.setElement(1,2, ElState.O);
        board.setElement(2,0, ElState.X);
        assertEquals(ElState.X, board.checkForWinner());
    }
    @Test
    public void diagonalTest() {
        board.setElement(0,0, ElState.X);
        board.setElement(0,1, ElState.O);
        board.setElement(1,1, ElState.X);
        board.setElement(2,1, ElState.O);
        board.setElement(2,2, ElState.X);
        assertEquals(ElState.X, board.checkForWinner());
    }
}
