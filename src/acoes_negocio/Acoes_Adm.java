package acoes_negocio;

import java.util.Optional;

import baseDados.BancoDados;
import entidades.Adm;

public class Acoes_Adm implements Interface_acesso {

	private BancoDados bd;
	
	public Acoes_Adm(BancoDados bd) {
		this.bd = bd;
	}

	@Override
	public Optional<Adm> consultar(String cpf) {
		if (bd.getAdm().getCpf().equals(cpf)) {
			return Optional.of(bd.getAdm());
		} else {
			return Optional.empty();
		}
	}

	@Override
	public boolean cadastrar(String nome, String cpf) {
		if(!bd.getAdm().getCpf().equals(cpf)){
			bd.getAdm().setNome(nome);
			bd.getAdm().setCpf(cpf);
			System.out.println("Perfil administrador cadastrado com sucesso!");
			return true;
		}else {
			return false;
		}	
	}

	@Override
	public String excluir(String cpf) {
		if(bd.getAdm().getCpf().equals(cpf)) {
			bd.getAdm().setNome(null);
			bd.getAdm().setCpf(null);
			return "Perfil administrador excluido com sucesso!";
		}else {
			return "perfil não existe";
		}
	}

	@Override
	public String toString() {
		return "Responsavel pela venda: " + bd.getAdm().getNome() + "%n";
	}	
}
