package utilidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import acoes_negocio.Acoes_Pedido;
import baseDados.BancoDados;
import entidades.Pedido;

public class Arquivos {

	private File path;

	public Arquivos() {
		this.path = new File("C:\\Users\\josea\\OneDrive\\Documentos\\temp\\Workspace java\\ProjetoLivraria");

	}

	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}

	public boolean pasta() {
		File pasta = new File(getPath() + ("\\Notas"));
		if (pasta.exists()) {
			return false;
		} else {
			try {
				pasta.mkdir();
				System.out.println("Pasta de notas de pedidos Criada com sucesso");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return true;
		}
	}

	public boolean NotaFiscal(BancoDados bd, String codigo) {
		Acoes_Pedido acoes_Pedido = new Acoes_Pedido(bd);
		Optional<Pedido> pedidoFinalizado = acoes_Pedido.consultar(codigo); 
		File nota = new File(getPath() + ("\\Notas\\Nota Fiscal.txt"));
		try {
			nota.createNewFile();
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(nota, true))) {
				bw.write(bd.getAdm().toString());
				bw.newLine();
				bw.write(pedidoFinalizado.toString());
				bw.newLine();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("Nota fiscal emitada com sucesso!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

}
