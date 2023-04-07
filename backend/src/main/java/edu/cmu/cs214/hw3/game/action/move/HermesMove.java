package edu.cmu.cs214.hw3.game.action.move;

import edu.cmu.cs214.hw3.game.Board;

public class HermesMove extends MoveAction{

    private boolean isPowerTriggered;

    private boolean requireNextAction;

    @Override
    public boolean validateMove(int r, int c, int newR, int newC, Board board, String playerName) throws Exception {
        try{
            boolean result = super.validateMove(r, c, newR, newC, board, playerName);
            if (result){
                boolean isTowerLevelSame = board.getTowerLevel(r, c) == board.getTowerLevel(newR, newC);
                if (isPowerTriggered){
                    if(!isTowerLevelSame){
                        super.setOkToMove(false);
                        throw new Exception("Hermes power is already triggered, cannot move up or down");
                    }
                } else {
                    if(isTowerLevelSame){
                        isPowerTriggered = true;
                    } else {
                        requireNextAction = true;
                    }
                }
            }
            return result;
        } catch (Exception e){
            if (e.getMessage().equals("worker already exists in the about-to-move cell") && r == newR && c == newC){
                super.setOkToMove(true);
                requireNextAction = true;
            } else {
                throw e;
            }
        }

        return false;

    }

    @Override
    public void performMove(Board board, int r, int c, int newR, int newC) {
        if (!(isPowerTriggered && requireNextAction)){
            super.performMove(board, r, c, newR, newC);
        }
    }

    @Override
    public double nextAction(double curPlayerAction) {
        if (requireNextAction){
            isPowerTriggered = false;
            requireNextAction = false;
            return super.nextAction(curPlayerAction);
        } else {
            return 3.5;
        }

    }
}
