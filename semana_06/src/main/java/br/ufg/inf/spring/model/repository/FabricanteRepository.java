package br.ufg.inf.spring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.ufg.inf.spring.ctrl.model.entidades.Fabricante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FabricanteRepository  extends JpaRepository<Fabricante, Integer> {

	//@Query("FROM Fabricante f WHERE LOWER(f.fabricante_nome) like %:searchTerm%")
	//Page<Fabricante> search(@Param("searchTerm") String searchTerm, Pageable pageable);
}
