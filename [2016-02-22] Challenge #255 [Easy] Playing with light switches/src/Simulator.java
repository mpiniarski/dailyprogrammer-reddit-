import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by marcin on 07.03.16.
 */
public class Simulator {
    private BitSet switches;

    public Simulator(int size) {
        switches = new BitSet(size);
    }

    public void rangeToggle(int []range) {
        Arrays.sort(range);
        switches.flip(range[0],range[1]+1);
    }

    public int bulbsOn() {
        return switches.cardinality();
    }
}
