import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by marcin on 30.03.16.
 */
public class GarageDoorTest {

    private GarageDoor garageDoor;

    @Before
    public void setUp() throws Exception {
        garageDoor = new GarageDoor();
    }

    @org.junit.Test
    public void testInitialState() throws Exception {
        assertEquals(GarageDoor.State.CLOSED, garageDoor.getCurrState());
    }

    @Test
    public void testOpening() throws Exception {
        garageDoor.clickButton();
        garageDoor.printStateHistory();
        assertEquals(GarageDoor.State.OPENING, garageDoor.getCurrState());
    }

    @Test
    public void testOpen() throws Exception {
        garageDoor.clickButton();
        garageDoor.completeCycle();
        garageDoor.printStateHistory();
        assertEquals(GarageDoor.State.OPEN, garageDoor.getCurrState());
    }

    @Test
    public void testInputFromDaily() throws Exception {
        garageDoor.clickButton();
        garageDoor.completeCycle();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.completeCycle();
        garageDoor.printStateHistory();
        assertEquals(GarageDoor.State.CLOSED, garageDoor.getCurrState());
    }

    @Test
    public void testClosedBlock() throws Exception {
        garageDoor.blockDoor();
        garageDoor.printStateHistory();
        assertEquals(GarageDoor.State.BLOCK_CLOSED, garageDoor.getCurrState());
    }

    @Test
    public void testBlockOpening() throws Exception {
        garageDoor.clickButton();
        garageDoor.blockDoor();
        garageDoor.printStateHistory();
        assertEquals(GarageDoor.State.BLOCK_OPENING, garageDoor.getCurrState());
    }

    @Test
    public void testEmergencyOpening() throws Exception {
        garageDoor.clickButton();
        garageDoor.completeCycle();
        garageDoor.clickButton();
        garageDoor.blockDoor();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.printStateHistory();
        assertEquals(GarageDoor.State.EMERGENCY_OPENING, garageDoor.getCurrState());
    }

    @Test
    public void testBlockOpenAfterEmergencyOpening() throws Exception {
        garageDoor.clickButton();
        garageDoor.completeCycle();
        garageDoor.clickButton();
        garageDoor.blockDoor();
        garageDoor.completeCycle();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.printStateHistory();
        assertEquals(GarageDoor.State.BLOCK_OPEN, garageDoor.getCurrState());
    }

    @Test
    public void testBlockClearedOpening() throws Exception {
        garageDoor.clickButton();
        garageDoor.blockDoor();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.clickButton();
        garageDoor.unblockDoor();
        garageDoor.printStateHistory();
        assertEquals(GarageDoor.State.OPENING, garageDoor.getCurrState());
    }

    @Test
    public void testBonusInputFromDaily() throws Exception {
        garageDoor.clickButton();
        garageDoor.completeCycle();
        garageDoor.clickButton();
        garageDoor.blockDoor();
        garageDoor.clickButton();
        garageDoor.completeCycle();
        garageDoor.clickButton();
        garageDoor.unblockDoor();
        garageDoor.clickButton();
        garageDoor.completeCycle();
        garageDoor.printStateHistory();
        assertEquals(GarageDoor.State.CLOSED, garageDoor.getCurrState());
    }
}
