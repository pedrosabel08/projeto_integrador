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


public class HistVendas extends JFrame {

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
	public HistVendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHistricoDeVendas = new JLabel("Hist\u00F3rico de Vendas");
		lblHistricoDeVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistricoDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHistricoDeVendas.setBounds(25, 11, 378, 14);
		contentPane.add(lblHistricoDeVendas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 36, 378, 180);
		contentPane.add(scrollPane);
		
		tbVendas = new JTable();
		tbVendas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Nome", "Valor", "Data"
			}
		));
		scrollPane.setViewportView(tbVendas);
		VendaBD vendaBD = new VendaBD();
		listaVendas = vendaBD.buscarVenda();
		
		modelo = (DefaultTableModel) tbVendas.getModel();
		for (int i = 0; i < listaVendas.size(); i++) {
			Venda v = listaVendas.get(i);
			modelo.addRow(new Object[] { v.getId(), v.getProduto(), v.getValor(), v.getData() });

		}
		tbVendas.setModel(modelo);
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBackground(UIManager.getColor("Button.shadow"));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(172, 227, 89, 23);
		contentPane.add(btnFechar);
	}
	
}
