package aufgabe3;
//package Debug02.src.aufgabe3;

import aufgabe3.data.*; //Import vom data-Subpackage

class DebugMain {
    public static void main(String[] args) {
        DebugData a = new DebugData(3.4, 5.6);
        DebugData b = new DebugData(1.0, 1.0);
        // Result should be approx. 5.18
        System.out.println(String.format("The distance between %s and %s is %g",
            a.str(), b.str(), a.distance(b)));
    }
}


/*
 * Zeile 3: Import vom data-Subpackage
 * Fehlermeldung: DebugData cannot be resolved to a type
 */