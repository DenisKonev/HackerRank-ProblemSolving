import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */

    public static long aVeryBigSum(List<Long> ar) {
        long result = 0;
        System.out.println(ar.size());
        for(int i = 0; i < ar.size(); i++) {
            result += ar.get(i);
            System.out.println(ar.get(i));
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Long> ar = new ArrayList<Long>();
        ar.add(101L);
        ar.add(102L);
        ar.add(103L);
        ar.add(104L);
        ar.add(105L);

        long result = Result.aVeryBigSum(ar);
        System.out.println(result);
    }
}
