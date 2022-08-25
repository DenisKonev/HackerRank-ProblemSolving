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
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
        String[] array = grid.toArray(new String[0]);

        for (int i = 1; i < array.length - 1; i++)
            for (int j = 1; j < array.length - 1; j++) {
                int cavity = Character.getNumericValue(array[i].charAt(j));
                if ((cavity > Character.getNumericValue(array[i - 1].charAt(j))) && (cavity > Character.getNumericValue(array[i].charAt(j - 1)))
                        && (cavity > Character.getNumericValue(array[i + 1].charAt(j))) && (cavity > Character.getNumericValue(array[i].charAt(j + 1))))
                    array[i] = array[i].substring(0,j) + 'X' + array[i].substring(j + 1);
            }
        return Arrays.asList(array);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
