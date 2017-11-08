import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JPasswordField;

public class LoginScreen extends JFrame{

	private JFrame frmGestorDeLibros;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frmGestorDeLibros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
		Constantes.gestorUsuarios = new GestorUsuarios();
		Constantes.log = new Log();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestorDeLibros = new JFrame();
		frmGestorDeLibros.setTitle("Gestor de Libros");
		frmGestorDeLibros.setBounds(100, 100, 526, 452);
		frmGestorDeLibros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmGestorDeLibros.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Sistema de Gestión de Libros");
		label.setBounds(14, 21, 502, 43);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		panel.add(label);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesión");
		btnIniciarSesin.setToolTipText("Verificar los datos e Iniciar sesión");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtUsuario.getText().length()<=0 || txtPassword.getText().length()<=0)
						throw new Exception("No pueden haber campos vacíos");
			
					Usuario usu = Constantes.gestorUsuarios.devuelveUsuario(txtUsuario.getText());
					if (usu == null)
						throw new Exception("El usuario NO existe. Registrese o ingrese nuevamente los datos.");
					
					if(!usu.getContrasenia().equals(txtPassword.getText()))
						throw new Exception("La contraseña no corresponde al usuario: " + usu.getUsuario());
					
					Constantes.gestorUsuarios.setLoggedUser(usu);
					
					MainScreen window = new MainScreen();
					window.setVisible(true);
					
					frmGestorDeLibros.dispose();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIniciarSesin.setBounds(176, 265, 157, 43);
		panel.add(btnIniciarSesin);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setToolTipText("Salir de la aplicación");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(359, 381, 157, 43);
		panel.add(btnSalir);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Ingrese el nombre de usuario aquí");
		txtUsuario.setBounds(176, 142, 157, 30);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(178, 126, 61, 16);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(178, 181, 91, 16);
		panel.add(lblContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Ingrese la contraseña del usuario aquí");
		txtPassword.setBounds(176, 198, 157, 30);
		panel.add(txtPassword);
	}

}
