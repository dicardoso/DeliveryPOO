package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pedido {
	private int id;
	private LocalDateTime dataHora;
	private double valorTotal;
	private String entregador;
	private boolean pago;
	private ArrayList<Produto> produtos = new ArrayList<>();
	private Cliente cliente;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public Pedido(Cliente cliente) {
		this.dataHora = LocalDateTime.now();
		
		this.pago = false;
		this.valorTotal = 0;
		this.entregador = "Não atribuído";
		this.cliente = cliente;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getEntregador() {
		return entregador;
	}
	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionaProduto(Produto produto) {
		this.produtos.add(produto);		
		this.setValorTotal(valorTotal + produto.getPreco());
	}
	
	public void removeProduto(Produto produto) throws Exception {
		if (produtos.contains(produto)) {
			this.produtos.remove(produto);
		}
		else {
			throw new Exception("Produto "+ produto.getNome().toUpperCase() +" não existe no pedido "+getId());
		}
	}
	@Override
	public String toString() {
		return "\nPedido " + id + "\nData e Hora: " + dataHora.format(formatter) + "\nValor Total: R$" + valorTotal + "\nEntregador:"
				+ entregador + "\nPago:" + (pago ? "S" : "N") + "\nProdutos:\n\t" + produtos + "\nCliente:" + cliente + "\n";
	}
	
}