import java.io.*;
        import java.util.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.toList;

class Result {
    public static int calculateMaxDistance(int n, List<Integer> arr) {
        int maxDistance = 0;

        for (int i = 0; i < n; i++) {
                int minDistance = n;
                if (arr.contains(i))
                    continue;
                for (int j = 0; j < arr.size(); j++) {
                    int tempDistance = Math.abs(arr.get(j) - i);
                    if (minDistance > tempDistance)
                        minDistance = tempDistance;
                    }
                maxDistance = Math.max(maxDistance, minDistance);
            }
        return maxDistance;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.calculateMaxDistance(n, arr);
        System.out.println(result);

        bufferedReader.close();
    }
}
