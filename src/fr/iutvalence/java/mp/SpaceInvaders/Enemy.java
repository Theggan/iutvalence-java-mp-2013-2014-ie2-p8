package fr.iutvalence.java.mp.SpaceInvaders;

/**
 * Class of enemy
 * @author thevenim
 *
 */
public class Enemy
{
    /**
     * To know if the enemy is dead or alive
     */
    private String state;
    private int yLeft;
    private int yCenter;
    private int yRight;
    

    /**
     * to create default enemy
     */
    public Enemy()
    {
      this.state =  "Alive";
      this.yLeft = 0;
      this.yCenter = 1;
      this.yRight = 2;
    }
    
    
    /**
     * to create enemy with parameters
     * @param pyLeft
     * @param pyCenter
     * @param pyRight
     */
    public Enemy(int pyLeft,int pyCenter, int pyRight)
    {
        this.state = "Alive";
        this.yLeft = pyLeft;
        this.yCenter = pyCenter;
        this.yRight = pyRight;
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
       this.yRight = yR;
    }
    public void setState(String changeState)
    {
        this.state = changeState;
    }
    
    
    public int getY()
    {
        return (this.yLeft);
    }
    
    public String toString()
    {
        return "6";
    }
}
