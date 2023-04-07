package edu.cmu.cs214.hw3.game;

public class Worker {
    private String playerName;

    private int workerId;

    public Worker(){
        playerName = "";
    }

    public Worker(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean checkName(String playerName){
        return this.playerName.equals(playerName);
    }


    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "playerName='" + playerName + '\'' +
                '}';
    }


}
