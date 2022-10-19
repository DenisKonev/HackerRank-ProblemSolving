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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        var newString = new StringBuilder();
        int rowCount = (int)(Math.sqrt(s.length())), columnCount = rowCount + 1;
        String[] stringArray = new String[rowCount];

        if (s.length() == 1)
            return s;
        else if (s.length() - (rowCount * rowCount) == 0) {
            rowCount -= 1;
            columnCount -= 1;
        }

        for (int i = 0; i < rowCount; i++) {
            stringArray = s.split("(?<=\\G.{" + columnCount + "})");
        }

        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < stringArray.length; j++)
                if (i < stringArray[j].length())
                    newString.append(stringArray[j].charAt(i));
            newString.append(" ");
        }

        return newString.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
