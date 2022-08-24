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
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> B) {
        int distributionCount = 0;
        boolean evenlyDistributed;
        Integer sum = B.stream().collect(Collectors.summingInt(Integer::intValue));
        
        if (sum % 2 == 1)
            return "NO";
        else {
            do {
                evenlyDistributed = checkDistributionValidity(B);
                if (!evenlyDistributed) {
                    distributeBreads(B);
                    distributionCount += 2;
                }
            } while (!evenlyDistributed);
            return Integer.toString(distributionCount);
        }
    }

    private static void distributeBreads(List<Integer> breads) {
        for (int i = 0; i < breads.size(); i++)
            if (breads.get(i) % 2 != 0) {
                increaseBreadsCount(i, breads);
                if (i == 0) {
                    increaseBreadsCount(i + 1, breads);
                    break;
                } else if (i == breads.size() - 1) {
                    increaseBreadsCount(i - 1, breads);
                    break;
                } else {
                    if (breads.get(i - 1) % 2 == 1) {
                        increaseBreadsCount(i - 1, breads);
                        break;
                    }
                    else {
                        increaseBreadsCount(i + 1, breads);
                        break;
                    }
                }
            }
    }

    private static void increaseBreadsCount(int i, List<Integer> breads) {
        breads.set(i, breads.get(i) + 1);
    }

    private static boolean checkDistributionValidity(List<Integer> breads) {
        boolean distributionValidity = true;
        for (int bread : breads)
            if (bread % 2 != 0) {
                distributionValidity = false;
                break;
            }
        return distributionValidity;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
