package view;

import java.util.Scanner;

import ctrl.execao.ContaNaoEncontradaException;
import ctrl.servico.ContaServico;
import ctrl.servico.PessoaServico;
import model.entidades.contas.Conta;
import model.entidades.contas.ContaEspecial;
import model.entidades.contas.ContaPoupanca;
import model.entidades.pessoas.Pessoa;
import model.enumerador.TipoConta;
import ctrl.execao.SaldoInsuficienteException;

public class BancoTela {
	private ContaServico cs;
	private PessoaServico ps;
	Scanner sc;
	
	public BancoTela() {
		cs = new ContaServico();
		ps = new PessoaServico();
		sc = new Scanner(System.in);
	}
	
	public void mostrarTelaInicial() {
		int escolha = -1;
		
		System.out.flush();
		do {
			mostraOpcoesTela();
			escolha = sc.nextInt();
			if(escolhaNaoValida(escolha)) {
				System.out.println("Opção invalida. Escolha novamente.");
				continue;
			}
			switch(escolha) {
				case 1:
					cadastrarConta();
					break;
				case 2:
					escolherConta();
					break;
				case 3:
					cadastrarPessoa();
					break;
				case 4:
					mostrarHistorico();
					break;
				case 5:
					System.out.println("Fechando a aplicação!!");
					break;
					
			}
		}while(escolha != 5);
		sc.close();
	}
	
	private void cadastrarConta() {
		System.out.println("Escolha uma pessoa na lista abaixo: ");
		Pessoa p = ps.escolherPessoa();	
		if(p == null) {
			System.out.println("Pessoa não encontrada. \nDeseja castrar uma nova pessoa? (1 - Sim / 2 - Não)");
			int es = sc.nextInt();
			if(es == 2) {
				System.out.println("Não sera possivel cadastrar uma nova conta sem uma pessoa cadastrada.");
				return;
			}else {
				p = ps.cadastraPessoa(sc);
			}
		}
		
			System.out.println("Deseja cadastrar: \n1 - Conta especial.\n2 - Conta poupança.");
			int es = sc.nextInt();
			System.out.println("Digite o saldo inicial: ");
			double saldoInicial = sc.nextDouble();
			TipoConta tp = escolheTipoConta();
			if(es == 1) {
				//conta especial
				System.out.println("Digite o limite para conta especial: ");
				double limite = sc.nextDouble();
				Conta conta = new ContaEspecial(p, cs.getNumeroProxConta(), saldoInicial, limite, tp);
				cs.inserirConta(conta);
			}else {
				System.out.println("Insira a taxa de correção para a conta poupança: ");
				double tx = sc.nextDouble();
				Conta conta2 = new ContaPoupanca(p, cs.getNumeroProxConta(), saldoInicial, tx, tp);
				cs.inserirConta(conta2);
			}
			System.out.println("Conta inserida.");
		
	}
	
	private void escolherConta() {
		System.out.println("Escolha uma conta:");
		cs.mostrarContas();
		int c = sc.nextInt();
		Conta conta = null;
		try {
			conta = cs.pegaConta(c);
		}catch(ContaNaoEncontradaException e) {
			System.out.println("Conta não encontrada. " + e.getMessage());
			return;
		}
		int menu = -1;
		do {
			System.out.println("1 - Alterar conta");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Transferir");
			System.out.println("5 - Saldo");
			System.out.println("6 - Extrato");
			System.out.println(" 7 - Retornar");
			switch(menu) {
				case 1:
					this.alterarConta(conta);
					break;
				case 2:
					depositar(conta);
					break;
				case 3:
					sacar(conta);
					break;
				case 4:
					transferir(conta);
					break;
				case 5:
					saldo(conta);
					break;
				case 6:
					conta.mostraExtrato();
					break;
				case 7:
					return;
			}
		}while(menu < 0 && menu > 7);
	}
	
	private void cadastrarPessoa() {
		Pessoa p = ps.cadastraPessoa(sc);
		if(p==null) {
			System.out.println("Ocorreu um erro ao cadastrar nova pessoa.");
		}
	}
	
	private void mostrarHistorico() {
		System.out.println("Historico das contas.");
	}
	
	private void mostraOpcoesTela() {
		System.out.println("Bem vindo ao banco! Escolha uma opção: ");
		System.out.println("1 - Cadastrar nova conta");
		System.out.println("2 - Selecionar uma conta");
		System.out.println("3 - Cadastrar cliente");
		System.out.println("4 - Relatorios");
		System.out.println("5 - Sair");
	}

	private boolean escolhaNaoValida(int e) {
		return (e < 0) || (e > 5);
	}
	
	private TipoConta escolheTipoConta() {
		int es = -1;
		do {
			System.out.println("1 - Conta Simples");
			System.out.println("2 - Conta Executiva");
			System.out.println("3 - Conta Premium");
			System.out.println("4 - Conta Personalite");
			es = sc.nextInt();
		}while(es < 1 && es > 4);
		switch (es) {
			case 1: return TipoConta.SIMPLES;
			case 2: return TipoConta.EXECUTIVA;
			case 3: return TipoConta.PREMIUM;
			case 4: return TipoConta.PERSONALITE;
		default:
			return TipoConta.SIMPLES;
		}
	}

	private void alterarConta(Conta c) {
		System.out.println("Alterando a conta.");
	}
	
	private void depositar(Conta c) {
		System.out.println("Digite o valor que deseja depositar: ");
		double val = sc.nextDouble();
		c.depositar(val);
	}
	
	private void sacar(Conta c) {
		try {
			System.out.println("Digite o valor que deseja sacar: ");
			double val = sc.nextDouble();
			c.sacar(val);
		}catch (SaldoInsuficienteException e) {
			System.out.println("Não foi possivel realizar saque. Saldo insuficiente.");
		}
	}

	private void transferir(Conta c) {
		try {
			if(c == null)
				throw new ContaNaoEncontradaException("Conta de origem não encontrada. Não e possivel fazer a transferência.");
			System.out.println("Digite o id da conta de destino: ");
			int id = sc.nextInt();
			Conta dest = cs.pegaConta(id);
			System.out.println("Digite o valor da transferencia: ");
			double val = sc.nextDouble();
			c.trasferir(dest, val);
		} catch (ContaNaoEncontradaException e) {
			System.out.println("Conta não encontrada. Transferencia não pode ser realizada.");
			return;
		}
		
	}
	
	private void saldo(Conta c) {
		System.out.println("O saldo da conta e "+c.getSaldoDisponivelString());
	}
	
}
