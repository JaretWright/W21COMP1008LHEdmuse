import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Load the fxml file and attach it to the stage object
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/createStudentView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("EdMuse Dashboard");
        stage.show();
    }
}
