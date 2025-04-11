import java.lang.reflect.Array;
import java.util.Arrays;

public class IntList {
    
    public static void main(String[] args) {
        int firstExample = 12345;
        int[] firstExampleToList = intToList(firstExample);
        int firstExampleAsIntAgain = listToInt(firstExampleToList);

        System.out.println("Int: " + firstExample);
        System.out.println("Array: " + Arrays.toString(firstExampleToList));
        System.out.println("Back to int: " + firstExampleAsIntAgain);

        int secondExample = 10051919;
        int[] secondExampleToList = intToList(secondExample);
        int secondExampleAsIntAgain = listToInt(secondExampleToList);

        System.out.println("Int: " + secondExample);
        System.out.println("Array: " + Arrays.toString(secondExampleToList));
        System.out.println("Back to int: " + secondExampleAsIntAgain);
    }

    //a
    public static int countNumbers(int num){
        String temp = String.valueOf(num);
        return temp.length();
    }

    //b
    public static int[] intToList(int value){
        int length = countNumbers(value);
        int[] result = new int[length];
        String valueString = String.valueOf(value);
        char[] valueAsCharArray = valueString.toCharArray();

        for(int i = 0; i < length; i++){
            result[i] = Character.getNumericValue(valueAsCharArray[i]);
        }
        
        return result;
    }

    //c
    public static int listToInt(int[] numbers){
        String result = "";

        for(int current: numbers){
            result += Character.forDigit(current, 10);
        }

        return Integer.parseInt(result);
    }

    //d
    public static int[] addOne(int[] numbers){
        return null;
    }
}
