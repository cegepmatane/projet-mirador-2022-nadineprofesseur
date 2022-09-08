package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Pokemon;

public class PokemonDAO {
	
	public Pokemon detaillerPokemon()
	{
		System.out.println("PokemonDAO.detaillerPokemon()");
		
		// (1) ALLER chercher le flux de données sur internet
		
		String URL_POKEMON = "https://pokeapi.co/api/v2/pokemon/ditto";
		String json = null;
		try {
			URL url = new URL(URL_POKEMON);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			json = lecteur.next();
			System.out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(json == null) return null;
		
		// (2) Parser les données recues en XML ou JSON

		Pokemon pokemon = new Pokemon();
		
		JsonParser parseur = new JsonParser();
		JsonObject document = parseur.parse(json).getAsJsonObject();
		
		int baseExperience = document.get("base_experience").getAsInt();
		System.out.println(baseExperience);
		pokemon.setExperience(baseExperience);
				
		return pokemon;
	}
	

}
