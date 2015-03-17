package paint;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TekenApp extends Application {
	private TekenCanvas tc;

	@Override
	public void start(Stage primaryStage) {
		BedienPaneel bp = new BedienPaneel();
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 440, 350);
		MenuBar menuBar = new MenuBar();
		VBox topPosition = new VBox();
		
		
		tc = new TekenCanvas(430, 300);
		bp.setPrefSize(440, 125);
		
		//menuBestand setup
		Menu menuBestand = new Menu("Bestand");
		MenuItem nieuw = new MenuItem("Niew  CTRL + N");
		menuBestand.getItems().add(nieuw);
		
		//menuOpties setup
		Menu menuOpties= new Menu("Opties");
		
		//MenuBar setup
		menuBar.getMenus().addAll(menuBestand,menuOpties);
		menuBar.setPrefSize(440, 10);
			
		
		root.setCenter(tc);
		tc.setStyle("-fx-border-color: black;");
		
		topPosition.getChildren().addAll(menuBar,bp);
		
		root.setTop(topPosition);
		scene.setRoot(root);
		primaryStage.setTitle("Paint");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
