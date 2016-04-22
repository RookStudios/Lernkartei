package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.MainController;


/**
 * Startet die Lernkartei
 * 
 * @author miro-albrecht
 *
 */
public class WISSLearnCards extends Application
{

	public static void main (String[] args)
	{
		launch(args);
	}

	@Override
	public void start (Stage primaryStage) throws Exception
	{
		new MainController(primaryStage);
	}

}