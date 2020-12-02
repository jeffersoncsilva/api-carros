package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.ctrl.excecao.CarroException;
import br.ufg.inf.spring.ctrl.excecao.CarroNotFoundException;
import br.ufg.inf.spring.ctrl.model.entidades.Carro;
import br.ufg.inf.spring.model.repository.CarroRepository;

@Service
public class CarroNegocio {
	
	@Autowired
	private CarroRepository repo;
	
	public List<Carro> listarTodosCarros(){
		return repo.findAll();
	}
	
	public Carro buscarCarroPorId(Integer id) throws CarroNotFoundException{
		Optional<Carro> ret = repo.findById(id);
		if(ret.isPresent())
			return ret.get();
		else {
			throw new CarroNotFoundException("Carro não foi encontrado.");
		}
	}
	
	public Carro insert(Carro c) throws CarroException{
		return this.insereOuAtualizaCarro(c);
	}
	
	public void delete(Integer id) throws CarroNotFoundException{
		Optional<Carro> ret = repo.findById(id);
		if(ret.isPresent())
			repo.deleteById(id);
		else {
			throw new CarroNotFoundException("Carro não foi encontrado.");
		}
	}
	
	public Carro update(Carro c) throws CarroNotFoundException, CarroException {
		if(c == null)
			throw new CarroException("Carro não pode ser vazio.");
		Optional<Carro> ret = repo.findById(c.getId());
		if(ret.isPresent()){
			Carro car = ret.get();
			if(car.estaValido()) {
				car.setAno(c.getAno());
				car.setCor(c.getCor());
				car.setModelo(c.getModelo());
				car.setPlaca(c.getPlaca());
				car.setTipo(c.getTipo());
				return repo.save(car);				
			}else {
				throw new CarroException("Dados do carro está errado.");
			}
		}else {
			throw new CarroNotFoundException("Carro não foi encontrado.");
		}
	}
	
	private Carro insereOuAtualizaCarro(Carro c) throws CarroException{
		if(c.estaValido())
			return repo.save(c);
		else
			throw new CarroException("Dados do carro está inválido. Por favor, corrija.");
	}
}
