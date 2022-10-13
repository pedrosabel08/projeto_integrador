package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;

import controle.ProdutoBD;
import modelo.Produto;

import javax.swing.event.AncestorEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class TelaVenda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
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
	public TelaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstoque.setBounds(128, 41, 61, 14);
		contentPane.add(lblEstoque);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento:");
		lblFormaDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePagamento.setBounds(42, 545, 141, 25);
		contentPane.add(lblFormaDePagamento);
		
		JLabel lblValorPagar = new JLabel("Valor \u00E0 Pagar:");
		lblValorPagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorPagar.setBounds(536, 464, 93, 14);
		contentPane.add(lblValorPagar);
		
		JButton btnNewButton = new JButton("Concluir ");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(536, 499, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBounds(282, 71, 61, 14);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(536, 545, 93, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelecionar.setBounds(42, 462, 103, 23);
		contentPane.add(btnSelecionar);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u00C0 vista");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(189, 548, 68, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("A prazo");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(269, 546, 74, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(282, 486, 110, 23);
		contentPane.add(btnPesquisar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				ProdutoBD produtoBD = new ProdutoBD();
				List<Produto> listaProdutos = produtoBD.pesquisarProduto();
				
				comboBox.removeAll();
				
				for(Produto p : listaProdutos) {
					comboBox.addItem(p);
				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		comboBox.setBounds(128, 83, 93, 22);
		contentPane.add(comboBox);
	}
	
	
}
