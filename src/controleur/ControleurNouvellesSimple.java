package controleur;

import java.util.ArrayList;
import java.util.List;
import com.sun.media.jfxmedia.logging.Logger;
import architecture.Controleur;
import donnee.NouvelleDAO;
import modele.Nouvelle;
import vue.VueNouvellesSimple;

public class ControleurNouvellesSimple extends Controleur {

	public ControleurNouvellesSimple()
	{
		Logger.logMsg(Logger.INFO, "new ControleurNouvelles()");
	}
	public void initialiser()
	{
		// VueNouvellesSimple.getInstance().afficherTotal();
		VueNouvellesSimple vue = VueNouvellesSimple.getInstance();
		vue.afficherTotal(3);
		
		NouvelleDAO dao = new NouvelleDAO();
		List<Nouvelle> nouvelles = dao.simulerListeNouvelles();
		vue.afficherNouvelles(nouvelles);
		
	}

}
