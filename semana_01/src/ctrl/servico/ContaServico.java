package ctrl.servico;

import java.util.ArrayList;
import java.util.List;
import ctrl.execao.ContaNaoEncontradaException;
import model.entidades.contas.Conta;

public class ContaServico {
	private List<Conta> contas;
	
	public ContaServico() {
		contas = new ArrayList<>();
	}

	public void inserirConta(Conta c) {
		contas.add(c);
	}
	
	public boolean removeConta(int id) throws ContaNaoEncontradaException{
		Conta c = null;
		for(Conta co : contas) {
			if(co.getNrConta() == id) {
				c = co;
				break;
			}
		}
		if(c == null) 
			throw new ContaNaoEncontradaException("Conta buscada não encontrada. ID da conta: " + id);	
		contas.remove(c);
		return true;
	}
	
	public Conta pegaConta(int id) throws ContaNaoEncontradaException {
		for(Conta c1 : contas) 
			if(c1.getNrConta() == id) 
				return c1;
		throw new ContaNaoEncontradaException("Não foi encontrada a conta solicitada com ID " + id);
	}
	
	public void mostrarContas() {
		StringBuilder sb;
		for(Conta c : contas) {
			sb = new StringBuilder();
			sb.append("Nome: " );
			sb.append(c.getCliente().getNome());
			sb.append(" -- ID conta:");
			sb.append(c.getNrConta());
			System.out.println(sb.toString());
		}
	}

	public int getNumeroProxConta() {
		return contas.size() + 1;
	}
}
