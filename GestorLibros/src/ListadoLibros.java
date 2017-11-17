

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

public class ListadoLibros extends JFrame {

	private JPanel contentPane;
	private static String listado = System.getenv("APPDATA") + "/GestorLibros/listado.txt";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoLibros frame = new ListadoLibros();
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
	public ListadoLibros() {
		setTitle("Gestor de Libros");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
		
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 493);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListadoDePacientes = new JLabel("Listado de Libros");
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
		btnCerrar.setBounds(188, 427, 89, 23);
		contentPane.add(btnCerrar);
		
		JList listPacientes = new JList();
		/*listPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList list = (JList)e.getSource();
				Libro libro = (Libro)list.getSelectedValue();
				
			}
		});*/
		listPacientes.setBounds(12, 65, 308, 320);
		contentPane.add(listPacientes);
		
		DefaultListModel modelo = new DefaultListModel();
		for (Libro p : Almacen.instancia.libros) {
			// String item = " [" + p.getISBN() + "] - " + p.getTitulo();
			modelo.addElement(p);
		}
		
		listPacientes.setModel(modelo);
		
		JButton button = new JButton("Imprimir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					imprimirListado();
			        File myFile = new File(listado);
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        // no application registered for PDFs
			    }
				// JOptionPane.showMessageDialog(null, "Listado generado", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button.setBounds(48, 427, 89, 23);
		contentPane.add(button);
		setLocationRelativeTo(null);
		
	}
	
	public void imprimirListado() {
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(listado))) {
			for (Libro libro : Almacen.instancia.libros)
				stream.writeChars(libro.getLibro() + '\n');
			
			stream.writeChars("Total de registros: " + Almacen.instancia.libros.size());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
