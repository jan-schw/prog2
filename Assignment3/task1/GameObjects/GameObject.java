package GameObjects;

public enum GameObject {
    GROUND('G'),
    LAVA('L'),
    AIROBSTACLE('O'),
    EMPTY(' '),
    GOAL('#');

    private char symbol;

    private GameObject(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){ 
        return this.symbol;
    }
}
