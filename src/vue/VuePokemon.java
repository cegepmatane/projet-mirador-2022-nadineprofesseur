package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurNouvellesSimple;
import controleur.ControleurPokemon;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import modele.Nouvelle;

public class VuePokemon extends Vue {
	String MESSAGE_TOTAL_NOUVELLES = "Il y a {total} nouvelles";

	protected ControleurPokemon controleur = null;
	protected static VuePokemon instance = null; 
	public static VuePokemon getInstance() {if(null==instance)instance = new VuePokemon();return VuePokemon.instance;}; 

	private VuePokemon() {
		super("pokemon.fxml", VuePokemon.class);
		Logger.logMsg(Logger.INFO, "new VuePokemon()");
		super.controleur = this.controleur = new ControleurPokemon();
	}
	
	// credit https://www.vecteezy.com/vector-art/141969-set-icon-characters-of-pokemon
	public void afficherPokemon()
	{
		System.out.println("VuePokemon.afficherPokemon()");
		
		ImageView vuePhoto = (ImageView)lookup("#pokemon-photo");
		// pokemon-1.png
		// <Image url="@decoration/pokemon/pokemon-1.png" />
		
		
		
	}
	
	
}
