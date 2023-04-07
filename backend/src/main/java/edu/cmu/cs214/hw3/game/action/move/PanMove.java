package edu.cmu.cs214.hw3.game.action.move;

import edu.cmu.cs214.hw3.game.Board;
import edu.cmu.cs214.hw3.game.action.wincheck.PanWin;

public class PanMove extends MoveAction{

    private PanWin panWin;

    @Override
    public boolean validateMove(int r, int c, int newR, int newC, Board board, String playerName) throws Exception {

        boolean result =  super.validateMove(r, c, newR, newC, board, playerName);
        if (result){
            if (board.getTowerLevel(r, c) > board.getTowerLevel(newR, newC)){
                panWin.incrementWinCon();
            }
        }

        return result;
    }

    public void setPanWin(PanWin panWin) {
        this.panWin = panWin;
    }
}
