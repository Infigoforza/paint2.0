package paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class TekenCanvas extends Canvas {

	public TekenCanvas(int breedte, int hoogte) {
		super(breedte, hoogte);
		getGraphicsContext2D().strokeLine(30, 10, 40, 20);
	}

}
