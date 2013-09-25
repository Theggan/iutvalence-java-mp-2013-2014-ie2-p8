package fr.iutvalence.java.mp.SpaceInvaders;

//TODO (fixed) Fix comment, this class is everything but a launch menu
/**
 * class SpaceInvaders : A new game
 * @author thevenim
 */
public class SpaceInvaders 
{ 
    public final static int CONSTANT_GRID = 33;
    public final static int CONSTANT_SPACECRAFT = 777;
    public final static int CONSTANT_ENNEMY = 666;
    public final static int CONSTANT_FIRE = 1;
    public final static int CONSTANT_EMPTY = 0;
    public final static int CONSTANT_PLACE_SPACECRAFT_X = 32; /* The lines */
    public final static int CONSTANT_PLACE_SPACECRAFT_Y = 16; /* The columns */ 

    // TODO (fixed) attribute has no visibility declared
    // TODO (fixed) non static attribute should be initialized inside a constructor
    // TODO (fixed) rename attribute (english)
    private int[][] grid;
    private int spacecraft;
    private int ennemy;
    private int fire;
    private int empty;
    
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
