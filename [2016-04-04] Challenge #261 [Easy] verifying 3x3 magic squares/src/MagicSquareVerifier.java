public class MagicSquareVerifier {
    private int[][] square;

    public void setSquare(int[][] square) {
        this.square = square;
    }

    public boolean isSquareMagic() {
        if(square.length == 0) return false;
        if(square.length != square[0].length) return false;

        int length = square.length;

        int[] rowSumArray = new int[length];
        int[] colSumArray = new int[length];
        int[] diagonalSumArray = new int[2];

        fillSumArrays(length, rowSumArray, colSumArray, diagonalSumArray);

        int magicSum = calculateMagicSum(length);
        return checkSumArrays(rowSumArray, colSumArray, diagonalSumArray, magicSum);
    }

    private void fillSumArrays(int length, int[] rowSum, int[] colSum, int[] diagonalSum) {
        for(int row=0; row<length; row++){
            for (int col = 0; col <length; col++) {
                rowSum[row] += square[row][col];
                colSum[col] += square[row][col];
                if (row == col) diagonalSum[0] += square[row][col];
                if (row == length - col - 1) diagonalSum[1] += square[row][col];
            }
        }
    }

    private int calculateMagicSum(int length) { // probably should make class MagicSumCalculator with this as a public method and test it...
        return (int) (length*(Math.pow(length,2)+1)/2);
    }

    private boolean checkSumArrays(int[] rowSumArray, int[] colSumArray, int[] diagonalSumArray, int magicSum) {
        return checkSumArray(rowSumArray,magicSum)
                && checkSumArray(colSumArray,magicSum)
                && checkSumArray(diagonalSumArray,magicSum);
    }

    private boolean checkSumArray(int[] sumArray, int expectedValue) {
        for (int sum : sumArray) {
            if (sum != expectedValue) return false;
        }
        return true;
    }

}
