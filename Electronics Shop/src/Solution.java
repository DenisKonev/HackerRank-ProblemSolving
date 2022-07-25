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

public class Solution {

    public static void main(String[] args) throws IOException {
        int result;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int budget = Integer.parseInt(firstMultipleInput[0]);

        List<Integer> keyboards = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> drives = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        bufferedReader.close();
        result = calculateBudget(budget, keyboards, drives);
        System.out.println(result);
    }

    private static int calculateBudget(int budget, List<Integer> keyboards, List<Integer> drives) {
        List<Integer> setPrices = new ArrayList<Integer>();
        int setPrice;

        Collections.sort(keyboards);
        Collections.sort(drives);

        // create a list of all possible sets that are not over the budget
        for (int keyboard : keyboards) {
            if (keyboard >= budget) {
                break;
            } else {
                for (int drive : drives) {
                    if (drive >= budget) {
                        break;
                    } else {
                        setPrice = keyboard + drive;
                        if (setPrice <= budget) {
                            setPrices.add(setPrice);
                        }
                    }
                }
            }
        }
        //sort the new list, try to find the best match from the end & return it or return -1 if nothing found
        Collections.sort(setPrices);
        for (int i = setPrices.size() - 1; i >= 0; i--) {
            setPrice = setPrices.get(i);
            if (setPrice <= budget) {
                return setPrice;
            }
        }
        return -1;
    }
}
