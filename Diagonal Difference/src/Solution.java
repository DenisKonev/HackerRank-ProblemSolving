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
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int result;
        int diagSum1 = 0;
        int diagSum2 = 0;
        int arrLength = arr.size();

        for(int i = 0; i < arrLength; i++){
            diagSum1 += arr.get(i).get(i);
            diagSum2 += arr.get(i).get(arrLength - (i+1));
        }

        result = diagSum1 - diagSum2;
        if(result < 0) {
            result = diagSum2 - diagSum1;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        int n = 3;
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0; i < n; i++) {
            arr.add(new ArrayList());
        }
        
        arr.get(0).add(01);
        arr.get(0).add(02);
        arr.get(0).add(03);
        arr.get(1).add(11);
        arr.get(1).add(12);
        arr.get(1).add(13);
        arr.get(2).add(21);
        arr.get(2).add(22);
        arr.get(2).add(23);

        int result = Result.diagonalDifference(arr);

    }
}
