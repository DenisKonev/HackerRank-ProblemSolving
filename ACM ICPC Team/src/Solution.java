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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        int maxTopics, maxTeams;
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> currentTopics = new ArrayList<Integer>();

        for (int i = 0; i < topic.size() - 1; i++)
            for (int j = i + 1; j < topic.size(); j++)
                currentTopics.add(findMaxTopics(topic.get(i), topic.get(j)));
        maxTopics = Collections.max(currentTopics);
        maxTeams = Collections.frequency(currentTopics, maxTopics);
        result.add(maxTopics);
        result.add(maxTeams);
        return result;
    }

    private static int findMaxTopics(String topics1, String topics2) {
        int topicsCount = 0;
        for (int i = 0; i < topics1.length(); i++)
            //check that each char in both strings = 1
            if ((Character.getNumericValue(topics1.charAt(i)) | (Character.getNumericValue(topics2.charAt(i)))) == 1)
                topicsCount++;
        return topicsCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

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
