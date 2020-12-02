package main;

import java.util.ArrayList;
import java.util.Scanner;

import contas.Conta;
import contas.ContaEspecial;
import contas.ContaPoupanca;
import pessoas.PessoaJuridica;
import pessoas.PessoaFisica;
import pessoas.Pessoa;

public class Banco {
	private final double LIMITE_ESPECIAL = 1000.0;
	private final double TAXA_POUPANCA = 0.1;
	private Scanner scan;
	private ArrayList<Conta> contas;
	
	public Banco() {
		scan = new Scanner(System.in);
		contas = new ArrayList<>();
	}
	
	public void cadastrarNovoCliente() {
		boolean ok;
		int escolha;
		do {
			System.out.println("ESCOLHA: 1 -> Pessoa Fisica || 2 -> Pessoa juridica");
			escolha = scan.nextInt();
			ok = (escolha == 1) || (escolha == 2);
			if(!ok)
				System.out.println("Opcao invalida. Digite novamente.");
		}while(!ok);
		Pessoa p;
		if(escolha == 1)
			p = pessoaFisica();
		else
			p = pessoaJuridica();
		do {
			System.out.println("ESCOLHA: 1 -> Conta Especial || 2 -> Conta Poupança");
			escolha = scan.nextInt();
			ok = (escolha == 1) || (escolha == 2);
		}while(!ok);
		if(escolha == 1) {
			contas.add(new ContaEspecial(p, LIMITE_ESPECIAL));
		}else
			contas.add(new ContaPoupanca(p, TAXA_POUPANCA));
	}
	
	private Pessoa pessoaFisica() {
		System.out.println("Digite o nome do cliente: ");
		String nome = scan.next();
		System.out.println("Digite o CPF do cliente: ");
		String cpf = scan.next();
		System.out.println("Digite a data de nascimento: ");
		String nascimento = scan.next();
		System.out.println("Digite o sexo do cliente: ");
		String sexo = scan.next();
		System.out.println("Digite o endereço do cliente: ");
		String  endereco = scan.next();
		
		return new PessoaFisica(nome, endereco, sexo, cpf, nascimento, this.contas.size());
		
	}
	
	private Pessoa pessoaJuridica() {
		System.out.println("Digite o nome do cliente: ");
		String nome = scan.next();
		System.out.println("Digite o CNPJ do cliente: ");
		String cnpj = scan.next();
		System.out.println("Digite a atividade: ");
		String atividade = scan.next();
		System.out.println("Digite o endereço do cliente: ");
		String  endereco = scan.next();
		
		return new PessoaJuridica(nome, atividade, endereco, cnpj, this.contas.size());
	}
	
	public void listarClientes() {
		for(int i = 0; i < contas.size(); i++) {
			Conta c = contas.get(i);
			System.out.println("NOME: " + c.getClient().getNome() + " -- conta: " + (i+1) + " -- Tipo: " + c.toString());
		}
	}
	
	public void listarQtdContas() {
		System.out.println("Qtd contas: " + contas.size());
	}
	
	public void escolherCliente() {
		
	}
	
	public void mostraSaldoTotal() {
		double d = 0.0;
		for(Conta c : contas)
			d += c.getSaldo();
		System.out.println("Saldo total nas contas e de: " + d);
	}
	
	public void test() {
		PessoaFisica pf1 = new PessoaFisica("Gasly", 1);
		PessoaFisica pf2 = new PessoaFisica("Carlos Sains", 2);
		PessoaFisica pf3 = new PessoaFisica("Stroll.", 3);
		
		PessoaJuridica pj1 = new PessoaJuridica("Lewis Hamilton", "Mercedes", 7);
		PessoaJuridica pj2 = new PessoaJuridica("Bottas", "Mercedes", 5);
		PessoaJuridica pj3 = new PessoaJuridica("Kimi Raikonem", "Alpha Tauri", 11);
		
		ContaEspecial ce1 = new ContaEspecial(pj1, 500);
		ContaEspecial ce2 = new ContaEspecial(pj2, 300);
		ContaEspecial ce3 = new ContaEspecial(pj3, 200);
		
		ContaPoupanca cp1 = new ContaPoupanca(pf1, 0.2);
		ContaPoupanca cp2 = new ContaPoupanca(pf2, 0.2);
		ContaPoupanca cp3 = new ContaPoupanca(pf3, 0.2);
		
		//Realiza deposito nas contas
		ce1.depositar(350);
		ce2.depositar(450);
		ce3.depositar(1000);
		cp1.depositar(23451);
		cp2.depositar(99999);
		cp3.depositar(10);
		
		System.out.println("Cliente: " + ce1.getClient().toString() + " | Saldo ce 1: " + ce1.getSaldo());
		System.out.println("Cliente: " + ce2.getClient().toString() + " | Saldo ce 2: " + ce2.getSaldo());
		System.out.println("Cliente: " + ce3.getClient().toString() + " | Saldo ce 3: " + ce3.getSaldo());
		
		System.out.println("Cliente: " + cp1.getClient().toString() + " | Saldo cp1: " + cp1.getSaldo());
		System.out.println("Cliente: " + cp2.getClient().toString() + " | Saldo cp2: " + cp2.getSaldo());
		System.out.println("Cliente: " + cp3.getClient().toString() + " | Saldo cp3: " + cp3.getSaldo());
		//Realiza saque nas contas.
		System.out.println("Cliente: " + ce1.getClient().toString() + " está sacando 100. OBS: " + ce1.sacar(100));
		System.out.println("Cliente: " + ce2.getClient().toString() + " está sacando 1600. OBS: " + ce2.sacar(1600));
		System.out.println("Cliente: " + ce3.getClient().toString() + " está sacando 200000050. OBS: " + ce3.sacar(100000));
		System.out.println("Cliente: " + cp1.getClient().toString() + " está sacando 100. OBS: " + cp1.sacar(1700));
		System.out.println("Cliente: " + cp2.getClient().toString() + " está sacando 10044. OBS: " + cp2.sacar(10044));
		System.out.println("Cliente: " + cp3.getClient().toString() + " está sacando 5. OBS: " + cp3.sacar(5));
		//Realiza transferencia entre contas
		System.out.println("Transferindo 50");
		System.out.println("ANTES: Cliente " + ce1.getClient().toString() + " SALDO: " + ce1.getSaldo());
		System.out.println("ANTES: Cliente " + ce2.getClient().toString() + " SALDO: " + ce2.getSaldo());
		System.out.println("STATUS: " + ce1.trasferir(ce2, 50));
		System.out.println("DEPOIS: Cliente " + ce1.getClient().toString() + " SALDO: " + ce1.getSaldo());
		System.out.println("DEPOIS: Cliente " + ce2.getClient().toString() + " SALDO: " + ce2.getSaldo());
		
		System.out.println("Transferindo 500");
		System.out.println("ANTES: Cliente " + ce1.getClient().toString() + " SALDO: " + ce1.getSaldo());
		System.out.println("ANTES: Cliente " + cp2.getClient().toString() + " SALDO: " + cp2.getSaldo());
		System.out.println("STATUS: " + ce1.trasferir(cp2, 500));
		System.out.println("DEPOIS: Cliente " + ce1.getClient().toString() + " SALDO: " + ce1.getSaldo());
		System.out.println("DEPOIS: Cliente " + cp2.getClient().toString() + " SALDO: " + cp2.getSaldo());
		
		System.out.println("Transferindo 100");
		System.out.println("ANTES: Cliente " + cp1.getClient().toString() + " SALDO: " + cp1.getSaldo());
		System.out.println("ANTES: Cliente " + ce1.getClient().toString() + " SALDO: " + ce1.getSaldo());
		System.out.println("STATUS: " + cp1.trasferir(ce2, 50));
		System.out.println("DEPOIS: Cliente " + cp1.getClient().toString() + " SALDO: " + cp1.getSaldo());
		System.out.println("DEPOIS: Cliente " + ce1.getClient().toString() + " SALDO: " + ce1.getSaldo());
		
		System.out.println("Transferindo 9999");
		System.out.println("ANTES: Cliente " + cp2.getClient().toString() + " SALDO: " + cp2.getSaldo());
		System.out.println("ANTES: Cliente " + cp3.getClient().toString() + " SALDO: " + cp3.getSaldo());
		System.out.println("STATUS: " + cp2.trasferir(cp3, 9990));
		System.out.println("DEPOIS: Cliente " + cp2.getClient().toString() + " SALDO: " + cp2.getSaldo());
		System.out.println("DEPOIS: Cliente " + cp3.getClient().toString() + " SALDO: " + cp3.getSaldo());
		
		
		//Atualiza rendimentos das contas poupanças
		System.out.println("ANTES: Cliente: " + cp1.getClient().toString() + " | Saldo cp1: " + cp1.getSaldo());
		System.out.println("ANTES: Cliente: " + cp2.getClient().toString() + " | Saldo cp2: " + cp2.getSaldo());
		System.out.println("ANTES: Cliente: " + cp3.getClient().toString() + " | Saldo cp3: " + cp3.getSaldo());
		cp1.atualizaSaldoRendimento();
		cp2.atualizaSaldoRendimento();
		cp3.atualizaSaldoRendimento();
		System.out.println("DEPOIS: Cliente: " + cp1.getClient().toString() + " | Saldo cp1: " + cp1.getSaldo());
		System.out.println("DEPOIS: Cliente: " + cp2.getClient().toString() + " | Saldo cp2: " + cp2.getSaldo());
		System.out.println("DEPOIS: Cliente: " + cp3.getClient().toString() + " | Saldo cp3: " + cp3.getSaldo());
		
		
		
		// Lista os nomes das contas e seus respectivos saldos
		System.out.println("Cliente: " + ce1.getClient().toString() + " | Saldo ce 1: " + ce1.getSaldo() + " TIPO: " + ce1.toString());
		System.out.println("Cliente: " + ce2.getClient().toString() + " | Saldo ce 2: " + ce2.getSaldo() + " TIPO: " + ce2.toString());
		System.out.println("Cliente: " + ce3.getClient().toString() + " | Saldo ce 3: " + ce3.getSaldo() + " TIPO: " + ce3.toString());
		
		System.out.println("Cliente: " + cp1.getClient().toString() + " | Saldo cp1: " + cp1.getSaldo() + " TIPO: " + cp1.toString());
		System.out.println("Cliente: " + cp2.getClient().toString() + " | Saldo cp2: " + cp2.getSaldo() + " TIPO: " + cp2.toString());
		System.out.println("Cliente: " + cp3.getClient().toString() + " | Saldo cp3: " + cp3.getSaldo() + " TIPO: " + cp3.toString());
		
		
		double saldoTotal = ce1.getSaldo() + ce2.getSaldo() + ce3.getSaldo() + cp1.getSaldo() + cp2.getSaldo() + cp3.getSaldo();
		System.out.println("Saldo de todas a contas: " + saldoTotal);
		
	}
}
