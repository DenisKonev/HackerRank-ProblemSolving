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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        List<Integer> misElems = new ArrayList<Integer>();
        List<Integer> validDivisors = new ArrayList<Integer>();
        int elemCount = 0;

        Collections.sort(a);
        Collections.sort(b);

        //looping from the last element of a to the first of b
        for (int i = a.get(a.size() - 1); i <= b.get(0); i++) {
            misElems.addAll(findMisElems(i, a));
        }

        validDivisors = misElems;
        for (int dividend : b) {
            validDivisors = findValidDivisors(dividend, validDivisors);
        }

        return validDivisors.size();
    }

    private static List<Integer> findMisElems(int dividend, List<Integer> divisors) {
        List<Integer> misElems = new ArrayList<Integer>();
        boolean woRemainFlag = false;

        for (int divisor : divisors) {
            if (dividend % divisor == 0) {
                woRemainFlag = true;
            } else {
                woRemainFlag = false;
                break;
            }
        }

        if (woRemainFlag) {
            misElems.add(dividend);
        }

        return misElems;
    }
    private static List<Integer> findValidDivisors(int dividend, List<Integer> divisors) {
        List<Integer> validDivisors = new ArrayList<Integer>();

        for (int divisor : divisors) {
            if( dividend % divisor == 0) {
                validDivisors.add(divisor);
            }
        }

        return validDivisors;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(4);

        List<Integer> brr = new ArrayList<Integer>();
        brr.add(24);
        brr.add(48);

        int total = Result.getTotalX(arr, brr);
        System.out.println(total);
    }
}
