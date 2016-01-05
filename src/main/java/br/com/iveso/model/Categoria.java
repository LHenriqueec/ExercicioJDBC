package br.com.iveso.model;

public enum Categoria {
	SOFTWARE('S'),
	MUSICA('M'),
	BAKUCP('B');
	
	private char categoria;
	
	Categoria(char c) {
		this.categoria = c;
	}
	
	@Override
	public String toString() {
		return String.valueOf(categoria);
	}
	
	public static Categoria getCategoria(char c) {
		for (Categoria categoria : values()) {
			if(categoria.toString().charAt(0) == c) {
				return categoria;
			}
		}
		return null;
	}
}
