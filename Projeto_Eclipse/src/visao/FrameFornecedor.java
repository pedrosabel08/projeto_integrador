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
import javax.swing.text.MaskFormatter;

import controle.FornecedorBD;
import controle.FuncionarioBD;
import modelo.Fornecedor;
import modelo.Funcionario;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;

public class FrameFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTable tabelaFornecedor;
	private JFormattedTextField txtCNPJ;
	private JFormattedTextField txtContato;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameFornecedor frame = new FrameFornecedor();
					frame.setLocationRelativeTo(null);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameFornecedor.class.getResource("/Imagens/Fornecedor.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 540);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 74, 647, 262);
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
	
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel.setBounds(67, 347, 83, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(192, 347, 158, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(385, 347, 135, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contato:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(579, 347, 135, 14);
		contentPane.add(lblNewLabel_3);
		
		txtID = new JTextField();
		txtID.setBackground(Color.WHITE);
		txtID.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtID.setEnabled(false);
		txtID.setBounds(64, 372, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBackground(Color.WHITE);
		txtNome.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtNome.setBounds(192, 372, 158, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCNPJ = new JFormattedTextField();
		txtCNPJ.setBounds(385, 372, 135, 20);
		contentPane.add(txtCNPJ);
		
		MaskFormatter maskCNPJ;
		try {
			maskCNPJ = new MaskFormatter("##.###.###/####-##");
			maskCNPJ.install(txtCNPJ);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarFornecedor();
				LimparCampos();
			}
		});
		btnNewButton.setBounds(67, 421, 108, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("Selecionar");
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCampos();
			}
		});
		btnNewButton_2.setBounds(185, 421, 108, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabelaFornecedor.getSelectedRowCount() > 0) {
				AlterarFornecedor();
				LimparCampos();
				}
				else {
				JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela para alterar!");
				}
			}
		});
		btnNewButton_3.setBounds(303, 421, 102, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabelaFornecedor.getSelectedRowCount() > 0) {
				excluirFornecedor();
				LimparCampos();	
				}
				else {
				JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela para excluir!");
				}
			}
		});
		btnNewButton_4.setBounds(415, 421, 101, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Limpar");
		btnNewButton_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnNewButton_5.setBounds(526, 421, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Fechar");
		btnNewButton_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicial inicio = new TelaInicial();
				inicio.setLocationRelativeTo(null);
				inicio.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(625, 422, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_4 = new JLabel("Tela de Fornecedores");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel_4.setBounds(336, 31, 135, 14);
		contentPane.add(lblNewLabel_4);
		
		txtContato = new JFormattedTextField();
		txtContato.setBounds(579, 372, 135, 20);
		contentPane.add(txtContato);
		
		MaskFormatter maskContato;
		try {
			maskContato = new MaskFormatter("(##)#####-####");
			maskContato.install(txtContato);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
	}
	
	private void SelecionarCampos() {
		
		if(tabelaFornecedor.getSelectedRowCount() > 0) {
		int setar = tabelaFornecedor.getSelectedRow();
		
		txtID.setText(tabelaFornecedor.getModel().getValueAt(setar, 0).toString());
		txtNome.setText(tabelaFornecedor.getModel().getValueAt(setar, 1).toString());
		txtCNPJ.setText(tabelaFornecedor.getModel().getValueAt(setar, 2).toString());
		txtContato.setText(tabelaFornecedor.getModel().getValueAt(setar, 3).toString());
	}
		else {
			JOptionPane.showMessageDialog(null,"Clique em uma linha da tabela para selecionar!");
		}
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
}
