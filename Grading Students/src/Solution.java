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
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        int nextMultiOf5 = 0;
        int gradeRemainder = 0;
        List<Integer> roundedGrades = new ArrayList<Integer>();

        for (int grade : grades) {
            if (grade >= 38) {
                nextMultiOf5 = ((grade / 5) * 5 + 5);
                gradeRemainder = nextMultiOf5 % grade;
                if (gradeRemainder < 3) {
                    roundedGrades.add(nextMultiOf5);
                } else {
                    roundedGrades.add(grade);
                }
            } else {
                roundedGrades.add(grade);
            }
        }
        return roundedGrades;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        int gradesCount = 5;

        List<Integer> grades = new ArrayList<Integer>();
        grades.add(73);
        grades.add(67);
        grades.add(38);
        grades.add(33);
        grades.add(84);

        List<Integer> result = Result.gradingStudents(grades);

        result.forEach((grade) -> {System.out.println(grade);});
    }
}
