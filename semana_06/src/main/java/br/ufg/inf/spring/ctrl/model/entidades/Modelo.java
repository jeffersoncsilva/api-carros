package br.ufg.inf.spring.ctrl.model.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private int id;
	
	@Column(name="nome")
	private String nomeModelo;
	
	//@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
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
	public int getId() {
		return id;
	}
	public void setId(int modeloId) {
		this.id = modeloId;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Modelo =" + nomeModelo;
	}
}
