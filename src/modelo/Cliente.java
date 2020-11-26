package modelo;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String telefone;
	private String endereco;
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	
	public Cliente(String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public void addPedidos(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public void removePedidos(Pedido pedido) throws Exception {
		if (pedidos.contains(pedido)) {
			this.pedidos.remove(pedido);
		}
		else {
			throw new Exception("Pedido "+ pedido.getId() +" não existe para ser removido");
		}
	}

	@Override
	public String toString() {
		String ped = "";
		for (Pedido p : pedidos) {
			ped += "\n"+p.getId();
		}
		return "\nNome:" + nome + "\nTelefone: " + telefone + "\nEndereco:" + endereco + "\nPedidos:" + ped ;
	}
	
}
