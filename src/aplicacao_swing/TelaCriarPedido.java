package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Pedido;

public class TelaCriarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblTelefone;
	private JButton btnCriar;
	private JButton btnLimpar;
	private JLabel lblmsg;
	private JCheckBox chkExpress;
	private JLabel lblExpress;
	private JTextField textFieldExpress;
	private JLabel lblTaxa;

	/**
	 * Create the frame.
	 */
	public TelaCriarPedido() {
		setTitle("Criar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(72, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		chkExpress = new JCheckBox();
		chkExpress.setBounds(170, 11, 20, 20);
		contentPane.add(chkExpress);
		
		textFieldExpress = new JTextField();
		textFieldExpress.setBounds(72, 41, 86, 20);
		contentPane.add(textFieldExpress);
		textFieldExpress.setColumns(10);
		textFieldExpress.setVisible(false);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 14, 56, 14);
		contentPane.add(lblTelefone);
		
		lblTaxa = new JLabel("Taxa");
		lblTaxa.setBounds(10, 44, 56, 14);
		contentPane.add(lblTaxa);
		lblTaxa.setVisible(false);
		
		lblExpress = new JLabel("Pedido Express");
		lblExpress.setBounds(190, 14, 96, 14);
		contentPane.add(lblExpress);
		
		btnCriar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
		
		chkExpress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkExpress.isSelected()) {
					textFieldExpress.setVisible(true);
					lblTaxa.setVisible(true);
				}
				else {
					textFieldExpress.setVisible(false);
					lblTaxa.setVisible(false);
				}
			}
		});
		
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Pedido ped;
					lblmsg.setText("");
					if(chkExpress.isSelected()) { //Rotina Express
						if (textFieldExpress.getText().isEmpty() || textField.getText().isEmpty()) {
							lblmsg.setText(lblmsg.getText()+"Campo Telefone e/ou Taxa vazio(s)");
						}
						else {
							String telefone = textField.getText();
							String taxa = textFieldExpress.getText();
							ped = Fachada.criarPedidoExpress(telefone, Integer.parseInt(taxa));
							
							chkExpress.setSelected(false);
							textFieldExpress.setVisible(false);
							lblTaxa.setVisible(false);
							lblmsg.setText("Pedido Express criado: ID " + ped.getId());
							textField.setText("");
							textField.requestFocus();
							System.out.println(ped);
						}
					}
					else{//Rotina Normal
						if(textField.getText().isEmpty()) {
							lblmsg.setText(lblmsg.getText()+"Campo Telefone vazio");
						}
						else {
							String telefone = textField.getText();
							ped = Fachada.criarPedido(telefone);
							lblmsg.setText("Pedido criado: ID " + ped.getId());
							textField.setText("");
							textField.requestFocus();
							System.out.println(ped);
						}
					}	
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(20, 98, 115, 23);
		contentPane.add(btnCriar);
		
		btnLimpar.setBounds(176, 98, 115, 23);
		contentPane.add(btnLimpar);

		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 144, 300, 14);
		contentPane.add(lblmsg);
	}
}
