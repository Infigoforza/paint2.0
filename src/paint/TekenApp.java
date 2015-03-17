package paint;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TekenApp extends Application {
	private TekenCanvas tc;
	private File huidigBestand = new File("image.png");
	private FileChooser fileChooser = new FileChooser();

	@Override
	public void start(Stage primaryStage) {
		BedienPaneel bp = new BedienPaneel();
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 440, 350);
		MenuBar menuBar = new MenuBar();
		VBox topPosition = new VBox();

		tc = new TekenCanvas(430, 300);
		bp.setPrefSize(440, 125);

		// menuBestand setup
		Menu menuBestand = new Menu("Bestand");
		MenuItem nieuw = new MenuItem("Niew  CTRL + N");
		menuBestand.getItems().add(nieuw);

		// Nieuw canvas
		nieuw.setOnAction(e -> {
			GraphicsContext gc = tc.getGraphicsContext2D();
			gc.setFill(Color.TRANSPARENT);
			gc.clearRect(0, 0, 430, 350);
		});

		MenuItem opslaan = new MenuItem("Opslaan");
		menuBestand.getItems().add(opslaan);

		// Image saver zonder dialog
		opslaan.setOnAction(e -> {
			try {
				afbeeldingOpslaan(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		MenuItem opslaanAls = new MenuItem("Opslaan als");
		menuBestand.getItems().add(opslaanAls);

		// Image saver met dialog
		opslaanAls.setOnAction(e -> {
			try {
				afbeeldingOpslaan(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		// menuOpties setup
		Menu menuOpties = new Menu("Opties");

		// MenuBar setup
		menuBar.getMenus().addAll(menuBestand, menuOpties);
		menuBar.setPrefSize(440, 10);

		root.setCenter(tc);
		tc.setStyle("-fx-border-color: black;");
		topPosition.getChildren().addAll(menuBar, bp);

		root.setTop(topPosition);
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
