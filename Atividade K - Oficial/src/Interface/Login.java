package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JFrame;

public class Login {

	private JFrame frame;
	private JTextField textLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 502, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textLogin = new JTextField();
		textLogin.setBounds(126, 113, 233, 24);
		frame.getContentPane().add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblNome = new JLabel("Login");
		lblNome.setBounds(126, 88, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkLogin(textLogin.getText(), new String(txtSenha.getPassword()))) {
					
					JOptionPane.showMessageDialog(null, "Bem Vindo ao TrelloApp!", "TrelloApp",1);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Dados Inválidos!", "TrelloApp",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(198, 228, 89, 30);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(126, 144, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(126, 169, 233, 24);
		frame.getContentPane().add(txtSenha);
		
		JLabel lblFazerLoginNo = new JLabel("Fazer Login no TrelloAPP");
		lblFazerLoginNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFazerLoginNo.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblFazerLoginNo.setBounds(126, 28, 233, 24);
		frame.getContentPane().add(lblFazerLoginNo);
	}
	
	public boolean checkLogin(String login, String senha) {
		return login.equals("usuario")&& senha.equals("senha");
		
	}
}