package model.entidades.contas;

import model.entidades.pessoas.Pessoa;
import model.enumerador.TipoConta;

public class ContaPoupanca extends Conta{
	private double txCorrecao;
	
	public ContaPoupanca(Pessoa cli, int nrConta, double saldo, double txCorrecao, TipoConta tp) {
		super(cli, nrConta, saldo, tp);
		this.txCorrecao = txCorrecao;
	}
	
	public double getTaxaCorrecao() {
		return this.txCorrecao;
	}
	public void setTaxaCorrecao(double tx) {
		this.txCorrecao = tx;
	}
	
	public void atualizaSaldoRendimento() {
		depositar(getSaldo() * txCorrecao);
	}
	
	@Override
	public String sacar(double val) {
		if((this.getSaldo() - val) >= 0) {
			debitar(val);
			return "Saque realizado!";
		}else
			return "Saldo insuficiente! Saque não foi realizado!";
		
	}

	public String toString() {
		return "Conta Poupanca.";
	}

	@Override
	public String trasferir(Conta c, double valor) {
		if((this.getSaldo() - valor ) >= 0) {
			c.depositar(valor);
			debitar(valor);
			return "Transferencia realizada!";
		}
		return "Saldo insuficiente para realizar a transferencia!";
	}

	@Override
	public String getSaldoDisponivelString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostraExtrato() {
		// TODO Auto-generated method stub
		
	}
}
