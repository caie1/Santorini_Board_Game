package edu.cmu.cs214.hw3.game.action.wincheck;

import edu.cmu.cs214.hw3.game.Board;

public class PanWin extends WinCheck {

    public int winCount = 0;

    public PanWin() {
        super();
    }

    public boolean validateWin(int r, int c, Board board) {
        return super.validateWin(r, c, board) || winCount >= 2;
    }

    public void incrementWinCon(){
        winCount++;
    }
}
