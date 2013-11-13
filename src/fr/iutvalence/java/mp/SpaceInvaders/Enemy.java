package fr.iutvalence.java.mp.SpaceInvaders;

public class Enemy
{
    /**
     * To know if the enemy is dead or alive
     */
    private String state;
    private int currentEnemiesLine;
    private int yLeft;
    private int yCenter;
    private int yRight;
    

    public Enemy()
    {
      this.state =  "Alive";
      this.yLeft = 0;
      this.yCenter = 1;
      this.yRight = 2;
    }
    /**
     * to have access of the enemy's position
     * @param yL
     * @param yC
     * @param yR
     */
    public void setY(int yL, int yC, int yR)
    {
       this.yLeft = yL; 
       this.yCenter = yC;
       this.yRight =yR;
    }

}
