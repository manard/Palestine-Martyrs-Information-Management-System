import java.util.Date;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReportAVL2 extends GridPane {
	private Label lb1, lb2;
	private TextField tf2;
	private Button b1, b4;
	private Text text1;
	Main obj = new Main();
	NodeAVL2 nodAVL;
	private TextArea ta;
	private HBox hbox, hbox2;
	private ComboBox<String> cb, cb1;
	public static CircularList list = new CircularList();

	public ReportAVL2() {
		setPadding(new Insets(110, 100, 100, 100));
		setVgap(10);
		setHgap(10);

		setBackground(new Background(new BackgroundImage(
				new Image("C:\\Users\\Lenovo\\Downloads\\WhatsApp Image 2023-05-12 at 5.16.56 PM.jpeg"),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT)));// background for this stage
		cb = new ComboBox<>();
		cb.setPromptText("Location");
		NodeList current = obj.list.front;
		do {
			cb.getItems().add((String) current.element);
			current = current.next;
		} while (current != obj.list.front);

		hbox = new HBox(10);
		hbox.getChildren().addAll(cb);
		hbox.setPadding(new Insets(-100, 0, 10, 100));
		add(hbox, 1, 0);
		hbox2 = new HBox();

		b1 = new Button("generate");// insert Button
		b1.setStyle("-fx-border-color:rgb(190, 100, 90)");
		b1.setPrefWidth(130);
		b1.setPrefHeight(30);
		hbox2.getChildren().add(b1);
		add(hbox2, 1, 12);
		hbox2.setPadding(new Insets(0, 0, 10, 130));
		ta = new TextArea();
		ta.setStyle("-fx-border-color: rgb(190, 100, 90); -fx-border-width: 2px;");
		ta.setMinHeight(220);
		add(ta, 1, 4);

		b1.setOnAction(e -> {
			if (cb.getValue() == null) {
				Warning2();
			} else {
				String text = ""; // Initialize an empty string to store the information
				for (int i = 0; i < obj.list.size(); i++) {
					if (obj.list.get(i).equals(cb.getValue())) {

						text += "***The Height is***: " + obj.list.getNode(i).getAVLList2().getHeight() + "\n";
						text += "***The date that had the maximum number of martyrs is***:\n "
								+"   "+ obj.list.getNode(i).getAVLList2().getDateMartyrs() + "\n\n";
						
						text += obj.list.getNode(i).getAVLList2().printReverse() + "\n";
					}
				}
				ta.setText(text);
			}
		});
	}

	public void Warning2() {// if the user click button before add text in tf1
		Stage stage = new Stage();// create new stage
		VBox vbox = new VBox(30);
		b4 = new Button("Ok");// OK button
		BorderPane border = new BorderPane();
		text1 = new Text("Please Choose Location ! \uD83D\uDE22");
		text1.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
		vbox.getChildren().addAll(text1, b4);
		vbox.setAlignment(Pos.CENTER);

		border.setBottom(vbox);
		Scene s = new Scene(border, 280, 90);
		stage.setScene(s);
		stage.setTitle("Warning!!!!");
		stage.show();
		b4.setOnAction(e -> {// close this stage and continue
			stage.close();

		});

	}

}
