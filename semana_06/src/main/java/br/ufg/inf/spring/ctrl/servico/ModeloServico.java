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

import br.ufg.inf.spring.ctrl.excecao.ModeloException;
import br.ufg.inf.spring.ctrl.excecao.ModeloNotFoundException;
import br.ufg.inf.spring.ctrl.model.entidades.Modelo;
import br.ufg.inf.spring.ctrl.negocio.ModeloNegocio;
@CrossOrigin
@RestController
@RequestMapping(value="/modelos")
public class ModeloServico {	
	@Autowired
	private ModeloNegocio negocio;
		
	@GetMapping
	public ResponseEntity<List<Modelo>> inicio() {
		List<Modelo> list = negocio.listarTodosModelos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Modelo> findById(@PathVariable Integer id){
		Modelo ret;
		try {
			ret = negocio.buscarModeloPorId(id);
			return ResponseEntity.ok(ret);
		} catch (ModeloNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
		}
	}
	
	@PostMapping
	public ResponseEntity<Modelo> insert(@RequestBody Modelo model){
		try {
			model = negocio.insereNovoModelo(model);
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/modelos/{id}").buildAndExpand(model.getId()).toUri();
			return ResponseEntity.created(uri).body(model);
		} catch (ModeloException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(model);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		try {
			negocio.delete(id);
			return ResponseEntity.noContent().build();
		} catch (ModeloNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Modelo> update(@PathVariable Integer id, @RequestBody Modelo m){
		try {
			m = negocio.update(m);
			return ResponseEntity.ok().body(m);
		} catch (ModeloNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (ModeloException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(m);
		}
	}
}
