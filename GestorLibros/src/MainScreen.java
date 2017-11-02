import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setTitle("Gestor de Libros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Sistema de Gestión de Libros");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		label.setBounds(6, 16, 502, 43);
		contentPane.add(label);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaScreen altaScreen = new AltaScreen();
				altaScreen.setVisible(true);
			}
		});
		btnAlta.setBounds(175, 95, 157, 43);
		contentPane.add(btnAlta);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaLibros baja = new BajaLibros();
				baja.setVisible(true);
			}
		});
		btnBaja.setBounds(175, 150, 157, 43);
		contentPane.add(btnBaja);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaLibros consulta = new ConsultaLibros();
				consulta.setVisible(true);
				
			}
		});
		btnConsulta.setBounds(175, 260, 157, 43);
		contentPane.add(btnConsulta);
		
		JButton btnModificacin = new JButton("Modificación");
		btnModificacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificacionScreen modificacion = new ModificacionScreen();
				modificacion.setVisible(true);
			}
		});
		btnModificacin.setBounds(175, 205, 157, 43);
		contentPane.add(btnModificacin);
		
		JButton btnListados = new JButton("Listados");
		btnListados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoLibros listados = new ListadoLibros();
				listados.setVisible(true);
			}
		});
		btnListados.setBounds(175, 315, 157, 43);
		contentPane.add(btnListados);
		
		JButton button_1 = new JButton("Salir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Almacen.instancia.guardar();
				System.exit(0);
			}
		});
		button_1.setBounds(350, 427, 157, 43);
		contentPane.add(button_1);
		
		JButton btnOrdenarRegistros = new JButton("Ordenar registros");
		btnOrdenarRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Almacen.instancia.estaVacio())
						throw new Exception("No hay registros");
					
					Almacen.instancia.ordenar();
					JOptionPane.showMessageDialog(null, "Registros ordenados correctamente.", "Info", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Info", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnOrdenarRegistros.setBounds(175, 370, 157, 43);
		contentPane.add(btnOrdenarRegistros);
		
		if (Constantes.gestorUsuarios.getLoggedUser().esAdministrador()) {
			JButton btnRegistrarse = new JButton("Registrar Usuario");
			btnRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegistrarUsuarios registrarUsuario = new RegistrarUsuarios();
					registrarUsuario.setVisible(true);
				}
			});
			btnRegistrarse.setBounds(175, 425, 157, 43);
			contentPane.add(btnRegistrarse);
		}
	}

}
