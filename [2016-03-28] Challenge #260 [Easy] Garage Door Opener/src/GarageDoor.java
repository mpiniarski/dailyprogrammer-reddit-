import java.util.ArrayList;
import java.util.List;

public class GarageDoor {
    enum State {CLOSED, OPEN, CLOSING,
                OPENING, STOPPED_WHILE_CLOSING, STOPPED_WHILE_OPENING,
                BLOCK_CLOSED, BLOCK_OPEN, EMERGENCY_OPENING, BLOCK_OPENING,
                BLOCKED_STOPPED_WHILE_CLOSING, BLOCKED_STOPPED_WHILE_OPENING}

    final private State[] clickButtonStateTransitionTable =
            new State[]{State.OPENING, State.CLOSING, State.STOPPED_WHILE_CLOSING,
                        State.STOPPED_WHILE_OPENING, State.OPENING, State.CLOSING,
                        State.BLOCK_CLOSED, State.BLOCK_OPEN, State.EMERGENCY_OPENING, State.BLOCK_OPENING,
                        State.BLOCKED_STOPPED_WHILE_CLOSING, State.BLOCKED_STOPPED_WHILE_OPENING};

    final private State[] completeCycleStateTransitionTable =
            new State[]{State.CLOSED, State.OPEN, State.CLOSED,
                        State.OPEN, State.STOPPED_WHILE_CLOSING, State.STOPPED_WHILE_OPENING,
                        State.BLOCK_CLOSED, State.BLOCK_OPEN, State.BLOCK_OPEN, State.BLOCK_OPENING,
                        State.BLOCKED_STOPPED_WHILE_CLOSING, State.BLOCKED_STOPPED_WHILE_OPENING};

    final private State[] blockDoorStateTransitionTable =
            new State[]{State.BLOCK_CLOSED, State.BLOCK_OPEN, State.EMERGENCY_OPENING,
                        State.BLOCK_OPENING, State.BLOCKED_STOPPED_WHILE_CLOSING, State.BLOCKED_STOPPED_WHILE_OPENING,
                        State.BLOCK_CLOSED, State.BLOCK_OPEN, State.EMERGENCY_OPENING, State.BLOCK_OPENING,
                        State.BLOCKED_STOPPED_WHILE_CLOSING, State.BLOCKED_STOPPED_WHILE_OPENING};

    final private State[] unblockDoorStateTransitionTable =
            new State[]{State.CLOSED, State.OPEN, State.CLOSING,
                    State.OPENING, State.STOPPED_WHILE_CLOSING, State.STOPPED_WHILE_OPENING,
                    State.CLOSED, State.OPEN, State.OPENING, State.OPENING,
                    State.STOPPED_WHILE_CLOSING, State.STOPPED_WHILE_OPENING};

    private State currState;

    private List<State> stateHistory = new ArrayList<State>();

    public GarageDoor() {
        this.currState = State.CLOSED;
        stateHistory.add(currState);
    }
    public void completeCycle() {
        currState = completeCycleStateTransitionTable[currState.ordinal()];
        stateHistory.add(currState);
    }

    public void clickButton() {
        currState = clickButtonStateTransitionTable[currState.ordinal()];
        stateHistory.add(currState);
    }

    public void blockDoor() {
        currState = blockDoorStateTransitionTable[currState.ordinal()];
        stateHistory.add(currState);
    }

    public void unblockDoor() {
        currState = unblockDoorStateTransitionTable[currState.ordinal()];
        stateHistory.add(currState);
    }

    public State getCurrState() {
        return currState;
    }

    public void printStateHistory() {
        for (int i = 0; i < stateHistory.size(); i++) {
            System.out.println(stateHistory.get(i));
        }
    }
}
