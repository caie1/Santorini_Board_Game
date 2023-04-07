package edu.cmu.cs214.hw3.game.action.wincheck;

import edu.cmu.cs214.hw3.game.Board;

public abstract class WinCheck {

    public boolean validateWin(int r, int c, Board board) {
        return board.getTowerLevel(r, c) == 3;
    }
}
