package controleur;

import java.util.ArrayList;
import java.util.List;
import com.sun.media.jfxmedia.logging.Logger;
import architecture.Controleur;
import modele.Nouvelle;
import vue.VueNouvellesSimple;
import vue.VuePokemon;

public class ControleurPokemon extends Controleur {

	public ControleurPokemon()
	{
		Logger.logMsg(Logger.INFO, "new ControleurNouvelles()");
	}
	public void initialiser()
	{
		VuePokemon vue = VuePokemon.getInstance();
		
		vue.afficherPokemon();
		
	}

}
