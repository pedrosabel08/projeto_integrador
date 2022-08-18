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
		lblNomeCompleto.setBounds(43, 43, 135, 14);
		contentPane.add(lblNomeCompleto);
		
		txtNome = new JTextField();
		txtNome.setBounds(188, 42, 186, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(118, 93, 44, 14);
		contentPane.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(188, 92, 186, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(21, 136, 157, 14);
		contentPane.add(lblDataDeNascimento);
		
		txtNasc = new JTextField();
		txtNasc.setBounds(188, 135, 186, 20);
		contentPane.add(txtNasc);
		txtNasc.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRg.setBounds(125, 187, 37, 14);
		contentPane.add(lblRg);
		
		txtRG = new JTextField();
		txtRG.setBounds(188, 186, 186, 20);
		contentPane.add(txtRG);
		txtRG.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String CPF = txtCPF.getText();
				String Nasc = txtNasc.getText();
				String RG = txtRG.getText();
				Cliente c = new Cliente();
				c.setNome(nome);
				c.setCPF(CPF);
				c.setNasc(Nasc);
				c.setRG(RG);
				listaClientes.add(c);
				atualizarJTable();
				limparCampos();
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(285, 248, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
