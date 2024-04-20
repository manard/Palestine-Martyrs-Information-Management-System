import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	public static CircularList list = new CircularList();
	public NodeList node = new NodeList();
	private Button b1;
	private Menu menu1, menu2, menu3, menu4;
	private MenuItem itemL1, itemL2, itemL3, itemM1, itemM2, itemM3, itemR1, itemR2, itemR3;
	// public CircularList list = new CircularList();
	FileChooser fileChooser = new FileChooser();// To create an file chooser
	public static NodeAVL2 nodAVL;

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage stage) {
		BorderPane border = new BorderPane();
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		b1 = new Button("Select File");
		b1.setPrefHeight(40);
		b1.setPrefWidth(120);
		vbox.getChildren().add(b1);
		vbox.setPadding(new Insets(20, 1, 80, 20));
		border.setBottom(vbox);

		Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
		b1.setFont(font);

		b1.setStyle(
				"-fx-background-color: #333333;-fx-text-fill:rgb(155, 160, 140);-fx-border-color: rgb(155, 160, 140);");

		b1.setShape(new Circle(1));
		b1.setOnMouseEntered(e -> {
			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), b1);
			scaleTransition.setToX(1.2);
			scaleTransition.setToY(1.2);
			scaleTransition.play();
		});
		b1.setOnMouseExited(e -> {
			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), b1);
			scaleTransition.setToX(1.0);
			scaleTransition.setToY(1.0);
			scaleTransition.play();
		});
		b1.setOnAction(e -> {
			itemL1.setVisible(true);
			itemL2.setVisible(true);
			itemL3.setVisible(true);
			itemM1.setVisible(true);
			itemM2.setVisible(true);
			itemM3.setVisible(true);
			itemR1.setVisible(true);
			itemR2.setVisible(true);
			itemR3.setVisible(true);
			addLocation(stage);

		});

		Image img = new Image("C:\\Users\\Lenovo\\Downloads\\download (1).jfif");

		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background bg = new Background(bImg);
		bImg.getSize();
		border.setBackground(bg);
		MenuBar bar = new MenuBar();
		bar.setStyle("-fx-background-color:rgb(155, 120, 100);");

		menu1 = new Menu("Location");// location menu
		itemL1 = new MenuItem("insert a new location");// insert choice
		itemL1.setVisible(false);
		itemL1.setOnAction(e -> {// insert stage
			b1.setVisible(false);
			border.setBackground(null);
			Location obj = new Location();
			border.setCenter(obj);
		});

		// Create a new MenuItem with the label "search location"
		itemL3 = new MenuItem("search location");

		// Set the visibility of the MenuItem to false initially
		itemL3.setVisible(false);

		// Set an action to be performed when the MenuItem is clicked
		itemL3.setOnAction(e -> {
			// Hide the b1 (assuming it's a button) when this MenuItem is clicked
			b1.setVisible(false);

			// Remove the background from the 'border' (assuming it's a container) when this
			// MenuItem is clicked
			border.setBackground(null);

			// Create a new instance of the 'SeachLocation' class (assuming it's a custom
			// JavaFX Node or Pane)
			SeachLocation search = new SeachLocation();

			// Set the 'SeachLocation' node as the center content of the 'border' container
			border.setCenter(search);
		});
		// Create a new MenuItem with the label "update/delete location"
		itemL2 = new MenuItem("update/delete location");

		// Set the visibility of the MenuItem to false initially
		itemL2.setVisible(false);

		// Set an action to be performed when the MenuItem is clicked
		itemL2.setOnAction(e -> {
			// Hide the b1 (assuming it's a button) when this MenuItem is clicked
			b1.setVisible(false);

			// Remove the background from the 'border' (assuming it's a container) when this
			// MenuItem is clicked
			border.setBackground(null);

			// Create a new instance of the 'Update_delete' class (assuming it's a custom
			// JavaFX Node or Pane)
			Update_delete ud = new Update_delete();

			// Set the 'Update_delete' node as the center content of the 'border' container
			border.setCenter(ud);
		});
		menu1.getItems().addAll(itemL1, itemL2, itemL3);
		menu2 = new Menu("Martyrs");

		menu3 = new Menu("Statistics");

		menu4 = new Menu("File");
		itemM1 = new MenuItem("Insert new Martyr");
		itemM1.setVisible(false);

		/*
		 * fileitem.setOnAction(e -> { File f = fileChooser.showOpenDialog(stage);
		 * itemM1.setVisible(false);
		 * 
		 * });
		 */
		// Create a new MenuItem with the label "Update-Delete new Martyr"
		itemM2 = new MenuItem("Update-Delete new Martyr");

		// Set the visibility of the MenuItem to false initially
		itemM2.setVisible(false);

		// Set an action to be performed when the MenuItem is clicked
		itemM2.setOnAction(e -> {
			// Hide the b1 (assuming it's a button) when this MenuItem is clicked
			b1.setVisible(false);

			// Remove the background from the 'border' (assuming it's a container) when this
			// MenuItem is clicked
			border.setBackground(null);

			// Create a new instance of the 'DeleteMartyr' class (assuming it's a custom
			// JavaFX Node or Pane)
			DeleteMartyr UM = new DeleteMartyr();

			// Set the 'DeleteMartyr' node as the center content of the 'border' container
			border.setCenter(UM);
		});
		itemM3 = new MenuItem("Search Martyr");// search martyer
		itemM3.setVisible(false);
		itemM3.setOnAction(e -> {
			b1.setVisible(false);
			border.setBackground(null);
			SearchMartyr SM = new SearchMartyr();
			border.setCenter(SM);

		});
		menu2.getItems().addAll(itemM1, itemM2, itemM3);
		itemR1 = new MenuItem("generate Report AVL1");
		itemR1.setVisible(false);
		itemR1.setOnAction(e -> {
			b1.setVisible(false);
			border.setBackground(null);
			Statistic S = new Statistic();
			border.setCenter(S);

		});
		itemR2 = new MenuItem("generate Report AVL2");
		itemR2.setVisible(false);
		itemR2.setOnAction(e -> {
			b1.setVisible(false);
			border.setBackground(null);
			ReportAVL2 S = new ReportAVL2();
			border.setCenter(S);

		});

		// Create a new MenuItem with label "generate Report"
		itemR3 = new MenuItem("generate Report");

		// Set the visibility of the MenuItem to false initially
		itemR3.setVisible(false);

		// Set an action to be performed when the MenuItem is clicked
		itemR3.setOnAction(e -> {
			// Hide the 'b1' (assuming it's a button or similar)
			b1.setVisible(false);

			// Set the background of 'border' to null, effectively removing the background
			border.setBackground(null);

			// Create an instance of the 'NextPrevMartyr' class (assuming it's a custom
			// class for generating reports)
			NextPrevMartyr S = new NextPrevMartyr();

			// Set the center of the 'border' to display the 'NextPrevMartyr' instance
			border.setCenter(S);
		});

		itemM1.setOnAction(e -> {
			b1.setVisible(false);
			border.setBackground(null);
			InsertMartyr ud = new InsertMartyr();
			border.setCenter(ud);
		});
		menu3.getItems().addAll(itemR1, itemR2, itemR3);

		bar.getMenus().add(menu1);// add menus to bar
		bar.getMenus().add(menu2);
		bar.getMenus().add(menu3);
		bar.getMenus().add(menu4);
		border.setTop(bar);

		MenuItem fileitem = new MenuItem("Save AS...");
		menu4.getItems().add(fileitem);

		// Set the action for the "Save AS..." option
		// Set an action to be performed when the 'fileitem' (assuming it's a MenuItem
		// or similar) is clicked
		fileitem.setOnAction(e -> {
			// Show the file save dialog and allow the user to choose a file location
			File file = fileChooser.showSaveDialog(stage);

			// Check if the user selected a valid file location
			if (file != null) {
				try (PrintWriter pw = new PrintWriter(file)) {
					// Iterate through the 'list' (assuming it's a list or data structure)
					for (int i = 0; i < list.size; i++) {
						// Assuming you have a method in the AVLTree class that returns the data as a
						// string.
						// Retrieve the data from 'list' and convert it to a string using
						// 'printInOrder2' method
						String infile = list.getNode(i).getAVLList1().printInOrder2();

						// Write the data to the file using the PrintWriter
						pw.print(infile);
					}
				} catch (IOException ex) {
					// If an IOException occurs during the process, print the stack trace for
					// debugging
					ex.printStackTrace();
				}
			}
		});
		Scene scene = new Scene(border, 600, 550);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Martyrs System");
		stage.show();

	}

	public void addLocation(Stage s) {// this method to add locations in list, and add Martyrs to inner list

		File fileSelected = fileChooser.showOpenDialog(s);

		if (fileSelected != null) {
			try {

				Scanner in = new Scanner(fileSelected);

				while (in.hasNext()) {
					String x = in.nextLine();

					String[] data = x.split(",");
					String location1 = data[2];
					if (list.isEmpty()) {
						list.addFirst(location1);
					}
					if (!(list.contains(location1))) {
						if (((String) list.getLast()).toLowerCase().compareTo(location1.toLowerCase()) < 0) {
							list.addLast(location1);

						} else {

							for (int i = 0; i < list.size(); i++) {
								if (((String) list.get(i)).toLowerCase().compareTo(location1.toLowerCase()) > 0) {
									list.add(i, location1);

									break;
								}
							}
						}

					}
					if (!(data[1].trim().isEmpty())) {
						Martyrobject M = new Martyrobject(data[0].trim(), Integer.parseInt(data[1]), new Date(data[3]),
								data[4].charAt(0));
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i).equals(location1)) {// combine with location
								// node.getAvl().insert(M);
								// list.getNode(i).insert(M);
								((AVLTree) list.getNode(i).getAVLList1()).insert(M);

								SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
								Date targetDate = dateFormat.parse(data[3]);

								// Create a DateStack object with the extracted date
								DateStack date = new DateStack(targetDate);

								// Insert the DateStack into the corresponding AVLTree sorted by date
								((AVLTree2) list.getNode(i).getAVLList2()).insert(date);
								nodAVL = new NodeAVL2(date);
								if (nodAVL.getDateStack().getDate().compareTo(new Date(data[3])) == 0) {
									nodAVL.getDateStack().getStack().push(M);

								}

							}

						}

					}

				}

				// list.print();
				// System.out.println(list.size());
				// System.out.println(list.getNode(0).getElement());
				// ((AVLTree) list.getNode(0).getAVLList1()).printInOrder();

				in.close();

				// nodAVL.getDateStack().getStack().printList2();
			} catch (FileNotFoundException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
