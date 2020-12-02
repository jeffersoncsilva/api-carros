package br.ufg.inf.spring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.spring.ctrl.model.entidades.Modelo;


public interface ModeloRepository extends JpaRepository<Modelo, Integer>{

}
