package database;

import java.sql.ResultSet;
import java.util.HashMap;

import model.Games;

public class GamesDao {

	private static GamesDao instance;

	private GamesDao() {
	}

	public static GamesDao getInstance() {
		if(instance == null) 
			instance = new GamesDao();
		return instance;
	}
	
	//crud
	
	//create
	
	public void add(HashMap<String, String> e) {
		String query="insert into games(titolo,url_image)values(?,?) ";
		String[] parametri= {e.get("titolo"),e.get("url_image")};
		Database.getInstance().eseguiQuery(query,parametri);
	} 

	//read all games
	public HashMap<Integer,Games> readAll() {
		String query="select* from games";
		HashMap<Integer, HashMap<String, Object>> dati=Database.getInstance().letturaDb(query);
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
