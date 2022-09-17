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
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int result = 0;
        boolean collision;

        for (int i = 0; i < 8; i++)
            for (int j = 1; j < n; j++) {
                collision = detectCollision(n, r_q, c_q, i, j, obstacles);
                if (collision)
                    break;
                result++;
            }
        return result;
    }
    private static boolean detectCollision(int boardSize, int queenY, int queenX, int direction, int step, List<List<Integer>> obstacles) {
        boolean collision = false;
        int[][] obstArray = new int[boardSize][boardSize];

        for (List<Integer> obst : obstacles) {
            int r = boardSize - obst.get(0);    // row index
            int c = obst.get(1) - 1;            //column index
            obstArray[r][c] = 1;
        }

        /* r - right, l - left, u - up, d - down, direction var shows where the queen goes, e.g. lr 0 - from left to right
         * 2 horizontal	directions	  lr 0	rl 1
         * 2 vertical directions	  du 2	ud 3
         * 4 diagonal directions	  lu 4	ld 5	rd 6	ru 7
         */
        switch (direction) {
            case 0:
                if ((queenX + step > boardSize) || (obstArray[boardSize - queenY][queenX + step - 1] == 1 )) {
                    collision = true;
                }
                else {
                    collision = false;
                }
                break;
            case 1:
                if ((queenX - step == 0) || (obstArray[boardSize - queenY][queenX - step - 1] == 1 )) {
                    collision = true;
                }
                else {
                    collision = false;
                }
                break;
            case 2:
                if ((queenY + step > boardSize) || (obstArray[boardSize - queenY - step][queenX - 1] == 1 )) {
                    collision = true;
                }
                else {
                    collision = false;
                }
                break;
            case 3:
                if ((queenY - step == 0) || (obstArray[boardSize - queenY + step][queenX - 1] == 1 )) {
                    collision = true;
                }
                else {
                    collision = false;
                }
                break;
            case 4:
                if ((queenX + step > boardSize) || (queenY + step > boardSize) ||
                        ((obstArray[boardSize - queenY][queenX + step - 1] == 1 ) && (obstArray[boardSize - queenY - step][queenX - 1] == 1 ))) {
                    collision = true;
                }
                else {
                    collision = false;
                }
                break;
            case 5:
                if ((queenX + step > boardSize) || (queenY - step == 0) ||
                        ((obstArray[boardSize - queenY][queenX + step - 1] == 1 ) && (obstArray[boardSize - queenY + step][queenX - 1] == 1 ))) {
                    collision = true;
                }
                else {
                    collision = false;
                }
                break;
            case 6:
                if ((queenX - step == 0) || (queenY + step > boardSize) ||
                        ((obstArray[boardSize - queenY][queenX - step - 1] == 1 ) && (obstArray[boardSize - queenY + step][queenX - 1] == 1 ))) {
                    collision = true;
                }
                else {
                    collision = false;
                }
                break;
            case 7:
                if ((queenX - step == 0) || (queenY - step == 0) ||
                        ((obstArray[boardSize - queenY][queenX - step - 1] == 1 ) && (obstArray[boardSize - queenY - step][queenX - 1] == 1 ))) {
                    collision = true;
                }
                else {
                    collision = false;
                }
                break;
        }
        return collision;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
