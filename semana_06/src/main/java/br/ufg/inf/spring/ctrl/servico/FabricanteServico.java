package br.ufg.inf.spring.ctrl.servico;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ufg.inf.spring.ctrl.excecao.FabricanteException;
import br.ufg.inf.spring.ctrl.excecao.FabricanteNotFoundException;
import br.ufg.inf.spring.ctrl.model.entidades.Fabricante;
import br.ufg.inf.spring.ctrl.negocio.FabricanteNegocio;

@CrossOrigin
@RestController
@RequestMapping(value="/fabricantes")
public class FabricanteServico {

	@Autowired
	private FabricanteNegocio negocio;
	
	
	@GetMapping
	public ResponseEntity<List<Fabricante>> inicio() {
		List<Fabricante> list = negocio.listarTodosFabricantes();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Fabricante> findById(@PathVariable Integer id){		
		Fabricante ret = null;
		try {
			ret = negocio.pegarFabricantePorId(id);
			return ResponseEntity.ok(ret);
		} catch (FabricanteNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ret);	
		}
	}
	
	@PostMapping
	public ResponseEntity<Fabricante> insert(@RequestBody Fabricante fab){
		try {
			fab = negocio.inserirNovoFabricante(fab);
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/fabricantes/{id}").buildAndExpand(fab.getId()).toUri();
			return ResponseEntity.created(uri).body(fab);
		} catch (FabricanteException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(fab);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		try {
			negocio.apagarFabricantePorId(id);
			return ResponseEntity.noContent().build();
		} catch (FabricanteNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());	
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Fabricante> update(@PathVariable Integer id, @RequestBody Fabricante fab){
		try {
			fab = negocio.atualizarFabricante(fab);
			return ResponseEntity.ok().body(fab);
		} catch (FabricanteNotFoundException e) {			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fab);	
		} catch (FabricanteException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(fab);
		}
	}
}
