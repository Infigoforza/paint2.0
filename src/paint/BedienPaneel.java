package paint;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BedienPaneel extends HBox {
	private static ColorPicker cp;
	private static ToggleGroup group;
	private static Color col;
	private Rectangle[] rec;
	Rectangle r = new Rectangle();

	public BedienPaneel() {
		VBox menu = new VBox();
		HBox linkerHbox = new HBox();
		HBox rechterHbox = new HBox();
		VBox centerAlignVbox = new VBox();
		VBox kleurenPaneelVbox = new VBox();
		MenuBar menuBar = new MenuBar();
		rec = new Rectangle[10];
		TilePane tile = new TilePane(7,10);
		

		tile.setPadding(new Insets(10, 10, 10, 10));

		for (int i = 0; i < 10; i++) {
			rec[i] = new Rectangle();
			tile.getChildren().add(rec[i]);
			rec[i].setWidth(27);
			rec[i].setHeight(27);
			rec[i].setOnMouseClicked(e -> getRekt(e));
		}

		rec[0].setFill(Color.BROWN);
		rec[1].setFill(Color.PURPLE);
		rec[2].setFill(Color.BLUE);
		rec[3].setFill(Color.RED);
		rec[4].setFill(Color.MAGENTA);
		rec[5].setFill(Color.NAVAJOWHITE);
		rec[6].setFill(Color.BLACK);
		rec[7].setFill(Color.AQUAMARINE);
		rec[8].setFill(Color.GAINSBORO);
		rec[9].setFill(Color.VIOLET);
		
		ToggleGroup group = new ToggleGroup();
		RadioButton lijnButton = new RadioButton("Lijn");
		RadioButton rechtHButoon = new RadioButton("Rechthoek");
		RadioButton circleButton = new RadioButton("Circle");
		RadioButton penButton = new RadioButton("Pen");
		penButton.setSelected(true);

		group = new ToggleGroup();
		lijnButton.setToggleGroup(group);
		rechtHButoon.setToggleGroup(group);
		circleButton.setToggleGroup(group);
		penButton.setToggleGroup(group);
		
		//menubar setup
		Menu menuBestand = new Menu("Bestand");
		menuBar.getMenus().add(menuBestand);
		menu.getChildren().add(menuBar);
		menu.setPrefSize(430, 10);
		
		

		linkerHbox.setPadding(new Insets(15, 15, 15, 12));
		cp = new ColorPicker();
		cp.setStyle("-fx-indent:10px;");
		// cp.setWidth(100);
		r.setWidth(100);
		r.setHeight(30);
		r.setFill(cp.getValue());
		linkerHbox.setPrefSize(50, 120);
		rechterHbox.setPrefSize(120, 100);
		linkerHbox.setStyle("-fx-border-color: black;");
		rechterHbox.setStyle("-fx-border-color: black;");
		centerAlignVbox.getChildren().addAll(cp, r);
		kleurenPaneelVbox.getChildren().addAll(lijnButton, rechtHButoon, circleButton, penButton);
		linkerHbox.getChildren().addAll(centerAlignVbox);
		
		linkerHbox.setAlignment(Pos.BOTTOM_LEFT);
		rechterHbox.getChildren().add(kleurenPaneelVbox);
		getChildren().addAll(linkerHbox, tile, rechterHbox);

		cp.setOnAction(e -> r.setFill(cp.getValue()));
	}

	public static Color getColor() {
		return cp.getValue();
	}

	public static Toggle getChecked() {
		return group.getSelectedToggle();
	}
	public void getRekt(javafx.scene.input.MouseEvent e){
		Rectangle r1 = (Rectangle)e.getSource();
		cp.setValue((Color) r1.getFill());
		r.setFill((Color) r1.getFill());
		
	}
}
