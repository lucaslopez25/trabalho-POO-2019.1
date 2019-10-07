package entidades;

public class Rgb extends Pigmento {
	private int red;
	private int green;
	private int blue;
	
	public Rgb() {
		super();
	}
	
	public Rgb (int r, int g, int b) {
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	
	public Rgb(String id, String nome, double litros, double preco,int r, int g, int b) {
		super(id, nome, litros, preco);
		this.red = r;
		this.green = g;
		this.blue = b;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}
}
