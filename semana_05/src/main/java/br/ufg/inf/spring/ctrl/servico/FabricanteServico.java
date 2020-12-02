package br.ufg.inf.spring.ctrl.servico;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ufg.inf.spring.ctrl.model.entidades.Fabricante;
import br.ufg.inf.spring.ctrl.negocio.FabricanteNegocio;

@RestController
@RequestMapping(value="/fabricantes")
public class FabricanteServico {

	@Autowired
	private FabricanteNegocio negocio;
	
	
	@GetMapping
	public ResponseEntity<List<Fabricante>> inicio() {
		List<Fabricante> list = negocio.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Fabricante> findById(@PathVariable Integer id){
		Fabricante ret = negocio.findById(id);
		return ResponseEntity.ok(ret);
	}
	
	@PostMapping
	public ResponseEntity<Fabricante> insert(@RequestBody Fabricante fab){
		fab = negocio.insert(fab);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/fabricantes/{id}").
				buildAndExpand(fab.getId()).toUri();
		return ResponseEntity.created(uri).body(fab);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		negocio.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Fabricante> update(@PathVariable Integer id, @RequestBody Fabricante fab){
		fab = negocio.update(fab);
		return ResponseEntity.ok().body(fab);
	}
}
