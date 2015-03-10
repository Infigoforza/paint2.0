package paint;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TekenApp extends Application {
	private TekenCanvas tc;

	@Override
	public void start(Stage primaryStage) {
		BedienPaneel bp = new BedienPaneel();
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 440, 350);
		tc = new TekenCanvas(430, 300);
		root.setCenter(tc);
		tc.setStyle("-fx-border-color: black;");
		root.setTop(bp);
		scene.setRoot(root);
		primaryStage.setTitle("Paint");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}