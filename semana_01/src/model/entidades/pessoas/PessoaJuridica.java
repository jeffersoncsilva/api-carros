package model.entidades.pessoas;

public class PessoaJuridica extends Pessoa{
	private String cnpj;
	private String atividade;
	
	public PessoaJuridica(String nome, String endereco, int id, String cnpj, String atividade) {
		super(nome, endereco, id);
		this.cnpj = cnpj;
		this.atividade = atividade;
	}
	
	public String getCnpj() { return this.cnpj; }
	public void setCnpj(String c) { this.cnpj = c; }
	
	public String getAtividade() { return this.atividade; }
	public void setAtividade(String at) { this.atividade = at; }

}
