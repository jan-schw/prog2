
public enum Action{
    A('A'),
    B('B');

    private char symbol;

    private Action(char symbol){
        this.symbol = symbol;
    }

    public char str(){
        return this.symbol;
    }
}