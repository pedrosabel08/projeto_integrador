import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Inicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Inicial frame = new Tela_Inicial();
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
	public Tela_Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarClientes = new JButton("Cadastrar Clientes");
		btnCadastrarClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarClientes.setBounds(44, 32, 151, 23);
		contentPane.add(btnCadastrarClientes);
		
		JButton btnCadastrarProdutos = new JButton("Cadastrar Produtos");
		btnCadastrarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarProdutos.setBounds(242, 32, 165, 23);
		contentPane.add(btnCadastrarProdutos);
		
		JButton btnItensEmEstoque = new JButton("Itens em Estoque");
		btnItensEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnItensEmEstoque.setBounds(44, 105, 151, 23);
		contentPane.add(btnItensEmEstoque);
		
		JButton btnHistricoDeVendas = new JButton("Hist\u00F3rico de Vendas");
		btnHistricoDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHistricoDeVendas.setBounds(242, 105, 165, 23);
		contentPane.add(btnHistricoDeVendas);
		
		JButton btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRealizarVenda.setBounds(242, 176, 165, 23);
		contentPane.add(btnRealizarVenda);
		
		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(44, 178, 151, 23);
		contentPane.add(btnNewButton);
	}

}
