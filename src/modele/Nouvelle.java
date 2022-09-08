package modele;

public class Nouvelle {
	
	protected String titre;
	protected String auteur;
	protected String date;
	protected String texte;
	
	public Nouvelle(String titre, String auteur) {
		super();
		this.titre = titre;
		this.auteur = auteur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	

}
