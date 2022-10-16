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
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        /* number of allowed swap operations for each container = sum of balls of another type
         * number of balls to swap of each type = total number of balls - balls in the correct container
         * if number of swap operations is not equal to the number of balls in the correct container then Impossible, otherwise Possible
         */
        int numberOfContainers = container.size();
        long[] allowedSwaps = new long[numberOfContainers];
        long[] ballsToSwap = new long[numberOfContainers];
        long[][] containerArray = container.stream().map(u -> u.stream().mapToLong(i -> i).toArray()).toArray(long[][]::new);

        //i = current container, j = current ball type
        for (int i = 0; i < numberOfContainers; i++)
            for (int j = 0; j < numberOfContainers; j++) {
                allowedSwaps[i] += containerArray[i][j];
                ballsToSwap[j] += containerArray[i][j];
            }

        Arrays.sort(allowedSwaps);
        Arrays.sort(ballsToSwap);

        for (int i = 0; i < numberOfContainers; i++)
            if (allowedSwaps[i] != ballsToSwap[i])
                return "Impossible";

            return "Possible";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
