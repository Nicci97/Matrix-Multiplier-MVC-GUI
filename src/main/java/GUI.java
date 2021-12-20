import ModelComponents.ComplexNumber;
import java.net.URL;
import java.util.ResourceBundle;
import ModelComponents.Row;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

// View
public class GUI implements Initializable {

    @FXML
    private TableColumn<Row, String> Matrix1Imag1, Matrix1Imag2, Matrix1Imag3, Matrix2Imag1, Matrix2Imag2, Matrix3Imag1, Matrix3Imag2,
            Matrix1Real1, Matrix1Real2, Matrix1Real3, Matrix2Real1, Matrix2Real2, Matrix3Real1, Matrix3Real2;

    private TableColumn<Row, String>[] tableColumns;

    @FXML
    private TableView<Row> tableViewA, tableViewB, tableViewC;

    @FXML
    private TextField field1, field2, field3, field11;

    @FXML
    void newGUIUpdate(ActionEvent event) {
        try {
            int row = Integer.parseInt(field1.getText());
            int col = Integer.parseInt(field2.getText());
            int newVal = Integer.parseInt(field3.getText());

            if (field11.getText().equals("A")) {
                MatrixCalculator.performMatrixUpdate('A', row, col, newVal);
            } else if (field11.getText().equals("B")) {
                MatrixCalculator.performMatrixUpdate('B', row, col, newVal);
            } else {
                System.out.println("Invalid Matrix Name");
                return;
            }

            MatrixCalculator.getMatrices().calculateMatrixC();
            refreshView();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void refreshView() {
        tableViewA.refresh();
        tableViewB.refresh();
        tableViewC.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumns = new TableColumn[]{Matrix1Real1, Matrix1Imag1, Matrix1Real2, Matrix1Imag2, Matrix1Real3, Matrix1Imag3,
        Matrix2Real1, Matrix2Imag1, Matrix2Real2, Matrix2Imag2, Matrix3Real1, Matrix3Imag1, Matrix3Real2, Matrix3Imag2};

        // update matrix A columns in GUI with data
        for (int i = 0; i < 6; i++) {
            int finalI = i;
            tableColumns[i].setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getElement(finalI)));
        }
        tableViewA.setItems(getTableDataFromModel('A'));

        int colIndexCount = 6;
        // update matrix B columns in GUI with data
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            tableColumns[colIndexCount].setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getElement(finalI)));
            colIndexCount++;
        }
        tableViewB.setItems(getTableDataFromModel('B'));

        // update matrix C columns in GUI with data
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            tableColumns[colIndexCount].setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getElement(finalI)));
            colIndexCount++;
        }
        tableViewC.setItems(getTableDataFromModel('C'));
    }

    public ObservableList<Row> getTableDataFromModel(char matrixID) {
        ObservableList<Row> matrixCols = FXCollections.observableArrayList();
        ComplexNumber[][] matrixData;
        switch (matrixID) {
            case 'A':
                matrixData = MatrixCalculator.getMatrices().getMatrixA().getMatrixData();
                break;
            case 'B':
                matrixData = MatrixCalculator.getMatrices().getMatrixB().getMatrixData();
                break;
            case 'C':
                matrixData = MatrixCalculator.getMatrices().getMatrixC().getMatrixData();
                break;
            default:
                matrixData = null;
                break;
        }

        for (int i = 0; i < matrixData.length; i++) {
            matrixCols.add(new Row(matrixData[i]));
        }
        return matrixCols;
    }
}
