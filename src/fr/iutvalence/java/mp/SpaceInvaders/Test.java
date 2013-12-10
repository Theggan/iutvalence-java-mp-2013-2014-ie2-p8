package fr.iutvalence.java.mp.SpaceInvaders;

/**
 * The class where we will execute the main program
 * @author thevenim
 *
 */

public class Test
{
    
    public static void main(String[] args)
    {
        SpaceInvaders newGame = new SpaceInvaders();
       
         
        // TODO (fix) play should be called only once.
           ThreadAsk ask = new ThreadAsk(newGame);
           ask.start();
          
           while (true) {newGame.play();}


    }

}
