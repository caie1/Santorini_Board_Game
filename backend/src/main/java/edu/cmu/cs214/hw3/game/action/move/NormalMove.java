package edu.cmu.cs214.hw3.game.action.move;

import edu.cmu.cs214.hw3.game.Board;

public class NormalMove extends MoveAction{
    @Override
    public boolean validateMove(int r, int c, int newR, int newC, Board board, String playerName) throws Exception {
        return super.validateMove(r, c, newR, newC, board, playerName);
    }
}
