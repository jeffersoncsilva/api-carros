package br.ufg.inf.spring.ctrl.excecao;

public class ModeloNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public ModeloNotFoundException(String msg) {
		super(msg);
	}
}
