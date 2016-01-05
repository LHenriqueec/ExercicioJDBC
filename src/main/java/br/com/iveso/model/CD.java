package br.com.iveso.model;

public class CD {
	private int id;
	private String nome;
	private Categoria categoria;
	private String conteudo;
	
	public CD(String nome, Categoria categoria, String conteudo) {
		id = 0;
		this.nome = nome;
		this.categoria = categoria;
		this.conteudo = conteudo;
	}
	
	public CD(int id, String nome, Categoria categoria, String conteudo) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.conteudo = conteudo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public String toString() {
		return "ID: "  + id
				+"\nNOME: " + nome
				+"\nCATEGORIA: " + categoria
				+"\nCONTEUDO: " + conteudo
				+ "\n========================\n";
	}
	
}
