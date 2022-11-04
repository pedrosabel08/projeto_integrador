package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioBD;
import modelo.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;

public class FrameFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTable tabelaFuncionario;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameFuncionario frame = new FrameFuncionario();
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
	public FrameFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 540);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(297, 347, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBackground(Color.WHITE);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setBounds(353, 344, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(498, 347, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtSenha = new JTextField();
		txtSenha.setBackground(Color.WHITE);
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSenha.setBounds(554, 344, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarFuncionario();
				listarValores();
				LimparCampos();
		}
		});
		btnCadastrar.setBounds(10, 419, 108, 23);
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 86, 512, 231);
		contentPane.add(scrollPane);
		
		tabelaFuncionario = new JTable();
		tabelaFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Senha"
			}
		));
		tabelaFuncionario.setBounds(220, 221, 155, -152);
		scrollPane.setViewportView(tabelaFuncionario);
		
		txtID = new JTextField();
		txtID.setBackground(Color.WHITE);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtID.setEnabled(false);
		txtID.setBounds(158, 344, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(128, 347, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValores();
			}
		});
		btnNewButton.setBounds(128, 419, 108, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCampos();
			}
		});
		btnNewButton_1.setBounds(246, 419, 108, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnNewButton_2.setBounds(364, 419, 108, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabelaFuncionario.getSelectedRowCount() > 0) {
				AlterarFuncionario();
				listarValores();
				LimparCampos();
				}
				else {
					JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela para alterar!");
				}
			}
		});
		btnNewButton_3.setBounds(482, 419, 108, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabelaFuncionario.getSelectedRowCount() > 0) {
				excluirFuncionario();
				listarValores();
				LimparCampos();	
				}
				else {
				JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela para excluir!");
				}
			}
		});
		btnNewButton_4.setBounds(600, 419, 86, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Fechar");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicial inicio = new TelaInicial();
				inicio.setLocationRelativeTo(null);
				inicio.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(696, 419, 95, 23);
		contentPane.add(btnNewButton_5);
		
	}
	
	private void SelecionarCampos() {
		if(tabelaFuncionario.getSelectedRowCount() > 0) {

		int setar = tabelaFuncionario.getSelectedRow();
		
		txtID.setText(tabelaFuncionario.getModel().getValueAt(setar, 0).toString());
		txtNome.setText(tabelaFuncionario.getModel().getValueAt(setar, 1).toString());
		txtSenha.setText(tabelaFuncionario.getModel().getValueAt(setar, 2).toString());
	}
		else {
			JOptionPane.showMessageDialog(null,"Clique em uma linha da tabela para selecionar!");
		}
	}
	
	private void CadastrarFuncionario() {
		String nome, senha;
		
		nome = txtNome.getText();
		senha = txtSenha.getText();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setSenha(senha);
		
		FuncionarioBD funcionarioBD = new FuncionarioBD();
		funcionarioBD.cadastrarFuncionario(funcionario);
	}
	private void LimparCampos() {
		txtID.setText("");
		txtNome.setText("");
		txtSenha.setText("");
		txtNome.requestFocus();
	}
	private void AlterarFuncionario() {
		int id;
		String nome, senha;
		
		id = Integer.parseInt(txtID.getText());
		nome = txtNome.getText();
		senha = txtSenha.getText();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionario.setSenha(senha);
		
		FuncionarioBD funcionarioBD = new FuncionarioBD();
		funcionarioBD.alterarFuncionario(funcionario);
	}
	private void excluirFuncionario() {
		int id;
		
		id = Integer.parseInt(txtID.getText());
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		
		FuncionarioBD funcionarioBD = new FuncionarioBD();
		funcionarioBD.excluirFuncionario(funcionario);
	}
	private void listarValores() {
		try {
			FuncionarioBD funcionarioBD = new FuncionarioBD();
			
			DefaultTableModel model = (DefaultTableModel) tabelaFuncionario.getModel();
			model.setNumRows(0);
			
			ArrayList<Funcionario> lista = funcionarioBD.pesquisarFuncionario();
			
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getId(),
						lista.get(num).getNome(),
						lista.get(num).getSenha()
				});
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}
	}
}
