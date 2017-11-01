

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

public class ConsultaLibros extends JFrame {

	private JPanel contentPane;
	private JTextField txtISBN;
	private JTextPane txtViewLibro;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaLibros frame = new ConsultaLibros();
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
	public ConsultaLibros() {
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
		
		JLabel lblListadoDePacientes = new JLabel("Consulta de Libros");
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
		btnCerrar.setBounds(117, 280, 89, 23);
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
					if (Almacen.instancia.estaVacio())
						throw new Exception("No hay registros");
					
					if(!FuncionesComunes.isDouble(txtISBN.getText()) || txtISBN.getText().length() != 13 || Double.parseDouble(txtISBN.getText()) < 0)
						throw new Exception("ISBN inválido");
					
					Optional<Libro> dato = Almacen.instancia.get(txtISBN.getText());
					if (!dato.isPresent())
						throw new Exception("El registro no existe");
					
					txtViewLibro.setText(dato.get().getLibro());
					
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
		setLocationRelativeTo(null);
		
	}
}
