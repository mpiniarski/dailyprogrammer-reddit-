import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by marcin on 20.03.16.
 */
public class SolverTest {
    @org.junit.Test
    public void testEmptyFile() throws Exception {
        Solver solver = new Solver();
        assertEquals(0, solver.findSolutionYear("empty.txt"));
    }

    @Test
    public void testInputFile() throws Exception {
        Solver solver = new Solver();
        assertThat(solver.findSolutionYear("input.txt"),
                anyOf(is(1822), is(1823), is(1824), is(1825),
                        is(1826), is(1831), is(1833), is(1834),
                        is(1835), is(1836), is(1837), is(1838),
                        is(1839), is(1840), is(1841), is(1843),
                        is(1844), is(1845)));
    }
}
