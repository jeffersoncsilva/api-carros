package model.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.enumerador.TipoCarro;

@Entity
public class Carro implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_carro")
	private int carId;
	
	@Column(name="tipo_carro")
	private TipoCarro tipo;
	
	@Column(name="placa")
	private String placa;
	
	@Column(name="ano")
	private int ano;
	
	@Column(name="cor")
	private String cor;
	
	@ManyToOne
	@JoinColumn(name="id_modelo")
	private Modelo modelo;

	public Carro() { }
	
	public Carro(String cor, String placa, int ano, TipoCarro tp, Modelo m) {
		this.cor = cor;
		this.placa = placa;
		this.ano = ano;
		this.tipo = tp;
		this.modelo = m;
	}
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
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
		return "Carro [carId=" + carId + ", tipo=" + tipo + ", placa=" + placa + ", ano=" + ano + ", cor=" + cor
				+ ", modelo=" + modelo + "]";
	}

	
	
	
}
