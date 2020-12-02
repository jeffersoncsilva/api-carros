package model.entidades.contas;

import ctrl.execao.SaldoInsuficienteException;
import model.entidades.pessoas.Pessoa;
import model.enumerador.TipoConta;

public abstract class Conta {
	private Pessoa cliente;
	private int nrConta;
	private double saldo;
	private TipoConta tipoConta;
	
	public Conta(Pessoa cli, int nrConta, double saldo, TipoConta tp) {
		this.cliente = cli;
		this.nrConta = nrConta;
		this.saldo = saldo;
		this.tipoConta = tp;
	}
	
	
	public void setCliente(Pessoa p) {
		this.cliente = p;
	}
	
	public Pessoa getCliente() {return this.cliente;}
	
	public int getNrConta() {
		return this.nrConta;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public TipoConta getTipoConta() { return this.tipoConta; }
	
	public void depositar(double saldo) {
		this.saldo += saldo;
	}
	protected void debitar(double val) {
		this.saldo -= val;
	}
	
	
	public abstract String sacar(double val) throws SaldoInsuficienteException;
	public abstract String trasferir(Conta c, double valor);	
	public abstract String getSaldoDisponivelString();
	public abstract void mostraExtrato();
}
