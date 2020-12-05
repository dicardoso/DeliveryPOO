package aplicacao_console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
import java.time.LocalDateTime;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import fachada.Fachada;

public class AplicacaoConsole {
	Pedido pedido1, pedido2, pedido3, pedido4, pedido5;
	Cliente diogo, gustavo, maria, jose, bruna;
	Produto suco, sorvete, batata, hamburguer, refri;
	
	public void iniciar(){
		System.out.println("\n------------INICIALIZAÇÃO-----------------");
		try {						
			diogo = Fachada.cadastrarCliente("Diogo", "111", "Avenida 1");
			gustavo = Fachada.cadastrarCliente("Gustavo", "222", "Rua 2"); 
			maria = Fachada.cadastrarCliente("Maria", "333", "Praça A"); 
			jose = Fachada.cadastrarCliente("José", "444", "Travessa 3"); 
			bruna = Fachada.cadastrarCliente("Bruna", "555", "Avenida B"); 
			System.out.println("\n### CLIENTES\n"+Fachada.listarClientes());
			
			suco = Fachada.cadastrarProduto("Suco", 3.0);
			sorvete = Fachada.cadastrarProduto("Sorvete", 5.0);
			batata = Fachada.cadastrarProduto("Batata Frita", 2.0);
			hamburguer = Fachada.cadastrarProduto("Hambúrguer", 3.5);
			refri = Fachada.cadastrarProduto("Refrigerante", 10.0);
			System.out.println("\n### PPRODUTOS\n"+Fachada.listarProdutos(""));
			
			pedido1 = Fachada.criarPedidoExpress(diogo.getTelefone(),10); 
			
			
			pedido2 = Fachada.criarPedido(gustavo.getTelefone()); 
			Fachada.adicionarProdutoPedido(pedido2.getId(),sorvete.getId());
			Fachada.removerProdutoPedido(pedido2.getId(),sorvete.getId());
			Fachada.adicionarProdutoPedido(pedido2.getId(),hamburguer.getId());
			
			pedido3 = Fachada.criarPedido(maria.getTelefone()); 
			Fachada.adicionarProdutoPedido(pedido3.getId(),suco.getId());
			Fachada.adicionarProdutoPedido(pedido3.getId(),sorvete.getId());
			Fachada.adicionarProdutoPedido(pedido3.getId(),batata.getId());
			Fachada.removerProdutoPedido(pedido3.getId(),suco.getId());
			
			pedido4 = Fachada.criarPedido(jose.getTelefone()); 
			Fachada.adicionarProdutoPedido(pedido4.getId(),suco.getId());
			Fachada.adicionarProdutoPedido(pedido4.getId(),batata.getId());
			Fachada.adicionarProdutoPedido(pedido4.getId(),hamburguer.getId());
			Fachada.removerProdutoPedido(pedido4.getId(),hamburguer.getId());
			Fachada.adicionarProdutoPedido(pedido4.getId(),refri.getId());
			
			pedido5 = Fachada.criarPedido(bruna.getTelefone()); 
			Fachada.adicionarProdutoPedido(pedido5.getId(),suco.getId());
			Fachada.adicionarProdutoPedido(pedido5.getId(),batata.getId());
			Fachada.adicionarProdutoPedido(pedido5.getId(),hamburguer.getId());
			Fachada.adicionarProdutoPedido(pedido5.getId(),refri.getId());
			Fachada.adicionarProdutoPedido(pedido5.getId(),sorvete.getId());
			System.out.println("\n### PEDIDOS\n"+Fachada.listarPedidos());
			
			System.out.println("\n### PEDIDOS DO CLIENTE\n");
			System.out.println(Fachada.listarPedidos(diogo.getTelefone(), 2));
			
			System.out.println("\n### CONSULTAR UM PEDIDO\n");
			System.out.println(Fachada.consultarPedido(pedido3.getId()));
			
			Fachada.pagarPedido(1, "João");
			Fachada.pagarPedido(2, "José");
			Fachada.cancelarPedido(3);
			
			System.out.println("\n### CLIENTES APÓS PEDIDOS\n"+Fachada.listarClientes());
			
			System.out.println("\n### CONSULTAR ARRECADAÇÃO\n");
			System.out.println(Fachada.consultarArrecadacao(LocalDateTime.now()));
			
			System.out.println("\n### CONSULTAR TOP\n");
			System.out.println(Fachada.consultarTop());			

		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}

	//  ***********************************************
	public static void main (String[] args){
		AplicacaoConsole app = new AplicacaoConsole();
		app.iniciar();
	}
}
