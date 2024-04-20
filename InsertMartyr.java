import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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

public class InsertMartyr extends GridPane {// insert new Martyrs
	private Label lb1, lb2, lb3, lb4, lb5;
	private TextField tf2, tf3;
	private Button b1, b4;
	private Text text1;
	Main obj = new Main();
	NodeAVL2 nodAVL;
	private ComboBox<String> cb, cb1;
	public static CircularList list = new CircularList();

	public InsertMartyr() {
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
		tf3 = new TextField();
		tf3.setPromptText("Age Greater than 0");
		add(tf3, 1, 2);
		lb2 = new Label("Name");// age label and its style
		add(lb2, 0, 1);
		lb2.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb2.setStyle("-fx-text-fill:rgb(190, 100, 90)");

		lb3 = new Label("Age");// Date of Death and its style
		lb3.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb3.setStyle("-fx-text-fill:rgb(190, 100, 90)");
		add(lb3, 0, 2);
		lb4 = new Label("Date of Death");// Gender and its style
		lb4.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb4.setStyle("-fx-text-fill:rgb(190, 100, 90)");

		VBox root = new VBox();
		root.setPadding(new Insets(10));

		// Create a DatePicker control
		DatePicker datePicker = new DatePicker();

		// Event handler for DatePicker value change
		datePicker.setOnAction(event -> {
			// Get the selected date from the DatePicker
			LocalDate selectedDate = datePicker.getValue();

			// Update the text field with the selected date

		});
		datePicker.setMaxWidth(100);
		// Add the DatePicker and TextField to the VBox layout
		root.getChildren().add(datePicker);
		add(root, 1, 3);
		add(lb4, 0, 3);
		lb5 = new Label("Gender");
		lb5.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb5.setStyle("-fx-text-fill:rgb(190, 100, 90)");
		add(lb5, 0, 4);
		cb1 = new ComboBox<>();
		cb1.getItems().add("M");
		cb1.getItems().add("F");
		add(cb1, 1, 4);
		b1 = new Button("Insert");// insert Button
		b1.setStyle("-fx-border-color:rgb(190, 100, 90)");
		b1.setPrefWidth(100);
		b1.setPrefHeight(30);
		add(b1, 1, 9);

		setAlignment(Pos.CENTER);

		b1.setOnAction(e -> {
			String location = cb.getValue();
			String name = tf2.getText();
			String age = tf3.getText();
			LocalDate selectedDate = datePicker.getValue();

			String gender = cb1.getValue();
			// Convert LocalDate to Date
			if ((age.isEmpty() || Integer.parseInt(age) <= 0) || location == null || name.isEmpty()
					|| selectedDate == null || gender == null) {

				// Handle the case where age is empty
				Warning2();
			} else {
				try {
					int ageValue = Integer.parseInt(age);
					// Rest of your code
					// Convert LocalDate to Date
					Date date = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

					Martyrobject M = new Martyrobject(name, ageValue, date, gender.charAt(0));

					// boolean locationFound = false;
					for (int i = 0; i < obj.list.size(); i++) {
						if (obj.list.get(i).equals(location)) {
							AVLTree avlTree = (AVLTree) obj.list.getNode(i).getAVLList1();
							if (avlTree != null) {
								avlTree.insert(M);
								Done();

							} else {
								avlTree = new AVLTree();
								avlTree.insert(M);
								obj.list.getNode(i).setAVLList1(avlTree);
								Done();

							}

							AVLTree2 avlTree2 = (AVLTree2) obj.list.getNode(i).getAVLList2();
							NodeAVL2 dateNode = avlTree2.getNodeByDate(date);
							if (dateNode != null && dateNode.getDateStack().getDate().equals(date)) {
								dateNode.getDateStack().getStack().push(M);
								Done();
							} else {
								DateStack dateStack = new DateStack(date);
								avlTree2.insert(dateStack);
								dateStack.getStack().push(M);
								Done();

							}

							// locationFound = true;
							// break;

						}

					}

				} catch (NumberFormatException ex) {
					System.out.println("Invalid age format. Please provide a valid numeric age.");
				}
				// Rest of your code
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
