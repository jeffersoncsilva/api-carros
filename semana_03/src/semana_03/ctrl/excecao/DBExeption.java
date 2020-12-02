package semana_03.ctrl.excecao;

public class DBExeption extends Exception {
	private static final long serialVersionUID = 1L;

	public DBExeption(String msg) {
		super(msg);
	}
}
