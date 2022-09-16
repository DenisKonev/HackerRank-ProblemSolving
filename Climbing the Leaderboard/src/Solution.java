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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        Integer[] resultingPlaces = new Integer[player.size()];
        int rank = 1;
		// go from higher value of player score to smaller value as we can count the rank from top of leaderboard. Note, both pointers are initialized here and so it makes it O(n+m)
        for (int p = player.size() - 1, r = 0; p >= 0; p--) {
			// on the leaderboard go down from top, increment the rank. On each step compare the value with players score so that we can set rank for it.
            while ((r <= ranked.size() - 1) && (ranked.get(r) > player.get(p))) {
				// if leaderboard score is higher than players score then continue and incremnet rank
                if ((r != 0) && (ranked.get(r) < ranked.get(r - 1)))
                    rank++;
                r++;
            }
			// if players score is higher than that on leaderboard then set players rank to 1
            if (r == 0)
                resultingPlaces[p] = 1;
            else
			// else set players rank to be 1 more than the rank calculated so far as player will be next on the leaderboard
                resultingPlaces[p] = rank + 1;
        }
        return Arrays.asList(resultingPlaces);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

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
