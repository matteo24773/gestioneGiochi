package model;

public class Teams {
	private String nome,nazione;
	public Teams() {}

	public Teams(String nome, String nazione) {
		super();
		this.nome = nome;
		this.nazione = nazione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
	

}
