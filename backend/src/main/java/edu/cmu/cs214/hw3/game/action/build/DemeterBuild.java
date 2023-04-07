package edu.cmu.cs214.hw3.game.action.build;

import edu.cmu.cs214.hw3.game.Board;

public class DemeterBuild extends BuildAction{
    private int prevRow = -1;
    private int prevCol = -1;

    @Override
    public boolean validateBuild(int r, int c, int newR, int newC, String playerName, Board board, boolean isDome) throws Exception {
        boolean result = super.validateBuild(r, c, newR, newC, playerName, board, isDome);
        if (newR != prevRow || newC != prevCol){
            if (result){
                prevRow = newR;
                prevCol = newC;
            }
            return result;
        } else {
            super.setOkToBuild(false);
            throw new Exception("Cannot build on previously built grid");
        }
    }

    @Override
    public double nextAction(double curPlayerAction){
        if (curPlayerAction == 5){
            return 5.5;
        } else if (curPlayerAction == 5.5){
            prevRow = -1;
            prevCol = -1;
            return 2;
        }
        return curPlayerAction;
    }

    @Override
    public int nextPlayer(double curPlayerAction, int curPlayer){
        if (curPlayerAction == 2){
            return (curPlayer + 1) % 2;
        } else {
            return curPlayer;
        }
    }

}
