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
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Panel;

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
		contentPane.setBackground(new Color(18, 183, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setBorder(null);
		lblUsuario.setBackground(new Color(0, 0, 139));
		lblUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 22));
		lblUsuario.setBounds(734, 489, 102, 32);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(0, 0, 0));
		lblSenha.setBackground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Yu Gothic UI", Font.PLAIN, 22));
		lblSenha.setBounds(734, 590, 102, 37);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		txtUsuario.setBounds(919, 482, 300, 47);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBackground(UIManager.getColor("Button.shadow"));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btnFechar.setBounds(734, 676, 118, 37);
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
		btnContinuar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btnContinuar.setBounds(1075, 676, 144, 37);
		contentPane.add(btnContinuar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBackground(Color.WHITE);
		txtSenha.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		txtSenha.setBounds(919, 585, 300, 47);
		contentPane.add(txtSenha);
		
		JLabel lblNewLabel_1 = new JLabel("Tela de Login:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(919, 409, 133, 32);
		contentPane.add(lblNewLabel_1);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setForeground(new Color(0, 0, 139));
		panel.setBounds(703, 55, 549, 329);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(24, 11, 500, 298);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/SLR (1).png")));
	}
}
