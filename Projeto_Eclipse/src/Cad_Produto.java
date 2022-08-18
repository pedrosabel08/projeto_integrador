import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Cad_Produto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cad_Produto frame = new Cad_Produto();
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
	public Cad_Produto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(85, 44, 46, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(192, 43, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(85, 84, 46, 14);
		contentPane.add(lblMarca);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 83, 118, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTamanho.setBounds(85, 129, 71, 14);
		contentPane.add(lblTamanho);
		
		textField_2 = new JTextField();
		textField_2.setBounds(192, 128, 118, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCor.setBounds(85, 176, 46, 14);
		contentPane.add(lblCor);
		
		textField_3 = new JTextField();
		textField_3.setBounds(192, 170, 118, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(286, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(163, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(42, 229, 89, 23);
		contentPane.add(btnFechar);
	}

}
