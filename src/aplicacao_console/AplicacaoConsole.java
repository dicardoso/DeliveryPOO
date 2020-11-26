package aplicacao_console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.time.LocalDateTime;

import modelo.Pedido;
import fachada.Fachada;

public class AplicacaoConsole {
	public void cadastrar(){
		System.out.println("\n------------CADASTRO-----------------");
		try {			
			Pedido pedido;
			
			Fachada.cadastrarCliente("Diogo", "111", "Avenida 1");
			Fachada.cadastrarCliente("Gustavo", "222", "Rua 2"); 
			Fachada.cadastrarCliente("Maria", "333", "Praça A"); 
			Fachada.cadastrarCliente("José", "444", "Travessa 3"); 
			
			Fachada.cadastrarProduto("arroz", 3.0);
			Fachada.cadastrarProduto("feijao", 5.0);
			Fachada.cadastrarProduto("leite", 2.0);
			Fachada.cadastrarProduto("carne", 30.0);
			Fachada.cadastrarProduto("oleo", 10.0);
			
			pedido = Fachada.criarPedido("111"); 
			Fachada.adicionarProdutoPedido(pedido.getId(),1);
			Fachada.adicionarProdutoPedido(pedido.getId(),2);
			Fachada.removerProdutoPedido(pedido.getId(),2);
			Fachada.adicionarProdutoPedido(pedido.getId(),3);
			Fachada.adicionarProdutoPedido(pedido.getId(),4);
			
			pedido = Fachada.criarPedido("222"); 
			Fachada.adicionarProdutoPedido(pedido.getId(),2);
			Fachada.adicionarProdutoPedido(pedido.getId(),3);
			Fachada.removerProdutoPedido(pedido.getId(),3);
			Fachada.adicionarProdutoPedido(pedido.getId(),1);
			
			pedido = Fachada.criarPedido("333"); 
			Fachada.adicionarProdutoPedido(pedido.getId(),1);
			Fachada.adicionarProdutoPedido(pedido.getId(),2);
			Fachada.adicionarProdutoPedido(pedido.getId(),3);
			Fachada.removerProdutoPedido(pedido.getId(),3);
			
			pedido = Fachada.criarPedido("444"); 
			Fachada.adicionarProdutoPedido(pedido.getId(),1);
			Fachada.adicionarProdutoPedido(pedido.getId(),3);
			Fachada.adicionarProdutoPedido(pedido.getId(),4);
			Fachada.removerProdutoPedido(pedido.getId(),4);
			Fachada.adicionarProdutoPedido(pedido.getId(),5);
			
			//System.out.println(Fachada.listarPedidos("987192720", 2));
			
			//System.out.println(Fachada.consultarPedido(3));
			
			Fachada.pagarPedido(1, "João");
			Fachada.pagarPedido(2, "José");
			Fachada.cancelarPedido(3);
			
			System.out.println(Fachada.consultarArrecadacao(LocalDateTime.now()));
			

		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}

	public void atualizar(){
		System.out.println("\n------------ATUALIZACAO-----------------");
		
	}

	public  void excluir(){
		System.out.println("\n------------EXCLUSAO-----------------");
		
	}

	public void listar(){
		System.out.println("\n------------LISTAGEM-----------------");

	}

	public void consultar(){
		System.out.println("\n------------CONSULTAS-----------------");

		
	}

	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		AplicacaoConsole app = new AplicacaoConsole();
		app.cadastrar();
		//app.atualizar();
//		app.excluir();
		//app.listar();
		//app.consultar();
	}

}
