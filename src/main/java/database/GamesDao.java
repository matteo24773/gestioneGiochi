package database;

import java.sql.ResultSet;
import java.util.HashMap;

import model.Games;

public class GamesDao {
	
	//crud
	
	//create
	
	public static void add(HashMap<String, String> e) {
		String query="insert into games(titolo,url)value(?,?) ";
		String[] parametri= {e.get("titolo"),e.get("url")};
		Database.eseguiQuery(query,parametri);
	} 

	//read all games
	public static HashMap<Integer,Games> readAll() {
		String query="select* from games";
		HashMap<Integer, HashMap<String, Object>> dati=Database.eseguiQuery(query);
		HashMap<Integer,Games> games=new HashMap<Integer, Games>();
		for (int chiave : dati.keySet()) {
			Games game=new Games();
			game.setName((String) dati.get(chiave).get("titolo"));
			game.setUrl((String) dati.get(chiave).get("url_image"));
			games.put(chiave,game );
			
		}
		
		return games;
	}

}
