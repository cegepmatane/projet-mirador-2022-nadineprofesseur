package donnee;

import java.io.ByteArrayInputStream;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
		//String URL_NOUVELLES_SPORT = "https://www.theguardian.com/sport/blog/rss";
		
		ServiceDAO dao = new ServiceDAO();
		String xml = dao.telechargerDonnees(URL_NOUVELLES_SPORT);
		
		// (2) Parser les données recues en XML ou JSON
		
		try {
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parseur.parse(new ByteArrayInputStream(xml.getBytes()));
			
			// String titreFil = document.getElementsByTagName("title").item(0).getTextContent();
			// System.out.println(titreFil);
			
			NodeList itemsXML = document.getElementsByTagName("item");
			// Node firstItemXML = itemsXML.item(0);
			// String firstItem = firstItemXML.getTextContent();
			// System.out.println(firstItem);
			
			for(int position = 0; position < itemsXML.getLength(); position++)
			{
				// NodeList linksXML = itemXML.getElementsByTagName("link");
				// Element linkXML = (Element)linksXML.item(0);
				// String lien = linkXML.getTextContent();
				
				Element itemXML = (Element)itemsXML.item(position);
				System.out.println("============= nouvel ITEM =================");
				
				String titre = itemXML.getElementsByTagName("title").item(0).getTextContent();
				System.out.println(titre);
				String lien = itemXML.getElementsByTagName("link").item(0).getTextContent();
				System.out.println(lien);			
				String description = itemXML.getElementsByTagName("description").item(0).getTextContent();
				System.out.println(description);
				String date = itemXML.getElementsByTagName("pubDate").item(0).getTextContent();
				System.out.println(date);
				
				// TODO - recuperer contenu de <dc:creator>
				// String auteur = itemXML.getElementsByTagNameNS("dc", "creator").item(0).getTextContent();
				// System.out.println(auteur);
				
				Nouvelle nouvelle = new Nouvelle();
				nouvelle.setTexte(description);
				nouvelle.setTitre(titre);
				nouvelle.setLien(lien);
				
				nouvelles.add(nouvelle);
								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return nouvelles;
	}
	

}
