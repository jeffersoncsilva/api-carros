package app;

import ctrl.servico.CarroServico;
import ctrl.servico.FabricanteServico;
import ctrl.servico.ModeloServico;
import model.entidade.Carro;
import model.entidade.Fabricante;
import model.entidade.Modelo;
import model.enumerador.TipoCarro;

public class TesteCamada {

	CarroServico carros = new CarroServico();
	FabricanteServico fabricante = new FabricanteServico();
	ModeloServico modelo = new ModeloServico();

	public void listaCarros() {
		System.out.println("Listando os carros do banco:");
		for (Carro c : carros.listar()) {
			System.out.println(c.toString());
		}
	}

	public void listaFabricante() {
		System.out.println("Listando os fabricantes do banco:");
		for (Fabricante f : fabricante.listar())
			System.out.println(f.toString());
	}

	public void listarModelos() {
		System.out.println("Listando os modelos no banco:");
		for (Modelo m : modelo.listar())
			System.out.println(m.toString());
	}

	public void inserirFabricante() {
		Fabricante f = new Fabricante("Ferrari");
		Fabricante f2 = new Fabricante("Burgat");
		Fabricante f3 = new Fabricante("Honda");
		f = fabricante.inserir(f);
		f2 = fabricante.inserir(f2);
		f3 = fabricante.inserir(f3);
	}

	public void inserirModelo() {
		Fabricante fabi = fabricante.buscarPorNome("Ferrari").get(0);
		Fabricante fabi2 = fabricante.buscarPorNome("Burgat").get(0);
		Modelo m = new Modelo("486 Italia", fabi);
		Modelo m2 = new Modelo("Veyron", fabi2);
		m = modelo.inserir(m);
		m2 = modelo.inserir(m2);
	}

	public void inserirCarro() {
		// String cor, String placa, int ano, TipoCarro tp, Modelo m
		Modelo m1 = modelo.procurarPorId(1);
		Modelo m2 = modelo.procurarPorId(2);
		Carro car1 = new Carro("Azul", "abc-1d23", 2020, TipoCarro.HATCH, m1);
		Carro car2 = new Carro("Azul", "abc-1d23", 2020, TipoCarro.HATCH, m2);
		car1 = carros.inserir(car1);
		car2 = carros.inserir(car2);
		System.out.println(car1);
		System.out.println(car2);
		System.out.println("--------------------------");
	}

	public void alterarFabricante() {
		Fabricante f = fabricante.buscarPorNome("Ferrari").get(0);
		f.setFabriNome("Ferrai da italia");
		f = fabricante.alterar(f);
	}

	public void alterarModelo() {
		Modelo m = modelo.procurarPorId(1);
		m.setNomeModelo("Ferrari 486 Italia");
		m = modelo.alterar(m);
	}

	public void alterarCarro() {
		Modelo m2 = modelo.procurarPorId(2);
		Carro car1 = carros.procurarPorPlaca("abc-1d23");
		car1.setCor("Cinza Escuro");
		car1.setPlaca("jbl-1d22");
		car1 = carros.alterar(car1);
	}

	public void procurarModeloPorId() {
		Modelo m = modelo.procurarPorId(1);
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
		Carro car1 = carros.procurarPorPlaca("jbl-1d22");
		car1 = carros.excluir(car1);
		System.out.println("Carro apagado!----------------");
	}

	public void excluiModelo() {
		Modelo m = modelo.procurarPorId(1);
		modelo.excluir(m);
	}

	public void excluiFabricante() {
		Fabricante f = fabricante.buscarPorNome("Honda").get(0);
		fabricante.excluir(f);
	}
}
