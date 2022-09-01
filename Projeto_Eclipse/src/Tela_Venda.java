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
import java.awt.event.ActionEvent;

public class Tela_Venda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Venda frame = new Tela_Venda();
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
	public Tela_Venda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(67, 71, 141, 20);
		contentPane.add(comboBox);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProduto.setBounds(108, 44, 74, 14);
		contentPane.add(lblProduto);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
		lblFormaDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFormaDePagamento.setBounds(67, 123, 141, 25);
		contentPane.add(lblFormaDePagamento);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(67, 169, 141, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblValorPagar = new JLabel("Valor \u00E0 Pagar");
		lblValorPagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorPagar.setBounds(272, 44, 93, 14);
		contentPane.add(lblValorPagar);
		
		JButton btnNewButton = new JButton("Concluir ");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(272, 96, 93, 23);
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
		btnNewButton_1.setBounds(272, 141, 93, 25);
		contentPane.add(btnNewButton_1);
	}
}
