package contas;

import pessoas.Pessoa;

public abstract class Conta {
	private Pessoa cliente;
	private int nrConta;
	private double saldo;
	
	public Conta(Pessoa cli) {
		setCliente(cli);
		depositar(0);
	}
	
	public Pessoa getClient() {
		return this.cliente;
	}
	
	public void setCliente(Pessoa p) {
		this.cliente = p;
	}
	
	public int getNrConta() {
		return this.nrConta;
	}
	
	/* {
		if(temSaldo()) {
			c.depositar(valor);
			return  sacar(valor);
		}
		return "Não foi possivel realizar transferencia. Saldo insuficiente!";
	}*/
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void depositar(double saldo) {
		this.saldo += saldo;
	}
	protected void debitar(double val) {
		this.saldo -= val;
	}
	
	
	public abstract String sacar(double val);
	public abstract String trasferir(Conta c, double valor);	
	
	
}
