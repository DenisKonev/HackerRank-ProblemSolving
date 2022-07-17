import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        int arrLength = candles.size();
        int lastArrElem = arrLength - 1;
        int candlesCount = 0;
        int maxValue = candles.stream().mapToInt(value -> value).max().orElseThrow(NoSuchElementException::new);

        for(int i = 0; i < arrLength; i++) {
            if(candles.get(i).equals(maxValue)) candlesCount++;
        }
        return candlesCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> candles = new ArrayList<Integer>();
        candles.add(9999934);
        candles.add(9999934);
        candles.add(9999934);
        candles.add(3920748);
        candles.add(5981868);

        int result = Result.birthdayCakeCandles(candles);
        System.out.println(result);

    }
}
