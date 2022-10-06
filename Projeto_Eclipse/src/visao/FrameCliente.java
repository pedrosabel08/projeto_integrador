package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ClienteBD;
import controle.FuncionarioBD;
import modelo.Cliente;
import modelo.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCliente extends JFrame {

	private JPanel ContentPane;
	private JTable tabelaCliente;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtNasc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCliente frame = new FrameCliente();
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
	public FrameCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 440);
		ContentPane = new JPanel();
		ContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(ContentPane);
		ContentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 39, 618, 200);
		ContentPane.add(scrollPane);
		
		tabelaCliente = new JTable();
		tabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "RG", "Data de nascimento"
			}
		));
		scrollPane.setViewportView(tabelaCliente);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(20, 250, 46, 14);
		ContentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(140, 250, 46, 14);
		ContentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(265, 250, 46, 14);
		ContentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RG");
		lblNewLabel_3.setBounds(381, 250, 46, 14);
		ContentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento");
		lblNewLabel_4.setBounds(484, 250, 104, 14);
		ContentPane.add(lblNewLabel_4);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(20, 280, 86, 20);
		ContentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(140, 280, 86, 20);
		ContentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(258, 280, 86, 20);
		ContentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtRG = new JTextField();
		txtRG.setBounds(372, 280, 86, 20);
		ContentPane.add(txtRG);
		txtRG.setColumns(10);
		
		txtNasc = new JTextField();
		txtNasc.setBounds(484, 280, 86, 20);
		ContentPane.add(txtNasc);
		txtNasc.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValores();
			}
		});
		btnNewButton.setBounds(10, 353, 96, 23);
		ContentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente();
				listarValores();
				LimparCampos();
			}
		});
		btnNewButton_1.setBounds(116, 353, 104, 23);
		ContentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Selecionar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCampos();
			}
		});
		btnNewButton_2.setBounds(230, 353, 103, 23);
		ContentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarCliente();
				listarValores();
				LimparCampos();
			}
		});
		btnNewButton_3.setBounds(341, 353, 96, 23);
		ContentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirCliente();
				listarValores();
				LimparCampos();	
			}
		});
		btnNewButton_4.setBounds(447, 353, 96, 23);
		ContentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Limpar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnNewButton_5.setBounds(549, 353, 89, 23);
		ContentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Fechar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicial inicio = new TelaInicial();
				inicio.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(549, 11, 89, 23);
		ContentPane.add(btnNewButton_6);
	}
	private void SelecionarCampos() {
		int setar = tabelaCliente.getSelectedRow();
		
		txtID.setText(tabelaCliente.getModel().getValueAt(setar, 0).toString());
		txtNome.setText(tabelaCliente.getModel().getValueAt(setar, 1).toString());
		txtCPF.setText(tabelaCliente.getModel().getValueAt(setar, 2).toString());
		txtRG.setText(tabelaCliente.getModel().getValueAt(setar, 3).toString());
		txtNasc.setText(tabelaCliente.getModel().getValueAt(setar, 4).toString());
	}
	
	private void CadastrarCliente() {
		String nome, cpf, rg, nasc;
		
		nome = txtNome.getText();
		cpf = txtCPF.getText();
		rg = txtRG.getText();
		nasc = txtNasc.getText();
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCPF(cpf);
		cliente.setRG(rg);
		cliente.setData_nascimento(nasc);
		
		ClienteBD clienteBD = new ClienteBD();
		clienteBD.cadastrarCliente(cliente);
	}
	private void LimparCampos() {
		txtID.setText("");
		txtNome.setText("");
		txtCPF.setText("");
		txtRG.setText("");
		txtNasc.setText("");
		txtNome.requestFocus();
	}
	private void AlterarCliente() {
		int id;
		String nome, cpf, rg, nasc;
		
		id = Integer.parseInt(txtID.getText());
		nome = txtNome.getText();
		cpf = txtCPF.getText();
		rg = txtRG.getText();
		nasc = txtNasc.getText();
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setCPF(cpf);
		cliente.setRG(rg);
		cliente.setData_nascimento(nasc);
		
		ClienteBD clienteBD = new ClienteBD();
		clienteBD.alterarCliente(cliente);
	}
	private void excluirCliente() {
		int id;
		
		id = Integer.parseInt(txtID.getText());
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		
		ClienteBD clienteBD = new ClienteBD();
		clienteBD.excluirCliente(cliente);
	}
	private void listarValores() {
		try {
			ClienteBD clienteBD = new ClienteBD();
			
			DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
			model.setNumRows(0);
			
			ArrayList<Cliente> lista = clienteBD.pesquisarCliente();
			
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getId(),
						lista.get(num).getNome(),
						lista.get(num).getCPF(),
						lista.get(num).getRG(),
						lista.get(num).getData_nascimento()
						
				});
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}
	}
}


