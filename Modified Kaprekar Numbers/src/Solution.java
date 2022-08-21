import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        boolean kaprekarNumberFound = false;

        for (long i = p; i <= q; i++) {
            long number = i * i;
            ArrayList<Long> array = splitToIntList(number);
            if (isValidKaprekarNumber(i, array)) {
                System.out.print(i + " ");
                kaprekarNumberFound = true;
            }
        }
        if (!kaprekarNumberFound)
            System.out.println("INVALID RANGE");
    }
    private static ArrayList<Long> splitToIntList(long number) {
        ArrayList<Long> array = new ArrayList<Long>();

        do{
            array.add(number % 10);
            number /= 10;
        } while  (number > 0);
        Collections.reverse(array);
        return array;
    }
    private static boolean isValidKaprekarNumber(long number, ArrayList<Long> array) {
        int substringLength = array.size() / 2;
        String firstNumberString = "", secondNumberString = "";
        long firstNumber = 0, secondNumber = 0;

        for (int i = 0; i < substringLength; i++)
            firstNumberString += String.valueOf(array.get(i));
        for (int i = substringLength; i < array.size(); i++)
            secondNumberString += String.valueOf(array.get(i));
        try {
            firstNumber = Integer.parseInt(firstNumberString);
        }   catch (NumberFormatException e) {
            firstNumber = 0;
        }
        try {
            secondNumber = Integer.parseInt(secondNumberString);
        }   catch (NumberFormatException e) {
            secondNumber = 0;
        }
        if (firstNumber + secondNumber == number)
            return true;
        else
            return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
