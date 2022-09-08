package donnee;

import java.util.ArrayList;
import java.util.List;

import modele.Nouvelle;

public class NouvelleDAO {
	
	
	public List<Nouvelle> simulerListeNouvelles()
	{
		List<Nouvelle> nouvelles = new ArrayList<Nouvelle>();
		nouvelles.add(new Nouvelle("Java au Cegep", "Nadine"));
		nouvelles.add(new Nouvelle("La prof va vite", "Sebastien"));
		nouvelles.add(new Nouvelle("L'ide est bizarre","classe"));
		nouvelles.add(new Nouvelle("JAVA build pas","Raphael"));
		
		return nouvelles;
	}
	

}
