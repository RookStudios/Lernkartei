package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.MainController;


/**
 * Optionen
 * 
 * @author miro-albrecht
 *
 */
public class OptionsView
{
	Stage	window;
	Scene	scene;

	public OptionsView (Stage primaryStage, MainController controller)
	{
		window = primaryStage;

		// Contorls (Sample)
		Button resetStats = new Button("Statistiken zur�cksetzten");
		CheckBox enableSound = new CheckBox("Audio");
		ColorPicker col = new ColorPicker();
		Button applyColor = new Button("Farbe speichern");

		// Setzt maximale Breite (ArrayList m�glich)
		Button back = new Button("Zur�ck");
		resetStats.setMaxWidth(200);
		enableSound.setMaxWidth(200);
		col.setMaxWidth(200);
		applyColor.setMaxWidth(200);
		back.setMaxWidth(200);

		// Erstellt Layout
		VBox tempVBox = new VBox();
		tempVBox.setPadding(new Insets(10));
		tempVBox.setSpacing(10);
		tempVBox.setAlignment(Pos.CENTER);
		tempVBox.getChildren().addAll(resetStats, enableSound, col, applyColor, back);

		// Setzt Verhalten
		// TODO Design 100% auslagern
		applyColor.setOnAction(e -> {
			if (col.getValue().getBrightness() < 0.6)
			{
				enableSound.setStyle("-fx-text-fill: white");
			}
			else
			{
				enableSound.setStyle("-fx-text-fill: black");
			}
			tempVBox.setStyle("-fx-background-color: rgb("
					+ col.getValue().getRed() * 255 + ","
					+ col.getValue().getGreen() * 255 + ","
					+ col.getValue().getBlue() * 255 + ")");
		});

		// Behaviour
		back.setOnAction(e -> controller.showMain());

		scene = new Scene(tempVBox, 800, 450);
	}

	public void show ()
	{
		window.setScene(scene);
	}
}