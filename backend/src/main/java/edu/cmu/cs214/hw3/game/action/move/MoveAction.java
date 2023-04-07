package edu.cmu.cs214.hw3.game.action.move;

import edu.cmu.cs214.hw3.game.Board;

public abstract class MoveAction {

    private boolean okToMove;
    public boolean validateMove(int r, int c, int newR, int newC, Board board, String playerName) throws Exception {

        if (!board.hasWorker(r, c)){
            throw new Exception("Cannot move worker because no worker in specified location");
        } else if (!board.nameMatch(r, c, playerName)) {
            throw new Exception("only worker owner can command the worker");
        }else {
            // check if move is valid
            if ((newR < 0 || newC < 0) || (newR >= 5 || newC >= 5)) {
                throw new IndexOutOfBoundsException("make this move will take the worker out of the board");
            }

            // check if destined location already have a worker or not
            if (board.hasWorker(newR,newC)) {
                throw new Exception("worker already exists in the about-to-move cell");
            } else if (Math.abs(newR - r) > 1 || Math.abs(newC - c) > 1) {
                throw new Exception("cannot move more than 1 cell");
            } else {
                // make the move, first check if the tower high is in range
                int currentTowerLevel = board.getTowerLevel(r, c);
                int targetTowerLevel = board.getTowerLevel(newR, newC);
                // if not in range, or if the tower has a dome, reject the move
                if (currentTowerLevel + 1 < targetTowerLevel) {
                    throw new Exception("Cannot move more one level higher");
                } else if (targetTowerLevel == 4) {
                    throw new Exception("cannot move to a tower with dome");
                } else {
                    okToMove = true;
                    return true;
                }
            }
        }
    }

    public void performMove(Board board, int r, int c, int newR, int newC){
        if (okToMove){
            board.moveWorker(r, c, newR, newC);
        }
    }

    public double nextAction(double curPlayerAction){
        return 5;
    }

    public double skipAction(double curPlayerAction){
        if (curPlayerAction < 4){
            curPlayerAction = 5;
        }
        return curPlayerAction;

    }

    public boolean isOkToMove() {
        return okToMove;
    }

    public void setOkToMove(boolean okToMove) {
        this.okToMove = okToMove;
    }
}
