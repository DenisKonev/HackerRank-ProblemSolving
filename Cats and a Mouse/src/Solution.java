import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> positions = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();

        String[] queriesString = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int queries = Integer.parseInt(queriesString[0]);

        for (int i = 0; i < queries; i++) {
            temp = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
            positions = Stream.concat(positions.parallelStream(), temp.parallelStream()).collect(Collectors.toList());
        }

/*        for (int position : positions) {
            System.out.print(position + " ");
        }
 */
        catAndMouse(queries, positions);
    }

    private static void catAndMouse(int queries, List<Integer> positions) {
        int catA, catB, mouse, postionIndex;

        for (int i = 0; i < queries; i++) {
            postionIndex = i * 3;
            catA = positions.get(postionIndex);
            catB = positions.get(postionIndex + 1);
            mouse = positions.get(postionIndex + 2);

            while (true) {
                if (catA == catB) {
                    System.out.println("Mouse C");
                    break;
                }
                if (catA == mouse) {
                    System.out.println("Cat A");
                    break;
                }
                if (catB == mouse) {
                    System.out.println("Cat B");
                    break;
                }
                //simulate cats movements
                if (catA > mouse) {
                    catA--;
                } else {
                    catA++;
                }
                if (catB > mouse) {
                    catB--;
                } else {
                    catB++;
                }
            }
        }
    }
}