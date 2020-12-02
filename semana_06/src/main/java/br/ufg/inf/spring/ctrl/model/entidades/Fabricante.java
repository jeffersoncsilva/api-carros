package br.ufg.inf.spring.ctrl.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fabricante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_fabi")
	private Integer id;
	
	@Column(name="fabricante_nome")
	private String fabriNome;
	
	public Fabricante(String fabriNome) {
		this.fabriNome = fabriNome;
	}
	
	public Fabricante() { }
	
	public String getFabriNome() {
		return fabriNome;
	}
	public void setFabriNome(String fabriNome) {
		this.fabriNome = fabriNome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer fabId) {
		this.id = fabId;
	}
	
	@Override
	public String toString() {
		return "Fabricante [fabriNome=" + fabriNome + ", fabId=" + id + "]";
	}
}
