import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ManagePropBox {

    private static int[] answer;

    public static int[] display(String title, Property prop) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label sellDev = new Label();
        Label buyDev = new Label();
        Label mortgageProp = new Label();
        sellDev.setText("Sell a Development on this Property");
        buyDev.setText("Buy a Developement on this Property");
        mortgageProp.setText("Mortgage this Property");

        int[] answer1 = new int[]{1, prop.getLocation()};
        int[] answer2 = new int[]{2, prop.getLocation()};
        int[] answer3 = new int[]{3, prop.getLocation()};
        int[] answer5 = new int[]{5, prop.getLocation()};

        Button developButton = new Button("+");
        Button mortgageButton = new Button("Mortgage");
        Button unMortgageButton = new Button("unMortgage");
        Button sellButton = new Button("-");

        if(prop.getClass() == BasicProp.class){
            //Clicking will set answer and close window
            developButton.setOnAction(e -> {
                answer = answer1;
                window.close();
            });
            sellButton.setOnAction(e -> {
                answer = answer2;
                window.close();
            });
            mortgageButton.setOnAction(e -> {
                answer = answer3;
                window.close();
            });
            unMortgageButton.setOnAction(e -> {
                answer = answer5;
                window.close();
            });
        }

        if(prop.getClass() == Railroad.class || prop.getClass() == Utility.class){

            sellButton.setDisable(true);
            developButton.setDisable(true);
            mortgageButton.setOnAction(e -> {
                answer = answer3;
                window.close();
            });
        }

        VBox layout = new VBox(10);
        if (prop.isMortgaged()){
            mortgageButton.setDisable(true);
        }else{
            unMortgageButton.setDisable(true);
        }
        //Add buttons
        layout.getChildren().addAll(buyDev, developButton, sellDev, sellButton, mortgageProp, mortgageButton, unMortgageButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        //Make sure to return answer
        return answer;
    }

}