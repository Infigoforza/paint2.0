package paint;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InstellingenDialoog {
	private TextField inputHeight, inputWidth;
	private Button annuleren, ok;
	private int height, width;
	private Label labelH, labelW;

	public InstellingenDialoog(Stage venster, int height, int width) {
		this.height = height;
		this.width = width;
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, width, height);

		inputHeight = new TextField();
		
		inputWidth = new TextField();
		annuleren = new Button("Anuleren");
		ok = new Button("Ok");
		labelH = new Label("Height");
		labelW = new Label("Width");
				
		HBox center = new HBox();
		
		center.setPrefSize(200, 200);
		center.getChildren().addAll(labelH,inputHeight,labelW,inputWidth,annuleren,ok);
		
		root.getChildren().addAll(center);
		scene.setRoot(root);
		venster.setTitle("Instellingen");
		venster.setScene(scene);
		venster.show();

	}

	

}
