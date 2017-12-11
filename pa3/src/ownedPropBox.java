import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ownedPropBox {


    static int[] answer;
    static Player thisplayer;

    public static int[] display(String title, Player nowplayer) {
        thisplayer = nowplayer;
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        ArrayList<Button> propButts = new ArrayList<>();
        for(Property prop :thisplayer.getPropertiesOwned())
        {
            Button propButton = new Button(String.valueOf(prop.getLocation()));
            propButts.add(propButton);
        }

        for (Button butt: propButts) {
            butt.setOnAction(e -> {
                int[] result = ManagePropBox.display("Manage Properties", thisplayer.getPropertiesOwned().get(propButts.indexOf(butt)));
                System.out.println(result);
                answer = result;
                window.close();
            });
        }

        VBox layout = new VBox(10);
        //Add buttons
        for (Button butt: propButts){
            layout.getChildren().add(butt);
        }
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        //Make sure to return answer
        return answer;
    }

}