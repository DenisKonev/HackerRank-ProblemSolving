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
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int totalAnnaToPay = 0;
        int totalToPay = 0;

        for (int elem : bill) {
            totalToPay += elem;
        }
        totalAnnaToPay = (totalToPay - bill.get(k)) / 2;
        if (totalAnnaToPay == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - totalAnnaToPay);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int k = 1;
        int b = 12;
        List<Integer> bill = new ArrayList<Integer>();
        bill.add(3);
        bill.add(10);
        bill.add(2);
        bill.add(9);

        Result.bonAppetit(bill, k, b);
    }
}
