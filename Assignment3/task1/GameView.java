import GameObjects.*;

public class GameView {

    private GameObject[][] game = new GameObject[20][3];
    private NPC player;

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

    public static void main(String[] args) {

        GameView test = new GameView();
        test.play();
    }

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

    public GameObject[] getFieldAtIndex(int index){
        GameObject[] nextField = new GameObject[3];

        for(int i = 0; i < 3; i++){
            nextField[i] = this.game[i][index];
        }
        
        return nextField;
    }

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
