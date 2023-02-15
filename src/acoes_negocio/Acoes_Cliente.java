package acoes_negocio;

import java.util.Optional;

import baseDados.BancoDados;
import entidades.Cliente;

public class Acoes_Cliente  implements Interface_acesso {
	
	private BancoDados bd;
	
	public Acoes_Cliente(BancoDados bd) {
		this.bd = bd;
	}
	
	@Override
	public Optional<Cliente> consultar(String cpf) {
		if(bd.getCliente().getCpf().equals(cpf)) {
			return Optional.of(bd.getCliente());
		} else {
			return Optional.empty();
		}
	}	
	
	@Override
	public boolean cadastrar(String nome, String cpf) {
		if(!bd.getCliente().getCpf().equals(cpf)) {
			bd.getCliente().setNome(nome);
			bd.getCliente().setCpf(cpf);
			System.out.println("Cliente cadastrado com sucesso");
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String excluir(String cpf) {
		if(bd.getCliente().getCpf().equals(cpf)) {
			bd.getCliente().setNome(null);
			bd.getCliente().setCpf(null);
			return "Cliente excluido com sucesso";
		}else {
			return "Perfil não existe";
		}
	}	
	
	@Override
	public String toString() {
		return "Cliente: " + bd.getCliente().getNome() + ", CPF: " + bd.getCliente().getCpf() + "%n";
	}
}
