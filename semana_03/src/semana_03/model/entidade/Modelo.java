package semana_03.model.entidade;

public class Modelo {
	private String nomeModelo;
	private int modeloId;
	private Fabricante fabricante;
	private int fabricanteId;
	
	public int getFabricanteId() {
		return fabricanteId;
	}

	public void setFabricanteId(int fabricanteId) {
		this.fabricanteId = fabricanteId;
	}

	public Modelo(String nomeModelo, int modeloId, Fabricante fabricante) {
		super();
		this.nomeModelo = nomeModelo;
		this.modeloId = modeloId;
		this.fabricante = fabricante;
	}
	
	public Modelo(String nomeModelo, int modeloId, int id) {
		super();
		this.nomeModelo = nomeModelo;
		this.modeloId = modeloId;
		this.fabricanteId = id;
	}
	
	
	public Modelo(String nome, int modelId) {
		this.nomeModelo = nome;
		this.fabricanteId = modelId;
	}
	
	public String getNomeModelo() {
		return nomeModelo;
	}
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	public int getModeloId() {
		return modeloId;
	}
	public void setModeloId(int modeloId) {
		this.modeloId = modeloId;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	
	@Override
	public String toString() {
		return "Modelo = " + nomeModelo + ", FabId: "+fabricanteId + ", Id: " + modeloId;
	}
	
	
	
}
