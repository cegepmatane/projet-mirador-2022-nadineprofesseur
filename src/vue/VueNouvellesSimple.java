package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurNouvellesSimple;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import modele.Nouvelle;

public class VueNouvellesSimple extends Vue {
	String MESSAGE_TOTAL_NOUVELLES = "Il y a {total} nouvelles";

	protected ControleurNouvellesSimple controleur = null;
	protected static VueNouvellesSimple instance = null; 
	public static VueNouvellesSimple getInstance() {if(null==instance)instance = new VueNouvellesSimple();return VueNouvellesSimple.instance;}; 

	private VueNouvellesSimple() {
		super("nouvelles-simple.fxml", VueNouvellesSimple.class);
		Logger.logMsg(Logger.INFO, "new VueNouvelles()");
		super.controleur = this.controleur = new ControleurNouvellesSimple();
	}
	
	public void afficherTotal(int total)
	{
		System.out.println("VueNouvellesSimple.afficherTotal()");
		
		Label vueTotal = (Label)lookup("#total-nouvelles");
		System.out.println(vueTotal);
		
		//vueTotal.setText("Coucou");
		
		vueTotal.setText("Il y a " + total + " nouvelles");
		
		//vueTotal.setText(MESSAGE_TOTAL_NOUVELLES.replace("{total}", ""+total));
	}
	
	public void afficherNouvelles(List<Nouvelle> nouvelles)
	{
		System.out.println("VueNouvellesSimple.afficherNouvelles()");
		
		FlowPane vueNouvelles = (FlowPane)lookup("#liste-nouvelles");
		
		//TextArea nouvelleTest = new TextArea();
		//nouvelleTest.setText("test de nouvelle");
		//vueNouvelles.getChildren().add(nouvelleTest);
		
		for(Nouvelle nouvelle : nouvelles)
		{
			TextArea vueNouvelle = new TextArea();
			vueNouvelle.setText(nouvelle.getTitre());
			vueNouvelles.getChildren().add(vueNouvelle);
		}
		
		
	}
	
	
}
