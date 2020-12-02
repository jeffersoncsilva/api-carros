package br.ufg.inf.spring.ctrl.excecao;

public class CarroNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	public CarroNotFoundException(String msg) {
		super(msg);
	}
}
