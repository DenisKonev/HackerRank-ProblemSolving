import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) throws IOException{
        int result;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int cloudsCount = Integer.parseInt(firstMultipleInput[0]);
        int jumpLength = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> clouds = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        bufferedReader.close();
        result = calculateEnergy(cloudsCount, jumpLength, clouds);
        System.out.println(result);
    }

    private static int calculateEnergy(int cloudsCount, int jumpLength, List<Integer> clouds) {
        int energy = 100, i = 0, arrayLength = cloudsCount - 1;

        do {
            i += jumpLength;
            if (i > arrayLength) {
                i %= cloudsCount;
            }
            energy -= clouds.get(i) == 1 ? 3 : 1;
        } while (i != 0);
        return energy;
    }
}