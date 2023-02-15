package entidades;

public abstract class Produto {
	
	private String codigo;
	private double preco;
	private int quantidade;
	
	public Produto() {
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double calcTotal() {
		return this.getPreco() * this.getQuantidade();
	}
}
