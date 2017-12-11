import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Random;

public class MysteryPopup {

    private static int[] answer;
    static String card1 = "Advance to Go";
    static String card2 = "Bank Error in your favor - Collect $200";
    static String card3 = "Doctor's fees - Pay #50";
    static String card4 = "From sale of Hamburger Helper stock you get $50";
    static String card5 = "Get out of Jail Free – This card may be kept until needed, or traded/sold";
    static String card6 = "Go to Jail – Go directly to Jail – Do not pass Go, do not collect $200";
    static String card7 = "Grand Opera Night - Collect $50 from every player for opening night seats";
    static String card8 = "Holiday Fund matures - Receive $100";
    static String card9 = "Income tax refund - Collect $20";
    static String card10 = "It's your birthday! - Collect $10 from every player";
    static String card11 = "Life insurance matures - Collect $100";
    static String card12 = "Pay hospital fees of $100";
    static String card13 = "Pay health inspector fees of $150";
    static String card14 = "Receive $25 consultancy fee";
    static String card15 = "You have won second prize in a hamburger flipping contest - Collect $10";
    static String card16 = "You inherit $100";
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
        window.setTitle("Mystery Meat Card");
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
