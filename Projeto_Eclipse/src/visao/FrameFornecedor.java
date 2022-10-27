package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.FornecedorBD;
import controle.FuncionarioBD;
import modelo.Fornecedor;
import modelo.Funcionario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtCNPJ;
	private JTextField txtContato;
	private JTable tabelaFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameFornecedor frame = new FrameFornecedor();
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
	public FrameFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 74, 673, 262);
		contentPane.add(scrollPane);
		
		tabelaFornecedor = new JTable();
		tabelaFornecedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CNPJ", "Contato"
			}
		));
		scrollPane.setViewportView(tabelaFornecedor);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(67, 347, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(192, 347, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ:");
		lblNewLabel_2.setBounds(413, 347, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contato:");
		lblNewLabel_3.setBounds(623, 347, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(64, 372, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(192, 372, 158, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(413, 372, 165, 20);
		contentPane.add(txtCNPJ);
		txtCNPJ.setColumns(10);
		
		txtContato = new JTextField();
		txtContato.setBounds(623, 372, 117, 20);
		contentPane.add(txtContato);
		txtContato.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarFornecedor();
				listarValores();
				LimparCampos();
			}
		});
		btnNewButton.setBounds(192, 418, 108, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pesquisar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValores();
			}
		});
		btnNewButton_1.setBounds(67, 418, 108, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Selecionar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCampos();
			}
		});
		btnNewButton_2.setBounds(310, 418, 108, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarFornecedor();
				listarValores();
				LimparCampos();
			}
		});
		btnNewButton_3.setBounds(428, 418, 102, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
				listarValores();
				LimparCampos();	
			}
		});
		btnNewButton_4.setBounds(540, 418, 101, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Limpar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnNewButton_5.setBounds(651, 418, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Fechar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicial inicio = new TelaInicial();
				inicio.setLocationRelativeTo(null);
				inicio.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(651, 11, 89, 23);
		contentPane.add(btnNewButton_6);
	}
	
	private void SelecionarCampos() {
		int setar = tabelaFornecedor.getSelectedRow();
		
		txtID.setText(tabelaFornecedor.getModel().getValueAt(setar, 0).toString());
		txtNome.setText(tabelaFornecedor.getModel().getValueAt(setar, 1).toString());
		txtCNPJ.setText(tabelaFornecedor.getModel().getValueAt(setar, 2).toString());
		txtContato.setText(tabelaFornecedor.getModel().getValueAt(setar, 3).toString());
	}
	
	private void CadastrarFornecedor() {
		String nome, cnpj, contato;
		
		nome = txtNome.getText();
		cnpj = txtCNPJ.getText();
		contato = txtContato.getText();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(nome);
		fornecedor.setCnpj(cnpj);
		fornecedor.setContato(contato);
		
		FornecedorBD fornecedorBD = new FornecedorBD();
		fornecedorBD.cadastrarFornecedor(fornecedor);
	}
	private void LimparCampos() {
		txtID.setText("");
		txtNome.setText("");
		txtCNPJ.setText("");
		txtContato.setText("");
		txtNome.requestFocus();
	}
	private void AlterarFornecedor() {
		int id;
		String nome, cnpj, contato;
		
		id = Integer.parseInt(txtID.getText());
		nome = txtNome.getText();
		cnpj = txtCNPJ.getText();
		contato = txtContato.getText();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);
		fornecedor.setNome(nome);
		fornecedor.setCnpj(cnpj);
		fornecedor.setContato(contato);

		
		FornecedorBD fornecedorBD = new FornecedorBD();
		fornecedorBD.alterarFornecedor(fornecedor);
	}
	private void excluirFornecedor() {
		int id;
		
		id = Integer.parseInt(txtID.getText());
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);
		
		FornecedorBD fornecedorBD = new FornecedorBD();
		fornecedorBD.excluirFornecedor(fornecedor);
	}
	private void listarValores() {
		try {
			FornecedorBD fornecedorBD = new FornecedorBD();
			
			DefaultTableModel model = (DefaultTableModel) tabelaFornecedor.getModel();
			model.setNumRows(0);
			
			ArrayList<Fornecedor> lista = fornecedorBD.pesquisarFornecedor();
			
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getId(),
						lista.get(num).getNome(),
						lista.get(num).getCnpj(),
						lista.get(num).getContato()

				});
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}
	}
}