package task1;

import task1.Gates.AndGate;
import task1.Gates.Gate;
import task1.Gates.NotGate;
import task1.Gates.OrGate;
import task1.Gates.XorGate;

public class Main {

    public static void main(String[] args) {

        Gate not = new NotGate();
        Gate or = new OrGate();
        Gate and = new AndGate();
        Gate xor = new XorGate();

        not.table();
        or.table();
        and.table();
        xor.table();
    }
}
