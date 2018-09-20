package imperative;

import static imperative.Solution.filterRecursive;
import static imperative.Solution.powerSum;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test_13_of_x_power_sum() {
        assertEquals(1, powerSum(13, 2));
    }

    @Test
    public void test_100_of_x_power_sum() {
        assertEquals(3, powerSum(100, 2));
    }

    @Test
    public void test_250_of_x_power_sum() {
        assertEquals(21, powerSum(250, 2));
    }

    @Test
    public void test_3_of_n_power_sum() {
        assertEquals(1, powerSum(100, 3));
    }
}