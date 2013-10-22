package fr.iutvalence.java.mp.SpaceInvaders;

/**
 * class SpaceInvaders : A new game
 * @author thevenim
 */
public class SpaceInvaders 
{ 
    /**
     * size of the grid ( 15 per 15 ) 
     */
    public final static int CONSTANT_GRID = 15;

    /**
     * constant which represent the Spacecraft
     */
    public final static int CONSTANT_SPACECRAFT = 7;

    /**
     * constant which represent the Enemy
     */
    public final static int CONSTANT_ENEMY = 6;

    /**
     * constant which represent the Fire
     */
    public final static int CONSTANT_FIRE = 1;

    /**
     * constant which represent the Void
     */
    public final static int CONSTANT_EMPTY = 0;

    // TODO (fix) fix comment
    /**
     * Declaration of the lines
     */
    public final static int CONSTANT_PLACE_SPACECRAFT_X = 14;

    /**
     * constant which represent the columns
     */
    public final static int CONSTANT_PLACE_SPACECRAFT_Y = 7;

    // TODO (fixed) rewrite comment
    /**
     * Declaration of the Grid to put our elements in it, like Spacecraft, enemies etc .. 
     */
    private int[][] grid;

    /**
     * enemies counter 
     */
    // TODO (fix) rename field (more explicit?)
    private int enemiesSideCounter;

    // TODO (fix) rename field (more explicit?)
    /**
     *  ChangeSide
     */
    private int changeSide;

    // TODO (fix) rename field (more explicit?)
    /**
     * ChangeLine
     */
    private int changeLine;
    
    // TODO (fix) write comment
    private int currentEnemiesLine;

    // TODO (fix) write comment
    private int nextLineAfterEnemies;

    // TODO (fix) rewrite comment, say how is the game once created
    /**
     * Declaration of the SpaceInvaders constructor
     */
    public SpaceInvaders()
    {   
        this.grid = new int [CONSTANT_GRID][CONSTANT_GRID];
        this.changeSide = 0;
        this.changeLine = 0;
        this.enemiesSideCounter = 2;
        this.currentEnemiesLine = 0;
        this.nextLineAfterEnemies = 3;
    }
    
    /**
     * Method to place elements in the grid cell
     */
    // TODO (fix) rename method
    public void placementOfElements()
    {
        // fill the grid with "empty" value
        for(int x=0; x<15; x++)
        {
            for (int y=0; y<15; y++)
            {
                this.grid[x][y]= CONSTANT_EMPTY;   
            }
        }
        this.grid[CONSTANT_PLACE_SPACECRAFT_X][CONSTANT_PLACE_SPACECRAFT_Y]=CONSTANT_SPACECRAFT;
    }
    
    /**
     * Method to display and move the elements in the grid
     */
    // TODO (fix) this method should be cut in two halves
    public void displayAndMoveElements()
    {

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
            if (this.changeLine==1)
            {
                for(int x=this.currentEnemiesLine;x<this.nextLineAfterEnemies;x++)
                {
                    for ( int y = 0; y<15;y++)
                    {
                        this.grid[x][y]=CONSTANT_EMPTY;
                    }
                }
                this.currentEnemiesLine ++;
                this.nextLineAfterEnemies ++;
                this.changeLine=0;              
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

            for(int x=this.currentEnemiesLine; x<this.nextLineAfterEnemies; x++)
            { 
                if( this.enemiesSideCounter== 1) // put the enemies at the left end //
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

                if (this.enemiesSideCounter == 2) // put the enemies on the center grid with one empty box at left and right//
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
                if (this.enemiesSideCounter == 3) // put the enemies at the right end
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
                this.enemiesSideCounter --; // to put this.enemiesSideCounter at 2 and in other hand at 1
            else
                this.enemiesSideCounter ++; // to up this.enemiesSideCounter
          

        }



    }

}




