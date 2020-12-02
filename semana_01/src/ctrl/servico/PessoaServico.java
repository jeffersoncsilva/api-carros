package ctrl.servico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.entidades.pessoas.Pessoa;
import model.entidades.pessoas.PessoaJuridica;
import model.enumerador.GeneroPessoa;
import model.entidades.pessoas.PessoaFisica;

public class PessoaServico {
	private List<Pessoa> pessoas;
	
	public PessoaServico() {
		pessoas = new ArrayList<>();
	}
	
	public Pessoa escolherPessoa(){
		if(pessoas.size() <= 0)
			return null;
		Scanner sc = new Scanner(System.in);
		for(Pessoa p : pessoas) {
			System.out.println(String.format("%d - %s", p.getId(), p.getNome()));
		}
		int es = sc.nextInt();
		sc.close();	
		if(es < 0 || es > pessoas.size())
			return null;
		for(Pessoa p: pessoas)
			if(p.getId() == es)
				return p;
		
		return null;
	}
	
	public Pessoa cadastraPessoa(Scanner sc) {
		Pessoa p = null;
		System.out.flush();
		System.out.println("Digite o nome:");
		String nome = sc.nextLine();
		System.out.println("Digite o endereço: ");
		String endereco = sc.nextLine();
		System.out.println("1 - Pessoa juridica. 2 - Pessoa Física. ");
		int esc = sc.nextInt();
		if(esc == 1) {
			System.out.println("Digite o CNPJ da pessoa: ");
			String cnpj = sc.nextLine();
			System.out.println("Digite a atividade: ");
			String atividade = sc.nextLine();
			p = new PessoaJuridica(nome, endereco, pessoas.size(), cnpj, atividade);
		}else {
			System.out.println("Digite o CPF: ");
			String cpf = sc.nextLine();
			System.out.println("Digite a data de nascimento: ");
			String data = sc.nextLine();
			System.out.println("Digite o genero da pessoa.\n1 - Feminino 2 - Masculino");
			int gen = sc.nextInt();
			p = new PessoaFisica(nome, endereco, pessoas.size(), cpf, convertToDate(data), convertToGener(gen));
		}
		pessoas.add(p);
		return p;
	}
	
	private Date convertToDate(String data) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			d = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	private GeneroPessoa convertToGener(int g) {
		return (g==1) ? GeneroPessoa.FEMININO : GeneroPessoa.MASCULINO;
	}
}
