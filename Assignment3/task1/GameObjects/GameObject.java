package task1.GameObjects;

/**
 * Different ingame objects for the GameView class
 * Includes five different objects with corresponding symbol in the game 
 * 
 * @author Jan Schweers
 * @version 24.04.2025
 */
public enum GameObject {

    /**  The five different objects that can be represented by this enum in the game */
    GROUND('G'),
    LAVA('L'),
    AIROBSTACLE('O'),
    EMPTY(' '),
    GOAL('Z');

    /** Symbol of the current object */
    private char symbol;

    /**
     * Constructor for GameObject
     * @param symbol Symbol of the current game object
     */
    private GameObject(char symbol){
        this.symbol = symbol;
    }

    /**
     * Getter for symbol
     * {@link GameObjects.GameObject.symbol} is the symbol of the current object
     * @return symbol
     */
    public char getSymbol(){ 
        return this.symbol;
    }
}
