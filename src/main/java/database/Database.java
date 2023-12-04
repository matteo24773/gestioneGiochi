package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.xdevapi.PreparableStatement;

import utility.LetturaFile;

public class Database {
	
	
	private static Database instance;


	private Database() {
		openConnection();
	}
	
	
	protected static Database getInstance() {
		if(instance == null)
			instance = new Database();
		return instance;
	}
	
	private static Connection conn;
	
	private static Connection getConnection() {
		if(conn==null) {
			openConnection();
		}
		return conn;
	}
	private static void openConnection() {
		HashMap<String, String>dati=LetturaFile.LetturaConnDb();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =DriverManager.getConnection(dati.get("percorso"),dati.get("user"),dati.get("pass"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("errore durante la connesione");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("errore:classe non trovato");
		}
	}
	public static void closeConnection() {
		try {
			if (conn!=null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("errore durante la chiusura");
		}
		
	}
	private static void closeItem(PreparedStatement ps,ResultSet rs) {
		try {
			if (ps!=null) {
				ps.close();
			}
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("errore durante le chiusure degli item");
		}
		
	}
	public HashMap<Integer, HashMap<String, Object>> eseguiQuery(String query,String...parametri) {
		HashMap<Integer, HashMap<String, Object>> dati=new HashMap<Integer, HashMap<String, Object>>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=getConnection().prepareStatement(query);
			for(int i=0;i<parametri.length;i++) {
				ps.setString(i+1, parametri[i]);
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				dati.put(rs.getInt(1),new  HashMap<String, Object>());
				for(int i=2;i<=rs.getMetaData().getColumnCount();i++) {
					dati.get(rs.getInt(1)).put(rs.getMetaData().getColumnLabel(i), rs.getObject(i));
					}
				}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeItem(ps, rs);
		}
		return dati;
	}
	

}
