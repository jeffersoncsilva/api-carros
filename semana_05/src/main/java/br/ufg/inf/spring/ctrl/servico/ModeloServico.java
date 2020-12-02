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

import br.ufg.inf.spring.ctrl.model.entidades.Modelo;
import br.ufg.inf.spring.ctrl.negocio.ModeloNegocio;

@RestController
@RequestMapping(value="/modelos")
public class ModeloServico {
	@Autowired
	private ModeloNegocio negocio;
	
	
	@GetMapping
	public ResponseEntity<List<Modelo>> inicio() {
		List<Modelo> list = negocio.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Modelo> findById(@PathVariable Integer id){
		Modelo ret = negocio.findById(id);
		return ResponseEntity.ok(ret);
	}
	
	@PostMapping
	public ResponseEntity<Modelo> insert(@RequestBody Modelo model){
		model = negocio.insert(model);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/modelos/{id}").
				buildAndExpand(model.getId()).toUri();
		return ResponseEntity.created(uri).body(model);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		negocio.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Modelo> update(@PathVariable Integer id, @RequestBody Modelo m){
		m = negocio.update(m);
		return ResponseEntity.ok().body(m);
	}
}
