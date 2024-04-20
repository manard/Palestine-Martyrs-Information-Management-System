import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

public class DeleteMartyr extends GridPane {
	private Label lb1, lb2, lb3, lb4, lb5;
	private Button b1, b4, b5;
	private Text text1;
	Main obj = new Main();
	private ComboBox<String> cb1, cb2;// loc, name,age
	private ComboBox<Date> cb4;
	private ComboBox<Integer> cb3;
	private ComboBox<Character> cb5;// gender
	public static CircularList list = new CircularList();

	public DeleteMartyr() {
		setPadding(new Insets(110, 100, 100, 100));
		setVgap(10);
		setHgap(10);

		setBackground(new Background(new BackgroundImage(
				new Image("C:\\Users\\Lenovo\\Downloads\\WhatsApp Image 2023-05-12 at 5.16.56 PM.jpeg"),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT)));// background for this stage
		cb1 = new ComboBox<>();
		NodeList current = obj.list.front;
		do {
			cb1.getItems().add((String) current.element);
			current = current.next;
		} while (current != obj.list.front);

		lb1 = new Label("Location");// name label and its style
		lb1.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb1.setStyle("-fx-text-fill:rgb(190, 100, 90)");
		add(lb1, 0, 0);

		add(cb1, 1, 0);
		cb2 = new ComboBox<>();
		add(cb2, 1, 1);
		cb3 = new ComboBox<>();
		add(cb3, 1, 2);
		lb2 = new Label("Name");// age label and its style
		add(lb2, 0, 1);
		lb2.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb2.setStyle("-fx-text-fill:rgb(190, 100, 90)");

		lb3 = new Label("Age");// Date of Death and its style
		lb3.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb3.setStyle("-fx-text-fill:rgb(190, 100, 90)");
		add(lb3, 0, 2);
		lb4 = new Label("Date");// Gender and its style
		lb4.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb4.setStyle("-fx-text-fill:rgb(190, 100, 90)");
		add(lb4, 0, 3);

		cb4 = new ComboBox<>();
		add(cb4, 1, 3);

		lb5 = new Label("Gender");// gender
		lb5.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		lb5.setStyle("-fx-text-fill:rgb(190, 100, 90)");
		add(lb5, 0, 4);
		cb5 = new ComboBox<>();
		add(cb5, 1, 4);
		b1 = new Button("Delete");// insert Button
		b1.setStyle("-fx-border-color:rgb(190, 100, 90)");
		b1.setPrefWidth(100);
		b1.setPrefHeight(30);
		add(b1, 1, 9);

		setAlignment(Pos.CENTER);
		cb1.setMaxWidth(110);
		cb2.setMaxWidth(230);
		cb4.setMaxWidth(210);
		cb1.setOnAction(e1 -> {// action to cb1 that effect in cb2
			String location = (String) cb1.getValue();
			System.out.println("KJHGFD");
			// Find the index of the selected city in the circular list
			int index = obj.list.find(location);// index to find
			System.out.println(index);
			cb2.getItems().clear();
			for (int i = 0; i < obj.list.getNode(index).getAVLList1().Size(); i++) {// size on tree1

				Martyrobject M = obj.list.getNode(index).getAVLList1().getMartyr(i);// martyr object
				System.out.println(M);
				cb2.getItems().add(M.getName());
			}

			cb2.setOnAction(e2 -> {// action to cb2 that effect in cb3
				String Name = (String) cb2.getValue();
				// Find the index of the selected city in the circular list
				cb3.getItems().clear();// clear
				for (int i = 0; i < obj.list.getNode(index).getAVLList1().Size(); i++) {

					Martyrobject M = obj.list.getNode(index).getAVLList1().getMartyr(i);
					System.out.println(M);
					if (M.getName().equals(Name)) {// if name then add age for this name
						cb3.getItems().add(M.getAge());// get age
					}
				}

				cb3.setOnAction(e3 -> {// action to cb3 that effect in cb4
					cb4.getItems().clear();// clear
					int age = cb3.getValue();

					for (int i = 0; i < obj.list.getNode(index).getAVLList1().Size(); i++) {// avltree1 size

						Martyrobject M = obj.list.getNode(index).getAVLList1().getMartyr(i);// object martyr
						System.out.println(M);
						if (M.getAge() == age && M.getName().equals(Name)) {// if all above is contain
							System.out.println("LLLLLLLLL");
							cb4.getItems().add(M.getDateOfDeth());// add date
						}
					}

					cb4.setOnAction(e4 -> {// action cb4
						cb5.getItems().clear();// clear
						Date date = cb4.getValue();

						for (int i = 0; i < obj.list.getNode(index).getAVLList1().Size(); i++) {// avl1size

							Martyrobject M = obj.list.getNode(index).getAVLList1().getMartyr(i);// objectmartyr
							System.out.println(M);
							if (M.getAge() == age && M.getName().equals(Name) && M.getDateOfDeth().equals(date)) {// if
																													// all
																													// above
																													// is

								cb5.getItems().add(M.getGender());// get gender
							}
						}

					});

				});
			});
		});

		b1.setOnAction(e -> {// button delete action
			if (cb1.getItems().isEmpty() || cb2.getItems().isEmpty() || cb3.getItems().isEmpty()
					|| cb4.getItems().isEmpty() || cb5.getItems().isEmpty()) {// if empty
				Warning2();

			} else {// if not empty
				String location = cb1.getValue();// take values
				String Name = cb2.getValue();
				int age = cb3.getValue();
				Date date = cb4.getValue();
				char gender = cb5.getValue();
				int index = obj.list.find(location);
				Martyrobject M = new Martyrobject(Name, age, date, gender);

				for (int i = 0; i < obj.list.getNode(index).getAVLList1().Size(); i++) { // if object is exit
					if (obj.list.getNode(index).getAVLList1().getMartyr(i).getName().equals(Name)
							&& obj.list.getNode(index).getAVLList1().getMartyr(i).getAge() == age
							&& obj.list.getNode(index).getAVLList1().getMartyr(i).getDateOfDeth().equals(date)
							&& obj.list.getNode(index).getAVLList1().getMartyr(i).getGender() == gender) {

						obj.list.getNode(index).getAVLList1()
								.remove2(obj.list.getNode(index).getAVLList1().getMartyr(i)); // remove the AVLTree1

						if (obj.list.getNode(index).getAVLList2().getNodeByDate(date).getDateStack().getDate()
								.equals(date)) {// if the date matches
							System.out.println("POIUYTREWuytreazxcvbnmnvcxzawertyuio");
							obj.list.getNode(index).getAVLList2().getNodeByDate(date).getDateStack().getStack()
							.printList();
							System.out.println("Removed from Stack");
							obj.list.getNode(index).getAVLList2().getNodeByDate(date).getDateStack().getStack()
									.removeElement(M);
						}
						break; // Exit the loop once the element is found and removed.
					}

				}
				/*
				 * System.out.println(obj.list.getNode(index).getAVLList2().getNodeByDate(date).
				 * getDateStack().getDate() .equals(date));
				 * obj.list.getNode(index).getAVLList2().getNodeByDate(date).getDateStack().
				 * getStack().printList();
				 */
				Done();
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
		HBox vbox = new HBox(10);
		b4 = new Button("Yes");// OK button
		BorderPane border = new BorderPane();
		text1 = new Text("Are u sure To Delete! \uD83D\uDE0A");
		text1.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
		b5 = new Button("No");// OK button
		border.setCenter(text1);
		vbox.getChildren().addAll(b4, b5);
		vbox.setAlignment(Pos.CENTER);

		border.setBottom(vbox);
		Scene s = new Scene(border, 350, 90);
		stage.setScene(s);
		stage.setTitle("Done!!!!");
		stage.show();
		b5.setOnAction(e -> {// close this stage and continue
			stage.close();
		});
		b4.setOnAction(e -> {
			stage.close();
			Done2();
		});

	}

	public void Done2() {// Done method
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