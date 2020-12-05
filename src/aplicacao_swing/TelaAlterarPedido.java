
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
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

public class TelaAlterarPedido extends JFrame {
	private JPanel contentPane;
	private JLabel lblIdPedido;
	private JLabel lblIdProduto;
	private JTextField textFieldPedido;
	private JTextField textFieldProduto;
	private JButton btnInserir;	
	private JLabel lblmsg;
	private JButton btnLimpar;
	private JButton button;

	/**
	 * Create the application.
	 */
	public TelaAlterarPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Alterar Pedido");
		setBounds(100, 100, 273, 229);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblIdPedido = new JLabel("ID do Pedido");
		lblIdPedido.setBounds(19, 28, 102, 14);
		contentPane.add(this.lblIdPedido);
		
		lblIdProduto = new JLabel("ID do Produto");
		lblIdProduto.setBounds(19, 56, 102, 14);
		contentPane.add(this.lblIdProduto);
		
		textFieldPedido = new JTextField();
		textFieldPedido.setBounds(124, 25, 50, 20);
		contentPane.add(this.textFieldPedido);
		textFieldPedido.setColumns(10);
		
		textFieldProduto = new JTextField();
		textFieldProduto.setBounds(124, 53, 50, 20);
		contentPane.add(this.textFieldProduto);
		textFieldProduto.setColumns(10);
		
		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int idPedido = Integer.parseInt(textFieldPedido.getText());
					int idProduto = Integer.parseInt(textFieldProduto.getText());
					
					Fachada.adicionarProdutoPedido(idPedido, idProduto);
					
					lblmsg.setText("Produto inserido ");
				} catch (NumberFormatException e) {
					lblmsg.setText("Campo id deve ser numerico");
				} catch (Exception e) {
					lblmsg.setText(e.getMessage());
				}
			}
		});
		btnInserir.setBounds(19, 101, 102, 23);
		contentPane.add(this.btnInserir);
		lblmsg = new JLabel("");
		lblmsg.setBounds(19, 164, 294, 14);
		contentPane.add(this.lblmsg);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldPedido.setText("");
				textFieldProduto.setText("");
				textFieldPedido.requestFocus();
			}
		});
		btnLimpar.setBounds(81, 130, 102, 23);
		contentPane.add(this.btnLimpar);
		
		button = new JButton("Remover");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idPedido = Integer.parseInt(textFieldPedido.getText());
					int idProduto = Integer.parseInt(textFieldProduto.getText());	
					
					Fachada.removerProdutoPedido(idPedido, idProduto);
					
					lblmsg.setText("Produto removido");
				} catch (Exception e1) {
					lblmsg.setText(e1.getMessage());
				}
			}
		});
		button.setBounds(127, 101, 102, 23);
		contentPane.add(button);
	}
}
