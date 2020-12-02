package br.ufg.inf.spring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.spring.ctrl.model.entidades.Fabricante;

public interface FabricanteRepository  extends JpaRepository<Fabricante, Integer> {

}
