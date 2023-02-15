package acoes_negocio;

import java.util.Optional;



public interface Interface_acesso {
	
	
	Optional<?> consultar (String cpf);
		
	boolean cadastrar (String nome, String cpf); 

	String excluir(String cpf);
		
}
