package model.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Modelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_modelo")
	private int modeloId;
	
	@Column(name="nome")
	private String nomeModelo;
	
	@ManyToOne
	@JoinColumn(name="id_fabi")
	private Fabricante fabricante;
	
	public Modelo() { }
	
	public Modelo(String nomeModelo, Fabricante fabricante) {
		super();
		this.nomeModelo = nomeModelo;
		this.fabricante = fabricante;
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
	@Override
	public String toString() {
		return "Modelo =" + nomeModelo;
	}
}
