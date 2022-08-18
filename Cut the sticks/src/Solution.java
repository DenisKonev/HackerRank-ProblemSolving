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
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        int minValue, arrSize = arr.size();
        List<Integer> tempArr = new ArrayList<Integer>(arr);
        List<Integer> result = new ArrayList<Integer>();

        result.add(tempArr.size());
        do {
            minValue = Collections.min(tempArr);
            if (arrSize != tempArr.size()) {
                result.add(tempArr.size());
                arrSize = tempArr.size();
            }
            tempArr = createNewArray(tempArr, minValue);
        } while (tempArr.size() != 0);
        return result;
    }

    private static List<Integer> createNewArray(List<Integer> tempArr, int minValue) {
        for (int i = 0; i < tempArr.size(); i++)
            if (tempArr.get(i) <= minValue) {
                tempArr.remove(i);
                i--;
            }
        tempArr.replaceAll(e -> e -= minValue);
        return tempArr;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
