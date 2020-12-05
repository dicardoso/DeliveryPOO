package modelo;

public class PedidoExpress extends Pedido{
	private double taxaEntrega;
	
	public PedidoExpress(Cliente cliente, double taxa) {
		super(cliente);
		this.taxaEntrega = taxa;
		super.setValorTotal(taxaEntrega);
	}
}
