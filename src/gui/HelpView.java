package gui;

import application.Constants;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Hilfefenster
 * 
 * @author miro-albrecht
 *
 */
public class HelpView extends View
{

	public HelpView (String setName)
	{
		super (setName, new Stage(), null);
		
		Image helpdesk = new Image("gui/pictures/helpdesk.jpg", true);

		ImageView view = new ImageView(helpdesk);

		VBox center = new VBox();
		center.setAlignment(Pos.CENTER);
		center.getChildren().add(view);

		this.getWindow().setTitle("Lernkartei Hilfe [Alpha]");
		this.getWindow().setResizable(false);
		this.setScene(new Scene(center, Constants.OPTIMAL_WIDTH, 150+Constants.OPTIMAL_HEIGHT));
	}

	@Override
	public void refreshView() {
		// TODO Auto-generated method stub
		
	}
	
}
