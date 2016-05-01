package application;

import gui.*;
import models.*;
import mvc.Controller;
/**
 * Diese Klasse Kontrolliert alle Sichten und Models. Den Sichten wird die
 * Navigation zur Verf�gung gestellt. Alle Sichten (ausser Modalfenster) werden
 * hier mit eindeutigen Namen versehen.
 * 
 * @author miro albrecht & hugo-lucca
 *
 */
public class MainController extends Controller
{
	@Override
	public void initMyModels() {
		this.addUniqueModel(new GameModel("game"));
		this.addUniqueModel(new DoorModel("door"));
		this.addUniqueModel(new BoxModel("box"));
		this.addUniqueModel(new CardModel("cards"));
	}

	@Override
	public void initMyViews() {
		this.addUniqueView(new MainView(getMainView(), this));
		this.addUniqueView(new StatisticsView("statisticsview", this));
		this.addUniqueView(new DoorView("doorview", this));
		this.addUniqueView(new OptionsView("optionsview", this));
		this.addUniqueView(new HelpView("helpview"));
		this.addUniqueView(new GameView("gameview", this));
		this.addUniqueView(new KarteiView("karteiview", this));
		this.addUniqueView(new BoxView("boxview", this));
		this.addUniqueView(new EditorView("editorview", this));
		this.addUniqueView(new ImpressumView("impressumview", this));
	}
}
