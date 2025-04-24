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
        String res = test.str();
        System.out.println(res);
    }

    public String str() {
        String result = "";

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 20; x++) {
                if (x == this.player.getxCoordinate() && y != 2) {
                    result += 'P';
                } else {
                    result += this.game[y][x].getSymbol();
                }
            }
            result += '\n';
        }

        return result;
    }
}
