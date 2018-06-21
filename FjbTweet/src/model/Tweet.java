package model;

public class Tweet {
	private String name;
	private String come;
	
	
	public Tweet(String name, String come) {
		super();
		this.name = name;
		this.come = come;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCome() {
		return come;
	}
	public void setCome(String come) {
		this.come = come;
	}

}
