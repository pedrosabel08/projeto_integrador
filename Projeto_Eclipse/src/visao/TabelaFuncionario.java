package visao;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.FuncionarioBD;
import modelo.Cliente;
import modelo.Funcionario;
import javax.swing.UIManager;

public class TabelaFuncionario extends JFrame {

	static Connection conexao;
	private JPanel contentPane;
	private JTable tbFuncionario;
	private ArrayList<Funcionario> listaFuncionarios;
	private Funcionario funcionarioSelecionado;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TabelaFuncionario(TelaVenda tv) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 125);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		tbFuncionario = new JTable();
		tbFuncionario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		tbFuncionario.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Login" }

		));
		scrollPane.setViewportView(tbFuncionario);
		FuncionarioBD funcionarioBD = new FuncionarioBD();
		listaFuncionarios = funcionarioBD.pesquisarFuncionario();

		tbFuncionario.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Login" }));
		scrollPane.setViewportView(tbFuncionario);

		modelo = (DefaultTableModel) tbFuncionario.getModel();
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			Funcionario p = listaFuncionarios.get(i);
			modelo.addRow(new Object[] { p.getId(), p.getNome() });

		}
		tbFuncionario.setModel(modelo);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linha = tbFuncionario.getSelectedRow();
				int idFuncionario = (int) tbFuncionario.getValueAt(linha, 0);

				for (Funcionario funcionario : listaFuncionarios) {
					if (funcionario.getId() == idFuncionario) {
						funcionarioSelecionado = funcionario;
					}
				}
				if (linha > -1) {

					tv.setFuncionarioSelecionado(funcionarioSelecionado);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "escolha uma linha na tabela");
				}
			}
			
		});
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		btnNewButton.setBounds(133, 172, 148, 36);
		contentPane.add(btnNewButton);
	}

}
