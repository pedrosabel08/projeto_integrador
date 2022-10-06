package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarClientes = new JButton("Clientes");
		btnCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrameCliente frame = new FrameCliente();
				frame.setVisible(true);
			}
		});
		btnCadastrarClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarClientes.setBounds(44, 32, 151, 23);
		contentPane.add(btnCadastrarClientes);
		
		JButton btnCadastrarProdutos = new JButton("Produtos");
		btnCadastrarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque frame = new TelaEstoque();
				frame.setVisible(true);
			}
		});
		btnCadastrarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarProdutos.setBounds(242, 32, 165, 23);
		contentPane.add(btnCadastrarProdutos);
		
		JButton btnHistricoDeVendas = new JButton("Hist\u00F3rico de Vendas");
		btnHistricoDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoVendas frame = new HistoricoVendas();
				frame.setVisible(true);
			}
		});
		btnHistricoDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHistricoDeVendas.setBounds(242, 178, 165, 23);
		contentPane.add(btnHistricoDeVendas);
		
		JButton btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVenda frame = new TelaVenda();
				frame.setVisible(true);
			}
		});
		btnRealizarVenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRealizarVenda.setBounds(131, 108, 165, 23);
		contentPane.add(btnRealizarVenda);
		
		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(44, 178, 151, 23);
		contentPane.add(btnNewButton);
	}

}
