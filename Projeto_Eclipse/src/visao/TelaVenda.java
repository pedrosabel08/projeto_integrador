package visao;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import visao.TelaEstoque;
import controle.ProdutoBD;
import modelo.Produto;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTable tabelaProdVenda;
	public JTextField textField;
	public JTextField txtID;

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
		TelaVenda TV = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento:");
		lblFormaDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePagamento.setBounds(45, 260, 141, 25);
		contentPane.add(lblFormaDePagamento);
		
		JLabel lblValorPagar = new JLabel("Valor \u00E0 Pagar:");
		lblValorPagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorPagar.setBounds(45, 376, 93, 23);
		contentPane.add(lblValorPagar);
		
		JButton btnNewButton = new JButton("Concluir ");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(45, 410, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicial inicio = new TelaInicial();
				inicio.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(45, 444, 93, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelecionar.setBounds(45, 211, 103, 23);
		contentPane.add(btnSelecionar);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u00C0 vista");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(45, 294, 68, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("A prazo");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(115, 294, 74, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(602, 67, 141, 307);
		contentPane.add(scrollPane);
		
		tabelaProdVenda = new JTable();
		tabelaProdVenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Quantidade"
			}
		));
		scrollPane.setViewportView(tabelaProdVenda);
		
		JLabel lblNewLabel = new JLabel("Carrinho");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(645, 42, 68, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 121, 91, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(45, 146, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(45, 72, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setBounds(45, 90, 46, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Calcular");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(45, 342, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaProduto TP = new TabelaProduto(TV);
				TP.setVisible(true);
				setVisible(false);
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(45, 177, 103, 23);
		contentPane.add(btnPesquisar);
		
	}
	
}

