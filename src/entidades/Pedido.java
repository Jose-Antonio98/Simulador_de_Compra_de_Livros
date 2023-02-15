package entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private String codigo;
	private Cliente clientes;
	private List<Produto> produtos;
	private double total;
	
	
	public Pedido() {
		this.clientes = new Cliente();
		this.produtos = new ArrayList<>();
	}

	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	private String getProdutosComprados() {
		StringBuilder produtos = new StringBuilder();
		produtos.append("[");
		for(Produto produto: getProdutos()) {
			produtos.append(produto.toString());
			produtos.append(" Qtd: ");
			produtos.append(produto.getQuantidade());
		}
		produtos.append("]\n");
		
		return produtos.toString();
	}
	
	@Override
	public String toString() {
		return "Pedido: " + codigo + "\n"
				+ clientes.toString() + "\n"
				+ "Produtos: \n" 
				+ getProdutosComprados() + "\n"
				+ "Total: " + total + "\n";
	}
}
