package edu.cmu.cs214.hw3.game.action.move;

import edu.cmu.cs214.hw3.game.Board;

public class MinotaurMove extends MoveAction{
//    private boolean okToMove;
    private boolean pushed;
    private int originR;
    private int originC;
    private int pushedToR;
    private int pushedTOC;

    @Override
    public boolean validateMove(int r, int c, int newR, int newC, Board board, String playerName) throws Exception {
        try{
            return super.validateMove(r, c, newR, newC, board, playerName);
        } catch (Exception e){
            if (board.getCellWorkerName(newR, newC).equals(playerName)){
                throw new Exception("You cannot push your own worker");
            } else if (e.getMessage().equals("worker already exists in the about-to-move cell")){
                int newNewR = newR + (newR - r);
                int newNewC = newC + (newC - c);

                // check if move is valid
                if ((newNewR < 0 || newNewC < 0) || (newNewR >= 5 || newNewC >= 5)) {
                    throw new IndexOutOfBoundsException("Minotaur is unable to push opponent out of gameboard");
                }

                // check if destined location already have a worker or not
                if (board.hasWorker(newNewR,newNewC)) {
                    throw new Exception("Minotaur is unable to push, because opponent worker have friend to back-him-up");
                } else {
                    this.pushed = true;
                    this.originR = newR;
                    this.originC = newC;
                    this.pushedToR = newNewR;
                    this.pushedTOC = newNewC;
                    super.setOkToMove(true);
                    return true;
                }
            } else {
                throw e;
            }
        }
    }

    @Override
    public void performMove(Board board, int r, int c, int newR, int newC) {
        if (pushed){
            board.moveWorker(originR, originC, pushedToR, pushedTOC);
            pushed = false;
        }

        if (super.isOkToMove()){
            super.performMove(board, r, c, newR, newC);
        }

    }
}
