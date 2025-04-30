package task1.Gates;

public class OrGate extends Gate {

    public OrGate(){
        super("|");

    }

    @Override
    public boolean evaluate(boolean a, boolean b) {
        return a || b;
    }
}
