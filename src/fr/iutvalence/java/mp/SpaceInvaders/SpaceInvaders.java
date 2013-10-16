package fr.iutvalence.java.mp.SpaceInvaders;

/**
 * class SpaceInvaders : A new game
 * @author thevenim
 */
public class SpaceInvaders 
{ 
    // TODO (fix) rewrite comment
    /**
     * Declaration of the grid cell numbers
     */
    public final static int CONSTANT_GRID = 15;

    /**
     * Declaration of the value which represent the Spacecraft
     */
    public final static int CONSTANT_SPACECRAFT = 7;

    /**
     * Declaration of the value which represent the Enemy
     */
    public final static int CONSTANT_ENEMY = 6;

    /**
     * Declaration of the value which represent the Fire
     */
    public final static int CONSTANT_FIRE = 1;

    /**
     * Declaration of the value which represent the Void
     */
    public final static int CONSTANT_EMPTY = 0;

    /**
     * Declaration of the lines
     */
    public final static int CONSTANT_PLACE_SPACECRAFT_X = 14;

    /**
     * Declaration of the value which represent the columns
     */
    public final static int CONSTANT_PLACE_SPACECRAFT_Y = 7;

    // TODO (fix) rewrite comment
    /**
     * Declaration of the Grid
     */
    private int[][] grid;

    /**
     * Declaration of the enemies counter 
     */
    // TODO (fix) rename field
    // TODO (fix) initialize field in a constructor
    private int counterOfEnemiesPlace = 2 ;

    // TODO (think about it) what is the purpose of this field?
    // TODO (fixed) write a comment
    /**
     * Declaration of the Spacecraft
     */
    private int spacecraft;

    // TODO (think about it) what is the purpose of this field?
    /**
     * Declaration of the Enemy
     */
    private int enemy;

    // TODO (think about it) what is the purpose of this field?
    /**
     * Declaration of the Fire
     */
    private int fire;

    // TODO (think about it) what is the purpose of this field?
    /**
     * Declaration of the Void
     */
    private int empty;

    
    // TODO (think about it) what is the purpose of this field?
    /**
     * Declaration of the ChangeSide
     */
    private int changeSide;
    
    // TODO (think about it) what is the purpose of this field?
    /**
     * declaration of the ChangeLine
     */
    private int changeLine;

    // TODO (fix) rewrite comment
    /**
     * Declaration of the default constructor
     */
    public SpaceInvaders()
    {   
        this.grid = new int [CONSTANT_GRID][CONSTANT_GRID];
        this.spacecraft = CONSTANT_SPACECRAFT;
        this.enemy = CONSTANT_ENEMY;
        this.fire = CONSTANT_FIRE;
        this.empty = CONSTANT_EMPTY;
        this.changeSide = 0;
        this.changeLine = 0;
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

        // put enemies
        for(int x=0; x<3; x++)
        {
            for(int y =0; y<13; y++)
            {
                this.grid[x][y] = CONSTANT_ENEMY;
            }
        }
        // display the grid
        while(true)
        {
            for(int x=0; x<15; x++)
            {
                for(int y = 0; y<15; y++)
                {
                    if (this.grid[x][y]==CONSTANT_EMPTY) /* if we have some empty box, we put V */
                    {
                        System.out.print("V");
                    }
                    else 
                    {
                        System.out.print(this.grid[x][y]); // display the grid normally //
                    }    
                }
                System.out.println();
            }
            try
            {
                Thread.sleep(3000); // wait 3s //
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // move enemies on a side 

            for(int x=0; x<3; x++)
            { 
                if( this.counterOfEnemiesPlace== 1) // put the enemies at the left end //
                {
                    for(int y = 0; y<13; y++)
                    {
                        this.grid[x][y]=CONSTANT_ENEMY;
                    }
                    for(int y = 13; y<15; y++)
                    {
                        this.grid[x][y]=CONSTANT_EMPTY;

                    }
                    this.changeSide=0;
                    this.changeLine = 1;
                } 

                if (this.counterOfEnemiesPlace == 2) // put the enemies on the center grid with one empty box at left and right//
                {

                    for(int y = 0; y<2; y++)
                    {
                        this.grid[x][y]=CONSTANT_EMPTY;

                    }
                    for(int y = 1; y<14; y++)
                    {
                        this.grid[x][y]=CONSTANT_ENEMY;
                    }
                    for(int y = 14; y<15; y++)
                    {
                        this.grid[x][y]=CONSTANT_EMPTY;

                    }

                }
                if (this.counterOfEnemiesPlace == 3) // put the enemies at the right end
                {

                    for(int y = 0; y<2; y++)
                    {
                        this.grid[x][y]=CONSTANT_EMPTY;

                    }
                    for(int y = 2; y<15; y++)
                    {
                        this.grid[x][y]=CONSTANT_ENEMY;
                    }
                    this.changeSide=1;

                }             
            } 
            if (this.changeSide == 1)
                this.counterOfEnemiesPlace --; // to put this.counterOfEnemiesPlace at 2 and in other hand at 1
            else 
                this.counterOfEnemiesPlace ++; // to up this.counterOfEnemiesPlace
   

        } 
    }
}
