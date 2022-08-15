import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.Year;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        int i;
        int check=0;
        for(i=0;i<s.length()&&i<t.length();i++)
            if(s.charAt(i)!=t.charAt(i))
                break;

        int d=s.length()-i;
        int a=t.length()-i;
        int p=k-d-a;
        String result;

        if(p==0)
            result = "Yes";
        else if(p<0)
            result = "No";
        else
        {
            if(p%2==0)
                result = "Yes";
            else
            {
                if(p>=(2*i))
                    result = "Yes";
                else
                    result = "No";
            }
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
