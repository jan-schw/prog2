import java.lang.reflect.Array;

public class Encryption { 
    private static int xInitial = 3;
    private static int aInitial = 7;
    private static int bInitial = 28;
    private static int mInitial = 256;

    public static void main(String[] args){
        char[] toEncrypt = {'S','U', 'P', 'E', 'R', 'S','E', 'C', 'R', 'E', 'T'};
        int length = Array.getLength(toEncrypt);

        int[] keys = new int[Array.getLength(toEncrypt)];

        for(int i = 0; i < length; i++){
            if(i > 0){
                keys[i] = nextInt(aInitial, bInitial, mInitial, keys[i-1]);
            }
            else{
                keys[0] = nextInt(aInitial, bInitial, mInitial, xInitial);
            }
        }
        int[] encrypted = encrypt(toEncrypt, keys);
        char[] decrypted = decrypt(encrypted, keys);

        System.out.println("To encrypt:");
        printCharArray(toEncrypt);

        System.out.println("Keys:");
        printIntArray(keys);
        
        System.out.println("Encryption:");
        printIntArray(encrypted);

        System.out.println("Decrypted:");
        printCharArray(decrypted);
    }

    //a)
    public static int nextInt(int a, int b, int m, int x){
        int nextX = (a * x + b) % m;
        return nextX;
    }

    //b)
    public static void printCharArray(char[] letters){
        for(char current: letters){
            System.out.print(current);
        }
        System.out.print('\n');
    }

    //c
    public static int[] encrypt(char[] letters, int[] keys){

        int length = Array.getLength(letters);
        int[] result = new int[length];

        for(int i = 0; i < length; i++){
            char currentChar = letters[i];
            int currentKey = keys[i];
            
            if(i > 0){
                result[i] = ((int) currentChar) ^ currentKey ^ result[i-1];
            }
            else{
                result[i] = ((int) currentChar) ^ currentKey;
            }
        }

        return result;
    }

    //d
    public static char[] decrypt(int[] letters, int[] keys){
        int length = Array.getLength(letters);
        char[] result = new char[length];

        for(int i = length - 1; i >= 0; i--){
            int currentChar = letters[i];
            int currentKey = keys[i];
            
            if(i > 0){
                result[i] = (char)(currentChar  ^ currentKey ^ letters[i-1]);
            }
            else{
                result[i] = (char)(currentChar ^ currentKey);
            }
        }

        return result;
    }

    private static void printIntArray(int[] array){
        for(int current: array){
            System.out.print(current + " ");
        }
        System.out.print('\n');
    }
}
