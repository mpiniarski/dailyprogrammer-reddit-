import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.FileLockInterruptionException;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by marcin on 07.03.16.
 */
public class SimulatorTest {

    private Simulator simulator;

    @Before
    public void setUp() throws Exception {
        simulator = new Simulator(0);
    }

    private void executeSimulationFromFile(String sourceFileName) throws FileNotFoundException, FileLockInterruptionException {
        File inputFile = new File(sourceFileName);
        Scanner input = new Scanner(inputFile);
        if (input.hasNextInt()){
            int size = input.nextInt();
            simulator = new Simulator(size);

            while (input.hasNextInt()){
                int currBegin = input.nextInt();
                int currEnd = 0;
                if (input.hasNextInt())
                    currEnd = input.nextInt();
                else{
                    throw new FileLockInterruptionException();
                }
                simulator.rangeToggle(new int[] {currBegin, currEnd});
            }
        }
        else {
            simulator = new Simulator(0);
        }
    }

    @org.junit.Test
    public void testEmptyInput() throws Exception {
        executeSimulationFromFile("empty.txt");
        assertEquals(0, simulator.bulbsOn());
    }

    @Test
    public void testNoTogglesInput() throws Exception {
        executeSimulationFromFile("noToggles.txt");
        assertEquals(0, simulator.bulbsOn());
    }

    @Test
    public void testOneToggle() throws Exception {
        executeSimulationFromFile("oneToggle.txt");
        assertEquals(5, simulator.bulbsOn());
    }

    @Test
    public void testManyToggles() throws Exception {
        executeSimulationFromFile("manyToggles.txt");
        assertEquals(7, simulator.bulbsOn());
    }

    @Test
    public void testChallengeInput() throws Exception {
        executeSimulationFromFile("challengeInput.txt");
        assertEquals(423, simulator.bulbsOn());
    }

    @Test
    public void testLotsOfToggles() throws Exception {
        executeSimulationFromFile("lots_of_switches.txt");
        assertEquals(2500245, simulator.bulbsOn());
    }
}
