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
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controle.FuncionarioBD;

public class TabelaFuncionario extends JFrame {
	
	static Connection conexao;
	private JPanel contentPane;
	private JTable tbFuncionario;
	private ArrayList<Funcionario> listaFuncionarios;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TabelaFuncionario(TelaVenda tv ){
		
		
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
		
		tbFuncionario = new JTable();
		tbFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Login"
			}
			
		));
		scrollPane.setViewportView(tbFuncionario);
		FuncionarioBD funcionarioBD = new FuncionarioBD();
		listaFuncionarios = funcionarioBD.pesquisarFuncionario();
		
		tbFuncionario.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Login"}));
		scrollPane.setViewportView(tbFuncionario);

		modelo = (DefaultTableModel) tbFuncionario.getModel();
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			Funcionario p = listaFuncionarios.get(i);
		modelo.addRow(new Object[] { p.getId(), p.getNome()});

		}
		tbFuncionario.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoPessoa = tbFuncionario.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					tv.txtIDFunc.setText(tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(), 0).toString());
					tv.txtNomeFunc.setText(tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(), 1).toString());
					
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