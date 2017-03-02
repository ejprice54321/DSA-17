import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class ProblemsTest {
    private int[] emptyCase;
    private int[] oneCase;
    private int[] twoCase;
    private int[] mediumCase;
    private int[] fastCase;
    private int[] slowCase;

    @Before
    public void setup() {
        emptyCase = HeapSortTest.generateRandomArrayOfSize(0);
        oneCase = HeapSortTest.generateRandomArrayOfSize(1);
        twoCase = HeapSortTest.generateRandomArrayOfSize(2);
        mediumCase = new int[]{3, 1, 6, 4, 2, 1, 8, 1, 10, 21, 6};
        fastCase = HeapSortTest.generateRandomArrayOfSize(1000);
        slowCase = HeapSortTest.generateRandomArrayOfSize(10000);
    }

    @Test
    public void testRunningMedian() {
        assertTrue(Arrays.equals(Problems.runningMedian(emptyCase), Problems.runningMedianReallySlow(emptyCase)));
        assertTrue(Arrays.equals(Problems.runningMedian(oneCase), Problems.runningMedianReallySlow(oneCase)));
        assertTrue(Arrays.equals(Problems.runningMedian(twoCase), Problems.runningMedianReallySlow(twoCase)));
        assertTrue(Arrays.equals(Problems.runningMedian(mediumCase), Problems.runningMedianReallySlow(mediumCase)));
        assertTrue(Arrays.equals(Problems.runningMedian(fastCase), Problems.runningMedianReallySlow(fastCase)));
        assertTrue(Arrays.equals(Problems.runningMedian(slowCase), Problems.runningMedianReallySlow(slowCase)));
    }

}
