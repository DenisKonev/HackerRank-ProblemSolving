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
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        int maxHeight = 1, charArrayPosition, charHeight;
        char[] chars = word.toCharArray();

        for (char ch : chars) {
            /*
            according to ASCII table "a" character has ASCII code 097 and "z" 122 so in order to match characters to correct index in array
            we should subtract 97 from int ASCII code representation of character
             */
            charArrayPosition = ch - 97;
            charHeight = h.get(charArrayPosition);
            if ( charHeight > maxHeight) {
                maxHeight = charHeight;
            }
        }
        //return area size in mm² assuming that we tak the highest letter and multiply it by number of letters
        return maxHeight * chars.length;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();
        bufferedReader.close();

        int result = Result.designerPdfViewer(h, word);
        System.out.println(result);
    }
}
