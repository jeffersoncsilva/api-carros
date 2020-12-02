package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.ctrl.model.entidades.Fabricante;
import br.ufg.inf.spring.model.repository.FabricanteRepository;

@Service
public class FabricanteNegocio {
	@Autowired
	private FabricanteRepository repo;
	
	public List<Fabricante> findAll(){
		return repo.findAll();
	}
	
	public Fabricante findById(Integer id) {
		Optional<Fabricante> ret = repo.findById(id);
		return ret.get();
	}
	
	public Fabricante insert(Fabricante f) {
		return repo.save(f);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Fabricante update(Fabricante m) {
		Fabricante fab = repo.getOne(m.getId());
		fab.setFabriNome(m.getFabriNome());
		return repo.save(fab);
	}
}
