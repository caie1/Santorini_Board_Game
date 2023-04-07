package edu.cmu.cs214.hw3.game.action.move;

import edu.cmu.cs214.hw3.game.Board;
import edu.cmu.cs214.hw3.game.Worker;

public class ApolloMove extends MoveAction{

    private boolean reversed;
    private int originR;
    private int originC;
    private int reversedR;
    private int reversedC;

    @Override
    public boolean validateMove(int r, int c, int newR, int newC, Board board, String playerName) throws Exception {
        try{
            return super.validateMove(r, c, newR, newC, board, playerName);
        } catch (Exception e){
            if (board.getCellWorkerName(newR, newC).equals(playerName)){
                throw new Exception("You cannot force your own worker");
            } else if (e.getMessage().equals("worker already exists in the about-to-move cell")){
                this.reversed = true;
                this.originR = newR;
                this.originC = newC;
                this.reversedR = r;
                this.reversedC = c;
                super.setOkToMove(true);
                return true;
            } else {
                throw e;
            }
        }
    }

    @Override
    public void performMove(Board board, int r, int c, int newR, int newC) {
        if (reversed){
            board.swapWorker(originR, originC, reversedR, reversedC);
            reversed = false;
        } else {
            if (super.isOkToMove()){
                super.performMove(board, r, c, newR, newC);
            }
        }
    }
}
