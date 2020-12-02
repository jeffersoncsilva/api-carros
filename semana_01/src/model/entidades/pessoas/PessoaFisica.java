package model.entidades.pessoas;

import java.util.Date;

import model.enumerador.GeneroPessoa;

public class PessoaFisica extends Pessoa{
	private String cpf;
	private Date dtNascimento;
	private GeneroPessoa genero;
	
	public PessoaFisica(String nome, String endereco, int id, String cpf, Date nascimento, GeneroPessoa genero) {
		super(nome, endereco, id);
		this.cpf = cpf;
		this.dtNascimento = nascimento;
		this.genero = genero;
	}
	
	public String getCpf() { return this.cpf; }
	public void setCpf(String c) { this.cpf = c; }
	
	public Date getDtnascimento() { return this.dtNascimento; }
	public void setDataNascimento(Date c) { this.dtNascimento = c; }
	
	public GeneroPessoa getGenero() { return this.genero; }
	public void setGenero(GeneroPessoa g) { this.genero = g; }

}
