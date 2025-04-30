package task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie den ersten boolean Wert an: ");
        boolean firstBool = scanner.nextBoolean();

        System.out.println("Geben Sie den zweiten boolean Wert an: ");
        boolean secondBool = scanner.nextBoolean();

        HalfAdder adder = new HalfAdder();
        boolean[] result = adder.add(firstBool, secondBool);

        String answer = String.format("Die Summe lautet %s, der Übertrag beträgt %s",
                (result[0] ? "1" : "0"), (result[1] ? "1" : "0"));

        System.out.println(answer);
        scanner.close();
    }
}
