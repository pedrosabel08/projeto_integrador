package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.table.DefaultTableModel;

import controle.Conexao;
import controle.VendaBD;
import modelo.Venda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 900);
		this.setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblUsuario.setBounds(680, 337, 102, 32);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBackground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblSenha.setBounds(680, 402, 102, 37);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtUsuario.setBounds(878, 322, 300, 47);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBackground(UIManager.getColor("Button.shadow"));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnFechar.setBounds(879, 501, 118, 37);
		contentPane.add(btnFechar);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBackground(UIManager.getColor("Button.shadow"));
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql = "select * from Funcionario where nome=? and senha=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, txtUsuario.getText());
					stmt.setString(2, new String(txtSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next()) {
						
						TelaInicial exibir = new TelaInicial();
						exibir.setLocationRelativeTo(null);
						exibir.setVisible(true);
						
						setVisible(false);
						
						JOptionPane.showMessageDialog(null, "Bem-Vindo!");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Esse usuario nao existe");
					}
					
					stmt.close();
					con.close();
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
				
			}
		});
		btnContinuar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnContinuar.setBounds(1060, 501, 118, 37);
		contentPane.add(btnContinuar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBackground(Color.WHITE);
		txtSenha.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtSenha.setBounds(878, 399, 300, 47);
		contentPane.add(txtSenha);
	}
}
