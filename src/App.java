
import architecture.Controleur;
import architecture.Fenetre;
import vue.VueNouvellesSimple;
import vue.VuePokemon;

public class App {

	public static void main(String[] parametres) {
		Controleur.choisirVuePrincipale(VueNouvellesSimple.class);
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
