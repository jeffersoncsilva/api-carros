package semana_03.model.entidade;

import semana_03.model.enumerador.TipoCarro;

public class Carro {
	private int carId;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}

	private TipoCarro tipo;
	private String placa;
	private int ano;
	private String cor;
	private Modelo modelo;
	private int modeloId;
	
	public Carro(TipoCarro tipo, String placa, int ano, String cor, Modelo modelo) {
		super();
		this.tipo = tipo;
		this.placa = placa;
		this.ano = ano;
		this.cor = cor;
		this.modelo = modelo;
	}
	public Carro(TipoCarro tipo, String placa, int ano, String cor, int modeloId) {
		super();
		this.tipo = tipo;
		this.placa = placa;
		this.ano = ano;
		this.cor = cor;
		this.modeloId = modeloId;
	}

	public int getModeloId() {
		return modeloId;
	}
	public void setModeloId(int modeloId) {
		this.modeloId = modeloId;
	}
	public TipoCarro getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Carro [tipo=" + tipo + ", placa=" + placa + ", ano=" + ano + ", cor=" + cor + ", modeloId=" + modeloId
				+ "]";
	}
	
	
	
	
}
