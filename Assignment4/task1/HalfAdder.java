package task1;

import task1.Gates.AndGate;
import task1.Gates.Gate;
import task1.Gates.XorGate;

public class HalfAdder {
    private Gate[] gates;

    public HalfAdder() {
        this.gates = new Gate[2];
        this.gates[0] = new AndGate();
        this.gates[1] = new XorGate();
    }

    public boolean[] add(boolean a, boolean b) {
        boolean[] result = new boolean[] { false, false };

        if (gates[0].evaluate(a, b)) {
            result[1] = true;
        } 
        else if (gates[1].evaluate(a, b)) {
            result[0] = true;
        }
        return result;
    }

    public void info() {
        for (Gate gate : gates) {
            String infoHeader = String.format("This is a %s gate", gate.getSymbol());
            System.out.println(infoHeader);
            gate.table();
        }
    }
}
