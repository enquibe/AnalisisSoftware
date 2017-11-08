

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class BajaLibros extends JFrame {

	private JPanel contentPane;
	private JTextField txtISBN;
	private JTextPane txtViewLibro;
	private Libro tmpISBN;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaLibros frame = new BajaLibros();
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
	public BajaLibros() {
		setTitle("Gestor de Libros");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
		
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 344, 337);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListadoDePacientes = new JLabel("Baja de Libros");
		lblListadoDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDePacientes.setFont(new Font("Arial", Font.BOLD, 18));
		lblListadoDePacientes.setBounds(37, 30, 257, 22);
		contentPane.add(lblListadoDePacientes);
		
		JButton btnCerrar = new JButton("Volver");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(243, 280, 89, 23);
		contentPane.add(btnCerrar);
		
		DefaultListModel modelo = new DefaultListModel();
		for (Libro p : Almacen.instancia.libros) {
			// String item = " [" + p.getISBN() + "] - " + p.getTitulo();
			modelo.addElement(p);
		}
		
		txtISBN = new JTextField();
		txtISBN.setBounds(12, 68, 236, 26);
		contentPane.add(txtISBN);
		txtISBN.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarLibro();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(243, 68, 89, 29);
		contentPane.add(btnBuscar);
		
		txtViewLibro = new JTextPane();
		txtViewLibro.setEditable(false);
		txtViewLibro.setBounds(12, 99, 320, 169);
		contentPane.add(txtViewLibro);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					borrarLibro();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnBorrar.setBounds(22, 277, 117, 29);
		contentPane.add(btnBorrar);
		setLocationRelativeTo(null);
		
	}
	
	private void borrarLibro() throws Exception{
		// Verifica que el ISBN ingresado
		// este correctamente seleccionado
		if(tmpISBN != null) {
			try {
				// Elimina el ISBN del Almacen 
				Almacen.instancia.eliminar(tmpISBN);
				
				// Actualiza el archivo del almacen 
				Almacen.instancia.guardar();
				
				tmpISBN = null;
				txtViewLibro.setText("");
				
				// Muestra el mensaje correspondiente
				// a la correcta eliminación del registro
				JOptionPane.showMessageDialog(null,"Registro borrado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex) {
				// Guarda el error en el log
				Constantes.log.append(Constantes.gestorUsuarios.getLoggedUser().getUsuario() + "@Error borrando el Libro seleccionado::" + ex.getMessage());
				
				// Lanza la excepción
				throw new Exception("Error borrando el Libro seleccionado");
			}
		}else {
			// Si el ISBN que se busco no es válido
			// lanza la excepción correspondiente
			throw new Exception("Ingrese un ISBN primero");
		}
	}
	
	private void buscarLibro() throws Exception {
		// Verifica que el Almacen no este vacío
		// y en caso contrario, lanza una excepción
		if (Almacen.instancia.estaVacio())
			throw new Exception("No hay registros");
		
		// Verifica que el ISBN sea correcto
		// y en caso contrario, lanza una excepción
		if(!FuncionesComunes.isDouble(txtISBN.getText()) || txtISBN.getText().length() != 13 || Double.parseDouble(txtISBN.getText()) < 0)
			throw new Exception("ISBN inválido");

		// Busca el libro en el almacen para proceder a eliminarlo
		// si no lo encuentra, lanza una excepción
		Optional<Libro> dato = Almacen.instancia.get(txtISBN.getText());
		if (!dato.isPresent())
			throw new Exception("Registro no encontrado");
							
		// Muestra el libro y habilita 
		// el botón de borrar
		txtViewLibro.setText(dato.get().getLibro());
		tmpISBN = dato.get();
	}
}
