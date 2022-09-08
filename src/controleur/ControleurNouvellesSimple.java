package controleur;

import java.util.ArrayList;
import java.util.List;
import com.sun.media.jfxmedia.logging.Logger;
import architecture.Controleur;
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
		
		List<Nouvelle> nouvelles = new ArrayList<Nouvelle>();
		nouvelles.add(new Nouvelle("Java au Cegep", "Nadine"));
		nouvelles.add(new Nouvelle("La prof va vite", "Sebastien"));
		nouvelles.add(new Nouvelle("L'ide est bizarre","classe"));
		nouvelles.add(new Nouvelle("JAVA build pas","Raphael"));
		
		vue.afficherNouvelles(nouvelles);
		
	}

}
