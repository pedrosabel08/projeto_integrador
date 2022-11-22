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
import java.awt.Toolkit;
import javax.swing.SwingConstants;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameFuncionario.class.getResource("/Imagens/Funcionario.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1900, 1000);
		this.setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel.setBounds(807, 663, 78, 22);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBackground(Color.WHITE);
		txtNome.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtNome.setBounds(903, 659, 176, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(1257, 661, 108, 22);
		contentPane.add(lblNewLabel_1);
		
		txtSenha = new JTextField();
		txtSenha.setBackground(Color.WHITE);
		txtSenha.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtSenha.setBounds(1375, 656, 176, 30);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarFuncionario();
				listarValores();
				LimparCampos();
		}
		});
		btnCadastrar.setBounds(317, 772, 176, 30);
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(317, 147, 1321, 471);
		contentPane.add(scrollPane);
		
		tabelaFuncionario = new JTable();
		tabelaFuncionario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		tabelaFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Senha"
			}
		));
		tabelaFuncionario.setBounds(220, 221, 155, -152);
		scrollPane.setViewportView(tabelaFuncionario);
		
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
		
		txtID = new JTextField();
		txtID.setBackground(Color.WHITE);
		txtID.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtID.setEnabled(false);
		txtID.setBounds(524, 659, 95, 30);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(430, 664, 68, 20);
		contentPane.add(lblNewLabel_2);
	
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCampos();
			}
		});
		btnNewButton_1.setBounds(546, 772, 176, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnNewButton_2.setBounds(1234, 772, 176, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
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
		btnNewButton_3.setBounds(777, 772, 176, 30);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
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
		btnNewButton_4.setBounds(1009, 772, 176, 30);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Fechar");
		btnNewButton_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicial inicio = new TelaInicial();
				inicio.setLocationRelativeTo(null);
				inicio.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(1462, 772, 176, 30);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_3 = new JLabel("Tela de Funcionarios");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel_3.setBounds(317, 90, 1321, 14);
		contentPane.add(lblNewLabel_3);
		
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
