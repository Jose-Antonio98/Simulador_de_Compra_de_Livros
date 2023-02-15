package utilidades;

import java.util.Optional;
import java.util.Scanner;

import acoes_negocio.Acoes_Produto;
import baseDados.BancoDados;
import entidades.Cliente;
import entidades.Livro;
import entidades.Pedido;
import entidades.Produto;

public class LeitorDados {

	private static Scanner ler;
	
	static {
		ler = new Scanner(System.in);
	}
	
	public static String lerDados() {
		String texto = ler.nextLine();
		return texto;
	}
	
	public static Livro lerLivro() {
		System.out.println("Cadastrando Livro");
		Livro livro = new Livro();
		
		System.out.print("Informe o nome do livro: ");
		String nome = lerDados();
		livro.setNome(nome);
		
		System.out.print("Informe o genero do livro: ");
		String genero = lerDados();
		livro.setGenero(genero);
		
		System.out.print("Informe o preço do livro: ");
		String preco = lerDados();
		livro.setPreco(Double.parseDouble(preco));
		return livro;
	}
	
	public static Cliente lerCliente() {
		System.out.println();
		System.out.println("Cadastrando Novo cliente");
		Cliente cliente = new Cliente();
		
		System.out.print("Informe o nome do cliente: ");
		String nome = lerDados();
		cliente.setNome(nome);
		
		System.out.print("Informe o CPF: ");
		String cpf = lerDados();
		cliente.setCpf(cpf);
		return cliente;
	}
	
	public static Pedido lerPedido(BancoDados bd) {
		Acoes_Produto acoesProduto = new Acoes_Produto(bd);
		
		System.out.println("Registrando pedido: ");
		Pedido pedido = new Pedido();
		
		String opcao = "s";
		do {
			System.out.print("Digite o codigo do produto: ");
			String codigo = lerDados();
			
			Optional<Produto> resultado = acoesProduto.consultar(codigo.toUpperCase());
			if (resultado.isPresent()) {
				Produto produto = resultado.get();
				
				System.out.print("Digite a quantidade: ");
				String quantidade = lerDados();
				produto.setQuantidade(Integer.parseInt(quantidade));
				
				pedido.getProdutos().add(produto);
				System.out.println("Produto adicionado ao carrinho");
				System.out.println();
			}else {
				System.out.println("Produto não existente");
				break;
			}
			System.out.print("Deseja adicionar mais produtos ao pedido? (s/n) ");
			opcao = lerDados();
		}while (opcao.equals("s"));
		
		return pedido;
	}
}
