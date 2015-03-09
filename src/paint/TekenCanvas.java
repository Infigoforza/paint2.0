package paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class TekenCanvas extends Canvas {
	
	private GraphicsContext gc = getGraphicsContext2D();

	public TekenCanvas(int breedte, int hoogte) {
		super(breedte, hoogte);
		
		this.setOnMouseDragged(e -> randomDraw(e));
		//this.setOnMouseDragged(e -> drawRect(e));

	}
	
	//gewoon zelf tekenen, geen figuren.
	public void randomDraw(MouseEvent e) {
		gc.getPixelWriter().setColor((int)e.getX(),(int)e.getY(), BedienPaneel.getColor());
		gc.getPixelWriter().setColor((int)e.getX(),(int)e.getY() + 1, BedienPaneel.getColor());
		gc.getPixelWriter().setColor((int)e.getX(),(int)e.getY() + 2, BedienPaneel.getColor());
		
	} 
	
		//Een vierkant tekenen
	public void drawRect(MouseEvent e){
		gc.lineTo(e.getX(), e.getY());
	}

}
