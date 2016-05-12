package controls;

import javafx.stage.Stage;
import models.QuizletModel;
import mvc.Controller;
import mvc.FXSettings;

/**
 * 
 * @author miro
 *
 */
public class QuizletController extends Controller
{
	public QuizletController ()
	{
		super(new Stage(), new FXSettings());
	}

	@Override
	public void initMyModels() {
		this.addUniqueModel(new QuizletModel("quizlet"));
	}

	@Override
	public void initMyViews() {
		
	}


}
