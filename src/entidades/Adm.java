package entidades;

public class Adm {

	private String nome;
	private String cpf;
	
	public Adm() {
		this.nome = "Joseph";
		this.cpf = "12345678910";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "Adm: " + nome + "\n";
	}
	
	
}
