package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.ctrl.model.entidades.Carro;
import br.ufg.inf.spring.model.repository.CarroRepository;

@Service
public class CarroNegocio {
	
	@Autowired
	private CarroRepository repo;
	
	public List<Carro> findAll(){
		return repo.findAll();
	}
	
	public Carro findById(Integer id) {
		Optional<Carro> ret = repo.findById(id);
		return ret.get();
	}
	
	public Carro insert(Carro c) {
		return repo.save(c);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Carro update(Carro c) {
		Carro car = repo.getOne(c.getId());
		car.setAno(c.getAno());
		car.setCor(c.getCor());
		car.setModelo(c.getModelo());
		car.setPlaca(c.getPlaca());
		car.setTipo(c.getTipo());
		return repo.save(car);
	}
}
