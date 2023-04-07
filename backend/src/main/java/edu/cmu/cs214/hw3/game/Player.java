package edu.cmu.cs214.hw3.game;

import java.util.ArrayList;

public class Player {
    private String name;

    private GodCard godCard;

    private Worker workerA;
    private Worker workerB;

    public Player() {
    }

    public Player(String name){
        this.name = name;
    }

    public Player(String name, Worker A, Worker B){
        this.name = name;
        this.workerA = A;
        this.workerA.setPlayerName(name);
        this.workerB = B;
        this.workerB.setPlayerName(name);
        this.godCard = null;
    }

    public void setName(String name){
        this.name = name;
        workerA.setPlayerName(name);
        workerB.setPlayerName(name);
    }

    public String getName(){
        return name;
    }

    public void setWorkerA(Worker w){
        if (workerA != null){
            workerA.setPlayerName("");
        }
        workerA = w;
        workerA.setPlayerName(name);
    }

    public void setWorkerB(Worker w){
        if (workerB != null){
            workerB.setPlayerName("");
        }
        workerB = w;
        workerB.setPlayerName(name);
    }

    public GodCard getGodCard() {
        return godCard;
    }

    public void setGodCard(GodCard godCard) {
        this.godCard = godCard;
    }

    public Worker getWorkerA() {
        return workerA;
    }

    public Worker getWorkerB() {
        return workerB;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", godCard=" + godCard +
                ", workerA=" + workerA +
                ", workerB=" + workerB +
                '}';
    }
}
