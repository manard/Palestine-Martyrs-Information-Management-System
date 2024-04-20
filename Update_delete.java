import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Update_delete extends GridPane {//For Location
	private Label lb;
	private TextField tf1, tf2;
	private Button b, b4;
	private Text text1;
	HBox hbox, hbox1;
	// StackPane stack = new StackPane();
	Main obj = new Main();
	private ObservableList<String> options = FXCollections.observableArrayList("Tulkarm", "Bethlehem", "North Tubas",
			"Hebron", "Gaza", "Jenin", "Rafah", "Khan Yunis", "al-Quds", "Deir al-Balah", "Tubas");

	public Update_delete() {

		hbox = new HBox(10);// to add label and tf
		hbox1 = new HBox(10);// to add button

		lb = new Label("Location");// label and its style
		lb.setFont(new Font("Times New Roman", 18));
		lb.setStyle("-fx-text-fill:rgb(190, 100, 90); ");
		setAlignment(Pos.BOTTOM_CENTER);

		b = new Button("Delete");// button insert and its style
		b.setStyle("-fx-border-color:rgb(190, 100, 90)");

		hbox1.getChildren().addAll(b);
		tf1 = new TextField();
		tf2 = new TextField();
		// hbox.getChildren().addAll(lb, tf1);
		hbox1.setAlignment(Pos.BOTTOM_CENTER);
		hbox1.setPadding(new Insets(300, 0, 10, 10));

		add(hbox1, 1, 70);

		setBackground(new Background(new BackgroundImage(
				new Image("C:\\Users\\Lenovo\\Downloads\\WhatsApp Image 2023-05-12 at 5.16.56 PM.jpeg"),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT)));// background for this stage

		ListView<String> listView = new ListView<>();

		hbox.getChildren().addAll(lb, tf1, listView);
		add(hbox, 1, 50);// add hboxes to the pain
		listView.setOnMouseClicked(event -> { // Get the selected item from the listView

			String selectedItem = listView.getSelectionModel().getSelectedItem();

			if (selectedItem != null) { // Check if an item is selected (not null)

				tf1.setText(selectedItem); // Set the text of tf1 (presumably a TextField) to the selected item
			}
		});
		tf1.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.DOWN) {
				// If the DOWN arrow key is pressed, focus on the listView and select the first
				// item
				listView.requestFocus();
				listView.getSelectionModel().selectFirst();
			} else if (event.getCode() == KeyCode.ENTER) {
				// If the ENTER key is pressed
				if (!listView.getItems().isEmpty()) {// If the listView is not empty, set the text of tf1 to the
														// selected item

					tf1.setText(listView.getSelectionModel().getSelectedItem());
				}
				event.consume(); // Consume the event to prevent further handling
			} else { // If any other key is released

				String enteredText = tf1.getText().toLowerCase();// Filter the options based on the entered text

				ObservableList<String> filteredOptions = options
						.filtered(option -> option.toLowerCase().startsWith(enteredText));

				listView.setItems(filteredOptions);// Set the filtered options as the items of the listView
			}
		});
		listView.setPrefWidth(100);
		listView.setMaxHeight(25);

		b.setOnAction(e -> {
			if (tf1.getText().equals("")) {
				Warning2();
				tf1.requestFocus();
			} else if ((obj.list.contains(tf1.getText().substring(0, 1).toUpperCase() + tf1.getText().substring(1)))) {// if
				// the
				// user
				// click
				// button
				// before
				// add
				// in tf
				obj.list.remove(tf1.getText());
				Done();
				tf1.requestFocus();
				System.out.println("This is the list");
				obj.list.print();
			}

			else if (!(tf1.getText().equals(""))
					&& !(obj.list.contains(tf1.getText().substring(0, 1).toUpperCase() + tf1.getText().substring(1)))) {// if
				// tf
				// text
				// is
				// already
				// in
				// list
				Warning();

			}

		});
		tf1.requestFocus();
		obj.list.print();
	}

	public void Warning() {// if the user click button before add text in tf1
		Stage stage = new Stage();// create new stage
		VBox vbox = new VBox(30);
		b4 = new Button("Ok");// OK button
		BorderPane border = new BorderPane();
		text1 = new Text("cant Find! \uD83D\uDE22");
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

	public void Warning2() {// if the user click button before add text in tf1
		Stage stage = new Stage();// create new stage
		VBox vbox = new VBox(30);
		b4 = new Button("Ok");// OK button
		BorderPane border = new BorderPane();
		text1 = new Text("Please enter the correct entry! \uD83D\uDE22");
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

	public void Done() {// Done method
		Stage stage = new Stage();// create new stage
		VBox vbox = new VBox(30);
		obj.list.print();
		b4 = new Button("Ok");// OK button
		BorderPane border = new BorderPane();
		text1 = new Text("Done! \uD83D\uDE0A");
		text1.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
		vbox.getChildren().addAll(text1, b4);
		vbox.setAlignment(Pos.CENTER);

		border.setBottom(vbox);
		Scene s = new Scene(border, 280, 90);
		stage.setScene(s);
		stage.setTitle("Done!!!!");
		stage.show();
		b4.setOnAction(e -> {// close this stage and continue
			stage.close();
		});

	}

}
