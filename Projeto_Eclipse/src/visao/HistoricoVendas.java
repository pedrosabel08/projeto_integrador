package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Venda;
import controle.VendaBD;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class HistoricoVendas extends JFrame {

	private JPanel contentPane;
	private JTable tbVendas;
	private DefaultTableModel modelo;
	private ArrayList<Venda> listaVendas;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public HistoricoVendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHistricoDeVendas = new JLabel("Hist\u00F3rico de Vendas");
		lblHistricoDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHistricoDeVendas.setBounds(145, 27, 174, 14);
		contentPane.add(lblHistricoDeVendas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 70, 271, 131);
		contentPane.add(scrollPane);
		
		tbVendas = new JTable();
		tbVendas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Valor", "Data"
			}
		));
		scrollPane.setViewportView(tbVendas);
		
		modelo = (DefaultTableModel) tbVendas.getModel();
		for (int i = 0; i < listaVendas.size(); i++) {
			Venda v = listaVendas.get(i);
			modelo.addRow(new Object[] { v.getId(), v.getValor(), v.getData() });

		}
		tbVendas.setModel(modelo);
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(171, 212, 89, 23);
		contentPane.add(btnFechar);
	}

}
