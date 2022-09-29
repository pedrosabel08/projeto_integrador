package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controle.ClienteBD;
import modelo.Cliente;

public class ManterCliente extends JFrame {

	protected static final int posicaoPessoa = 0;
	protected static final int pessoaSelecionada = 0;
	private JPanel contentPane;
	public JTextField txtNome;
	public JTextField txtCPF;
	public JTextField txtNasc;
	public JTextField txtRG;
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private Cliente clienteSelecionado;
	static Connection conexao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManterCliente frame = new ManterCliente();
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
	public ManterCliente() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 360);
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

		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = txtNome.getText();
				String cpf = txtCPF.getText();
				String rg = txtRG.getText();
				String dataNasc = txtNasc.getText();

				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setCPF(cpf);
				cliente.setRG(rg);
				cliente.setData_nascimento(dataNasc);

				ClienteBD bdCliente = new ClienteBD();
				boolean cadastrou = bdCliente.inserirCliente(cliente);

				if (cadastrou == false) {
					JOptionPane.showMessageDialog(null, "Erro. Cliente não cadastrado!");
				} else {
					txtNome.setText("");
					txtCPF.setText("");
					txtRG.setText("");
					txtNasc.setText("");
				}

			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(268, 248, 106, 23);
		contentPane.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCPF.setText("");
				txtRG.setText("");
				txtNasc.setText("");
			}
		});
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(46, 248, 89, 23);
		contentPane.add(btnFechar);

		JButton btntabela = new JButton("Tabela");
		btntabela.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btntabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaClientes lc = new ListaClientes();
				lc.setVisible(true);
				setVisible(false);
			}
		});
		btntabela.setBounds(158, 248, 89, 23);
		contentPane.add(btntabela);

		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClienteBD clientebd = new ClienteBD();
				
				Cliente cliente = listaClientes.get(pessoaSelecionada);

				String nome = txtNome.getText();
				String cpf = txtCPF.getText();
				String rg = txtRG.getText();
				String dataNasc = txtNasc.getText();

				cliente.setNome(nome);
				cliente.setCPF(cpf);
				cliente.setRG(rg);
				cliente.setData_nascimento(dataNasc);

				int result = clientebd.alterarClientes(cliente);

				listaClientes.set(result, cliente);

				txtNome.setText("");
				txtCPF.setText("");
				txtRG.setText("");
				txtNasc.setText("");
			}
		});
		btnNewButton.setBounds(401, 250, 89, 23);
		contentPane.add(btnNewButton);
	}

}
