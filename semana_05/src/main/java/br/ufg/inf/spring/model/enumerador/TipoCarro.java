package br.ufg.inf.spring.model.enumerador;

public enum TipoCarro {
	SEDAN(1, "Sedan"),
	HATCH(2, "Hatch"),
	PIC_UP(2, "Pic-up");
	
	private int id;
	private String desc;
	
	public int getId() {
		return id;
	}
	public String getDesc() {
		return desc;
	}
	
	private TipoCarro(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String toString() {
		return this.desc;
	}
	
	public static TipoCarro fomId(int id) {
		switch (id) {
			case 1: 
				return SEDAN;
			case 2: 
				return HATCH;
			case 3:
				return PIC_UP;
		}
		return SEDAN;
	}
}
