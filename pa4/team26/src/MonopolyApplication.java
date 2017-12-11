import java.lang.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MonopolyApplication extends Application {

    public static String title = "";
    public static boolean classic;

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public static void launchClassic()
    {
        GameFactory cg = new ClassicGame();
        title = cg.getTitle();
        classic = true;
    }

    @FXML
    public static void launchMeat()
    {
        GameFactory mg = new MeatGame();
        title = mg.getTitle();
        classic = false;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Start Game!");
        window.setMinWidth(300);
        ArrayList<Button> options = new ArrayList<>();
        Button classicBtn = new Button("Classic Version");
        Button meatBtn = new Button("Meat Version");
        options.add(classicBtn);
        options.add(meatBtn);
        classicBtn.setOnAction(e -> {
            launchClassic();
            window.close();
        });
        meatBtn.setOnAction(e -> {
            launchMeat();
            window.close();
        });

        VBox layout = new VBox(10);
        for (Button b : options)
        {
            layout.getChildren().add(b);
        }
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        if (classic == true)
        {
            Parent root = FXMLLoader.load(getClass().getResource("classicboard.fxml"));
            primaryStage.setTitle(this.title);
            primaryStage.setScene(new Scene(root, 1080, 720));
            primaryStage.show();
            primaryStage.setResizable(false);
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("meatboard.fxml"));
            primaryStage.setTitle(this.title);
            primaryStage.setScene(new Scene(root, 1080, 720));
            primaryStage.show();
            primaryStage.setResizable(false);
        }
    }
}

