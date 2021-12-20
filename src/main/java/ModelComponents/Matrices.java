package ModelComponents;

public class Matrices {

    private Matrix matrixA;
    private Matrix matrixB;
    private Matrix matrixC;

    public Matrices() {
        matrixA = new Matrix(2, 3);
        matrixB = new Matrix(3, 2);
        matrixC = new Matrix(2, 2);
    }

    /** Getters */
    public Matrix getMatrixA() {
        return matrixA;
    }

    public Matrix getMatrixB() {
        return matrixB;
    }

    public Matrix getMatrixC() {
        return matrixC;
    }

    public void calculateMatrixC() {
        matrixMultiplaction(matrixA.getMatrixData(), matrixB.getMatrixData(), matrixC.getMatrixData());
    }

    public static void matrixMultiplaction(ComplexNumber[][] A, ComplexNumber[][] B, ComplexNumber[][] resultMatrix) {
        for (int row = 0; row < resultMatrix.length; row++) {
            for (int col = 0; col < resultMatrix[row].length; col++) {
                resultMatrix[row][col] = multiplyMatricesCell(A, B, row, col);
            }
        }
    }

    public static ComplexNumber multiplyMatricesCell(ComplexNumber[][] firstMatrix, ComplexNumber[][] secondMatrix,
                                                     int row, int col) {
        int cellReal = 0;
        int cellImaginary = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cellReal += firstMatrix[row][i].getRealComponent() * secondMatrix[i][col].getRealComponent()
                    - firstMatrix[row][i].getImagComponent() * secondMatrix[i][col].getImagComponent();
            cellImaginary += firstMatrix[row][i].getImagComponent() * secondMatrix[i][col].getRealComponent()
                    + firstMatrix[row][i].getRealComponent() * secondMatrix[i][col].getImagComponent();
        }
        return new ComplexNumber(cellReal, cellImaginary);
    }

}
