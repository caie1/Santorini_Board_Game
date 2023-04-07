package edu.cmu.cs214.hw3.game;

public class Tower {

    private int level;
    private boolean hasDome;

    public Tower(int level){
        this.level = level;
    }

    public Tower(){
        this.level = 0;
        this.hasDome = false;
    }

    /**
     * build the tower
     * @param isDome check if to build dome or not
     * @throws Exception
     */
    public void build(boolean isDome) throws Exception {
        if (isDome){
            if (level < 3){
                throw new Exception("tower is not tall enough to have a dome");
            }else{
                level = 4;
                hasDome = true;
            }
        }else{
            if (hasDome){
                throw new Exception("tower already have a dome, can not build block any more.");
            }else if (level >= 4){
                throw new Exception("tower can not add more block");
            }else{
                level++;
            }
        }
    }

    public int getLevel(){
        if (hasDome) {
            return 4;
        }
        return level;
    }
    
    public boolean hasDome(){
        return hasDome;
    }

    @Override
    public String toString() {
        return "Tower{" +
                "level=" + level +
                ", hasDome=" + hasDome +
                '}';
    }
}
