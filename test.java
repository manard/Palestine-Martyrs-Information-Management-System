import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class test extends Application {
	FileChooser fileChooser = new FileChooser();
	public static void main(String[] args) {
        Application.launch(args);
	

	}

	@Override
	public void start(Stage stage){
		Label txt =new Label("ISBN");
		TextField tf=new TextField();
		Button b=new Button("Search");
		HBox hbox1=new HBox(10);
		HBox hbox=new HBox(10);
		hbox.getChildren().addAll(txt,tf);
		hbox1.getChildren().add(b);
		Scene s=new Scene(hbox,300,200);
	//	stage.setScene(s);
		Scene se=new Scene(hbox1,200,200);
		stage.setScene(se);
		b.setOnAction(e ->{
			addLocation(stage);
		});
		stage.show();
		
	}

	public void addLocation(Stage s) {// this method to add locations in list, and add Martyrs to inner list

		File fileSelected = fileChooser.showOpenDialog(s);

		if (fileSelected != null) {
			try {

				Scanner in = new Scanner(fileSelected);

			}
			catch (FileNotFoundException e) { // TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	}
}