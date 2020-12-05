package aplicacao_swing;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class TelaListagem extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public TelaListagem(String op) {

		setTitle("Listagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 511);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 458, 445);
		textArea.setEditable(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scroll);

		try{
			String aux = "";
			ArrayList<Pedido> pedidos;
			ArrayList<Produto> produtos;
			ArrayList<Cliente> clientes;
			String telefone = "";
			
			switch (op) {
			case "produtos":
				produtos = Fachada.listarProdutos(null);
				for(Produto p : produtos) {
					aux += p.toString() + "----------\n";
				}
				break;

			case "top":
				aux = Fachada.consultarTop();
				break;
				
			case "clientes":
				clientes = Fachada.listarClientes();
				aux = "CLIENTES\n";
				if (clientes != null) {
					for(Cliente p : clientes) {
						aux += p.toString() + "\n----------\n";
					}
				}
				else {
					aux += "\nCliente não cadastrado\n----------\n";
				}
				break;
			case "pedidos":
				pedidos = Fachada.listarPedidos();
				aux = "PEDIDOS\n";
				if (pedidos != null) {
					for(Pedido p : pedidos) {
						aux += p.toString() + "----------\n";
					}
				}
				else {
					aux += "\nNenhum pedido cadastrado\n----------\n";
				}
				break;

			case "pedidosCliente":
				telefone = JOptionPane.showInputDialog(this, "Telefone do cliente");
				
				pedidos = Fachada.listarPedidos(telefone, 3);
				aux = "PEDIDOS: "+ pedidos.get(0).getCliente().getNome() +"\n\n";
				
				for(Pedido p : pedidos) {
					aux += p.toString() + "----------\n";
				}
				
				break;
				
			case "pagos":
				telefone = JOptionPane.showInputDialog(this, "Telefone do cliente");
				
				pedidos = Fachada.listarPedidos(telefone, 1);
				aux = "PEDIDOS PAGOS: "+pedidos.get(0).getCliente().getNome()+"\n\n";
				
				for(Pedido p : pedidos) {
					aux += p.toString() + "----------\n";
				}	
				break;	
				
			case "naoPagos":
				telefone = JOptionPane.showInputDialog(this, "Telefone do cliente");
				
				pedidos = Fachada.listarPedidos(telefone, 2);
				aux = "PEDIDOS NÃO PAGOS: "+pedidos.get(0).getCliente().getNome()+"\n\n";
				for(Pedido p : pedidos) {
					aux += p.toString() + "----------\n";
				}
				break;
				
			case "arrecadacao":
				double arrecadacao;
				String data = JOptionPane.showInputDialog(this, "Data");
				
				if(!data.isEmpty()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
					LocalDateTime date = LocalDate.parse(data, formatter).atStartOfDay().plusHours(10);
			    
					arrecadacao = Fachada.consultarArrecadacao(date);
					aux = "Arrecadação para o período: " + date.format(formatter) + "\nR$ "+String.valueOf(arrecadacao);
				}
				else {
					aux = "Campo vazio";
				}
				break;
			}	
			textArea.setText(aux);
			textArea.setCaretPosition(0);
		}
		catch(Exception erro){
			textArea.setText(erro.getMessage());
		}
	}
}
