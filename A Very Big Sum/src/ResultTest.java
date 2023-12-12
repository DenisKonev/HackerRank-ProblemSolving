import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    public void testAVeryBigSum() {
        List<Long> ar = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        long expectedResult = 15L;

        long actualResult = Result.aVeryBigSum(ar);

        assertEquals(expectedResult, actualResult);
    }
}