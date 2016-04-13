import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicSquareVerifierTest {

    private MagicSquareVerifier magicSquareVerifier;

    @Before
    public void setUp() throws Exception {
        magicSquareVerifier = new MagicSquareVerifier();
    }

    @org.junit.Test
    public void testEmptyArray() throws Exception {
        magicSquareVerifier.setSquare(new int[][]{});
        assertEquals(false, magicSquareVerifier.isSquareMagic());
    }

    @Test
    public void test3x3MagicSquare() throws Exception {
        magicSquareVerifier.setSquare(new int[][]{
                {8, 1, 6},
                {3, 5, 7},
                {4, 9, 2}
        });
        assertEquals(true, magicSquareVerifier.isSquareMagic());
    }

    @Test
    public void test3x3NotMagicSquare() throws Exception {
        magicSquareVerifier.setSquare(new int[][]{
                {3, 5, 7},
                {8, 1, 6},
                {4, 9, 2}
        });
        assertEquals(false, magicSquareVerifier.isSquareMagic());
    }

/*    @Test
    public void magicSumCalculate() throws Exception {
        assertEquals(15, magicSquareVerifier.calculateMagicSum(3));
        assertEquals(34, magicSquareVerifier.calculateMagicSum(4));
        assertEquals(65, magicSquareVerifier.calculateMagicSum(5));
        assertEquals(111, magicSquareVerifier.calculateMagicSum(6));
        assertEquals(175, magicSquareVerifier.calculateMagicSum(7));
        assertEquals(260, magicSquareVerifier.calculateMagicSum(8));
    }*/

    @Test
    public void test4x4MagicSquare() throws Exception {
        magicSquareVerifier.setSquare(new int[][]{
                {1, 15, 14, 4},
                {12, 6, 7, 9},
                {8, 10, 11, 5},
                {13, 3, 2, 16},
        });
        assertEquals(true, magicSquareVerifier.isSquareMagic());
    }

    @Test
    public void test4x4NotMagicSquare() throws Exception {
        magicSquareVerifier.setSquare(new int[][]{
                {1, 15, 14, 4},
                {12, 7, 6, 9},
                {8, 10, 11, 5},
                {13, 3, 2, 16},
        });
        assertEquals(false, magicSquareVerifier.isSquareMagic());
    }

    @Test
    public void test8x8MagicSqiare() throws Exception { // Mercury :-)
        magicSquareVerifier.setSquare(new int[][]{
                {8, 	58, 	59, 	5, 	    4,  	62, 	63, 	1},
                {49, 	15, 	14, 	52, 	53, 	11, 	10, 	56},
                {41, 	23, 	22, 	44, 	45, 	19, 	18, 	48},
                {32, 	34, 	35, 	29, 	28, 	38, 	39, 	25},
                {40, 	26, 	27, 	37, 	36, 	30, 	31, 	33},
                {17, 	47, 	46, 	20, 	21, 	43, 	42, 	24},
                {9, 	55, 	54, 	12, 	13, 	51, 	50, 	16},
                {64, 	2, 	    3, 	    61, 	60, 	6, 	    7,   	57}
        });
        assertEquals(true, magicSquareVerifier.isSquareMagic());

    }
}
