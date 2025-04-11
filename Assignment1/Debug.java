public class Debug {   //class falsch geschrieben (ckass)

    // Methode that checks whether a given number is prime
    public static boolean isPrime(int n) {
        // Return false if number is one, zero or negative
        if (n <= 1) {   //2 zu 1 geändert
            return false;
        }
        // Check for all factors smaller and equal to n/2 whether it is a prime factor.
        // If it is a prime factor, return false.
        for (int i = 2; i <= n / 2; i++) {  //-- zu ++ geändert
            if (n % i == 0) {
                return false;    //true zu false geändert
            }
        }
        // If no prime factor was found, return true.
        return true;
    }


    // Method that prints all numbers in an array that are prime
    public static void printPrime(int[] arr) {    //String zu void geändert
        for (int i = 0; i < arr.length; i++) {      //<= zu < geändert
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args){ //main Methode hat gefehlt

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printPrime(arr);
    
        // output should be as follows:
        // 2
        // 3
        // 5
        // 7
    }

}

/*
 * Zeile 1: class falsch geschrieben (ckass)
 * Fehlermeldung: Syntax error on token "ckass", class expected
 * 
 * Zeile 6: 2 zu 1 geändert, damit wirklich nur auf 1, 0 und negative Zahlen geprüft wird
 * Fehlermeldung: /
 * 
 * Zeile 11: -- zu ++ geändert, damit i hochinkrementiert wird
 * Fehlermeldung: /
 * 
 * Zeile 13: true zu false geändert, wenn ein Primfaktor gefunden wird, dann muss false und nicht true zurückgegeben werden
 * Fehlermeldung: /
 * 
 * Zeile 22: String zu void geändert, die Methode schreibt in die Konsole und braucht keinen Rückgabewert
 * Fehlermeldung: This method must return a result of type String
 * 
 * Zeile 23: <= zu < geändert, sonst kommt es direkt zu einer OutOfBoundsException, weil versucht wird auf einen ungültigen Index zuzugreifen 
 * Fehlermeldung: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
        at Debug.printPrime(Debug.java:24)
 * 
 * 
 * Zeile 30: main Methode hat gefehlt
 * Fehlermeldung: Fehler: Hauptmethode in Klasse Debug nicht gefunden
 * 
 */