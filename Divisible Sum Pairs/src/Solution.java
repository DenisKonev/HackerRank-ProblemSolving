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
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int total = 0;

        //first loop through array elements excluding the last one
        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if ((i < j) && (((ar.get(i) + ar.get(j)) % k == 0))) {
                    total++;
                }
            }
        }
        return total;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int n = 6;
        int k = 3;
        List<Integer> ar = new ArrayList<Integer>();
        ar.add(1);
        ar.add(3);
        ar.add(2);
        ar.add(6);
        ar.add(1);
        ar.add(2);

        int result = Result.divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }
}
