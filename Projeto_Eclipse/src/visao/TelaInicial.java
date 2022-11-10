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
import javax.swing.UIManager;

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
		setBounds(100, 100, 490, 320);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarClientes = new JButton("Clientes");
		btnCadastrarClientes.setBackground(UIManager.getColor("Button.shadow"));
		btnCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrameCliente frame = new FrameCliente();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnCadastrarClientes.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnCadastrarClientes.setBounds(44, 32, 151, 23);
		contentPane.add(btnCadastrarClientes);
		
		JButton btnCadastrarProdutos = new JButton("Produtos");
		btnCadastrarProdutos.setBackground(UIManager.getColor("Button.shadow"));
		btnCadastrarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaEstoque frame = new TelaEstoque();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnCadastrarProdutos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnCadastrarProdutos.setBounds(276, 32, 151, 23);
		contentPane.add(btnCadastrarProdutos);
		
		JButton btnHistricoDeVendas = new JButton("Hist\u00F3rico");
		btnHistricoDeVendas.setBackground(UIManager.getColor("Button.shadow"));
		btnHistricoDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistVendas frame = new HistVendas();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnHistricoDeVendas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnHistricoDeVendas.setBounds(44, 168, 151, 23);
		contentPane.add(btnHistricoDeVendas);
		
		JButton btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.setBackground(UIManager.getColor("Button.shadow"));
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaVenda frame = new TelaVenda();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
							}
		});
		btnRealizarVenda.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnRealizarVenda.setBounds(276, 168, 151, 23);
		contentPane.add(btnRealizarVenda);
		
		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(153, 232, 167, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Funcion\u00E1rios");
		btnNewButton_1.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrameFuncionario func = new FrameFuncionario();
				func.setLocationRelativeTo(null);
				func.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnNewButton_1.setBounds(44, 98, 151, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fornecedor");
		btnNewButton_2.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrameFornecedor frame = new FrameFornecedor();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnNewButton_2.setBounds(276, 98, 151, 23);
		contentPane.add(btnNewButton_2);
	}

}
