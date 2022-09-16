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
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] bucket = new int[k];
        int answer = 0;

        for (int i : s)
            bucket[i % k]++;
        //only one element is allowed in the subarray which divide w/o remainder by k
        if (bucket[0] != 0)
            answer++;
        //find the largest amount of elements for each pair which satisfy task terms, e.g. for k = 7 it's 1 & 6, 2 & 5 and etc.
        for (int i = 1; i <= bucket.length / 2; i++) {
            if ((bucket.length % 2 == 0) && (i == bucket.length / 2)) {
                answer++;
                break;
            }
            if (bucket[i] > bucket[bucket.length - i])
                answer += bucket[i];
            else
                answer += bucket[bucket.length - i];
        }
        return answer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
