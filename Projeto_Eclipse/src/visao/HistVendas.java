package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.VendaBD;
import modelo.Venda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;


public class HistVendas extends JFrame {

	private JPanel contentPane;
	private JTable tbVendas;
	private DefaultTableModel modelo;
	private ArrayList<Venda> listaVendas;
	private JTextField txtTotal;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public HistVendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 370);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHistricoDeVendas = new JLabel("Hist\u00F3rico de Vendas");
		lblHistricoDeVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistricoDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHistricoDeVendas.setBounds(87, 11, 378, 14);
		contentPane.add(lblHistricoDeVendas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 36, 507, 180);
		contentPane.add(scrollPane);
		
		tbVendas = new JTable();
		tbVendas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		tbVendas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Produto","Cliente","Funcionario", "Valor", "Data"
			}
		));
		scrollPane.setViewportView(tbVendas);
		VendaBD vendaBD = new VendaBD();
		listaVendas = vendaBD.buscarVenda();
		
		modelo = (DefaultTableModel) tbVendas.getModel();
		for (int i = 0; i < listaVendas.size(); i++) {
			Venda v = listaVendas.get(i);
			modelo.addRow(new Object[] { v.getId(),v.getNome_produto(),v.getNome_cliente(),v.getNome_func(), v.getValor(), v.getData() });

		}

		tbVendas.setModel(modelo);
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBackground(UIManager.getColor("Button.shadow"));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnFechar.setBounds(25, 247, 121, 49);
		contentPane.add(btnFechar);
		
		JLabel lblNewLabel_4 = new JLabel("Valor Total:");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(333, 266, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtTotal.setColumns(10);
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setBounds(432, 263, 86, 20);
		contentPane.add(txtTotal);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double somaTotal=0;

				for(int i=0; i<modelo.getRowCount();i++)
					somaTotal += Double.parseDouble(modelo.getValueAt(i, 4).toString());
				txtTotal.setText(String.valueOf(somaTotal));
			}
		});
		btnTotal.setBounds(156, 263, 89, 23);
		contentPane.add(btnTotal);
	}
}
