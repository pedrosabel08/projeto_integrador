package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

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
					frame.setLocationRelativeTo(null);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCliente.class.getResource("/Imagens/inicial.png")));
		setBounds(100, 100, 1800, 900);
		this.setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(18, 183, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarClientes = new JButton("  Clientes");
		btnCadastrarClientes.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagens/Cliente.png")));
		btnCadastrarClientes.setBackground(UIManager.getColor("Button.focus"));
		btnCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrameCliente frame = new FrameCliente();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnCadastrarClientes.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnCadastrarClientes.setBounds(542, 177, 182, 71);
		contentPane.add(btnCadastrarClientes);
		
		JButton btnCadastrarProdutos = new JButton("  Produtos");
		btnCadastrarProdutos.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagens/produtos.png")));
		btnCadastrarProdutos.setBackground(UIManager.getColor("Button.focus"));
		btnCadastrarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaEstoque frame = new TelaEstoque();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnCadastrarProdutos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnCadastrarProdutos.setBounds(906, 177, 182, 71);
		contentPane.add(btnCadastrarProdutos);
		
		JButton btnHistricoDeVendas = new JButton("  Hist\u00F3rico");
		btnHistricoDeVendas.setIcon(new ImageIcon("C:\\Users\\Aluno\\projeto_integrador\\Projeto_Eclipse\\src\\Imagens\\historico.png"));
		btnHistricoDeVendas.setBackground(UIManager.getColor("Button.focus"));
		btnHistricoDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistVendas frame = new HistVendas();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnHistricoDeVendas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnHistricoDeVendas.setBounds(542, 455, 182, 71);
		contentPane.add(btnHistricoDeVendas);
		
		JButton btnRealizarVenda = new JButton("    Venda");
		btnRealizarVenda.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagens/carrinhodecompras.png")));
		btnRealizarVenda.setBackground(UIManager.getColor("Button.focus"));
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaVenda frame = new TelaVenda();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
							}
		});
		btnRealizarVenda.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnRealizarVenda.setBounds(906, 455, 182, 71);
		contentPane.add(btnRealizarVenda);
		
		JButton btnNewButton = new JButton("Fechar Sistema");
		btnNewButton.setBackground(UIManager.getColor("Button.focus"));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(542, 585, 182, 71);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Funcionarios");
		btnNewButton_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagens/Funcionario.png")));
		btnNewButton_1.setBackground(UIManager.getColor("Button.focus"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrameFuncionario func = new FrameFuncionario();
				func.setLocationRelativeTo(null);
				func.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_1.setBounds(542, 313, 182, 71);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fornecedor");
		btnNewButton_2.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagens/Fornecedor.png")));
		btnNewButton_2.setBackground(UIManager.getColor("Button.focus"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrameFornecedor frame = new FrameFornecedor();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_2.setBounds(906, 313, 182, 71);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Tela Inicial");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
		lblNewLabel.setBounds(728, 90, 182, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Log Off");
		btnNewButton_3.setBackground(UIManager.getColor("Button.focus"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin frame = new TelaLogin();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_3.setBounds(906, 585, 182, 71);
		contentPane.add(btnNewButton_3);
	}
}
