import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.JulianFields;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        final int dayOfProgrammer = 256;
        LocalDate date = LocalDate.ofYearDay(year, dayOfProgrammer);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        if ((year <= 1919) && (year % 4 == 0) && (!date.isLeapYear())) {
            date = date.plusDays(-1);
        }

        if (year == 1918) {
            date = date.plusDays(13);
        }

        String parsedDate = date.format(formatter);
        return parsedDate;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        int year = 1918;

        String result = Result.dayOfProgrammer(year);
        System.out.println(result);
    }
}
