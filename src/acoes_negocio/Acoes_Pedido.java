package acoes_negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import baseDados.BancoDados;
import entidades.Cliente;
import entidades.Pedido;
import entidades.Produto;
import utilidades.Arquivos;
import utilidades.LeitorDados;

public class Acoes_Pedido {
	
	private BancoDados bd = new BancoDados();

	public Acoes_Pedido(BancoDados bd) {
		this.bd = bd;
	}

	public BancoDados getBd() {
		return bd;
	}

	public void setBd(BancoDados bd) {
		this.bd = bd;
	}
	
	public double valorTotal(List<Produto> produtos) {
		double total = 0.0;
		for (Produto produto : produtos) {
			total += produto.calcTotal();
		}
		return total;
	}
	
	public void salvarPedido(Pedido novoPedido, Cliente cliente) {
		String codigo = "PE%4d%2d%04d";
        LocalDate hoje = LocalDate.now();
        codigo = String.format(codigo, hoje.getYear(), hoje.getMonthValue(), hoje.getDayOfMonth(), bd.getPedidos().length);
        
        novoPedido.setCodigo(codigo);
        novoPedido.setClientes(cliente);
        novoPedido.setTotal(valorTotal(novoPedido.getProdutos()));
        bd.adicionaPedidos(novoPedido);
        System.out.println("Pedido cadastrado com sucesso.");
	}
	
	public void excluir(String codigo) {

        int pedidoExclusao = -1;
        for (int i = 0; i < bd.getPedidos().length; i++) {

            Pedido pedido = bd.getPedidos()[i];
            if (pedido.getCodigo().equals(codigo.toUpperCase())) {
                pedidoExclusao = i;
                break;
            }
        }
        if (pedidoExclusao != -1) {
            bd.removePedidos(pedidoExclusao);
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }
    }
	
	public void finalizarPedido() {
		Arquivos arquivos = new Arquivos();
		arquivos.pasta();
		System.out.print("Digite o codigo do pedido: ");
		String cod = LeitorDados.lerDados();
		arquivos.NotaFiscal(bd, cod);
	}
	
	public Optional<Pedido> consultar(String codigo) {
		for(Pedido pedido : bd.getPedidos()) {
			if(pedido.getCodigo().equals(codigo)) {
			return Optional.of(pedido);
			} 
		}
		return Optional.empty();
	}
	
	public void listarTodos() {

        if (bd.getPedidos().length == 0) {
            System.out.println("Não existem pedidos cadastrados");
        } else {

            for (Pedido pedido: bd.getPedidos()) {
                System.out.println(pedido.toString());
            }
        }
    }
}
