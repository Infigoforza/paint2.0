package paint;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BedienPaneel extends HBox {
	private static ColorPicker cp;

	public BedienPaneel() {
		HBox h1 = new HBox();
		HBox h2 = new HBox();
		VBox v1 = new VBox();
		VBox v2 = new VBox();
		
		Rectangle[] recArr = new Rectangle[9];
//		for (Rectangle rec : recArr){
//			rec.setWidth(100);
//			rec.setHeight(30);
//			rec.setFill(Color.AQUAMARINE);
//		}
		
		Button testButton = new Button("Klik me");
		
		h1.setPadding(new Insets(15, 15, 15, 12));
		cp = new ColorPicker();
		Rectangle r = new Rectangle();
		r.setWidth(100);
		r.setHeight(30);
		
		h1.setPrefSize(50, 100);
		h2.setPrefSize(400, 100);
		h1.setStyle("-fx-border-color: black;");
		h2.setStyle("-fx-border-color: black;");
		v1.getChildren().addAll(cp, r);
		v2.getChildren().addAll(testButton);
		h1.getChildren().addAll(v1);
		h1.setAlignment(Pos.CENTER_LEFT);
		h2.getChildren().add(v2);
		getChildren().addAll(h1, h2);
		
		cp.setOnAction(e -> r.setFill(cp.getValue()));
	}

	public static Color getColor() {
		return cp.getValue();
	}
}
