package semana_03.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import semana_03.ctrl.excecao.DBExeption;
import semana_03.ctrl.servico.CarroServico;
import semana_03.ctrl.servico.FabricanteServico;
import semana_03.ctrl.servico.ModeloServico;
import semana_03.model.dao.BancoProvisorio;
import semana_03.model.dao.DB;
import semana_03.model.entidade.Carro;
import semana_03.model.entidade.Fabricante;
import semana_03.model.entidade.Modelo;
import semana_03.model.enumerador.TipoCarro;

public class TesteCamada {
	CarroServico carros = new CarroServico();
	FabricanteServico fabricante = new FabricanteServico();
	ModeloServico modelo = new ModeloServico();
	
	public void listaCarros() {
		System.out.println("Listando os carros do banco:");
		for(Carro c : carros.listar()) {
			System.out.println(c.toString());
		}
	}
	
	public void listaFabricante() {
		System.out.println("Listando os fabricantes do banco:");
		for(Fabricante f : fabricante.listar())
			System.out.println(f.toString());
	}
	
	public void listarModelos() {
		System.out.println("Listando os modelos no banco:");
		for(Modelo m : modelo.listar())
			System.out.println(m.toString());
	}
	
	public void inserirFabricante() {
		Fabricante f = new Fabricante("Ferrari");
		Fabricante f2 = new Fabricante("Burgat");
		f = fabricante.inserir(f);
		f2 = fabricante.inserir(f2);
		System.out.println(f);
		System.out.println(f2);
	}
	
	public void inserirModelo() {
		Modelo m = new Modelo("486 Italia", 4);
		Modelo m2 = new Modelo("Veyron", 5);
		m = modelo.inserir(m);
		m2 = modelo.inserir(m2);
		System.out.println(m);
		System.out.println(m2);
	}
	
	public void inserirCarro() {
		Carro carro1 = new Carro(TipoCarro.SEDAN, "abc-1d23", 2020, "Vermelho", 6);
		carro1 = carros.inserir(carro1);
		System.out.println(carro1);
		System.out.println("--------------------------");
	}
	
	public void alterarFabricante() {
		Fabricante f = new Fabricante("Ferrari Italia");
		f.setFabId(4);
		f = fabricante.alterar(f);
		System.out.println(f.toString());
	}
	
	public void alterarModelo() {
		Modelo m = new Modelo("486 Italia", 4);
		m.setModeloId(5);
		m.setNomeModelo("Ferrari 486 Italia");
		m = modelo.alterar(m);
		System.out.println(m.toString());
	}
	
	public void alterarCarro() {
		Carro carro1 = new Carro(TipoCarro.SEDAN, "abc-1d23", 2020, "Vermelho", 6);
		carro1.setCarId(5);
		carro1.setCor("azul");
		 carro1 = carros.alterar(carro1);
		 System.out.println(carro1.toString());
	}
	
	public void procurarModeloPorId() {
		Modelo m = modelo.procurarPorId(3);
		System.out.println(m.toString());
		System.out.println("-------------------");
	}
	
	public void procurarFabricantePorId() {
		Fabricante fab = fabricante.procurarPorId(2);
		System.out.println(fab.toString());
		System.out.println("-------------------");
	}
	
	public void procurarCarroPorPlaca() {
		Carro c = carros.procurarPorPlaca("12345678");
		System.out.println(c.toString());
		System.out.println("-------------------");
	}
	
	public void excluiCarro() {
		Carro carro1 = new Carro(TipoCarro.SEDAN, "abc-1d23", 2020, "Vermelho", 6);
		carro1 = carros.excluir(carro1);
	}
	
	public void excluiModelo() {
		Modelo m = new Modelo("486 Italia", 4);
		m.setModeloId(6);
		modelo.excluir(m);
	}
	
	public void excluiFabricante() {
		Fabricante f = new Fabricante("Ferrari Italia");
		f.setFabId(7);
		fabricante.excluir(f);
	}
	
	/*
	public void testarInserir(){
		
		Fabricante ford = new Fabricante("Ford", 1);
		Fabricante honda = new Fabricante("Honda", 2);
		BancoProvisorio.fabricante.add(ford);
		BancoProvisorio.fabricante.add(honda);
		
		Modelo ka = new Modelo("KA", 1, ford);
		Modelo city = new Modelo("City", 2, honda);
		
		BancoProvisorio.modelos.add(ka);
		BancoProvisorio.modelos.add(city);
		
		Carro carro1 = new Carro(TipoCarro.SEDAN, "abc-1d23", 2020, "Vermelho", ka);
		Carro carro2 = new Carro(TipoCarro.SEDAN, "abc-1d24", 2021, "Azul", city);
		
		//BancoProvisorio.carros.add(carro1);
		BancoProvisorio.carros.add(carro2);
		
		servico.inserir(carro1);
		
		carro1.setCor("Preto");
		servico.alterar(carro1);
		
		List<Carro> cars = servico.listar();
		
		servico.excluir(carro2);
		
		for(Carro c : cars)
			System.out.println(c.toString());
		
		System.out.println("Inserindo carro.");
		System.out.println(servico.procurarPorPlaca("abc-1d37"));
	}*/
}
