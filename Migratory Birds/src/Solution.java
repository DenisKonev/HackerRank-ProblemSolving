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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        int firstCount = 0, secondCount = 0, thirdCount = 0, fourthCount = 0, fifthCount = 0;
        int maxValue = 0;
        int correctID = 0;
        List<Integer> counts = new ArrayList<Integer>();

        for (int elem : arr) {
            switch (elem) {
                case 1:
                    firstCount++;
                    break;
                case 2:
                    secondCount++;
                    break;
                case 3:
                    thirdCount++;
                    break;
                case 4:
                    fourthCount++;
                    break;
                case 5:
                    fifthCount++;
                    break;
            }
        }
        counts.add(firstCount);
        counts.add(secondCount);
        counts.add(thirdCount);
        counts.add(fourthCount);
        counts.add(fifthCount);

        maxValue = findMaxValue(counts);

        for (int i = 0; i < 5; i++) {
            if (counts.get(i) == maxValue) {
                correctID = i + 1;
                break;
            }
        }
        return correctID;
    }

    private static int findMaxValue (List<Integer> list) {
        List<Integer> sortedlist = new ArrayList<>(list);

        Collections.sort(sortedlist);
        return sortedlist.get(sortedlist.size() - 1);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(4);
        arr.add(4);
        arr.add(4);
        arr.add(5);
        arr.add(3);

        int result = Result.migratoryBirds(arr);
        System.out.println(result);
    }
}
