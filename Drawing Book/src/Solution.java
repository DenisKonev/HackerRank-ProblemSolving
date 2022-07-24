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
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        int upwardCount = 0;
        int backwardCount = 0;

        for (int i = 0; i < n; i = i + 2) {
            if ((p == i) || (p == i + 1 )) {
                break;
            }
            upwardCount++;
        }
        if (n % 2 == 1) {
            n -= 1;
        }
        for (int i = n; i > 0; i = i -2) {
            if ((p == i) || (p == i + 1)) {
                break;
            }
            backwardCount++;
        }
        if (upwardCount >= backwardCount) {
            return backwardCount;
        }   else {
            return upwardCount;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int n = 6;
        int p = 5;

        int result = Result.pageCount(n, p);
        System.out.println(result);
    }
}
