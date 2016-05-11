package Learning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import database.Database;

public class Bewertungsklasse extends JFrame implements ActionListener {
	// F�r Zufallskarte

	private static final long serialVersionUID = 1L;

	public static ArrayList<String> getShuffledCards(String query) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String[]> cards = Database.pullFromStock(query);
		ArrayList<Double> ZufallsZahl = new ArrayList<Double>();

		if (cards == null) {
			debug.Debugger.out("getData cards = null");
			return result;

		} else {

			for (String[] s : cards) {
				double rnd = (double) ((Math.random() * 50000) + 1);
				if (rnd == Double.parseDouble(s[0])) {
					debug.Debugger.out(s[0]);
					String data = s[0] + controls.Globals.SEPARATOR + s[1] + controls.Globals.SEPARATOR + s[2];
					result.add(data);
				}

			}

			// Gemischte liste wird zur�ck gegeben

			return result;

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Wenn richtig gedr�ckt wird z�hlt es Kartenpunkte + 1 und eine neue
		// "Karte" wird Angezeigt
		// if (e.getSource() == richtig) {
		// Zufallszieher.rdm = Zufallszieher.ziehen();
		// if (Kartenpunkte < 5) {
		// Kartenpunkte = Kartenpunkte + 1;
		// }
		// KartenPunkte.setText("Kartenpunkte : " +
		// Integer.toString(+Kartenpunkte));
		//
		// Zufallszieher.rdm++;
		//
		// // wenn zufallszahl kleiner oder gleich der h�chste eintrag der DB
		// // ist wird eine zuf�llige karte angezeit.
		// if (Zufallszieher.rdm <= Database.pullFromStock(boxName).size()) {
		// KartenAnzeigen.setText(Database.pullFromStock(boxName).get(Zufallszieher.rdm)[1]);
		// }
		// a = 1;
		// // Punkt der Karte wird auf 1 gesetzt n�chste karte erscheint
		// } else if (e.getSource() == falsch) {
		// Zufallszieher.rdm = Zufallszieher.ziehen();
		// if (Kartenpunkte >= 2) {
		//
		// KartenPunkte.setText("Kartenpunkte : " +
		// Integer.toString(Kartenpunkte));
		//
		// Zufallszieher.rdm = Zufallszieher.ziehen();
		// KartenAnzeigen.setText(Database.pullFromStock(boxName).get(Zufallszieher.rdm)[1]);
		// Kartenpunkte = 1;
		// a = 1;
		// }
		//
		// } else if (e.getSource() == Abbrechen) {
		// MainFrame.setVisible(false);
		// } else if (e.getSource() == dreheKarte) {
		//
		// a++;
		//
		// // dreht Karte auf l�sugs seite
		// if (a % 2 == 0) {
		// KartenAnzeigen.setText(Database.pullFromStock(boxName).get(Zufallszieher.rdm)[2]);
		// a++;
		// // sollte karte zur�ckdrehen
		// } else if (a % 2 != 0) {
		// KartenAnzeigen.setText(Database.pullFromStock(boxName).get(Zufallszieher.rdm)[1]);
		// a++;
		// }

		// }
	}
}
