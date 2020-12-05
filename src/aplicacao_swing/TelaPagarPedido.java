package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

public class TelaPagarPedido extends JFrame {
	/**
	 * 
	 */
	private JPanel contentPane;
	private JLabel lblIdPedido;
	private JLabel lblEntregador;
	private JTextField textFieldPedido;
	private JTextField textFieldEntregador;
	private JButton btnPagar;	
	private JLabel lblmsg;
	private JButton btnLimpar;
	
	public TelaPagarPedido() {
		initialize();
	}
	
	private void initialize() {
		setTitle("Pagar Pedido");
		setBounds(100, 100, 273, 229);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIdPedido = new JLabel("ID do Pedido");
		lblIdPedido.setBounds(19, 28, 102, 14);
		contentPane.add(this.lblIdPedido);
		
		lblEntregador = new JLabel("Entregador");
		lblEntregador.setBounds(19, 56, 102, 14);
		contentPane.add(this.lblEntregador);
		
		textFieldPedido = new JTextField();
		textFieldPedido.setBounds(100, 25, 50, 20);
		contentPane.add(this.textFieldPedido);
		textFieldPedido.setColumns(10);
		
		textFieldEntregador = new JTextField();
		textFieldEntregador.setBounds(100, 53, 80, 20);
		contentPane.add(this.textFieldEntregador);
		textFieldEntregador.setColumns(10);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int idPedido = Integer.parseInt(textFieldPedido.getText());
					String nomeEntregador = textFieldEntregador.getText();
					
					Fachada.pagarPedido(idPedido, nomeEntregador);
					lblmsg.setText("Pedido pago com sucesso! Obrigado!");
				} catch (Exception e) {
					lblmsg.setText(e.getMessage());
				}
			}
		});
				
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldPedido.setText("");
				textFieldEntregador.setText("");
				textFieldPedido.requestFocus();
			}
		});
		
		btnPagar.setBounds(19, 101, 102, 23);
		contentPane.add(this.btnPagar);
		
		btnLimpar.setBounds(127, 101, 102, 23);
		contentPane.add(btnLimpar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(19, 164, 294, 14);
		contentPane.add(this.lblmsg);
	}
}
