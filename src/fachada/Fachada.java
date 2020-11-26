/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO - Programação Orientada a Objetos
 * Prof. Fausto Ayres
 *
 */
package fachada;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelo.Pedido;
import modelo.Produto;
import modelo.Cliente;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();
	
	/*******************************
	 *  CADASTROS
	 *******************************/
	public static Produto cadastrarProduto(String nome, double preco) throws  Exception{
		Produto p = repositorio.localizarProdutoNome(nome);
		if (p!=null)
			throw new Exception("cadastrar produto - produto ja cadastrado:" + nome);

		p = new Produto(nome,preco);
		repositorio.adicionarProduto(p);
		return p;
	}
	
	public static Cliente cadastrarCliente(String telefone, String nome, String endereco) throws  Exception{
		Cliente c = repositorio.localizarCliente(telefone);
		if (c == null) {
			repositorio.adicionarCliente(new Cliente(telefone, nome, endereco));
			return new Cliente(telefone, nome, endereco);
		}
		throw new Exception("Cliente já cadastrado:" + c);	
	}
	
	public static Pedido criarPedido(String telefone) throws  Exception{
		Cliente cliente = repositorio.localizarCliente(telefone);
		if(cliente != null) {
			Pedido p = new Pedido(cliente);
			cliente.addPedidos(p);
			repositorio.adicionarPedido(p);
			return p;
		}
		throw new Exception("Cliente inexistente: Telefone " + telefone);
	}
	
	public static void adicionarProdutoPedido(int idPedido, int idProduto) throws Exception {
		Pedido pedido = repositorio.localizarPedido(idPedido);
		Produto produto = repositorio.localizarProduto(idProduto);
		
		if(pedido != null) {
			if(produto != null) {
				pedido.adicionaProduto(produto);
				produto.adicionaPedido(pedido);
			}
			else {
				throw new Exception("Produto inexistente");
			}
		}
		else {
			throw new Exception("Pedido inexistente");
		}
	}
	
	public static void removerProdutoPedido(int idPedido, int idProduto) throws Exception {
		Pedido pedido = repositorio.localizarPedido(idPedido);
		Produto produto = repositorio.localizarProduto(idProduto);
		
		if(pedido != null) {
			if(produto != null) {
				pedido.removeProduto(produto);
				produto.removePedido(pedido);
			}
			else {
				throw new Exception("Produto inexistente");
			}
		}
		else {
			throw new Exception("Pedido inexistente");
		}
	}
	
	public static void pagarPedido(int idPedido, String nomeEntregador) throws Exception {
		Pedido pedido = repositorio.localizarPedido(idPedido);
		
		if(pedido == null) {
			throw new Exception("Pedido inexistente");
		}
		else {
			pedido.setEntregador(nomeEntregador);
			pedido.setPago(true);
		}		
	}
	
	public static void cancelarPedido(int idPedido) throws Exception {
		Pedido pedido = repositorio.localizarPedido(idPedido);
		
		if(pedido == null) {
			throw new Exception("Pedido inexistente");
		}
		else {
			repositorio.removerPedido(pedido);
		}		
	}
	
	/*******************************
	 *  CONSULTAS
	 *******************************/
	public static Pedido consultarPedido(int idPedido) throws Exception {
		Pedido pedido = repositorio.localizarPedido(idPedido);
		
		if(pedido != null) {
			return pedido;
		}
		throw new Exception("Pedido inexistente");
	}
	
	public static double consultarArrecadacao(LocalDateTime dia) {
		double total = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ArrayList<Pedido> pedidos = repositorio.getPedidos();
		
		for(Pedido p : pedidos) {
			if(p.getDataHora().format(formatter).equals(dia.format(formatter))) {
				total += p.getValorTotal();
			}
		}
		return total;
	}
	
	public ArrayList<Produto> consultarTop(){
		ArrayList<Produto> aux = new ArrayList<>();
		
		return aux;
	}
	/*******************************
	 *  LISTAGEM
	 *******************************/
	public static ArrayList<Produto> listarProdutos(String texto) {
		ArrayList<Produto> produtos = repositorio.getProdutos();
		ArrayList<Produto> aux = new ArrayList<>();
		if(texto == null) {
			return produtos;
		}
		for(Produto p : produtos) {
			if (p.getNome().contains(texto)) {
				aux.add(p);
			}
		}
		return aux;
	}
	
	public static ArrayList<Cliente> listarClientes() {
		return repositorio.getClientes();
	}
	
	public static ArrayList<Pedido> listarPedidos() {	
		return repositorio.getPedidos();
	}
	
	public static ArrayList<Pedido> listarPedidos(String telefone, int tipo) {
		ArrayList<Pedido> pedidos = repositorio.getPedidos();
		ArrayList<Pedido> aux = new ArrayList<>();
		
		switch (tipo) {
		case 1:{
			for(Pedido p : pedidos) 
				if (p.isPago() && p.getCliente().getTelefone().equals(telefone)) aux.add(p);
			break;
		}
		case 2:{
			for(Pedido p : pedidos) 
				if (!p.isPago() && p.getCliente().getTelefone().equals(telefone)) aux.add(p);
			break;
		}
		case 3:{
			aux.addAll(pedidos);
			break;
		}
		default:{
			System.out.println("Tipo de pedido inválido");
		}	
		}
		return aux;
	}
}//class
