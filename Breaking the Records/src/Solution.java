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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int min = scores.get(0), max = scores.get(0);
        int minCount = 0, maxCount = 0;
        List<Integer> records = new ArrayList<Integer>();

        for (int score : scores) {
            if (score > max) {
                max = score;
                maxCount++;
            }
            if (score < min) {
                min = score;
                minCount++;
            }
        }

        records.add(maxCount);
        records.add(minCount);
        return records;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> scores = new ArrayList<Integer>();
        scores.add(7);
        scores.add(4);
        scores.add(21);
        scores.add(36);
        scores.add(10);

        List<Integer> result = Result.breakingRecords(scores);

        for (int res : result) {
            System.out.println(res);
        }
    }
}
