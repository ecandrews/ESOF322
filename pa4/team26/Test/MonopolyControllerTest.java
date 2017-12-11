import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Rule;

public class MonopolyControllerTest {
    @Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();


    @Test
    public void controllerTest() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("meatboard.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.setResizable(false);
        primaryStage.showAndWait();
    }



}