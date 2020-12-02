package br.ufg.inf.spring.ctrl.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ufg.inf.spring.model.enumerador.TipoCarro;

@Entity
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_carro")
	private int id;
	
	@Column(name="ano")
	private int ano;
	
	@Column(name="cor")
	private String cor;
	
	@Column(name="tipo_carro")
	private TipoCarro tipo;
	
	@Column(name="placa")
	private String placa;
	
	@ManyToOne
	@JoinColumn(name="id_modelo")
	private Modelo modelo;
	
	public boolean estaValido() {
		return modelo != null && placa.length() >= 6 && placa.length() <= 7 && ano >= 0 &&  cor.length() > 0 && tipo != null;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	@Override
	public String toString() {
		return "Carro [id=" + id + ", ano=" + ano + ", cor=" + cor + ", modelo=" + modelo + ", tipo=" + tipo
				+ ", placa=" + placa + "]";
	}
	
	
}
