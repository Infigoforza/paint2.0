package paint;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BedienPaneel extends HBox {
	private static ColorPicker cp;

	public BedienPaneel() {
		HBox h1 = new HBox();
		HBox h2 = new HBox();
		h1.setPadding(new Insets(15,15,15,12));
		cp = new ColorPicker();
		Rectangle r = new Rectangle();
		r.setWidth(100);
		r.setHeight(30);
		h1.setPrefSize(50, 100);
		h1.setStyle("-fx-border-color: black;");
		h1.getChildren().addAll(cp, r);
		h1.setAlignment(Pos.CENTER_LEFT);
		getChildren().addAll(h1);
		cp.setOnAction(e -> r.setFill(cp.getValue()));
	}
	
	public static Color getColor(){
		return cp.getValue();
	}
}
