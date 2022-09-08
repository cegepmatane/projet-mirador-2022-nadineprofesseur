package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modele.Nouvelle;

public class NouvelleDAO {


	public String stripNonValidXMLCharacters(String in) {
	    StringBuffer out = new StringBuffer(); // Used to hold the output.
	    char current; // Used to reference the current character.

	    if (in == null || ("".equals(in))) return ""; // vacancy test.
	    for (int i = 0; i < in.length(); i++) {
	        current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
	        if ((current == 0x9) ||
	            (current == 0xA) ||
	            (current == 0xD) ||
	            ((current >= 0x20) && (current <= 0xD7FF)) ||
	            ((current >= 0xE000) && (current <= 0xFFFD)) ||
	            ((current >= 0x10000) && (current <= 0x10FFFF)))
	            out.append(current);
	    }
	    return out.toString();
	} 	
	
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
		
		//String URL_NOUVELLES_SPORT = "https://www.cbc.ca/cmlink/rss-sports-nhl";
		String URL_NOUVELLES_SPORT = "https://www.theguardian.com/sport/blog/rss";
		String xml = null;
		try {
			URL url = new URL(URL_NOUVELLES_SPORT);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			xml = lecteur.next();
			xml = stripNonValidXMLCharacters(xml);
			//System.out.println(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(xml == null) return null;
		
		// (2) Parser les données recues en XML ou JSON
		
		try {
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			@SuppressWarnings("deprecation")
			Document document = parseur.parse(new StringBufferInputStream(xml));
			
			//NodeList itemsXML = document.getElementsByTagName("item");
			//Node firstItemXML = itemsXML.item(0);
			//String firstItem = firstItemXML.getTextContent();
			//System.out.println(firstItem);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return nouvelles;
	}
	

}
