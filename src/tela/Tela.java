package tela;

import java.util.Optional;

import acoes_negocio.Acoes_Adm;
import acoes_negocio.Acoes_Pedido;
import acoes_negocio.Acoes_Produto;
import baseDados.BancoDados;
import entidades.Adm;
import entidades.Cliente;
import entidades.Livro;
import entidades.Pedido;
import utilidades.LeitorDados;

public class Tela {

	private static Adm admLogado = null;
	private static BancoDados bd = new BancoDados();
	private static Acoes_Adm acoes_Adm = new Acoes_Adm(bd);
	private static Acoes_Produto acoes_Produto = new Acoes_Produto(bd);
	private static Acoes_Pedido acoes_pedido = new Acoes_Pedido(bd);

	public static void main(String[] args) {

		// estoque
		Livro[] livros = new Livro[5];
		livros[0] = new Livro("O senhor dos aneis", "Romance", 75.00);
		livros[1] = new Livro("It a coisa", "Terror", 55.00);
		livros[2] = new Livro("O iluminado", "Terror", 35.00);
		livros[3] = new Livro("Dracula", "Terror", 65.00);
		livros[4] = new Livro("A divina comedia", "Poesia", 25.00);
		for (int i = 0; i < livros.length; i++) {
			acoes_Produto.salvarProduto(livros[i]);
		}

		// banco de clientes

		System.out.println("Bem Vindo a e-Livraria");

		String opcao = "";

		while (true) {

			if (admLogado == null) {
				System.out.print("Digite o cpf: ");
				String cpf = LeitorDados.lerDados();
				identidicarUsuario(cpf);
			}

			System.out.println();
			System.out.println("1 - Cadastrar Livros");
			System.out.println("2 - Excluir Livro");
			System.out.println("3 - Fazer pedido");
			System.out.println("4 - Excluir pedido");
			System.out.println("5 - Listar produtos");
			System.out.println("6 - Listar pedidos");
			System.out.println("7 - Finalizar pedido");
			System.out.println("8 - Deslogar");
			System.out.println("9 - Sair");
			System.out.print("Selecione uma opção: ");

			opcao = LeitorDados.lerDados();
			String resp = "s";
			String cpfAdm = null;
			Optional<Adm> autenticar;
			switch (opcao) {

			case "1":

				System.out.print("Digite o cpf do administrador para proceguir:");
				cpfAdm = LeitorDados.lerDados();
				autenticar = acoes_Adm.consultar(cpfAdm);
				if (!autenticar.isEmpty()) {
					do {
						Livro livro = LeitorDados.lerLivro();
						if (acoes_Produto.salvarProduto(livro) == true) {
							System.out.println("Produto cadastrado com sucesso.");
						} else {
							System.out.println("Produto já cadastrado.");
						}
						System.out.print("Deseja cadastrar mais livros: (s/n)");
						resp = LeitorDados.lerDados();
						System.out.println();
					} while (resp.equals("s"));
					System.out.println();
					acoes_Produto.listarTodos();
					break;
				} else {
					System.out.println("permissão necessaria para continuar");
					break;
				}

			case "2":
				System.out.print("Digite o cpf do administrador para proceguir:");
				cpfAdm = LeitorDados.lerDados();
				autenticar = acoes_Adm.consultar(cpfAdm);
				if (!autenticar.isEmpty()) {
					do {
						System.out.print("Digite o codigo do livro que deseja excluir: ");
						String cod = LeitorDados.lerDados();
						acoes_Produto.excluirProduto(cod);
						System.out.print("Deseja excluir mais livros: (s/n)");
						resp = LeitorDados.lerDados();
						System.out.println();
					} while (resp.equals("s"));
					System.out.println();
					acoes_Produto.listarTodos();
					break;
				} else {
					System.out.println("permissão necessaria para continuar");
					break;
				}

			case "3":
				Cliente cliente = LeitorDados.lerCliente();
				System.out.println();
				acoes_Produto.listarTodos();
				Pedido pedido = LeitorDados.lerPedido(bd);
				acoes_pedido.salvarPedido(pedido, cliente);
				break;

			case "4":
				System.out.println("Digite o codigo do pedido");
				String codigoPedido = LeitorDados.lerDados();
				acoes_pedido.excluir(codigoPedido);
				acoes_pedido.listarTodos();
				break;

			case "5":
				acoes_Produto.listarTodos();
				break;

			case "6":
				acoes_pedido.listarTodos();
				break;

			case "7":
				System.out.print("Digite o cpf do administrador para proceguir:");
				cpfAdm = LeitorDados.lerDados();
				autenticar = acoes_Adm.consultar(cpfAdm);
				if (!autenticar.isEmpty()) {
					acoes_pedido.listarTodos();
					acoes_pedido.finalizarPedido();
				} else {
					System.out.println("Permisão necessaria.");
				}

			case "8":
				System.out.println(String.format("Volte sempre %s!", admLogado.getNome()));
				admLogado = null;
				break;

			case "9":
				System.out.println("Aplicação encerrada.");
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}

	private static void identidicarUsuario(String cpf) {
		Optional<Adm> resultado = acoes_Adm.consultar(cpf);

		if (resultado.isPresent()) {
			Adm adm = resultado.get();
			System.out.println(String.format("Olá %s! Você está logado.", adm.getNome()));
			admLogado = adm;
		} else {
			System.out.println("Usuario não encontrado");
			int chances = 3;
			int tentativas = 0;
			while (tentativas <= chances) {
				if (tentativas >= chances) {
					System.out.println("Tentativas esgotadas");
					System.out.println("Tente novamente mais tarde.");
					System.exit(0);
				}
				System.out.println("Usuario não encontrado, tente novamente(Max 3).");
				System.out.println("Tentativa Nº " + (tentativas + 1));
				System.out.print("Digite o CPF: ");
				cpf = LeitorDados.lerDados();
				resultado = acoes_Adm.consultar(cpf);
				tentativas++;
				if (resultado.isPresent()) {
					Adm adm = resultado.get();
					System.out.println(String.format("Olá %s! Você está logado.", adm.getNome()));
					admLogado = adm;
					break;
				}
			}
		}
	}
}