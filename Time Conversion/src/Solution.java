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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        int hoursPM = 0;
        String newString = "";
        s.toUpperCase();

        if(s.endsWith("AM")) {
            if(s.startsWith("12")) {
                newString = s.replaceFirst("12", "00");
                newString = newString.replace("AM", "");
            } else newString = s.replace("AM", "");
        } else {
            if(s.startsWith("12")) newString = s.replace("PM", "");
            else {
                hoursPM = Integer.parseInt(s.substring(0,2)) + 12;
                newString = s.replaceFirst(s.substring(0,2), String.valueOf(hoursPM));
                newString = newString.replace("PM", "");
            }
        }
        return newString;

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        String s = "11:12:12PM";
        String result = Result.timeConversion(s);
        System.out.println(result);
    }
}
