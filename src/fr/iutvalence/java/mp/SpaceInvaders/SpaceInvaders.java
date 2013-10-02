package fr.iutvalence.java.mp.SpaceInvaders;

//TODO (fixed) Fix comment, this class is everything but a launch menu
/**
 * class SpaceInvaders : A new game
 * @author thevenim
 */
public class SpaceInvaders 
{ 
    // TODO (fixed) write a comment
    /**
     * Declaration of the grid cell numbers
     */
    public final static int CONSTANT_GRID = 15;

    // TODO (fixed) write a comment
    /**
     * Declaration of the value which represent the Spacecraft
     */
    public final static int CONSTANT_SPACECRAFT = 7;

    // TODO (fixed) write a comment 
    /**
     * Declaration of the value which represent the Ennemy
     */
    public final static int CONSTANT_ENNEMY = 6;

    // TODO (fixed) write a comment 
    /**
     * Declaration of the value which represent the Fire
     */
    public final static int CONSTANT_FIRE = 1;

    // TODO (fixed) write a comment 
    /**
     * Declaration of the value which represent the Void
     */
    public final static int CONSTANT_EMPTY = 0;

    // TODO (fixed) write a comment 
    /**
     * Declaration of the lines
     */
    public final static int CONSTANT_PLACE_SPACECRAFT_X = 14;

    // TODO (fixed) write a comment
    /**
     * Declaration of the value which represent the columns
     */
    public final static int CONSTANT_PLACE_SPACECRAFT_Y = 7;

    // TODO (fixed) write a comment
    /**
     * Declaration of the Grid
     */
    private int[][] grid;

    // TODO (fixed) write a comment
    /**
     * Declaration of the Spacecraft
     */
    private int spacecraft;

    // TODO (fixed) write a comment
    /**
     * Declaration of the Ennemy
     */
    private int ennemy;

    // TODO (fixed) write a comment 
    /**
     * Declaration of the Fire
     */
    private int fire;

    // TODO (fixed) write a comment 
    /**
     * Declaration of the Void
     */
    private int empty;

    // TODO (fixed) write a comment 
    /**
     * Declaration of the default constructor
     */
    public SpaceInvaders()
    {   
        this.grid = new int [CONSTANT_GRID][CONSTANT_GRID];
        this.spacecraft = CONSTANT_SPACECRAFT;
        this.ennemy = CONSTANT_ENNEMY;
        this.fire = CONSTANT_FIRE;
        this.empty = CONSTANT_EMPTY;
        // TODO créer une fonction pour alléger le programme qui parcours le tableau
        //        static void parcours(int i, int j, int k, int l)
        //        {
        //          for(String str : tabBis)
        //            System.out.println(str);
        //        }








        // fill the grid with "empty" value
        for(int x=0; x<15; x++)
        {
            for (int y=0; y<15; y++)
            {
                this.grid[x][y]= CONSTANT_EMPTY;   
            }
        }
        this.grid[CONSTANT_PLACE_SPACECRAFT_X][CONSTANT_PLACE_SPACECRAFT_Y]=CONSTANT_SPACECRAFT;

        // put ennemies
        for(int x=0; x<3; x++)
        {
            for(int y = 1; y<14; y++)
            {
                this.grid[x][y] = CONSTANT_ENNEMY;
            }
        }
        // display the ennemies' grid
        while(true)
        {
            for(int x=0; x<15; x++)
            {
                for(int y = 0; y<15; y++)
                {
                    if (this.grid[x][y]==CONSTANT_EMPTY)
                    {
                        System.out.print("V");
                    }
                    else 
                    {
                        System.out.print(this.grid[x][y]);
                    }    
                 }
                System.out.println();
            }
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            // move ennemies to right
            for(int x=0; x<15; x++)
            {
                for(int y = 2; y<15; y++)
                {
                    this.grid[x][y]=CONSTANT_ENNEMY;
                }
            }            
        } 
    }
}
