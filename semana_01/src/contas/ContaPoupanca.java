package contas;

import pessoas.Pessoa;

public class ContaPoupanca extends Conta{
	private double txCorrecao;
	
	public ContaPoupanca(Pessoa p, double tx) {
		super(p);
		this.setTaxaCorrecao(tx);
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
}
