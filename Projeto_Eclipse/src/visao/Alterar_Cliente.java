package visao;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.ClienteBD;
import modelo.Cliente;

public class Alterar_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtNasc;
	private JTextField txtRG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alterar_Cliente frame = new Alterar_Cliente();
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
	public Alterar_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCompleto.setBounds(93, 45, 111, 14);
		contentPane.add(lblNomeCompleto);
		
		txtNome = new JTextField();
		txtNome.setBounds(213, 44, 142, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(167, 91, 35, 14);
		contentPane.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(213, 90, 142, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(68, 134, 134, 14);
		contentPane.add(lblDataDeNascimento);
		
		txtNasc = new JTextField();
		txtNasc.setBounds(213, 133, 142, 20);
		contentPane.add(txtNasc);
		txtNasc.setColumns(10);
		
		JLabel lblRG = new JLabel("RG:");
		lblRG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRG.setBounds(167, 179, 46, 14);
		contentPane.add(lblRG);
		
		txtRG = new JTextField();
		txtRG.setBounds(213, 178, 142, 20);
		contentPane.add(txtRG);
		txtRG.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = listaClientes.get(posicaoPessoa);

				String nome = txtNome.getText();
				String cpf = txtCPF.getText();
				String rg = txtRG.getText();
				String dataNasc = txtNasc.getText();
				
				cliente.setNome(nome);
				cliente.setCPF(cpf);
				cliente.setRG(rg);
				cliente.setNasc(dataNasc);
											
				int result = cliente.alterarClientes(cliente);
			
				listaClientes.set(result, cliente);


				while (table.getModel().getRowCount() > 0) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				
				}

				ClienteBD clientebd = new ClienteBD();
				listaClientes = clientebd.listarClientes();
				table = new JTable();
				table.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "Nome", "CPF", "RG", "Nasc"}));
				scrollPane.setViewportView(table);

				modelo = (DefaultTableModel) table.getModel();
				for (int i = 0; i < listaClientes.size(); i++) {
					Cliente c = listaClientes.get(i);
					modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getCPF(), c.getRG(), c.getNasc()});

				}
				table.setModel(modelo);
				
				txtNome.setText("");
				txtCPF.setText("");
				txtRG.setText("");
				txtNasc.setText("");
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(266, 227, 89, 23);
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
		btnLimpar.setBounds(167, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(68, 227, 89, 23);
		contentPane.add(btnFechar);
		
		JButton btnAlterar = new JButton("alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAlterar.setBounds(365, 229, 89, 23);
		contentPane.add(btnAlterar);
	}

}
