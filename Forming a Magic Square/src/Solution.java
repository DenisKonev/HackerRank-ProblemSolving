import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        //all magic squares possible for 3x3 matrix
        int[][] magicSquares = {
                { 8, 1, 6, 3, 5, 7, 4, 9, 2 },
                { 4, 3, 8, 9, 5, 1, 2, 7, 6 },
                { 2, 9, 4, 7, 5, 3, 6, 1, 8 },
                { 6, 7, 2, 1, 5, 9, 8, 3, 4 },
                { 6, 1, 8, 7, 5, 3, 2, 9, 4 },
                { 8, 3, 4, 1, 5, 9, 6, 7, 2 },
                { 4, 9, 2, 3, 5, 7, 8, 1, 6 },
                { 2, 7, 6, 9, 5, 1, 4, 3, 8 }};
        int[] array = s.stream().flatMap(Collection::stream).collect(Collectors.toList())
                .stream().mapToInt(Integer::intValue).toArray();
        // difference can't be more than 100, actually 45, but I'm too lazy to double-check it, so I put 100 :)
        int minPossibleDifference = 100;

        for (int i = 0; i < magicSquares.length; i++) {
            int differenceSum = 0;
            for (int j = 0; j < array.length; j++)
                differenceSum += Math.abs(magicSquares[i][j] - array[j]);
            if (minPossibleDifference > differenceSum)
                minPossibleDifference = differenceSum;
        }
        return minPossibleDifference;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
