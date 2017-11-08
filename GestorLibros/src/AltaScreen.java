import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Optional;
import java.awt.event.ActionEvent;

public class AltaScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtISBN;
	private JTextField txtTitulo;
	private JTextField txtEditorial;
	private JTextField txtAutor;
	private JTextField txtPublicacion;
	private JTextField txtEdicion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaScreen frame = new AltaScreen();
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
	public AltaScreen() {
		setTitle("Gestor de Libros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Sistema de Gestión de Libros");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		label.setBounds(6, 6, 502, 43);
		contentPane.add(label);
		
		JLabel lblAlta = new JLabel("Alta de libro");
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblAlta.setBounds(0, 55, 502, 43);
		contentPane.add(lblAlta);
		
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(95, 126, 300, 30);
		contentPane.add(txtISBN);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(97, 110, 298, 16);
		contentPane.add(lblIsbn);
		
		JLabel lblTtulo = new JLabel("Título");
		lblTtulo.setBounds(97, 165, 298, 16);
		contentPane.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(97, 219, 298, 16);
		contentPane.add(lblAutor);
		
		JLabel lblEdicin = new JLabel("Edición");
		lblEdicin.setBounds(97, 332, 298, 16);
		contentPane.add(lblEdicin);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(97, 278, 298, 16);
		contentPane.add(lblEditorial);
		
		JLabel lblAoDePublicacin = new JLabel("Año de publicación");
		lblAoDePublicacin.setBounds(97, 388, 298, 16);
		contentPane.add(lblAoDePublicacin);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					guardar();
					JOptionPane.showMessageDialog(null, "Registro agregado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(61, 460, 157, 43);
		contentPane.add(btnGuardar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(295, 460, 157, 43);
		contentPane.add(btnVolver);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(95, 181, 300, 30);
		contentPane.add(txtTitulo);
		
		txtEditorial = new JTextField();
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(95, 291, 300, 30);
		contentPane.add(txtEditorial);
		
		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(95, 236, 300, 30);
		contentPane.add(txtAutor);
		
		txtPublicacion = new JTextField();
		txtPublicacion.setColumns(10);
		txtPublicacion.setBounds(95, 405, 300, 30);
		contentPane.add(txtPublicacion);
		
		txtEdicion = new JTextField();
		txtEdicion.setColumns(10);
		txtEdicion.setBounds(95, 350, 300, 30);
		contentPane.add(txtEdicion);
	}
	
	/**
	* Guarda un libro en el Almacen
	* y actualiza el archivo.
	*
	* @return Libro guardado o Exception
	*/
	private void guardar() throws Exception {
		// Verifica si el ISBN ingresado es válido, caso contrario devuelve una excepción
		if(!FuncionesComunes.isDouble(txtISBN.getText()) || txtISBN.getText().length() != 13 || Double.parseDouble(txtISBN.getText()) < 0)
			throw new Exception("ISBN inválido");
		
		// Busca en el almacen por el ISBN ingresado
		// caso contrario devuelve una excepción
		Optional<Libro> dato = Almacen.instancia.get(txtISBN.getText());
		
		// Verifica si la busqueda fue satisfactoria para informar 
		// si el registro ya se encuentra en el Almacen
		if (dato.isPresent())
			throw new Exception("El registro ya existe");
		
		// Verifica si el título ingresado es válido
		// caso contrario devuelve una excepción
		if(txtTitulo.getText().length()<=0)
			throw new Exception("Ingrese un título");
		
		// Verifica si el Autor ingresado es válido 
		// caso contrario devuelve una excepción
		if(txtAutor.getText().length()<=0)
			throw new Exception("Ingrese un Autor");
		
		// Verifica si la editorial ingresado es válido 
		// caso contrario devuelve una excepción
		if(txtEditorial.getText().length()<=0)
			throw new Exception("Ingrese una editorial");
		
		// Verifica si la Edición ingresado es válido 
		// caso contrario devuelve una excepción
		if(!FuncionesComunes.isInteger(txtEdicion.getText()) || Integer.parseInt(txtEdicion.getText()) < 1 || Integer.parseInt(txtEdicion.getText()) > Integer.MAX_VALUE)
			throw new Exception("Edición inválida");
		
		// Verifica si el Año de publicación ingresado es válido
		// caso contrario devuelve una excepción
		if(!FuncionesComunes.isInteger(txtPublicacion.getText()) || Integer.parseInt(txtPublicacion.getText()) < 1500)
			throw new Exception("Año de publicación inválido");
		
		// Crea una nueva instancia de Libro
		// seteando ISBN, Título, Autor, Editorial
		// Edición y Año de Publicación
		Libro nuevoLibro = new Libro();
		nuevoLibro.setISBN(txtISBN.getText());
		nuevoLibro.setTitulo(txtTitulo.getText());
		nuevoLibro.setAutor(txtAutor.getText());
		nuevoLibro.setEditorial(txtEditorial.getText());
		nuevoLibro.setEdicion(Integer.parseInt(txtEdicion.getText()));
		nuevoLibro.setAnno_de_publicacion(Integer.parseInt(txtPublicacion.getText()));
		
		//Guarda la nueva instancia de Libro en el almacen
		Almacen.instancia.agregar(nuevoLibro);
		
		//Actualiza el archivo del Almacen
		Almacen.instancia.guardar();
	}

}
