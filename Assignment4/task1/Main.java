package task1;

import task1.Gates.AndGate;
import task1.Gates.Gate;
import task1.Gates.NotGate;
import task1.Gates.OrGate;

public class Main {

    public static void main(String[] args) {

        Gate not = new NotGate();
        Gate or = new OrGate();
        Gate and = new AndGate();

        not.table();
        or.table();
        and.table();
    }
}
