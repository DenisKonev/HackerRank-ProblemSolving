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
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int loc1 = x1;
        int loc2 = x2;
        int i = 0;
        String result = "NO";

        while (i < 100000) {
            loc1 += v1 ;
            loc2 += v2;
            i++;

            if ((v1 > v2) && (loc1 > loc2)) {
                result = "NO";
                break;
            }

            if ((v2 > v1) && (loc2 > loc1)) {
                result = "NO";
                break;
            }

            if (loc1 == loc2) {
                result = "YES";
                break;
            }
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        int x1 = 43;
        int v1 = 2;
        int x2 = 70;
        int v2 = 2;

        String result = Result.kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
