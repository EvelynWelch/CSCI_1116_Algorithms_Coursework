// Author: Evie Welch
// date 02/22/23

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
	private Map<String, Integer>[] mapForBoy = new HashMap[10];
	private Map<String, Integer>[] mapForGirl = new HashMap[10];

	private Button btFindRanking = new Button("Find Ranking");
	private ComboBox<Integer> cboYear = new ComboBox<>();
	private ComboBox<String> cboGender = new ComboBox<>();
	private TextField tfName = new TextField();
	private Label lblResult = new Label();

	
	
	public class BabynameScanner {
		public String makeUrlString(String year) {
			String urlString = "http://liveexample.pearsoncmg.com/data/babynamesranking";
			return urlString + year + ".txt";
		}

		public URL URLfactory(String urlString) {
			try {
				URL url = new URL(urlString);
				return url;
			} catch (MalformedURLException e) {
				System.out.println("URLfactory() error: " + e.getMessage());
				return null;
			}
		}

		public Map[] getNameRankings(String year) throws Exception {
			Map<String, Integer> boyNames = new HashMap<String, Integer>();
			Map<String, Integer> girlNames = new HashMap<String, Integer>();
			
			URL babyNameURL = URLfactory(makeUrlString(year));

			Scanner input = new Scanner(babyNameURL.openStream());
			while (input.hasNextLine()) {
				String l = input.nextLine();
				String[] v = l.split("\\s+");
				int rank = Integer.valueOf(v[0]);
//				System.out.println("v[3]: " + v[3]);
				String boyName = v[1];
				String girlName = v[3];
				boyNames.put(boyName, rank);
				girlNames.put(girlName, rank);
			}

			input.close();
			Map[] nameRankings = {girlNames, boyNames};
			
			return nameRankings;
		}
	}

	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Select a year:"), 0, 0);
		gridPane.add(new Label("Boy or girl?"), 0, 1);
		gridPane.add(new Label("Enter a name:"), 0, 2);
		gridPane.add(cboYear, 1, 0);
		gridPane.add(cboGender, 1, 1);
		gridPane.add(tfName, 1, 2);
		gridPane.add(btFindRanking, 1, 3);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(gridPane);
		borderPane.setBottom(lblResult);
		BorderPane.setAlignment(lblResult, Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 370, 160);
		primaryStage.setTitle("Exercise21_11"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		for (int year = 2001; year <= 2010; year++) {
			cboYear.getItems().add(year);
		}
		cboYear.setValue(2001);

		cboGender.getItems().addAll("Male", "Female");
		cboGender.setValue("Male");
		
		btFindRanking.setOnAction(e -> {
			
			int year = cboYear.getValue();
			int index = year - 2001;
			
			String gender = cboGender.getValue();
			String name = tfName.getText();
			Map[] names = gender.equalsIgnoreCase("female") ? mapForGirl : mapForBoy;
			if(names[index] == null) {
				try {
					BabynameScanner nameScanner = new BabynameScanner();
					Map[] r = nameScanner.getNameRankings(String.valueOf(year));
					mapForGirl[index] = r[0];
		
					mapForBoy[index] = r[1];
 				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
			if(names[index].containsKey(name)) {
				int rank = (int)names[index].get(name);
				lblResult.setText(gender + " name " + name + " is ranked #" + rank + " in year " + year);
			} else {
				System.out.println(names[index].keySet());
				lblResult.setText(gender + " name " + name + " is not in the list of " + gender.toLowerCase() + " names from " + year);

			}
			
		});
		
		

	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
