package model.enumerador;

public enum TipoConta {
	SIMPLES(1, "Simples"),
	EXECUTIVA(2, "Executiva"),
	PREMIUM(3, "Premium"),
	PERSONALITE(4, "Personalite");
	
	private int id;
	private String desc;
	
	private TipoConta(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public int getId() { return this.id; }
	public String getDesc() { return this.desc; }
	public String toString() { return this.desc; }
}
