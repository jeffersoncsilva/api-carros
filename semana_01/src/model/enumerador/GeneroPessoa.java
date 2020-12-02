package model.enumerador;

public enum GeneroPessoa {
	MASCULINO (1, "Masculino"),
	FEMININO(2, "Feminino");
	
	private int id;
	private String desc;
	
	private GeneroPessoa(int id, String sexo) {
		this.id = id;
		this.desc = sexo;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public String toString() { return this.desc; }
	
	
}
