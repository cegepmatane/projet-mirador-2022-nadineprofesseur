package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ServiceDAO {

	public String telechargerDonnees(String hyperlien)
	{
		String xml = null;
		try {
			URL url = new URL(hyperlien);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			
			lecteur.useDelimiter("\\A");
			xml = lecteur.next();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(xml == null) return null;
		return xml;
	}	
}
