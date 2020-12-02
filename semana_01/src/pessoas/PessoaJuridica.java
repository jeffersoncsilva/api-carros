package pessoas;

public class PessoaJuridica extends Pessoa{
	private String cnpj;
	private String atividade;
	
	public PessoaJuridica(String nome, String s2, int i) {
		super(nome);
	}
	
	public PessoaJuridica(String nome, String atividade, String end, String cnpj, int id){
		super(nome, end, id);
		this.setCnpj(cnpj);
		this.setAtividade(atividade);
	}
	
	public String getCnpj() { return this.cnpj; }
	public void setCnpj(String c) { this.cnpj = c; }
	
	public String getAtividade() { return this.atividade; }
	public void setAtividade(String at) { this.atividade = at; }

}
