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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        float positFrac = 0;
        int positCount = 0;
        float negatFrac = 0;
        int negatCount = 0;
        float zeroFrac = 0;
        int zeroCount = 0;
        int arrLenght = arr.size();

        for(int i = 0; i < arrLenght; i++) {
            if(arr.get(i) > 0) {
                positCount += 1;
            } else if (arr.get(i) < 0) {
                negatCount += 1;
            } else {
                zeroCount += 1;
            }
        }

        positFrac = (float)positCount / arrLenght;
        negatFrac = (float)negatCount / arrLenght;
        zeroFrac = (float)zeroCount / arrLenght;

        System.out.printf("%.6f %n", positFrac);
        System.out.printf("%.6f %n", negatFrac);
        System.out.printf("%.6f %n", zeroFrac);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int n = 6;
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        arr.add(-1);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(1);

        Result.plusMinus(arr);


    }
}
