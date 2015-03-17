package paint;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TekenApp extends Application {
	private TekenCanvas tc;
	private File huidigBestand = new File("test.png");
	private FileChooser fileChooser = new FileChooser();

	@Override
	public void start(Stage primaryStage) {
		BedienPaneel bp = new BedienPaneel();
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 440, 350);
		Button testButton = new Button("Click me to save");
		testButton.setOnAction(e -> {
			try {
				afbeeldingOpslaan(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		tc = new TekenCanvas(430, 300);

		root.setCenter(tc);
		root.setBottom(testButton);
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

	private boolean afbeeldingOpslaan(boolean dialoogAltijdTonen) throws IOException {
		if (dialoogAltijdTonen) {
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				huidigBestand = file;
			}
		}
		
		SnapshotParameters params = new SnapshotParameters();
		WritableImage img = tc.snapshot(params, null);
		RenderedImage img2 = SwingFXUtils.fromFXImage(img, null);
		ImageIO.write(img2, "png", huidigBestand);
		return true;
	}
}
