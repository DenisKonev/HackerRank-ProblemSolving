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
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int appleLocation = 0;
        int appleCount = 0;
        int orangeLocation = 0;
        int orangeCount = 0;

        for (int apple : apples) {
            appleLocation = a + apple;
            if ((appleLocation >= s) && (appleLocation <= t)) {
                appleCount++;
            }
        }

        for (int orange : oranges) {
            orangeLocation = b + orange;
            if ((orangeLocation >= s) && (orangeLocation <= t)) {
                orangeCount++;
            }
        }

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int s = 3;
        int t = 8;
        int a = 0;
        int b = 10;

        List<Integer> apples = new ArrayList<Integer>();
        apples.add(5);
        apples.add(0);
        apples.add(-5);

        List<Integer> oranges = new ArrayList<Integer>();
        oranges.add(5);
        oranges.add(0);
        oranges.add(-5);

        Result.countApplesAndOranges(s, t, a, b, apples, oranges);
    }
}
