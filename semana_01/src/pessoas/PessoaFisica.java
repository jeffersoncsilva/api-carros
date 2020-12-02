package pessoas;

public class PessoaFisica extends Pessoa{
	private String cpf;
	private String dtNascimento;
	private String genero;
	
	public PessoaFisica(String nome, int saldo) {
		super(nome);
	}
	
	public PessoaFisica(String nome, String end, String gen, String cpf, String dataNascimento, int id) {
		super(nome, end, id);
		this.setCpf(cpf);
		this.dtNascimento = dataNascimento;
		this.genero = gen;
		setEndereco(end);
	}
	
	public String getCpf() { return this.cpf; }
	public void setCpf(String c) { this.cpf = c; }
	
	public String getDtnascimento() { return this.dtNascimento; }
	public void setDataNascimento(String c) { this.dtNascimento = c; }
	
	public String getGenero() { return this.genero; }
	public void setGenero(String g) { this.genero = g; }

}
