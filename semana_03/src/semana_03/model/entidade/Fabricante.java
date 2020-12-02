package semana_03.model.entidade;

public class Fabricante {
	private String fabriNome;
	private int fabId;
	
	public Fabricante(String fabriNome, int fabId) {
		super();
		this.fabriNome = fabriNome;
		this.fabId = fabId;
	}
	
	public Fabricante(String nome) {
		this.fabriNome = nome;
	}
	
	public String getFabriNome() {
		return fabriNome;
	}
	public void setFabriNome(String fabriNome) {
		this.fabriNome = fabriNome;
	}
	public int getFabId() {
		return fabId;
	}
	public void setFabId(int fabId) {
		this.fabId = fabId;
	}
	
	@Override
	public String toString() {
		return "Fabricante [fabriNome=" + fabriNome + ", fabId=" + fabId + "]";
	}
}
