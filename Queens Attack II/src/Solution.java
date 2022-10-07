import java.io.*;
import java.util.*;
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
        /*  n - board size 	k - number of obstacles
         *  r_q, c_q - queen's position     r_q = y	    c_q = x
         */
        int result = 0;
        boolean collision = false;

        if (obstacles.isEmpty())
            return noObstaclesResult(n, r_q, c_q);

        /* first loop steps increment, second loop is representation of eight possible directions, e.g. from left to right
         * i - step, j - direction
         */
        for (int j = 0; j < 8; j++)
            for (int i = 1; i < n; i++)
             {
                collision = detectCollision(n, r_q, c_q, j, i, obstacles);
                if (collision) {
                    result += i - 1;
                    break;
                }
            }
        return result;
    }

    private static int noObstaclesResult(int boardSize, int y, int x) {
        int result = (boardSize - 1) * 2;

        if (y > x) {
            result += (x - 1) * 2;
            result += boardSize - y;
            result += y - 1;
        }
        else if (y < x) {
            result += (y - 1) *2;
            result += boardSize - x;
            result += x - 1;
        } else
            result += boardSize - 1;
        return result;
    }

    private static boolean detectCollision(int boardSize, int queenY, int queenX, int direction, int step, List<List<Integer>> obstacles) {
        int newQueenX, newQueenY;
        boolean collision = false;

        /* r - right, l - left, u - up, d - down, direction var shows where the queen goes, e.g. lr 0 - from left to right
         lu 4 - diagonal direction left upwards
         * 2 horizontal	directions	  lr 0	rl 1
         * 2 vertical directions	  du 2	ud 3
         * 4 diagonal directions	  lu 4	ld 5	rd 6	ru 7
         */
        for (List<Integer> obstacle : obstacles) {
            int obstacleY = obstacle.get(0);
            int obstacleX = obstacle.get(1);
            switch (direction) {
                case 0:
                    newQueenX = queenX + step;
                    if ((newQueenX > boardSize) || detectObstacleCollision(newQueenX, queenY, obstacleX, obstacleY))
                        collision = true;
                    break;
                case 1:
                    newQueenX = queenX - step;
                    if ((newQueenX == 0) || detectObstacleCollision(newQueenX, queenY, obstacleX, obstacleY))
                        collision = true;
                    break;
                case 2:
                    newQueenY = queenY + step;
                    if ((newQueenY > boardSize) || detectObstacleCollision(queenX, newQueenY, obstacleX, obstacleY))
                        collision = true;
                    break;
                case 3:
                    newQueenY = queenY - step;
                    if ((newQueenY == 0) || detectObstacleCollision(queenX, newQueenY, obstacleX, obstacleY))
                        collision = true;
                    break;
                case 4:
                    newQueenX = queenX + step;
                    newQueenY = queenY + step;
                    if ((newQueenX > boardSize) || (newQueenY > boardSize) || detectObstacleCollision(newQueenX, newQueenY, obstacleX, obstacleY))
                        collision = true;
                    break;
                case 5:
                    newQueenX = queenX + step;
                    newQueenY = queenY - step;
                    if ((newQueenX > boardSize) || (newQueenY == 0) || detectObstacleCollision(newQueenX, newQueenY, obstacleX, obstacleY))
                        collision = true;
                    break;
                case 6:
                    newQueenX = queenX - step;
                    newQueenY = queenY + step;
                    if ((newQueenX == 0) || (newQueenY > boardSize) || detectObstacleCollision(newQueenX, newQueenY, obstacleX, obstacleY))
                        collision = true;
                    break;
                case 7:
                    newQueenX = queenX - step;
                    newQueenY = queenY - step;
                    if ((newQueenX == 0) || (newQueenY == 0) || detectObstacleCollision(newQueenX, newQueenY, obstacleX, obstacleY))
                        collision = true;
                    break;
            }
            if (collision)
                break;
        }
        return collision;
    }
    private static boolean detectObstacleCollision(int queenX, int queenY, int obstacleX, int obstacleY) {
        boolean collision = false;

        if ((queenX == obstacleX) && (queenY == obstacleY))
            collision = true;
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
