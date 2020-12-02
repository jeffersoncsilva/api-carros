package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.ctrl.excecao.ModeloException;
import br.ufg.inf.spring.ctrl.excecao.ModeloNotFoundException;
import br.ufg.inf.spring.ctrl.model.entidades.Modelo;
import br.ufg.inf.spring.model.repository.ModeloRepository;

@Service
public class ModeloNegocio {
	@Autowired
	private ModeloRepository repo;
	
	public List<Modelo> listarTodosModelos(){
		return repo.findAll();
	}
	
	public Modelo buscarModeloPorId(Integer id) throws ModeloNotFoundException{
		Optional<Modelo> ret = repo.findById(id);
		if(ret.isPresent())
			return ret.get();
		else
			throw new ModeloNotFoundException("Modelo com id " + id + " não foi encontrado.");
	}
	
	public Modelo insereNovoModelo(Modelo m) throws ModeloException {
		return this.insereOuAtualizaModelo(m);
	}
	
	public void delete(Integer id) throws ModeloNotFoundException {
		Optional<Modelo> mod = repo.findById(id);
		if(mod.isPresent()) {
			Modelo m = mod.get();
			m.setFabricante(null);
			repo.delete(m);
		}
		else {
			throw new ModeloNotFoundException("Modelo não foi encontrado.");
		}
	}
	
	public Modelo update(Modelo m) throws ModeloNotFoundException, ModeloException {
		Optional<Modelo> mod = repo.findById(m.getId());
		if(mod.isPresent()) {
			Modelo model = repo.getOne(m.getId());
			model.setNomeModelo(m.getNomeModelo());
			model.setFabricante(m.getFabricante());
			return repo.save(model);			
		}else {
			throw new ModeloNotFoundException("Modelo não foi encontrado. Não é possivel atualizar.");
		}
			
	}
	
	private Modelo insereOuAtualizaModelo(Modelo m) throws ModeloException {
		if(m.getFabricante() == null || m.getNomeModelo().length() == 0)
			throw new ModeloException("Dados modelos incorreto. Não é possível cadastrar modelo.");
		else {
			return repo.save(m);
		}
	}
}
