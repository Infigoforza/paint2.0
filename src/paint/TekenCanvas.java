package paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class TekenCanvas extends Canvas {
	private GraphicsContext gc = getGraphicsContext2D();

	public TekenCanvas(int breedte, int hoogte) {
		super(breedte, hoogte);
		this.setOnMouseClicked(e -> randomDraw(e));
		this.setOnMouseDragged(e -> randomDraw(e));
		this.setOnMouseReleased(e -> randomDraw(e));
	}

	// gewoon zelf tekenen, geen figuren.
	public void randomDraw(MouseEvent e) {
		if (e.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			gc.setStroke(BedienPaneel.getColor());
			gc.beginPath();
		}

		if (e.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
			gc.setStroke(BedienPaneel.getColor());
			gc.lineTo(e.getX(), e.getY());
			gc.stroke();
		}

		if (e.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
			gc.closePath();
		}
	}

	// Een vierkant tekenen
	public void drawRect(MouseEvent e) {
		gc.lineTo(e.getX(), e.getY());
	}
}