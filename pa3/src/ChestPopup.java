import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Random;

public class ChestPopup {
    private static int[] answer;
    static String card1 = "Advance to Go";
    static String card2 = "Advance to Porkbelly Plaza - If you pass Go, collect $200";
    static String card3 = "Advance to Salami Sidewalk – If you pass Go, collect $200";
    static String card4 = "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.";
    static String card5 = "Advance token to the nearest Railroad and pay owner twice the rental to which they are otherwise entitled. If Railroad is unowned, you may buy it from the Bank.";
    static String card6 = "Bank pays you dividend of $50";
    static String card7 = "Get out of Jail Free – This card may be kept until needed, or traded/sold";
    static String card8 = "Go Back 3 Spaces";
    static String card9 = "Go to Jail – Go directly to Jail – Do not pass Go, do not collect $200";
    static String card10 = "Make general repairs on all your property – For each house pay $25 – For each hotel $100";
    static String card11 = "Pay poor tax of $15";
    static String card12 = "Take a trip to Breast Street - If you pass Go, collect $200";
    static String card13 = "Take a walk on the Statler Street – Advance token to Boardwalk";
    static String card14 = "You have been elected Chairman of the Board – Pay each player $50";
    static String card15 = "Your building loan matures – Collect $150";
    static String card16 = "You have won a crossword competition - Collect $100";
    static String title = "";




    public static int[] display()
    {

        Random rand = new Random();
        int cardNumber = rand.nextInt(16) + 1;
        int[] answer1 = new int[]{cardNumber};
        switch(cardNumber){
            case 1:
                title = card1;
                break;
            case 2:
                title = card2;
                break;
            case 3:
                title = card3;
                break;
            case 4:
                title = card4;
                break;
            case 5:
                title = card5;
                break;
            case 6:
                title = card6;
                break;
            case 7:
                title = card7;
                break;
            case 8:
                title = card8;
                break;
            case 9:
                title = card9;
                break;
            case 10:
                title = card10;
                break;
            case 11:
                title = card11;
                break;
            case 12:
                title = card12;
                break;
            case 13:
                title = card13;
                break;
            case 14:
                title = card14;
                break;
            case 15:
                title = card15;
                break;
            case 16:
                title = card16;
                break;
        }
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Community Ice Chest Card");
        window.setMinWidth(250);
        Label cardMessage = new Label();
        Button confirm = new Button("Ok");
        cardMessage.setText(title);
        confirm.setOnAction(e -> {
            answer = answer1;
            window.close();
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(cardMessage, confirm);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
}
