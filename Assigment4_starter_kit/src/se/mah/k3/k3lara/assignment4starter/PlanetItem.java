package se.mah.k3.k3lara.assignment4starter;

public class PlanetItem {
	
	String name;
	int img;
	
	public PlanetItem(String name, int img) {
		super();
		this.name = name;
		this.img = img;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
