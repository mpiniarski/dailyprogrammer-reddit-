/**
 * Created by marcin on 01.03.16.
 */
public class MatrixTransform {
    public static int[][] oblique(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[][]{};
        } else {
            int[][] result = new int[matrix.length * 2 - 1][matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (row + col < matrix.length) {
                        result[row + col][row] = matrix[row][col];
                    } else {
                        result[row + col][matrix.length - col - 1] = matrix[row][col];
                    }
                }
            }
            return result;
        }
    }

    public static int[][] deoblique(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[][]{};
        } else {
            int height = matrix.length;
            int width = matrix[0].length;
            int[][] result = new int[matrix[0].length][matrix[0].length];
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (row < width) {
                        if (col <= row)
                            result[col][row - col] = matrix[row][col];
                    } else {
                        if (col <= height - 1 - row) {
                            result[row % width + 1 + col][width - col - 1] = matrix[row][col];
                        }
                    }
                }
            }

            return result;
        }
    }

//    private static void printTable(int[][] result) {
//        for (int row = 0; row < result.length; row++) {
//            for (int col = 0; col < result[row].length; col++) {
//                System.out.print(result[row][col]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//    }
}
