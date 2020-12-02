package br.ufg.inf.spring.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ufg.inf.spring.ctrl.model.entidades.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
	
	@Query("FROM Carro c WHERE LOWER(c.cor) like %:searchTerm% ")
	Page<Carro> search(@Param("searchTerm") String searchTerm, Pageable pageable);
	
}
