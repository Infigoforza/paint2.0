package paint;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

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
		Stage instellingenD = new Stage();
		tc = new TekenCanvas(430, 300);
		bp.setPrefSize(440, 125);

		// menuBestand setup
		Menu menuBestand = new Menu("_Bestand");

		menuBestand.setOnAction(e -> {
			menuBestand.show();
		});


		MenuItem nieuw = new MenuItem("_Niew  CTRL + N");
		menuBestand.getItems().add(nieuw);
		;

		// Nieuw canvas
		nieuw.setOnAction(e -> {
			GraphicsContext gc = tc.getGraphicsContext2D();
			gc.setFill(Color.TRANSPARENT);
			gc.clearRect(0, 0, 430, 350);
		});

		nieuw.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));

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

		MenuItem opslaanAls = new MenuItem("Opslaan Als");
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
		MenuItem instellingen = new MenuItem("Instellingen");

		// Menu dialoog tonen
		instellingen.setOnAction(e -> {
			InstellingenDialoog dialog = new InstellingenDialoog(instellingenD,
					200, 200);
		});
		menuOpties.getItems().add(instellingen);

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

	private boolean afbeeldingOpslaan(boolean dialoogAltijdTonen)
			throws IOException {
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
