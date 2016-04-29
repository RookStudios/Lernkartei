package scrollyv8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;


public class Audio {
	
	private String fileName = "";
	public javazoom.jl.player.Player pl;
	public Audio (String file) {
		
		fileName = file;
		
	}

	/**
	 * Standartm�ssig ist der Pfad folgendermassen: Ordner Sounds / Audiofiles
	 * 
	 * @param fileName
	 *            --> Name des Files dass du abspielen willst
	 */

	public void playAudio () {

		String fullPath = debug.Environment.getUserPath()
				+ "\\git\\Lernkartei\\Sounds\\Audiofiles\\"
				+ fileName;

		try {

			FileInputStream in = new FileInputStream(fullPath);

			pl = new javazoom.jl.player.Player(in);
			pl.play();
			pl.close();

		}
		catch (JavaLayerException jle) {

			jle.printStackTrace();

		}
		catch (FileNotFoundException fnf) {

			fnf.printStackTrace();

		}

	}
	
	public void stopAudio (Audio aud) {
		
		aud.pl.close();
		
	}

}