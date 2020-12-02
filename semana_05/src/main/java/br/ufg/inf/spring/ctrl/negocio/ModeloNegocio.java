package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.ctrl.model.entidades.Modelo;
import br.ufg.inf.spring.model.repository.ModeloRepository;

@Service
public class ModeloNegocio {
	@Autowired
	private ModeloRepository repo;
	
	public List<Modelo> findAll(){
		return repo.findAll();
	}
	
	public Modelo findById(Integer id) {
		Optional<Modelo> ret = repo.findById(id);
		return ret.get();
	}
	
	public Modelo insert(Modelo m) {
		return repo.save(m);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Modelo update(Modelo m) {
		Modelo model = repo.getOne(m.getId());
		model.setNomeModelo(m.getNomeModelo());
		return repo.save(model);
	}
}
