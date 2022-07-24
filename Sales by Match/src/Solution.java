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
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        int totalSocks = 0;
        int totalPairs = 0;

        for (int i = 1; i < 101; i++) {
            for (int elem : ar) {
                if (i == elem) {
                    totalSocks++;
                }
            }
            totalPairs += totalSocks / 2;
            totalSocks = 0;
        }
        return totalPairs;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int n = 7;
        List<Integer> ar = new ArrayList<Integer>();
        ar.add(1);
        ar.add(2);
        ar.add(1);
        ar.add(2);
        ar.add(1);
        ar.add(3);
        ar.add(2);

        int result = Result.sockMerchant(n, ar);
        System.out.println(result);
    }
}
