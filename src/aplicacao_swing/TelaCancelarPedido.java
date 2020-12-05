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

public class TelaCancelarPedido extends JFrame {
	private JPanel contentPane;
	private JLabel lblIdPedido;
	private JTextField textFieldPedido;
	private JButton btnCancelar;	
	private JLabel lblmsg;
	private JButton btnLimpar;
	
	public TelaCancelarPedido() {
		initialize();
	}
		
	private void initialize() {
		setTitle("Pagar Pedido");
		setBounds(100, 100, 273, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIdPedido = new JLabel("ID do Pedido");
		lblIdPedido.setBounds(19, 28, 102, 14);
		contentPane.add(this.lblIdPedido);
		textFieldPedido = new JTextField();
		textFieldPedido.setBounds(100, 25, 50, 20);
		contentPane.add(this.textFieldPedido);
		textFieldPedido.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					if(textFieldPedido.getText().isEmpty()) {
						lblmsg.setText("Campo vazio");
					}
					
					else {
						int idPedido = Integer.parseInt(textFieldPedido.getText());
						Fachada.cancelarPedido(idPedido);
						lblmsg.setText("Pedido cancelado com sucesso!");
						textFieldPedido.setText("");
						textFieldPedido.requestFocus();
					}
				} catch (Exception e) {
					lblmsg.setText(e.getMessage());
				}
			}
		});
				
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldPedido.setText("");
				textFieldPedido.requestFocus();
			}
		});
		
		btnCancelar.setBounds(19, 101, 102, 23);
		contentPane.add(this.btnCancelar);
		
		btnLimpar.setBounds(127, 101, 102, 23);
		contentPane.add(btnLimpar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(19, 134, 294, 14);
		contentPane.add(this.lblmsg);
	}		
}
