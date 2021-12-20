import ModelComponents.Matrices;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

// Controller
public class MatrixCalculator extends Application {

    private static Matrices matrices = new Matrices(); // model

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MatrixCalculator.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Matrix Multiplier!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Matrices getMatrices() {
        return matrices;
    }

    public static void performMatrixUpdate(char matrixID, int row, int col, int newVal) {
        if (matrixID == 'A') {
            matrices.getMatrixA().performUpdate(row, col, newVal);
        } else {
            matrices.getMatrixB().performUpdate(row, col, newVal);
        }
    }

}
