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

public class TabelaClientes extends JFrame {
	
	static Connection conexao;
	private JPanel contentPane;
	private JTable tbCliente;
	private ArrayList<Cliente> listaClientes;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TabelaClientes(TelaVenda tv ){
		
		
			System.out.println(conexao);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tbCliente = new JTable();
		tbCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome","CPF"
			}
			
		));
		scrollPane.setViewportView(tbCliente);
		ClienteBD clienteBD = new ClienteBD();
		listaClientes = clienteBD.pesquisarCliente();
		
		tbCliente.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome","CPF"}));
		scrollPane.setViewportView(tbCliente);

		modelo = (DefaultTableModel) tbCliente.getModel();
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente p = listaClientes.get(i);
		modelo.addRow(new Object[] { p.getId(), p.getNome() , p.getCPF()  });

		}
		tbCliente.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = tbCliente.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					tv.txtIDCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 0).toString());
					tv.txtNomeCliente.setText(tbCliente.getValueAt(tbCliente.getSelectedRow(), 1).toString());
					tv.setVisible(true);
					setVisible(false);				
					}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
			
		});
		panel_1.add(btnNewButton);
	}

}