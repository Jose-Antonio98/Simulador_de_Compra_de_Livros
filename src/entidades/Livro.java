package entidades;

public class Livro extends Produto{
	
	private String nome;
	private String genero;
	
	public Livro(String nome, String genero, double valor) {
		this.nome = nome;
		this.genero = genero;
		this.setPreco(valor);
	}
	
	public Livro() {
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public double calcTotal() {
		return this.getPreco() * this.getQuantidade();
	}

	@Override
	public String toString() {
		return "COD: " + getCodigo() + " Livro: " + nome + ", genero: " + genero + ", valor uni: " + this.getPreco() + "\n";
	}
	
	
}
