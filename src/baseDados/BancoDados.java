package baseDados;

import java.util.ArrayList;
import java.util.List;

import entidades.Adm;
import entidades.Cliente;
import entidades.Livro;
import entidades.Pedido;
import entidades.Produto;

public class BancoDados {
	
	private List<Produto> produtos;
	private Cliente cliente;
	private List<Livro> livros;
	private List<Pedido> pedidos;
	private Adm adm;
	
	public BancoDados() {
		this.produtos = new ArrayList<>();
		this.cliente = new Cliente();
		this.livros = new ArrayList<>();
		this.pedidos = new ArrayList<>();
		this.adm = new Adm(); 
		
	}

	public Produto[] getProdutos() {
		return produtos.toArray(new Produto[produtos.size()]);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Livro[] getLivros() {
		return livros.toArray(new Livro[livros.size()]);
	}

	public Pedido[] getPedidos() {
		return pedidos.toArray(new Pedido[pedidos.size()]);
	}

	public Adm getAdm() {
		return adm;
	}

	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void removeProduto(int posisao) {
		produtos.remove(posisao);
	}
	
	public void adicionaLivros(Livro livro) {
		livros.add(livro);
	}
	
	public void removeLivros(int posisao) {
		livros.remove(posisao);
	}
	
	public void adicionaPedidos(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void removePedidos(int posisao) {
		pedidos.remove(posisao);
	}
}
