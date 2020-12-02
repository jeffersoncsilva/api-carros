package contas;

import pessoas.Pessoa;

public class ContaEspecial extends Conta{
	double limit;
	
	public ContaEspecial(Pessoa p, double limite) {
		super(p);
		this.setLimit(limite);
	}
	
	public void setLimit(double l) {
		this.limit = l;
	}
	public double getLimit() {
		return this.limit;
	}
	
	@Override
	public String sacar(double val) {
		if(((this.getSaldo() + this.limit) - val) >= 0) {
			debitar(val);
			return "Saque Realizado com sucesso!!";
		}
		return "Não foi possivel realizar saque. Saldo insuficiente!";
	}
	
	@Override
	public String trasferir(Conta c, double valor) {
		if(((this.getSaldo()+limit) - valor ) >= 0) {
			c.depositar(valor);
			debitar(valor);
			return "Transferencia realizada!";
		}
		return "Saldo insuficiente para realizar a transferencia!";
	}

	@Override
	public double getSaldo() {
		return super.getSaldo() + limit;
	}
	
	@Override
	public String toString() {
		return "Conta Expecial.";
	}

}
