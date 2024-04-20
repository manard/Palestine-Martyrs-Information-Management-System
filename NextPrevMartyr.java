import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class NextPrevMartyr extends GridPane {
	private Button b1, b2;
	private TextArea ta, ta2;
	Main obj = new Main();
	private HBox hbox, hbox2;
	private int count = 0;
	NodeList current = obj.list.front;

	public NextPrevMartyr() {
		setBackground(new Background(new BackgroundImage(
				new Image("C:\\Users\\Lenovo\\Downloads\\WhatsApp Image 2023-05-12 at 5.16.56 PM.jpeg"),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT)));// background for this stage
		b1 = new Button();
		Polygon next = new Polygon();
		next.getPoints().addAll(0.0, 0.0, 10.0, 5.0, 0.0, 10.0);
		next.setStyle("-fx-fill: black"); // Set arrow color to black

		// Set the arrow as the graphic for the button
		// Create a new Button 'b1' with a graphic 'next' (assumed to be previously
		// defined)
		b1.setGraphic(next);

		// Create a new Button 'b2' with a graphic 'prev' (arrow pointing left)
		b2 = new Button();
		Polygon prev = new Polygon();
		prev.getPoints().addAll(10.0, 0.0, 0.0, 5.0, 10.0, 10.0); // Define the points for the polygon arrow
		prev.setStyle("-fx-fill: black"); // Set arrow color to black
		b2.setGraphic(prev);

		// Create a new TextArea 'ta' with custom styling
		ta = new TextArea();
		ta.setMinWidth(2);
		ta.setMaxWidth(140);
		ta.setMaxHeight(4);
		ta.setStyle("-fx-border-color: rgb(190, 100, 90); -fx-border-width: 2px;");

		// Create an HBox 'hbox' and add the buttons 'b2' and 'b1', and the TextArea
		// 'ta' to it
		hbox = new HBox(3);
		hbox.getChildren().addAll(b2, ta, b1);
		add(hbox, 1, 3); // Add the HBox to the layout (GridPane or similar)

		// Create another HBox 'hbox2' and a TextArea 'ta2' with custom styling
		hbox2 = new HBox(3);
		hbox.setPadding(new Insets(50, 50, 10, 200));
		ta2 = new TextArea();
		ta2.setMinHeight(250);
		hbox2.setPadding(new Insets(80, 50, 10, 80));
		ta2.setStyle("-fx-border-color: rgb(190, 100, 90); -fx-border-width: 2px;");

		hbox2.getChildren().add(ta2);
		add(hbox2, 1, 4);
		String txt = "";
		ta.setText((String) current.element);
		txt += "The numbers of martyrs in " + ta.getText() + " is: " + obj.list.getNode(0).getAVLList1().Size() + "\n";
		txt += "The date that had the maximum number of martyrs is:\n "
				+ obj.list.getNode(0).getAVLList2().getDateMartyrs() + "\n";
		txt += "The Height is: " + obj.list.getNode(0).getAVLList1().getHeight() + "\n\n";
		txt += obj.list.getNode(0).getAVLList1().printInOrder2() + "\n";
		// Add other properties if available

		ta2.setText(txt);

		b1.setOnAction(e -> {
			String text = "";
			obj.list.print();

			while (current.next != null) {// while the prev element in linked list not null then:
				current = current.next;// set currnt to next
				ta.setText(current.element.toString());// set element to txtArea
				for (int i = 0; i < obj.list.size; i++) {
					if (obj.list.get(i).equals(ta.getText())) {
						// System.out.println(obj.list.getNode(i).getAVLList1().printInOrder2());
						text += "The numbers of martyrs in " + ta.getText() + " is: "
								+ obj.list.getNode(i).getAVLList1().Size() + "\n";
						text += "The date that had the maximum number of martyrs is:\n "
								+ obj.list.getNode(i).getAVLList2().getDateMartyrs() + "\n";
						text += "The Height is: " + obj.list.getNode(i).getAVLList1().getHeight() + "\n\n";
						text += obj.list.getNode(i).getAVLList1().printInOrder2() + "\n";
						// Add other properties if available

						ta2.setText(text);
					}
				}
				break;

			}
		});

		b2.setOnAction(e -> {
			String text = "";

			// Move the 'current' node to the beginning of the list
			while (current.prev != null) {
				current = current.prev;

				// Set the text of the TextArea 'ta' with the current element's toString()
				ta.setText(current.element.toString());

				// Loop through the list of locations in 'obj.list'
				for (int i = 0; i < obj.list.size; i++) {
					// Check if the current location in the list matches the text in the TextArea
					// 'ta'
					if (obj.list.get(i).equals(ta.getText())) {
						// Get the AVLTree associated with the current location
						AVLTree avlTree = (AVLTree) obj.list.getNode(i).getAVLList1();

						// Build the text to display in the TextArea 'ta2'
						text += "The numbers of martyrs in " + ta.getText() + " is: " + avlTree.Size() + "\n";
						text += "The date that had the maximum number of martyrs is:\n "
								+ obj.list.getNode(i).getAVLList2().getDateMartyrs() + "\n";
						text += "The Height is: " + avlTree.getHeight() + "\n\n";
						text += avlTree.printInOrder2() + "\n";
						// Add other properties if available

						// Set the TextArea 'ta2' with the generated text
						ta2.setText(text);
					}
				}

				// Exit the loop after processing the first node (beginning of the list)
				break;
			}
		});
	}

}