package model;

public class Games {
	private String name,url;

	public Games() {
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Games [name=" + name + ", url=" + url + "]";
	}

	
	

}
