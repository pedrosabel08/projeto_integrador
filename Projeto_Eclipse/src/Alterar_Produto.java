import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alterar_Produto extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTextField txtTamanho;
	private JTextField txtCor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alterar_Produto frame = new Alterar_Produto();
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
	public Alterar_Produto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(91, 36, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(91, 61, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(91, 86, 46, 14);
		contentPane.add(lblMarca);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTamanho.setBounds(91, 111, 82, 14);
		contentPane.add(lblTamanho);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCor.setBounds(91, 136, 46, 14);
		contentPane.add(lblCor);
		
		txtID = new JTextField();
		txtID.setBounds(189, 35, 131, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(189, 60, 131, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(189, 85, 131, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtTamanho = new JTextField();
		txtTamanho.setBounds(189, 110, 131, 20);
		contentPane.add(txtTamanho);
		txtTamanho.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(189, 135, 131, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(63, 227, 89, 23);
		contentPane.add(btnFechar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtNome.setText("");
				txtMarca.setText("");
				txtTamanho.setText("");
				txtCor.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(162, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(261, 227, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreo.setBounds(91, 161, 46, 14);
		contentPane.add(lblPreo);
		
		textField = new JTextField();
		textField.setBounds(189, 160, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
