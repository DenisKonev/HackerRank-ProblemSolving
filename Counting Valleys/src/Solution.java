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
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int curLevel = 0;
        int valCount = 0;
        boolean mountFlag = true;
        List<Character> pathParts = convertStringToCharList(path);

        for (char pathPart : pathParts) {
            //If we traverse mountain raise current level & opposite for downhill
            if (pathPart == 'U') {
                curLevel++;
            } else {
                curLevel--;
                if ((curLevel < 0) && (mountFlag)) {
                    valCount++;
                }
            }
            if (curLevel >= 0) {
                mountFlag = true;
            } else {
                mountFlag = false;
            }
        }
        return valCount;
    }
    private static List<Character> convertStringToCharList(String str) {
        List<Character> chars = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        return chars;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        int steps = 8;
        String path =  "UDDDUDUU";

        int result = Result.countingValleys(steps, path);
        System.out.println(result);
    }
}
