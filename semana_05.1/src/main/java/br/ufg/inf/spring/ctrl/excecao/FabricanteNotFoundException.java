package br.ufg.inf.spring.ctrl.excecao;

public class FabricanteNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public FabricanteNotFoundException(String msg) {
		super(msg);
	}

}
