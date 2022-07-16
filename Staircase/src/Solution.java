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
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        int j = 0;
        String spaces = " ".repeat(n);
        String sharps = "";

        for(int i = n; i > 0; i--) {
            j++;
            sharps = "#".repeat(j);
            spaces = (spaces.substring(0, i - 1)) + sharps;
            System.out.println(spaces);
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int n = 25;

        Result.staircase(n);

    }
}
