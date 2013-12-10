package fr.iutvalence.java.mp.SpaceInvaders;


/**
 * My first Thread
 * @author thevenim
 *
 */
public class ThreadAsk extends Thread
{
    /**
     * A variable of SpaceInvaders Type
     */
    private SpaceInvaders spaceInvadersThread;
    
    /**
     * Default constructor of our thread
     */
    public ThreadAsk()
    {
       super(); // TODO Auto-generated constructor stub
    }
    
    /**
     * Thread with parameter
     * @param newGame // parameter of our thread, his type is SpaceInvaders
     */
    public ThreadAsk(SpaceInvaders newGame)
    {
        super();
        this.spaceInvadersThread = newGame;
    }
    
    // what the thread do
    public void run()
    {
       while (true) {this.spaceInvadersThread.askToMoveOrShoot();}
        
    }

}
