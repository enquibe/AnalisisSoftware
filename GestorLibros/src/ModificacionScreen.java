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
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificacionScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtEditorial;
	private JTextField txtAutor;
	private JTextField txtPublicacion;
	private JTextField txtEdicion;
	private JTextField txtISBN;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	Optional<Libro> dato;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificacionScreen frame = new ModificacionScreen();
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
	public ModificacionScreen() {
		setTitle("Gestor de Libros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlta = new JLabel("Modificación de libro");
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblAlta.setBounds(6, 0, 502, 43);
		contentPane.add(lblAlta);
		
		JLabel lblTtulo = new JLabel("Título");
		lblTtulo.setBounds(65, 131, 298, 16);
		contentPane.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(65, 185, 298, 16);
		contentPane.add(lblAutor);
		
		JLabel lblEdicin = new JLabel("Edición");
		lblEdicin.setBounds(65, 298, 298, 16);
		contentPane.add(lblEdicin);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(65, 244, 298, 16);
		contentPane.add(lblEditorial);
		
		JLabel lblAoDePublicacin = new JLabel("Año de publicación");
		lblAoDePublicacin.setBounds(65, 354, 298, 16);
		contentPane.add(lblAoDePublicacin);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					
					// Verificaciones
					if(txtTitulo.getText().length()<=0 && checkBox.isSelected())
						throw new Exception("Ingrese un título");
					
					if(txtAutor.getText().length()<=0 && checkBox_1.isSelected())
						throw new Exception("Ingrese un Autor");
					
					if(txtEditorial.getText().length()<=0 && checkBox_2.isSelected())
						throw new Exception("Ingrese una editorial");
					
					if(checkBox_3.isSelected() && (!FuncionesComunes.isInteger(txtEdicion.getText()) || Integer.parseInt(txtEdicion.getText()) < 1 || Integer.parseInt(txtEdicion.getText()) > Integer.MAX_VALUE))
						throw new Exception("Edición inválida");
					
					if(checkBox_4.isSelected() && (!FuncionesComunes.isInteger(txtPublicacion.getText()) || Integer.parseInt(txtPublicacion.getText()) < 1500))
						throw new Exception("Año de publicación inválido");
						
					// Actualiza el registro
					if(checkBox.isSelected())
						dato.get().setTitulo(txtTitulo.getText());
					
					if(checkBox_1.isSelected())
						dato.get().setAutor(txtAutor.getText());
					
					if(checkBox_2.isSelected())
						dato.get().setEditorial(txtEditorial.getText());
					
					if(checkBox_3.isSelected())
						dato.get().setEdicion(Integer.parseInt(txtEdicion.getText()));
					
					if(checkBox_4.isSelected())
						dato.get().setAnno_de_publicacion(Integer.parseInt(txtPublicacion.getText()));
					
					Constantes.log.append(Constantes.gestorUsuarios.getLoggedUser().getUsuario() + "@Modificado el libro " + dato.get().getLibro());
					
					Almacen.instancia.guardar();
					
					JOptionPane.showMessageDialog(null, "Registro agregado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(75, 426, 157, 43);
		contentPane.add(btnGuardar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(309, 426, 157, 43);
		contentPane.add(btnVolver);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(63, 147, 323, 30);
		contentPane.add(txtTitulo);
		
		txtEditorial = new JTextField();
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(63, 257, 323, 30);
		contentPane.add(txtEditorial);
		
		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(63, 202, 323, 30);
		contentPane.add(txtAutor);
		
		txtPublicacion = new JTextField();
		txtPublicacion.setColumns(10);
		txtPublicacion.setBounds(63, 371, 323, 30);
		contentPane.add(txtPublicacion);
		
		txtEdicion = new JTextField();
		txtEdicion.setColumns(10);
		txtEdicion.setBounds(63, 316, 323, 30);
		contentPane.add(txtEdicion);
		
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(63, 86, 323, 30);
		contentPane.add(txtISBN);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Almacen.instancia.estaVacio())
						throw new Exception("No hay registros");
					
					if(!FuncionesComunes.isDouble(txtISBN.getText()) || txtISBN.getText().length() != 13 || Double.parseDouble(txtISBN.getText()) < 0)
						throw new Exception("ISBN inválido");
					
					dato = Almacen.instancia.get(txtISBN.getText());
					if (!dato.isPresent())
						throw new Exception("El registro no existe");
					
					txtISBN.setText(dato.get().getISBN());
					txtTitulo.setText(dato.get().getTitulo());
					txtEditorial.setText(dato.get().getEditorial());
					txtAutor.setText(dato.get().getAutor());
					txtPublicacion.setText(Integer.toString(dato.get().getAnno_de_publicacion()));
					txtEdicion.setText(Integer.toString(dato.get().getEdicion()));
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(401, 86, 90, 33);
		contentPane.add(button);
		
		JLabel lblIngreseIsbn = new JLabel("Ingrese ISBN");
		lblIngreseIsbn.setBounds(65, 72, 298, 16);
		contentPane.add(lblIngreseIsbn);
		
		checkBox = new JCheckBox("Modificar");
		checkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTitulo.setEnabled(!txtTitulo.isEnabled());
			}
		});
		checkBox.setSelected(true);
		checkBox.setBounds(398, 150, 128, 23);
		contentPane.add(checkBox);
		
		checkBox_1 = new JCheckBox("Modificar");
		checkBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAutor.setEnabled(!txtAutor.isEnabled());
			}
		});
		checkBox_1.setSelected(true);
		checkBox_1.setBounds(398, 205, 128, 23);
		contentPane.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("Modificar");
		checkBox_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEditorial.setEnabled(!txtEditorial.isEnabled());
			}
		});
		checkBox_2.setSelected(true);
		checkBox_2.setBounds(398, 260, 128, 23);
		contentPane.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("Modificar");
		checkBox_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEdicion.setEnabled(!txtEdicion.isEnabled());
			}
		});
		checkBox_3.setSelected(true);
		checkBox_3.setBounds(398, 319, 128, 23);
		contentPane.add(checkBox_3);
		
		checkBox_4 = new JCheckBox("Modificar");
		checkBox_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPublicacion.setEnabled(!txtPublicacion.isEnabled());
			}
		});
		checkBox_4.setSelected(true);
		checkBox_4.setBounds(398, 374, 128, 23);
		contentPane.add(checkBox_4);
	}
}
