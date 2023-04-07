package edu.cmu.cs214.hw3.game.action.build;

import edu.cmu.cs214.hw3.game.Board;
import edu.cmu.cs214.hw3.game.action.Action;

public abstract class BuildAction implements Action {

    private boolean okToBuild;

    public boolean validateBuild(int r, int c, int newR, int newC, String playerName, Board board, boolean isDome) throws Exception {
        // check for special cases
        if (!board.hasWorker(r, c)){
            throw new Exception("Cannot build because no worker in specified location");
        } else if (!board.nameMatch(r, c, playerName)){
            throw new Exception("Cannot build because the worker does not belong to the player");
        } else {
            if((newR < 0 || newC < 0) || (newR >= 5 || newC >= 5)){
                throw new IndexOutOfBoundsException("can not build when location is out of the board");
            }
            if (board.hasWorker(newR, newC)){
                throw new Exception("Cannot build because the distinated location alreay has a worker");
            }
            if (Math.abs(newR - r) > 1 || Math.abs(newC - c) > 1) {
                throw new Exception("can only build in adjacent cell");
            }
            this.okToBuild = true;
            return true;
        }
    }

    public void performBuild(Board board, int r, int c, int newR, int newC, boolean isDome) throws Exception {
        if (okToBuild){
            board.build(r, c, newR, newC, isDome);
        }
    }

    public double nextAction(double curPlayerAction){
        if (curPlayerAction > 4){
            return 2;
        }
        return curPlayerAction;
    }

    public int nextPlayer(double curPlayerAction, int curPlayer){
        if (curPlayerAction == 2){
            return (curPlayer + 1) % 2;
        } else {
            return curPlayer;
        }
//        return curPlayerAction + 1;
    }

    public double skipBuildAction(double curPlayerAction){
        if (curPlayerAction >= 4){
            curPlayerAction = 2;
        }
        return curPlayerAction;
    }


    public boolean isOkToBuild() {
        return okToBuild;
    }

    public void setOkToBuild(boolean okToBuild) {
        this.okToBuild = okToBuild;
    }
}
