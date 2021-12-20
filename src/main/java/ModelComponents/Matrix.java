package ModelComponents;

public class Matrix {
    private final int columns;
    private final int rows;
    private ComplexNumber[][] data;

    public Matrix(int row, int col) {
        columns = col;
        rows = row;
        data = new ComplexNumber[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = new ComplexNumber(0, 0);
            }
        }
    }

    public void performUpdate(int row, int col, int newVal) {
        System.out.println(col);
        // check if input valid
        if (row < 0 || row >= data.length) {
            System.out.println("Invalid row index for matrix");
            return;
        } else if (col < 0 || col >= 2*data[0].length) {
            System.out.println("Invalid col index for matrix");
            return;
        }

        ComplexNumber cell = data[row][(int)col/2];
        if (col == 0 || col == 2 || col == 4) {
            cell.setRealComponent(newVal);
        } else {
            cell.setImagComponent(newVal);
        }
    }

    /** Setters */
    public void setCellValue(ComplexNumber value, int rowIndex, int colIndex) {
        data[rowIndex][colIndex] = value;
    }

    /** Getters */
    public int getNumberOfColumns() {
        return columns;
    }

    public int getNumberOfRows() {
        return rows;
    }

    public ComplexNumber[][] getMatrixData() {
        return data;
    }

}