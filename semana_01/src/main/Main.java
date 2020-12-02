package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Banco b = new Banco();
		int op = 1;
		do {
			System.out.println("Bem vindo ao banco! Escolha uma opção para prosseguir:");
			System.out.println("1 - Cadastrar novo cliente.");
			System.out.println("2 - Listar clientes.");
			System.out.println("3 - Escolher um cliente.");
			System.out.println("4 - Listar quantidade contas.");
			System.out.println("5 - Listar saldo total banco.");
			System.out.println("6 - Sair");
			op = scan.nextInt();
			switch(op) {
				case 1: 
					b.cadastrarNovoCliente();
					break;
				case 2:
					b.listarClientes();
					break;
				case 3: 
					b.escolherCliente();
					break;
				case 4:
					b.listarQtdContas();
					break;
				case 5:
					b.mostraSaldoTotal();
					break;
				case 6:
					break;
					default:
						System.out.println("Opção invalida. Escolha outra!");
			}
		}while(op != 6);
		// Testa a aplicação sem alimentar os dados.
		// b.test();
	}
	
	
	
	
}
