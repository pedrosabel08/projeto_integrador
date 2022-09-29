package visao;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelo.Cliente;
import controle.ClienteBD;

public class ListaClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnExcluir;
	private JButton btnNewButton;
	private DefaultTableModel modelo;
	private ArrayList<Cliente> listaClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaClientes frame = new ListaClientes();
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
	public ListaClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 529, 157);
		contentPane.add(scrollPane);
		ClienteBD clientebd = new ClienteBD();
		listaClientes = clientebd.listarClientes();
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "CPF", "RG", "Data de Nascimento" }));
		scrollPane.setViewportView(table);
		modelo = (DefaultTableModel) table.getModel();
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente c = listaClientes.get(i);
			modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getCPF(), c.getRG(), c.getData_nascimento() });
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

		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoPessoa = table.getSelectedRow();
				
				if (posicaoPessoa > -1) {
					Cliente pessoaSelecionada = listaClientes.get(posicaoPessoa);
				}

				if (posicaoPessoa > -1) {
					ManterCliente x = new ManterCliente();
					x.txtNome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					x.txtCPF.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					x.txtNasc.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
					x.txtRG.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
					x.setVisible(true);
				} else {

					JOptionPane.showMessageDialog(null, "escolha uma linha na tabela");

				}
			}

		});
		btnNewButton_1.setBounds(119, 214, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("Cadastro");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManterCliente cadclientes = new ManterCliente();
				cadclientes.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(437, 214, 89, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = (table.getValueAt(table.getSelectedRow(), 0).toString());
				int b = Integer.parseInt(a);

				Cliente cliente = new Cliente();
				cliente.setId(b);

				ClienteBD bdCliente = new ClienteBD();
				bdCliente.removeCliente(cliente);

				((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
			}
		});
		btnNewButton_2.setBounds(280, 214, 89, 23);
		contentPane.add(btnNewButton_2);
	};

}