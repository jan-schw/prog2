import GameObjects.*;

/**
 * This class provides multiple methods to play a small jump&run game
 * Includes the current state of the game and uses multiple GameObjects to represent objects in the game
 * 
 * @author Jan Schweers
 * @version 24.04.2025
 */
public class GameView {

    /** Represents the current state of the game in a 2d array */
    private GameObject[][] game = new GameObject[20][3];
    /** NPC object for playing the game */
    private NPC player;

    /** 
     * Constructor for game view
     */
    public GameView() {
        player = new NPC();
        GameObject[] y2 = {
                GameObject.EMPTY, GameObject.EMPTY, GameObject.AIROBSTACLE, GameObject.EMPTY, GameObject.EMPTY,
                GameObject.EMPTY, GameObject.AIROBSTACLE, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY,
                GameObject.AIROBSTACLE, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.AIROBSTACLE,
                GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.AIROBSTACLE, GameObject.EMPTY
        };
        GameObject[] y1 = {
                GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY,
                GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY,
                GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY,
                GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY, GameObject.EMPTY
        };
        GameObject[] y0 = {
                GameObject.GROUND, GameObject.GROUND, GameObject.GROUND, GameObject.GROUND, GameObject.LAVA,
                GameObject.GROUND, GameObject.GROUND, GameObject.GROUND, GameObject.LAVA, GameObject.GROUND,
                GameObject.GROUND, GameObject.GROUND, GameObject.LAVA, GameObject.GROUND, GameObject.GROUND,
                GameObject.GROUND, GameObject.LAVA, GameObject.GROUND, GameObject.GROUND, GameObject.GOAL
        };

        this.game = new GameObject[][] { y2, y1, y0 };
    }

    /**
     * A very fancy main method for testing and playing the game
     * @param args who knows
     */
    public static void main(String[] args) {
        //Packagestruktur sortiert die beiden Klassen die zum Spielen benötigt werden
        //in das Extra-Package GameObjects, um das ganze Projekt übersichtlicher zu gestalten
        GameView game = new GameView();
        game.play();
    }

    /** 
     * Method for playing the game
     * Periodically prints the game state to the console
     */
    public void play(){
        while(true){
            //Print current game state
            String currentGameState = this.str();
            System.out.println(currentGameState);

            //Check for end of game
            int playerX = this.player.getxCoordinate();
            GameObject[] currentField = this.getFieldAtIndex(playerX);

            if(currentField[2].equals(GameObject.LAVA) || currentField[2].equals(GameObject.GOAL)){
                System.out.println("END!");
                break;
            }

            GameObject[] nextField = this.getFieldAtIndex(playerX + 1);

            //Check for air obstacle
            if(nextField[0].equals(GameObject.AIROBSTACLE) && !this.player.isCrouching()){
                this.player.crouch();
            }
            //Check for lava
            else if(nextField[2].equals(GameObject.LAVA)){
                if(this.player.isCrouching()){
                    this.player.standUp();
                }
                else{
                    this.player.dashRight();
                }
            }
            else{
                this.player.walkRight();
            }
        }
    }

    /**
     * Returns the game field at the specified index
     * @param index x value of the wanted field
     * @return  Array of GameObjects containing the field at the wanted index
     */
    public GameObject[] getFieldAtIndex(int index){
        GameObject[] nextField = new GameObject[3];

        for(int i = 0; i < 3; i++){
            nextField[i] = this.game[i][index];
        }
        
        return nextField;
    }

    /**
     * Prints the current state of the game as a string
     * @return String of the game state
     */
    public String str() {
        String result = "";

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 20; x++) {

                //Printing the player
                if (x == this.player.getxCoordinate() && y != 2) {

                    //Dont print player in air if crouching
                    if(y == 0 && this.player.isCrouching()){
                        result += this.game[y][x].getSymbol();
                    }
                    else{
                        result += 'P';
                    }
                    
                } else {
                    result += this.game[y][x].getSymbol();
                }
            }
            result += '\n';
        }

        return result;
    }
}
