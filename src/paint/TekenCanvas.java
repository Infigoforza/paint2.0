package paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class TekenCanvas extends Canvas {
	private Label lb = new Label("kip");

	public TekenCanvas(int breedte, int hoogte) {
		super(breedte, hoogte);
	}
	

}
