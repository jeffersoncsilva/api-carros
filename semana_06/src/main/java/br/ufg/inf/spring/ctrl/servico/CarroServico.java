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

import br.ufg.inf.spring.ctrl.excecao.CarroException;
import br.ufg.inf.spring.ctrl.excecao.CarroNotFoundException;
import br.ufg.inf.spring.ctrl.model.entidades.Carro;
import br.ufg.inf.spring.ctrl.negocio.CarroNegocio;

@CrossOrigin
@RestController
@RequestMapping(value="/carros")
public class CarroServico {

	@Autowired
	private CarroNegocio negocio;
		
	@GetMapping
	public ResponseEntity<List<Carro>> inicio() {
		List<Carro> list = negocio.listarTodosCarros();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Carro> findById(@PathVariable Integer id){
		Carro ret = null;
		try {
			ret = negocio.buscarCarroPorId(id);
			return ResponseEntity.ok(ret);
		} catch (CarroNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ret);	
		}
	}
	
	@PostMapping
	public ResponseEntity<Carro> insert(@RequestBody Carro car){
		try {
			car = negocio.insert(car);
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/carros/{id}").buildAndExpand(car.getId()).toUri();
			return ResponseEntity.created(uri).body(car);
		} catch (CarroException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(car);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		try {
			negocio.delete(id);
			return ResponseEntity.noContent().build();
		} catch (CarroNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Carro> update(@PathVariable Integer id, @RequestBody Carro car){
		try {
			car = negocio.update(car);
			return ResponseEntity.ok().body(car);
		} catch (CarroNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(car);
		} catch (CarroException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(car);
		}
	}
}
