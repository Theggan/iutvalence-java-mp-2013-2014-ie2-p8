package fr.iutvalence.java.mp.SpaceInvaders;

//TODO (fixed) Fix comment, this class is everything but a launch menu
/**
 * class SpaceInvaders : A new game
 * @author thevenim
 */
public class SpaceInvaders 
{ 
    // TODO (fix) write a comment 
    public final static int CONSTANT_GRID = 33;

    // TODO (fix) write a comment 
    public final static int CONSTANT_SPACECRAFT = 777;
    
    // TODO (fix) write a comment 
    public final static int CONSTANT_ENNEMY = 666;
    
    // TODO (fix) write a comment 
    public final static int CONSTANT_FIRE = 1;
    
    // TODO (fix) write a comment 
    public final static int CONSTANT_EMPTY = 0;
    
    // TODO (fix) write a comment 
    public final static int CONSTANT_PLACE_SPACECRAFT_X = 32; /* The lines */
    
    // TODO (fix) write a comment 
    public final static int CONSTANT_PLACE_SPACECRAFT_Y = 16; /* The columns */ 

    // TODO (fix) write a comment 
    private int[][] grid;
    
    // TODO (fix) write a comment 
    private int spacecraft;
    
    // TODO (fix) write a comment 
    private int ennemy;
    
    // TODO (fix) write a comment 
    private int fire;
    
    // TODO (fix) write a comment 
    private int empty;
    
    // TODO (fix) write a comment 
    public SpaceInvaders()
    {   
        this.grid = new int [CONSTANT_GRID][CONSTANT_GRID];
        this.spacecraft = CONSTANT_SPACECRAFT;
        this.ennemy = CONSTANT_ENNEMY;
        this.fire = CONSTANT_FIRE;
        this.empty = CONSTANT_EMPTY;
        this.grid[CONSTANT_PLACE_SPACECRAFT_X][CONSTANT_PLACE_SPACECRAFT_Y]=CONSTANT_SPACECRAFT;
        this.grid[0][0] = CONSTANT_ENNEMY;
    }
}
