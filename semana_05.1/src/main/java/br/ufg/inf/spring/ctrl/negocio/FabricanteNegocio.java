package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.ufg.inf.spring.ctrl.excecao.FabricanteException;
import br.ufg.inf.spring.ctrl.excecao.FabricanteNotFoundException;
import br.ufg.inf.spring.ctrl.model.entidades.Fabricante;
import br.ufg.inf.spring.model.repository.FabricanteRepository;

@Service
public class FabricanteNegocio {
	@Autowired
	private FabricanteRepository repo;
	
	public List<Fabricante> listarTodosFabricantes(){
		return repo.findAll();
	}
	
	public Fabricante pegarFabricantePorId(Integer id) throws FabricanteNotFoundException{
		Optional<Fabricante> ret = repo.findById(id);
		if(!ret.isPresent())
			throw new FabricanteNotFoundException("Fabricante com id " + id +"não encontrado.");
		return ret.get();
	}
	
	public Fabricante inserirNovoFabricante(Fabricante f) throws FabricanteException {
		return this.insereOuAtualizaFabricante(f);
	}
	
	public void apagarFabricantePorId(Integer id) throws FabricanteNotFoundException {
		Optional<Fabricante> fabi = repo.findById(id);
		if(fabi.isPresent())			
			repo.deleteById(id);
		else
			throw new FabricanteNotFoundException("Fabricante não encontrado.");
	}
	
	public Fabricante atualizarFabricante(Fabricante m) throws FabricanteNotFoundException, FabricanteException{
		Optional<Fabricante> fab = repo.findById(m.getId());
		if(!fab.isPresent())
			throw new FabricanteNotFoundException("Fabricante com id " + m.getId()+"não encontrado.");
		Fabricante fabUpd = fab.get();
		fabUpd.setFabriNome(m.getFabriNome());
		
		return this.insereOuAtualizaFabricante(fabUpd);
	}
	
	private Fabricante insereOuAtualizaFabricante(Fabricante fab) throws FabricanteException {
		if(fab.getFabriNome().length() == 0)
			throw new FabricanteException("Fabricante sem nome.");
		return repo.save(fab);
	}
	
	public Page<Fabricante> search(String searchTerm, int page, int size, String order, String active){
		PageRequest pageRequest = PageRequest.of(page, size, (order.contentEquals("desc"))?Sort.Direction.DESC : Sort.Direction.ASC, active);
		return repo.search(searchTerm.toLowerCase(), pageRequest);
	}

}