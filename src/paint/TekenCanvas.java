package paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class TekenCanvas extends Canvas {

	public TekenCanvas(int breedte, int hoogte) {
		super(breedte, hoogte);
		GraphicsContext gc = getGraphicsContext2D();
		this.setOnMousePressed(e -> lineTekenen());

	}

	public void lineTekenen() {
		
	}

}
