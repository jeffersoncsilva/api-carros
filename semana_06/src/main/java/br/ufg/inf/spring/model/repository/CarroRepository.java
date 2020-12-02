package br.ufg.inf.spring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.spring.ctrl.model.entidades.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
