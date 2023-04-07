package edu.cmu.cs214.hw3.game.action.build;

import edu.cmu.cs214.hw3.game.Board;

public class NormalBuild extends BuildAction{
    @Override
    public boolean validateBuild(int r, int c, int newR, int newC, String playerName, Board board, boolean isDome) throws Exception {
        return super.validateBuild(r, c, newR, newC, playerName, board, isDome);
    }
}
