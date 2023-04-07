package edu.cmu.cs214.hw3.game;

public class Cell {
    private final int row;
    private final int col;
    private Worker worker;
    private Tower tower;

    public Cell(int i, int j){
        this.row = i;
        this.col = j;
        this.worker = null;
        this.tower = new Tower();
    }

    /**
     * build the tower in this cell
     * @param isDome indicate if the about-to-build tower is dome or not
     * @throws Exception
     */
    public void build(boolean isDome) throws Exception{
        tower.build(isDome);
    }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public Worker getWorker(){
        return worker;
    }

    public void setWorker(Worker w){
        worker = w;
    }

    public Tower getTower(){
//        System.out.println("triggered here");
        return tower;
    }

    public void setTower(Tower t){
        tower = t;
    }

    /**
     * get the tower level depending on the tower of this cell
     * @return integer representing the tower level, 0 if no tower is build
     */
    public int getTowerLevel(){
        if (hasTower()){
            if (tower.hasDome()){
                return 4;
            } else {
                return tower.getLevel();
            }
        } else {
            return 0;
        }
    }

    public boolean hasTower(){
        return tower != null;
    }

    public boolean hasWorker(){
        if (worker != null){
            return !worker.getPlayerName().equals("");
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", worker=" + worker +
                ", tower=" + tower +
                '}';
    }
}
