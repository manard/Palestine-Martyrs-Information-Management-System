import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SearchMartyr extends GridPane {
	private Label lb1, lb2;
	private TextField tf2;
	private Button b1, b4;
	private Text text1;
	Main obj = new Main();
	ObservableList<String> observableList;
	NodeAVL2 nodAVL;
	private TextArea ta;
	private ComboBox<String> cb, cb1;
	public static CircularList list = new CircularList();

	private ObservableList<String> options = FXCollections.observableArrayList();

	public SearchMartyr() {

		setPadding(new Insets(110, 100, 100, 100));
		setVgap(10);
		setHgap(10);

		setBackground(new Background(new BackgroundImage(
				new Image("C:\\Users\\Lenovo\\Downloads\\WhatsApp Image 2023-05-12 at 5.16.56 PM.jpeg"),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT)));// background for this stage
		cb = new ComboBox<>();
		NodeList current = obj.list.front;
		do {
			cb.getItems().add((String) current.element);
			current = current.next;
		} while (current != obj.list.front);

		lb1 = new Label("Location");// name label and its style
		lb1.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb1.setStyle("-fx-text-fill:rgb(190, 100, 90)");
		add(lb1, 0, 0);

		add(cb, 1, 0);
		tf2 = new TextField();
		add(tf2, 1, 1);
		tf2.setPromptText("Name");
		lb2 = new Label("Name");// age label and its style
		add(lb2, 0, 1);
		lb2.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb2.setStyle("-fx-text-fill:rgb(190, 100, 90)");
		b1 = new Button("Search");// insert Button
		b1.setStyle("-fx-border-color:rgb(190, 100, 90)");
		b1.setPrefWidth(100);
		b1.setPrefHeight(30);
		add(b1, 1, 12);
		ta = new TextArea();
		ta.setMaxWidth(150);
		ta.setMinHeight(130);
		add(ta, 1, 3);
		lb1 = new Label("Result");// name label and its style
		lb1.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb1.setStyle("-fx-text-fill:rgb(190, 100, 90)");
		add(lb1, 0, 3);
		for (int i = 0; i < obj.list.size; i++) {
			if (cb.getValue() == (obj.list.get(i))) {
				options.add((String) obj.list.getNode(i).getAVLList1().printInOrder2());
			}
		}

		ListView<String> listView = new ListView<>();

		listView.setOnMouseClicked(event -> { // Get the selected item from the listView

			String selectedItem = listView.getSelectionModel().getSelectedItem();

			if (selectedItem != null) { // Check if an item is selected (not null)

				tf2.setText(selectedItem); // Set the text of tf1 (presumably a TextField) to the selected item
			}
		});
		tf2.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.DOWN) {
				// If the DOWN arrow key is pressed, focus on the listView and select the first
				// item
				listView.requestFocus();
				listView.getSelectionModel().selectFirst();
			} else if (event.getCode() == KeyCode.ENTER) {
				// If the ENTER key is pressed
				if (!listView.getItems().isEmpty()) {// If the listView is not empty, set the text of tf1 to the
														// selected item

					tf2.setText(listView.getSelectionModel().getSelectedItem());
				}
				event.consume(); // Consume the event to prevent further handling
			} else { // If any other key is released

				String enteredText = tf2.getText().toLowerCase();// Filter the options based on the entered text

				ObservableList<String> filteredOptions = options
						.filtered(option -> option.toLowerCase().startsWith(enteredText));

				listView.setItems(filteredOptions);// Set the filtered options as the items of the listView
			}
		});
		listView.setMinHeight(50);
		listView.setMaxWidth(160);
		//add(listView, 2, 1);

		b1.setOnAction(e -> {
			// Get the selected location from the ComboBox
			String location = cb.getValue();

			// Get the name from the TextField
			String name = tf2.getText();

			// Check if either the location is not selected or the name is empty
			if (location == null || name.isEmpty()) {
				// Show a warning if the location is not selected or the name is empty
				Warning2();
			} else {
				// Loop through the list of locations in 'obj.list'
				for (int i = 0; i < obj.list.size(); i++) {
					// Check if the current location in the list matches the selected location
					if (obj.list.get(i).equals(location)) {
						// Get the AVLTree associated with the current location
						AVLTree avlTree = (AVLTree) obj.list.getNode(i).getAVLList1();

						// Check if the AVLTree contains the specified name
						if (avlTree.find(name) != null) {
							// If the name is found, build the text to display in the TextArea 'ta'
							String Text = "*Find it* \nName: " + avlTree.find(name).getObj().getName() + "\n";
							Text += "Age: " + avlTree.find(name).getObj().getAge() + "\n";
							Text += avlTree.find(name).getObj().toString2() + "\n";
							Text += "Gender: " + avlTree.find(name).getObj().getGender() + "\n";
							// Add other properties if available

							// Set the TextArea 'ta' with the generated text
							ta.setText(Text);
						} else {
							// If the name is not found, display a message in the TextArea 'ta'
							ta.setText("Sorry, Can't Find \uD83D\uDE22");
						}
					}
				}
			}
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

}
