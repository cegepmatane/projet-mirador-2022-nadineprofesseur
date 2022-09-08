package vue;
import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurMirador;
public class VueMirador extends Vue {

	protected ControleurMirador controleur;
	protected static VueMirador instance = null; 
	public static VueMirador getInstance() {if(null==instance)instance = new VueMirador();return VueMirador.instance;}; 
	
	private VueMirador() 
	{
		super("mirador.fxml", VueMirador.class);
		super.controleur = this.controleur = new ControleurMirador();
		Logger.logMsg(Logger.INFO, "new VueMirador()");
	}
		
}
