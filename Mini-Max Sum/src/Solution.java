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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        long minSum = 0;
        long maxSum = 0;
        int arrLenght = arr.size();
        int lastListElem = arrLenght - 1;

        Collections.sort(arr);

        for(int i = 0; i < arrLenght; i++) {
            if(i == 0) minSum += arr.get(i);
            else if(i == lastListElem) maxSum += arr.get(i);
            else {
                minSum += arr.get(i);
                maxSum += arr.get(i);
            }
        }
        System.out.println(minSum + " " + maxSum);
    }
}

    public class Solution {
        public static void main(String[] args) throws IOException {
            List<Integer> arr = new ArrayList<Integer>();
            arr.add(10);
            arr.add(0);
            arr.add(-5);
            arr.add(5);
            arr.add(-10);

            Result.miniMaxSum(arr);
        }
    }
