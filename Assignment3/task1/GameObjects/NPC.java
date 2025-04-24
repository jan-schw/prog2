package task1.GameObjects;

/**
 * Non-playable-character for the GameView class
 * Tracks if he is crouching or standing up and the current x coordinate
 * 
 * @author Jan Schweers
 * @version 24.04.2025
 */
public class NPC {
    /** State if npc is currently crouching or not */
    private boolean isCrouching;
    /** Current x coordinate of the npc in the game */
    private int xCoordinate;

    /**
     * Constructor for NPC class
     * @author Jan Schweers
     */
    public NPC(){
        this.isCrouching = false;
        this.xCoordinate = 0;
    }

    /**
     * Let's the NPC stand up
     * @author Jan Schweers
     */
    public void standUp(){
        this.isCrouching = false;
    }

    /**
     * Let's the NPC crouch
     * @author Jan Schweers
     */
    public void crouch(){
        this.isCrouching = true;
    }

    /**
     * Lets the NPC walk one field to the right
     * @author Jan Schweers
     */
    public void walkRight(){
        this.xCoordinate++;
    }

    /**
     * Lets the NPC dash two fields to the right
     * @author Jan Schweers
     */
    public void dashRight(){
        if(!isCrouching){
            this.xCoordinate += 2;
        }
    }

    /**
     * Returns value of isCrouching
     * {@link GameObjects.NPC.isCrouching} is the state if npc is currently crouching or not
     * @return isCrouching
     */
    public boolean isCrouching() {
        return isCrouching;
    }

    /**
     * Getter for xCoordinate
     * {@link GameObjects.NPC.xCoordinate} is the current x coordinate of the npc in the game
     * @return xCoordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }
}
