package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Pokemon;

public class PokemonDAO extends ServiceDAO{
	
	public Pokemon detaillerPokemon(String nom)
	{
		System.out.println("PokemonDAO.detaillerPokemon()");
		
		// (1) ALLER chercher le flux de données sur internet
		
		String URL_POKEMON = "https://pokeapi.co/api/v2/pokemon/" + nom;
		String json = telechargerDonnees(URL_POKEMON);
		System.out.println(json);
		
		// (2) Parser les données recues en XML ou JSON

		Pokemon pokemon = new Pokemon();
		
		JsonParser parseur = new JsonParser();
		JsonObject document = parseur.parse(json).getAsJsonObject();
		
		int baseExperience = document.get("base_experience").getAsInt();
		System.out.println(baseExperience);
		pokemon.setExperience(baseExperience);
		
	    JsonArray listeMovesJson = document.get("moves").getAsJsonArray();
	    JsonObject moveJson = listeMovesJson.get(0).getAsJsonObject().get("move").getAsJsonObject();
	    String move = moveJson.get("name").getAsString();
	    System.out.println(move);
		return pokemon;
	}
	
	public List<Pokemon> listerPokemons()
	{
		System.out.println("PokemonDAO.listerPokemons()");
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		// (1) ALLER chercher le flux de données sur internet
		
		String URL_POKEMON = "https://pokeapi.co/api/v2/pokemon/";
		String json = telechargerDonnees(URL_POKEMON);

		// (2) Parser les données recues en XML ou JSON

		JsonParser parseur = new JsonParser();
		JsonObject document = parseur.parse(json).getAsJsonObject();
		JsonArray resultatsJson = document.get("results").getAsJsonArray();
		
		for(JsonElement pokemonElement : resultatsJson)
		{
			JsonObject pokemonJson = pokemonElement.getAsJsonObject();
			
			String nom = pokemonJson.get("name").getAsString();
			System.out.println(nom);

			String url = "";
			if(pokemonJson.get("url") != null)
			{
				url = pokemonJson.get("url").getAsString();			
			}
			
			Pokemon pokemon = new Pokemon();
			pokemon.setNom(nom);
			pokemon.setUrl(url);
			pokemons.add(pokemon);
		}
		
		return pokemons;
	}
	

}
