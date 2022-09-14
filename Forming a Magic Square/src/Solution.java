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
        ArrayList<Integer> sumsList = new ArrayList<>(calculateSums(s));
        int magicConstant = findMagicConstant(s, sumsList), sumOfModifications = 0;


        return sumOfModifications;
    }

    private static int findMagicConstant(List<List<Integer>> list, ArrayList<Integer> sumsList) {
        SortedSet<Integer> sortedUniqueList = new TreeSet<>(sumsList);
        int magicConstant = 0, currentMaxOccurrences = 0;

        for (int val : sortedUniqueList) {
            int numOfOccurrences = Collections.frequency(sumsList, val);
            if (numOfOccurrences > currentMaxOccurrences) {
                magicConstant = val;
                currentMaxOccurrences = numOfOccurrences;
            }
        }
        return magicConstant;
    }

    private static ArrayList<Integer> calculateSums(List<List<Integer>> list) {
        int[][] array = list.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        ArrayList<Integer> sumsList = new ArrayList<>();

        //adding all eight sums to the list: 3 horizontal lines, 3 vertical & 2 diagonals
        for (int i = 0; i < array.length; i++) {
            sumsList.add(array[i][0] + array[i][1] + array[i][2]);
            sumsList.add(array[0][i] + array[1][i] + array[2][i]);
        }
        sumsList.add(array[0][0] + array[1][1] + array[2][2]);
        sumsList.add(array[0][2] + array[1][1] + array[2][0]);
        return sumsList;
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
