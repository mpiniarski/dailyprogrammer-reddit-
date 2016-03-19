import static org.junit.Assert.assertArrayEquals;

/**
 * Created by marcin on 01.03.16.
 */
public class Test {
    @org.junit.Test
    public void testEmptyOblique() throws Exception {
        int[][] matrix = new int[][]{};
        int[][] result = new int[][]{};
        assertArrayEquals(MatrixTransform.oblique(matrix), result);
    }

    @org.junit.Test
    public void testOblique() throws Exception {
        int[][] matrix = new int[][]{
                {0,   1,  2,  3,  4,  5},
                {6,   7,  8,  9, 10, 11},
                {12, 13, 14, 15, 16, 17},
                {18, 19, 20, 21, 22, 23},
                {24, 25, 26, 27, 28, 29},
                {30, 31, 32, 33, 34, 35}};
        int[][] result = new int[][]{
                { 0,  0,  0,  0,  0,  0},
                { 1,  6,  0,  0,  0,  0},
                { 2,  7, 12,  0,  0,  0},
                { 3,  8, 13, 18,  0,  0},
                { 4,  9, 14, 19, 24,  0},
                { 5, 10, 15, 20, 25, 30},
                {11, 16, 21, 26, 31,  0},
                {17, 22, 27, 32,  0,  0},
                {23, 28, 33,  0,  0,  0},
                {29, 34,  0,  0,  0,  0},
                {35,  0,  0,  0,  0,  0}};
        assertArrayEquals(MatrixTransform.oblique(matrix), result);
    }

    @org.junit.Test
    public void testDeoblique() throws Exception {
        int[][] matrix = new int[][]{
                { 0,  0,  0,  0,  0,  0},
                { 1,  6,  0,  0,  0,  0},
                { 2,  7, 12,  0,  0,  0},
                { 3,  8, 13, 18,  0,  0},
                { 4,  9, 14, 19, 24,  0},
                { 5, 10, 15, 20, 25, 30},
                {11, 16, 21, 26, 31,  0},
                {17, 22, 27, 32,  0,  0},
                {23, 28, 33,  0,  0,  0},
                {29, 34,  0,  0,  0,  0},
                {35,  0,  0,  0,  0,  0}};
        int[][] result = new int[][]{
                {0,   1,  2,  3,  4,  5},
                {6,   7,  8,  9, 10, 11},
                {12, 13, 14, 15, 16, 17},
                {18, 19, 20, 21, 22, 23},
                {24, 25, 26, 27, 28, 29},
                {30, 31, 32, 33, 34, 35}};
        assertArrayEquals(MatrixTransform.deoblique(matrix), result);
    }

    @org.junit.Test
    public void testEmptyDeoblique() throws Exception {
        int[][] matrix = new int[][]{};
        int[][] result = new int[][]{};
        assertArrayEquals(MatrixTransform.deoblique(matrix), result);
    }
}
