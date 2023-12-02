package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LetturaFile {
	
	public static HashMap<String, String> LetturaConnDb() {
		HashMap<String, String>dati=new HashMap<String, String>();
		
		try {
			Scanner sc=new Scanner(new File("res/DbConf.txt"));
			while(sc.hasNext()) {
				String[] linea=sc.nextLine().split(";");
				dati.put(linea[0], linea[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("fine non trovato");
			// TODO: handle exception
		}
		return dati;
	}

}
