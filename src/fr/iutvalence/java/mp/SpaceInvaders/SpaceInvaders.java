package fr.iutvalence.java.mp.SpaceInvaders;

import java.util.Random;

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
    public final static Object CONSTANT_ENEMY = 6;

    /**
     * constant which represent the Fire
     */
    public final static int CONSTANT_FIRE = 1;

    /**
     * constant which represent the Void
     */
    public final static Object CONSTANT_EMPTY = 0;
    
    /**
     * constant which represent where the enemy is down
     */
    public final static Object CONSTANT_ENEMY_DOWN = 9;

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
    private Object[][] grid;

    /**
     * Declaration of the current enemies line 
     */
    private int currentEnemiesLine;

    /**
     * Declaration of enemies line limit 
     */
    private int nextLineAfterEnemies;

    /**
     * Position Y of the Space Craft during the game
     */
    private int POS_Y;

    /**
     * Position X of the fire during the game
     */
    private int POS_X_Fire;
    
    /**
     * Enemy
     */
    Enemy newEnemy;

    // TODO (fix) rewrite comment, say how is the game once created
    /**
     * Declaration of the SpaceInvaders constructor
     */
    public SpaceInvaders()
    {   
        this.grid = new Object [CONSTANT_GRID][CONSTANT_GRID];
        this.currentEnemiesLine = 0;
        this.nextLineAfterEnemies = 3;
        this.fillGrid();
        this.putEnemies();
        this.POS_Y=CONSTANT_PLACE_SPACECRAFT_Y;
        this.POS_X_Fire=CONSTANT_PLACE_SPACECRAFT_X-1;

    }

    /**
     * Method to place elements in the grid cell
     */
    // TODO (fixed) rename method
    private void fillGrid()
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
     * Method to display the grid with elements
     */
    private void displayGrid()
    {
        for(int x=0; x<15; x++)
        {
            for(int y = 0; y<15; y++)
            {
                if (this.grid[x][y]==CONSTANT_EMPTY || this.grid[x][y]==CONSTANT_ENEMY_DOWN) /* if we have some empty box, we put V */
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
     * Method to create some new enemies
     */
    private void putEnemies()
    {
        for(int x=this.currentEnemiesLine; x<this.nextLineAfterEnemies; x++)
        {
            
      
            for(int y = 0; y<13; y++)
            {
                this.newEnemy = new Enemy(y,y+1,y+2);
                this.grid[x][y]= this.newEnemy;
                
            }
        }
    }

    /**
     * Method to move elements to the left
     */
   /* private void left()
    {
        for(int x=this.currentEnemiesLine; x<this.nextLineAfterEnemies; x++)
        {
            for(int y = 0; y<13; y++)
            {
                if (this.grid[x][y] != CONSTANT_ENEMY_DOWN)
                {
                 System.out.println(this.newEnemy.getY());
                   
                }
            }
            for(int y = 13; y<15; y++)
            {
                this.grid[x][y]=CONSTANT_EMPTY;

            }
        }
    }*/

    /**
     * Method to move elements to the center
     */
    private void center()
    {
        for(int x=this.currentEnemiesLine; x<this.nextLineAfterEnemies; x++)
        {
            for(int y = 0; y<2; y++)
            {
                this.grid[x][y]=CONSTANT_EMPTY;
            }
            for(int y = 1; y<14; y++)
            {
                if (this.grid[x][y] != CONSTANT_ENEMY_DOWN)
                {
                    this.grid[x][y]=CONSTANT_ENEMY;
                }
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
    private void right()
    {
        for(int x=this.currentEnemiesLine; x<this.nextLineAfterEnemies; x++)
        {
            for(int y = 0; y<2; y++)
            {
                this.grid[x][y]=CONSTANT_EMPTY;
            }
            for(int y = 2; y<15; y++)
            {
                if (this.grid[x][y] != CONSTANT_ENEMY_DOWN)
                {
                    this.grid[x][y]=CONSTANT_ENEMY;
                }
            }
        }
    }

    /**
     * Method to down : erase all enemies and create enemies on down line 
     */
    private void changeLine()
    {
        for(int x=this.currentEnemiesLine;x<this.nextLineAfterEnemies;x++)
        {
            for ( int y = 0; y<15;y++)
            {
                if (this.grid[x][y] != CONSTANT_ENEMY_DOWN)
                {
                    this.grid[x][y]=CONSTANT_EMPTY;
                } 
            }
        }
        this.currentEnemiesLine ++;
        this.nextLineAfterEnemies ++;
    }

    /**
     * Method to shoot enemies randomly
     */
    private void randomShoot()
    {
        int POS_Y_Fire = this.POS_Y; // To save the column of the fire 
        Random t = new Random();

        if (t.nextInt(2)==1)
        {            
            while(this.grid[this.POS_X_Fire][POS_Y_Fire]!=CONSTANT_ENEMY && this.POS_X_Fire>0 )
            {
                this.grid[this.POS_X_Fire][POS_Y_Fire]=CONSTANT_FIRE;
                this.displayGrid();
                this.POS_X_Fire--;
                this.grid[this.POS_X_Fire+1][POS_Y_Fire]=CONSTANT_EMPTY;
            }
            if(this.grid[this.POS_X_Fire][POS_Y_Fire]==CONSTANT_ENEMY)
            {
                this.grid[this.POS_X_Fire][POS_Y_Fire]=CONSTANT_ENEMY_DOWN;
            }
            this.POS_X_Fire=CONSTANT_PLACE_SPACECRAFT_X-1;
        }        
    }

    /**
     * Method to move Space Craft randomly
     */
    private void randomMovement()
    { 
        Random r = new Random();

        if (r.nextInt(2)==0)
        {
            if (this.POS_Y == 0)
            {
                this.grid[CONSTANT_PLACE_SPACECRAFT_X][this.POS_Y+1]=CONSTANT_SPACECRAFT;
                this.grid[CONSTANT_PLACE_SPACECRAFT_X][this.POS_Y]=CONSTANT_EMPTY;
                this.POS_Y++; 
            }
            else 
            {        
                this.grid[CONSTANT_PLACE_SPACECRAFT_X][this.POS_Y-1]=CONSTANT_SPACECRAFT;
                this.grid[CONSTANT_PLACE_SPACECRAFT_X][this.POS_Y]=CONSTANT_EMPTY;
                this.POS_Y--;
            }

        }
        else
        {
            if (this.POS_Y == 14)
            {
                this.grid[CONSTANT_PLACE_SPACECRAFT_X][this.POS_Y-1]=CONSTANT_SPACECRAFT;
                this.grid[CONSTANT_PLACE_SPACECRAFT_X][this.POS_Y]=CONSTANT_EMPTY;
                this.POS_Y--;
            }
            else
            {
                this.grid[CONSTANT_PLACE_SPACECRAFT_X][this.POS_Y+1]=CONSTANT_SPACECRAFT;
                this.grid[CONSTANT_PLACE_SPACECRAFT_X][this.POS_Y]=CONSTANT_EMPTY;
                this.POS_Y++;
            }
        }   
    }

    /**
     * Method to pause
     */
    private void pause()
    {
        try
        {
            Thread.sleep(1500); // wait 3s //
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // TODO (fixED) this method should be the only public method in this class
    /**
     * Method to play
     */
    public void play()
    {
        // TODO (fix) go on with realistic game algorithm
        // where the player is asked to move or shoot ?
        //this.left();
        this.displayGrid();
        this.randomMovement();
        this.randomShoot();
        this.pause();
        this.center(); 
        this.displayGrid();
        this.randomMovement();
        this.randomShoot();
        this.pause();
        this.right();
        this.displayGrid();
        this.randomMovement();
        this.randomShoot();
        this.pause();
        this.center();
        this.displayGrid();
        this.randomMovement();
        this.randomShoot();
        //this.left();
        this.pause();
        this.displayGrid();
        this.pause();
        this.changeLine();
    }
}






