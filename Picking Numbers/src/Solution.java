import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        int maxLength = 0;
        List<Integer> subarray = new ArrayList<Integer>();

        for (int i = 0; i < a.size(); i++) {
            subarray = findValidSubarray(a, a.get(i));
            if ((subarray.size() > maxLength)) {
                maxLength = subarray.size();
            }
        }
        return maxLength;
    }

    private static List<Integer> findValidSubarray(final List<Integer> array, final Integer integer) {
        final List<Integer> subarray = new ArrayList<Integer>();
        for (final int elem : array) {
            if ((elem == integer) || (elem + 1 == integer)) {
                subarray.add(elem);
                System.out.print(elem + " ");
            }
        }
        System.out.println();
        return subarray;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        bufferedReader.close();

        int result = Result.pickingNumbers(a);
        System.out.println(result);
    }
}
