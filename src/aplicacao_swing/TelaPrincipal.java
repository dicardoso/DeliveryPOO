package aplicacao_swing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import aplicacao_console.AplicacaoConsole;
import fachada.Fachada;
import modelo.Produto;

public class TelaPrincipal {
	private JFrame frame;
	private JLabel label;
	private JMenu mnListagem;
	private JMenuItem mntmCriar;
	private JMenuItem mntmCancelar;
	private JMenuItem mntmClientes;
	private JMenu mnPedido;
	private JMenuItem mntmPagar;
	private JMenuItem mntmAlterar;
	private JMenu mntmProdutos;
	private AbstractButton mntmPedidos;
	private AbstractButton mntmPedidos1;
	private JMenuItem mntmArrecadacao;
	private JMenuItem mntmProdutos1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Delivery POO");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					new AplicacaoConsole().cadastrar();
					
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(frame, "até breve !");
			}
		});

		frame.setBounds(100, 100, 384, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//imagem de fundo
		label = new JLabel("");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight()); //fundo da janela

		ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/imagem1.jpg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(imagem);
		frame.getContentPane().add(label);
		frame.setResizable(false);

		//-------------BARRA DE MENU-----------------------------------
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		//-------------MENU-----------------------------------
		mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);

		mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCriarPedido j = new TelaCriarPedido();
				j.setVisible(true);
			}
		});
		mnPedido.add(mntmCriar);

		mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlterarPedido j = new TelaAlterarPedido();
				j.setVisible(true);
			}
		});
		mnPedido.add(mntmAlterar);

		mntmPagar = new JMenuItem("Pagar");
		mntmPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPagarPedido j = new TelaPagarPedido();
				j.setVisible(true);
			}
		});
		mnPedido.add(mntmPagar);
		
		mntmCancelar = new JMenuItem("Cancelar");
		mntmCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				j.setVisible(true);
			}
		});
		mnPedido.add(mntmCancelar);

		//-------------MENU-----------------------------------
		mnListagem = new JMenu("Listagem");
		menuBar.add(mnListagem);

		mntmProdutos = new JMenu("Produtos");
		mnListagem.add(mntmProdutos);
		
		mntmProdutos1 = new JMenuItem("Todos");
		mntmProdutos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				j.setVisible(true);
			}
		});
		mntmProdutos.add(mntmProdutos1);
		
		mntmProdutos1 = new JMenuItem("Top");
		mntmProdutos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				j.setVisible(true);
			}
		});
		mntmProdutos.add(mntmProdutos1);

		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				j.setVisible(true);
			}
		});
		mnListagem.add(mntmClientes);

		mntmPedidos = new JMenu("Pedidos");
		mnListagem.add(mntmPedidos);
		
		mntmPedidos1 = new JMenuItem("Todos");
		mntmPedidos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem();
				j.setVisible(true);
			}
		});
		mntmPedidos.add(mntmPedidos1);
		
		mntmPedidos1 = new JMenuItem("Por cliente");
		mntmPedidos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroPrateleira j = new TelaCadastroPrateleira();
				j.setVisible(true);
			}
		});
		mntmPedidos.add(mntmPedidos1);
		
		mntmPedidos1 = new JMenuItem("Pagos por cliente");
		mntmPedidos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroPrateleira j = new TelaCadastroPrateleira();
				j.setVisible(true);
			}
		});
		mntmPedidos.add(mntmPedidos1);

		mntmPedidos1 = new JMenuItem("Não pagos por cliente");
		mntmPedidos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroPrateleira j = new TelaCadastroPrateleira();
				j.setVisible(true);
			}
		});
		mntmPedidos.add(mntmPedidos1);
		
		mntmArrecadacao = new JMenuItem("Arrecadação");
		mntmArrecadacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroPrateleira j = new TelaCadastroPrateleira();
				j.setVisible(true);
			}
		});
		mnListagem.add(mntmArrecadacao);
	}
}
