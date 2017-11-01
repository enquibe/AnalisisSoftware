

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtpContra;
	private JPasswordField txtpContraConf;
	private JLabel lblDarDeAlta;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarUsuarios frame = new RegistrarUsuarios();
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
	public RegistrarUsuarios() {
		setTitle("Registrar Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 250);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre Usuario");
		lblNewLabel.setBounds(39, 42, 133, 26);
		contentPane.add(lblNewLabel);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(39, 81, 133, 26);
		contentPane.add(lblContrasea);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContrasea.setBounds(39, 120, 140, 26);
		contentPane.add(lblConfirmarContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("El nombre de usuario permite letras y n\u00FAmeros.");
		txtUsuario.setBounds(190, 44, 116, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtpContra = new JPasswordField();
		txtpContra.setToolTipText("La contrase\u00F1a puede ser alfanum\u00E9rica");
		txtpContra.setBounds(190, 83, 116, 24);
		contentPane.add(txtpContra);

		txtpContraConf = new JPasswordField();
		txtpContraConf.setToolTipText("La contrase\u00F1a debe igual a la de arriba.");
		txtpContraConf.setBounds(190, 120, 116, 24);
		contentPane.add(txtpContraConf);

		lblDarDeAlta = new JLabel("Dar de alta nuevo usuario para el sistema");
		lblDarDeAlta.setForeground(Color.BLUE);
		lblDarDeAlta.setFont(new Font("Calibri", Font.ITALIC, 15));
		lblDarDeAlta.setBounds(12, 13, 350, 16);
		contentPane.add(lblDarDeAlta);		

		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (txtUsuario.getText().length() < 4 || txtUsuario.getText().length() > 10)
						throw new Exception("El usuario debe contener como mínimo 4 caractéres y como máximo 10.");

					if (!FuncionesComunes.isValidUserOrPass(txtUsuario.getText()))
						throw new Exception("El usuario no tiene un formato válido, solo se permiten letras y/o números.");

					Usuario usu = Constantes.gestorUsuarios.devuelveUsuario(txtUsuario.getText());
					if (usu != null)
						throw new Exception("El usuario ya existe, elija otro nombre de usuario");

					if (txtpContra.getText().length() < 4 || txtpContra.getText().length() > 10)
						throw new Exception("La contraseña debe contener como mínimo 4 caractéres y como máximo 10.");

					if (!FuncionesComunes.isValidUserOrPass(txtpContra.getText()))
						throw new Exception(
								"La contraseña no tiene un formato válido, solo se permiten letras y/o números.");

					if (!txtpContra.getText().equals(txtpContraConf.getText()))
						throw new Exception("La contraseña no coincide, escriba las mismas contrasñas.");

					Constantes.gestorUsuarios.registrarUsuario(txtUsuario.getText(), txtpContra.getText());
					JOptionPane.showMessageDialog(null, "¡Alta realizada satisfactoriamente!", "Confirmación",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(49, 159, 97, 25);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(194, 159, 97, 25);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
		getRootPane().setDefaultButton(btnNewButton);
	}
	

}
