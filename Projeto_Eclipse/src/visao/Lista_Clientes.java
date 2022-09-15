package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ClienteBD;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import modelo.Cliente;
public class Lista_Clientes extends JFrame {
	private DefaultTableModel modelo;
	private JPanel contentPane;
	private JTable table;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnNewButton;
	private ArrayList<Cliente> listaClientes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista_Clientes frame = new Lista_Clientes();
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
	public Lista_Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 529, 157);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Data de Nascimento", "RG"
			}
		));
		scrollPane.setViewportView(table);
		ClienteBD clientebd = new ClienteBD();
		listaClientes = clientebd.listarTodosClientes();
		table= new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "CPF", "Data de Nascimento", "RG"
				}
			));
			scrollPane.setViewportView(table);
			modelo = (DefaultTableModel) table.getModel();
			for(int i = 0; i < listaClientes.size(); i++) {
				Cliente c = listaClientes.get(i);
				modelo.addRow(new Object[] {c.getId(),c.getNome(), c.getCPF(), c.getRG(),c.getData_nascimento()});
				}
			table.setModel(modelo);
				
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(20, 214, 88, 23);
		contentPane.add(btnFechar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(118, 214, 90, 23);
		contentPane.add(btnExcluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Alterar_Cliente frame = new Alterar_Cliente();
				frame.setVisible(true);
			}
		});
		btnAlterar.setBounds(317, 214, 85, 23);
		contentPane.add(btnAlterar);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cad_Cliente frame = new Cad_Cliente();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(412, 214, 98, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setBounds(218, 214, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
