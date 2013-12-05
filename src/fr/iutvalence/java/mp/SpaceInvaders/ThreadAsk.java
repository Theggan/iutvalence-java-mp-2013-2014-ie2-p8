package fr.iutvalence.java.mp.SpaceInvaders;


/**
 * My first Thread
 * @author thevenim
 *
 */
public class ThreadAsk extends Thread
{

    public ThreadAsk()
    {
       super(); // TODO Auto-generated constructor stub
    }
    /**
     * Thread with parameter
     * @param name
     */
    public ThreadAsk(String name)
    {
        super(name);
    }
    
    public void run()
    {
        SpaceInvaders ask = new SpaceInvaders();
        while(true)
        ask.askToMoveOrShoot();
    }

}
