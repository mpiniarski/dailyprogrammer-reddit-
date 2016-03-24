import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by marcin on 24.03.16.
 */
public class SolverTest {

    private IpDistanceSolver solver;

    @Before
    public void setUp() throws Exception {
        solver = new IpDistanceSolver();
    }

    @Test
    public void testLittleMoveIp() throws Exception {
        assertEquals(6.0, solver.calculateDistance("777.777.777.777"));
    }

    @Test
    public void testInput() throws Exception {
        assertEquals(27.38, solver.calculateDistance("219.45.143.143"));
    }

    @Test (expected = IncorrectIpAdressException.class)
    public void testNotCorrectIpTooLong() throws Exception {
        solver.calculateDistance("2100.45.143.14");
    }

    @Test (expected = IncorrectIpAdressException.class)
    public void testNotCorrectIpIllegalCharacters() throws Exception {
        solver.calculateDistance("21.4a5.143.14");
    }
}
