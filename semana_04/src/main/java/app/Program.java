package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidade.Biblioteca;

public class Program {

	public static void main(String[] args) {
		
		TesteCamada ts = new TesteCamada();
		
		//ts.inserirFabricante();
		ts.listaFabricante();
		//ts.alterarFabricante();
		ts.excluiFabricante();
		ts.listaFabricante();
		
		//ts.inserirModelo();
		//ts.listarModelos();
		//ts.alterarModelo();
		//ts.excluiModelo();
		//ts.listarModelos();

		//ts.inserirCarro();
		//ts.alterarCarro();
		//ts.listaCarros();
		//ts.excluiCarro();
		//ts.alterarCarro();
		//ts.listaCarros();
	}
}
