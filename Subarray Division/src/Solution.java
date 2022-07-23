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
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        int segSum = 0;
        int total = 0;
        int arrIndex = s.size() - 1;
        int i = 0;

        do {
            for (int j = i; j < i + m; j++) {
                segSum += s.get(j);
            }
            if (segSum == d) {
                total++;
            }
            segSum = 0;
            i++;
        } while ( i <= s.size() - m);
        return total;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> s = new ArrayList<Integer>();
        s.add(2);
        s.add(5);
        s.add(1);
        s.add(3);
        s.add(4);
        s.add(4);
        s.add(3);
        s.add(5);
        s.add(1);
        s.add(1);
        s.add(2);
        s.add(1);
        s.add(4);
        s.add(1);
        s.add(3);
        s.add(3);
        s.add(4);
        s.add(2);
        s.add(1);

        int d = 18;
        int m = 7;

        int result = Result.birthday(s, d, m);
        System.out.println(result);
    }
}
