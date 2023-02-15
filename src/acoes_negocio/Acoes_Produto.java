package acoes_negocio;

import java.util.Optional;

import baseDados.BancoDados;
import entidades.Produto;

public class Acoes_Produto {
	
	private BancoDados bd = new BancoDados();

	public Acoes_Produto(BancoDados bd) {
		this.bd = bd;
	}
	
	public Boolean salvarProduto(Produto novoProduto) {

		String codigo = "PR%04d";
		codigo = String.format(codigo, bd.getProdutos().length);
		novoProduto.setCodigo(codigo);
		 	
		boolean produtoRepetido = false;
		for (Produto produto : bd.getProdutos()) {
			if (produto.getCodigo() == novoProduto.getCodigo()) {
				produtoRepetido = true;
				break;
			}
		}
		if (!produtoRepetido) {
			this.bd.adicionarProduto(novoProduto);
			return true;
		}
		return false;
	}
	
	public void excluirProduto(String codigo) {
		
		int produtoExclusao = -1;
		for (int i = 0; i < bd.getProdutos().length; i++) {
			
			Produto produto = bd.getProdutos()[i];
			if (produto.getCodigo().equals(codigo.toUpperCase())) {
				produtoExclusao = i;
				break;
			}
		}
		
		if (produtoExclusao != -1) {
			bd.removeProduto(produtoExclusao);
			System.out.println("Produto excluido com sucesso.");
		} else {
			System.out.println("Produto inexistente.");
		}
	}
	
	public Optional<Produto> consultar(String cogigo) {
		for (Produto produto : bd.getProdutos()) {
			if(produto.getCodigo().equals(cogigo)) {
				return Optional.of(produto);
			}
		}
		return Optional.empty();
	}
	
	public void listarTodos() {
		if (bd.getProdutos().length == 0) {
			System.out.println("Não existem produtos acadastrados");
		} else {
			for (Produto produto : bd.getProdutos()) {
				System.out.println(produto.toString());
			}
		}
	}
}
