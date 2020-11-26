package modelo;

import java.util.ArrayList;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

public class Produto {
		private int id;
		private String nome;
		private double preco;
		private ArrayList<Pedido> pedidos = new ArrayList<>();
		
		public Produto(String nome,  double preco) {
			this.nome = nome;
			this.preco = preco;
		}
		
		public ArrayList<Pedido> getPedidos() {
			return pedidos;
		}

		public void setPedidos(ArrayList<Pedido> pedidos) {
			this.pedidos = pedidos;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		
		public void adicionaPedido(Pedido pedido) {
			this.pedidos.add(pedido);
		}
		
		public void removePedido(Pedido pedido) throws Exception {
			if (pedidos.contains(pedido)) {
				this.pedidos.remove(pedido);
			}
			else {
				throw new Exception("Pedido "+ pedido.getId() +" não existe para ser removido");
			}
		}
		
		//---------------------------------------
		
		@Override
		public String toString() {
			return "Produto: " + nome + ", Preço: R$ " + preco + "\n\t";
		}	
}
