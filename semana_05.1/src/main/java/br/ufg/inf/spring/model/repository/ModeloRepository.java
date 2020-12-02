package br.ufg.inf.spring.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ufg.inf.spring.ctrl.model.entidades.Modelo;


public interface ModeloRepository extends JpaRepository<Modelo, Integer>{
	
	@Query("FROM Modelo m WHERE LOWER(m.nomeModelo) like %:searchTerm% ")
	Page<Modelo> search(@Param("searchTerm") String searchTerm, Pageable pageable);
}
