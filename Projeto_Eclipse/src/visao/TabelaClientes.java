package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import modelo.Funcionario;
import modelo.Cliente;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controle.ClienteBD;
import controle.FuncionarioBD;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;

public class TabelaClientes extends JFrame {

	static Connection conexao;
	private JPanel contentPane;
	private JTable tbCliente;
	private ArrayList<Cliente> listaClientes;
	private Cliente clienteSelecionado;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TabelaClientes(TelaVenda tv) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(18, 183, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 125);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		tbCliente = new JTable();
		tbCliente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		tbCliente.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "CPF" }

		));
		scrollPane.setViewportView(tbCliente);
		ClienteBD clienteBD = new ClienteBD();
		listaClientes = clienteBD.pesquisarCliente();

		tbCliente.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "CPF" }));
		scrollPane.setViewportView(tbCliente);

		modelo = (DefaultTableModel) tbCliente.getModel();
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente p = listaClientes.get(i);
			modelo.addRow(new Object[] { p.getId(), p.getNome(), p.getCPF() });

		}
		tbCliente.setModel(modelo);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linha = tbCliente.getSelectedRow();
				int idCliente = (int) tbCliente.getValueAt(linha, 0);

				for (Cliente cliente : listaClientes) {
					if (cliente.getId() == idCliente) {
						clienteSelecionado = cliente;
					}
				}
				if (linha > -1) {

					tv.setClienteSelecionado(clienteSelecionado);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "escolha uma linha na tabela");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		btnNewButton_1.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_1.setBounds(137, 180, 148, 36);
		contentPane.add(btnNewButton_1);
	}

}