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

    /**
     * Declaration of the place of Spacecraft on the grid at the beginning (Line)
     */
    public final static int CONSTANT_PLACE_SPACECRAFT_X = 14;

    /**
     * Declaration of the place of Spacecraft on the grid at he beginning (Column)
     */
    public final static int CONSTANT_PLACE_SPACECRAFT_Y = 7;

    /**
     * Declaration of the Grid to put our elements in it, like Spacecraft, enemies etc .. 
     */
    private int[][] grid;

    /**
     * Declaration of the current enemies line 
     */
    private int currentEnemiesLine;

    /**
     * Declaration of enemies line limit 
     */
    private int nextLineAfterEnemies;


    // TODO (fix) rewrite comment, say how is the game once created
    /**
     * Declaration of the SpaceInvaders constructor
     */
    public SpaceInvaders()
    {   
        this.grid = new int [CONSTANT_GRID][CONSTANT_GRID];
        this.currentEnemiesLine = 0;
        this.nextLineAfterEnemies = 3;
        this.fillGridWithSpaceCraftAndEmptyCase();    

    }

    /**
     * Method to place elements in the grid cell
     */
    // TODO (fix) rename method
    public void fillGridWithSpaceCraftAndEmptyCase()
    {
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
     * method to display the grid with elements
     */
    public void displayGrid()
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
    }

    /**
     * Method to move elements to the left
     */
    public void left()
    {
        for(int x=this.currentEnemiesLine; x<this.nextLineAfterEnemies; x++)
        {
            for(int y = 0; y<13; y++)
            {
                this.grid[x][y]=CONSTANT_ENEMY;
            }
            for(int y = 13; y<15; y++)
            {
                this.grid[x][y]=CONSTANT_EMPTY;

            }
        }
    }

    /**
     * Method to move elements to the center
     */
    public void center()
    {
        for(int x=this.currentEnemiesLine; x<this.nextLineAfterEnemies; x++)
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
    }

    /**
     * Method to move elements to the right
     */
    public void right()
    {
        for(int x=this.currentEnemiesLine; x<this.nextLineAfterEnemies; x++)
        {
            for(int y = 0; y<2; y++)
            {
                this.grid[x][y]=CONSTANT_EMPTY;
            }
            for(int y = 2; y<15; y++)
            {
                this.grid[x][y]=CONSTANT_ENEMY;
            }
        }
    }

    /**
     * Method to down 
     */
    public void changeLine()
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
    }
    
    /**
     * Method to pause
     */
    public void pause()
    {
        try
        {
            Thread.sleep(3000); // wait 3s //
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    // TODO (fix) this method should be the only public method in this class
    /**
     * Method to play
     */
    public void play()
    {
        // TODO (fix) go on with realistic game algorithm
        // where the player is asked to move or shoot ?
        this.left();
        this.displayGrid();
        this.pause();
        this.center();
        this.displayGrid();
        this.pause();
        this.right();
        this.displayGrid();
        this.pause();
        this.center();
        this.displayGrid();
        this.pause();
        this.left();
        this.displayGrid();
        this.pause();
        this.changeLine();
    }
}






