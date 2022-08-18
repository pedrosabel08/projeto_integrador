import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Tela_Estoque extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Estoque frame = new Tela_Estoque();
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
	public Tela_Estoque() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItensEmEstoque = new JLabel("Itens em Estoque");
		lblItensEmEstoque.setBounds(165, 22, 122, 17);
		lblItensEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblItensEmEstoque);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 62, 330, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Produto", "Tamanho", "Marca", "Cor"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(69, 227, 89, 23);
		contentPane.add(btnFechar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(180, 227, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(289, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
