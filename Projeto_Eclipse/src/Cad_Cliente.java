import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cad_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtNasc;
	private JTextField txtRG;
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private Cliente clienteSelecionado;
	private JTextField txtID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cad_Cliente frame = new Cad_Cliente();
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
	public Cad_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCompleto.setBounds(44, 77, 135, 14);
		contentPane.add(lblNomeCompleto);
		
		txtNome = new JTextField();
		txtNome.setBounds(198, 76, 186, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(125, 113, 44, 14);
		contentPane.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(198, 112, 186, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(21, 146, 135, 14);
		contentPane.add(lblDataDeNascimento);
		
		txtNasc = new JTextField();
		txtNasc.setBounds(198, 145, 186, 20);
		contentPane.add(txtNasc);
		txtNasc.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRg.setBounds(125, 184, 37, 14);
		contentPane.add(lblRg);
		
		txtRG = new JTextField();
		txtRG.setBounds(198, 183, 186, 20);
		contentPane.add(txtRG);
		txtRG.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente;
				cliente = new Cliente();
				cliente.setId(txtID.getText());
				cliente.setNome(txtNome.getText());
				cliente.setCPF(txtCPF.getText());
				cliente.setNasc(txtNasc.getText());
				cliente.setRG(txtRG.getText());

				
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(285, 248, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtNome.setText("");
				txtCPF.setText("");
				txtNasc.setText("");
				txtRG.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(158, 248, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(33, 248, 89, 23);
		contentPane.add(btnFechar);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(125, 52, 19, 14);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(198, 45, 186, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
	}
	protected void limparCampos() {
		txtNome.setText("");
		txtCPF.setText("");
		txtNasc.setText("");
		txtRG.setText("");
	}
	protected void atualizarJTable() {
		DefaultTableModel modelo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Nasc", "RG"
			}
		);
		
		for(int i=0; i< listaClientes.size(); i++) {
			Cliente c = listaClientes.get(i);
			modelo.addRow(new Object[] { c.getNome(), c.getCPF(), c.getNasc(), c.getRG() });
		}
		
		
}
}
