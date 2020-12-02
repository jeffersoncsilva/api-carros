package model.entidades.pessoas;

public class Pessoa {
	private int id;
	private String nome;
	private String endereco;
	
	public Pessoa(String n, String end, int id) {
		this.nome = n;
		this.endereco = end;
		this.id = id + 1;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int i) {
		this.id = i;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String end) {
		this.endereco = end;
	}
	
	public String toString() {
		return String.format("Nome: %s", this.nome);
	}
}
