package vue;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurNouvelles;

public class VueNouvelles extends Vue {

	protected ControleurNouvelles controleur = null;
	protected static VueNouvelles instance = null; 
	public static VueNouvelles getInstance() {if(null==instance)instance = new VueNouvelles();return VueNouvelles.instance;}; 

	private VueNouvelles() {
		super("nouvelles.fxml", VueNouvelles.class);
		Logger.logMsg(Logger.INFO, "new VueNouvelles()");
		super.controleur = this.controleur = new ControleurNouvelles();
	}
	

}
