package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public List<Nouvelle> listerNouvellesSport()
	{
		System.out.println("NouvelleDAO.listerNouvelles()");
		List<Nouvelle> nouvelles = new ArrayList<Nouvelle>();
		
		// (1) ALLER chercher le flux de données sur internet
		
		String URL_NOUVELLES_SPORT = "https://www.cbc.ca/cmlink/rss-sports-nhl";
		String xml = null;
		try {
			URL url = new URL(URL_NOUVELLES_SPORT);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			xml = lecteur.next();
			System.out.println(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(xml == null) return null;
		
		
		
		return nouvelles;
	}
	

}
