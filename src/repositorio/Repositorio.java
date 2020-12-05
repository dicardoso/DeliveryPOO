
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
package repositorio;

import java.util.ArrayList;

import modelo.Pedido;
import modelo.Produto;
import modelo.Cliente;

public class Repositorio {
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	
	//*** Produtos
	public void adicionarProduto(Produto p){
		p.setId(produtos.size() + 1);
		produtos.add(p);
	}
	public void removerProduto(Produto p){
		produtos.remove(p);
	}
	public Produto localizarProduto(int id){
		for(Produto p : produtos){
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	public Produto localizarProdutoNome(String nome){
		for(Produto p : produtos){
			if(p.getNome() == nome)
				return p;
		}
		return null;
	}
	
	//*** Clientes
	public void adicionarCliente(Cliente p){
		clientes.add(p);
	}
	public void removerCliente(Cliente p){
		clientes.remove(p);
	}
	public Cliente localizarCliente(String telefone){
		if(clientes.size() > 0) {
			for(Cliente p : clientes){
				if(p.getTelefone().equals(telefone))
					return p;
			}
		}
		return null;
	}
	
	//*** Pedidos
	public void adicionarPedido(Pedido p){
		
		if (!pedidos.isEmpty()) {
			p.setId(pedidos.get(pedidos.size()-1).getId() + 1);
		}
		else {
			p.setId(1);
		}
		pedidos.add(p);
	}
	
	public void removerPedido(Pedido p) throws Exception{
		for (Produto produto : p.getProdutos()) {
			produto.removePedido(p);
		}
		pedidos.remove(p);
	}
	public Pedido localizarPedido(int id){
			for(Pedido p : pedidos){
				if(p.getId() == id)
					return p;
			}
			return null;
		}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public int getTotalProdutos(){
		return produtos.size();
	}
	public int getTotalPedidos(){
		return pedidos.size();
	}
	public int getTotalClientes(){
		return clientes.size();
	}
}

