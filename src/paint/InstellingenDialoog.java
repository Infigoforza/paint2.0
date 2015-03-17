package paint;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InstellingenDialoog extends Stage {
	private TextField inputHeight, inputWidth;
	private Button annuleren, ok;
	private int height, width;
	private Label labelH, labelW;

	public InstellingenDialoog(Stage owner, int height, int width) {
		initOwner(owner);
		this.height = height;
		this.width = width;
		FlowPane root = new FlowPane();
		Scene scene = new Scene(root, width, height);
		inputHeight = new TextField();
		inputWidth = new TextField();
		annuleren = new Button("Anuleren");

		annuleren.setOnAction(e -> {
			this.close();
		});

		ok = new Button("Ok");
		ok.setOnAction(e -> {
					
			this.close();
		});
		labelH = new Label("Height");
		labelW = new Label("Width");
		root.getChildren().addAll(labelH, inputHeight, labelW, inputWidth,
				annuleren, ok);
		scene.setRoot(root);
		this.setTitle("Instellingen");
		this.setScene(scene);
		this.showAndWait();

	}
	
	public double geefHoogte() {
		return Double.parseDouble(inputHeight.getText());
	}
	
	public double geefBreedte() {
		return Double.parseDouble(inputWidth.getText());
	}
}
