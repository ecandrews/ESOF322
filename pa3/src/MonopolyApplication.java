import java.lang.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MonopolyApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("board.fxml"));
        primaryStage.setTitle("Meatopoly");
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}

