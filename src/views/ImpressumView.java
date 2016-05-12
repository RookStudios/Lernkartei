package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mvc.Controller;
import mvc.FXView;

public class ImpressumView extends FXView
{
	/*
	 * Ich nehme mal an wir werden die Texte mit Labels anzeigen.
	 * Ich hab versucht den Hintergrund etwas heller zu machen nur einen kleinen Akzent.
	 * Ich habs nicht und versuche es bald mit css. Es ist aber noch nicht gekl�rt ob das 
	 * wirklich Labels sein sollten oder ob es was besseres gibt.
	 * 
	 *    -------
	 *   � To Do �
	 * 	  -------
	 * - Der Text sollte besser formatiert sein. (Andere Schrift)
	 * 
	 * - Der Hintergrund sollte ganz schwach heller sein,
	 *	 das Problem ist dass man bei Optionen vielleicht eine andere Farbe
	 *	 ausw�hlen kann als Hintergrund und wenn ich jetzt eine feste Farbe setzte
	 *   sieht es dann schr�g aus. Ich kann es ja nicht auf halb durchsichtig stellen.
	 *   
	 * - Das Formatieren k�nnte auch noch ein Problem sein. 
	 * 	 Mit \n kann man eine neue Zeile machen aber ich kenn die anderen nicht.
	 * 
	 */
	

	public ImpressumView(String newName, Controller newController) {
		// this constructor is the same for all view's
		super(newName, newController);
		construct();
	}

	@Override
	public Parent constructContainer() {
		// Buttons
		AppButton backBtn = new AppButton("Zur�ck");
		
		
		
		//Labels (f�r die Infotexte)
		Label labelTitel = new Label("Impressum");
		
		//Hier kommt der angezeigte Text hin:
		Label labelText = new Label("Name des Produkts:\nErsteller:\nRechte:\netc...");
		
		//Zeilenumbruch am Fensterrand
		labelText.setWrapText(true);

		//IDs f�r CSS
		labelTitel.setId("impressumtext");
		labelText.setId("impressumtext");

		//Damit der Text nicht bis zum Fensterrand geht sondern noch etwas abstand hat
		Double size = getController().getTheFXSettings().getOPTIMAL_WIDTH()*.95;
		size += 10;
		labelText.setPrefWidth(size);
		labelTitel.setPrefWidth(size);
		
		//Box f�r die Navigation
		HBox naviBox = new HBox(10);
		naviBox.getChildren().addAll(backBtn);
			
		//Box f�r Titel
		VBox TitelBox = new VBox(10);
		TitelBox.getChildren().addAll(labelTitel);
		TitelBox.setAlignment(Pos.CENTER);
				
		//Box f�r Mitte Text
		VBox BoxMitText = new VBox(20);
		BoxMitText.getChildren().addAll(labelText);
		BoxMitText.setAlignment(Pos.CENTER);
		
		// Behaviour
		backBtn.setOnAction(e -> getController().showMainView());
		
		// Layout
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(15));
		borderPane.setBottom(naviBox);
		borderPane.setCenter(BoxMitText);
		borderPane.setTop(TitelBox);
			
		
		// TODO Auto-generated method stub
		return borderPane;
	}

	@Override
	public void refreshView ()
	{
	}
}
