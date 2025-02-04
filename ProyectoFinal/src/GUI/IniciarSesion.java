package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.SesionIniciada;
import Logica.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class IniciarSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio de Sesión ");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblNewLabel.setBounds(144, 31, 152, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_1.setBounds(104, 84, 62, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña: ");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_2.setBounds(104, 140, 102, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton btnIniciarSesion = new JButton("Ingresar ");
		btnIniciarSesion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String usuario = textFieldUsuario.getText().trim();
		            String contraseña = textFieldContraseña.getText().trim();

		            if (usuario.isEmpty() || contraseña.isEmpty()) {
		                throw new Exception("Todos los campos deben estar llenos");
		            }

		            Usuario usuarioLogueado = verificar(usuario, contraseña);

		            if (usuarioLogueado != null) {
		                // Guardar el usuario en la sesión
		                SesionIniciada.iniciarSesion(usuarioLogueado);

		                JOptionPane.showMessageDialog(contentPane, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		                
		                // Abrir ventana de selección
		                Seleccion seleccionwindow = new Seleccion();
		                seleccionwindow.setVisible(true);
		                dispose(); // Cerrar la ventana de login
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Datos incorrectos. Inténtalo nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
		            }

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		
		btnIniciarSesion.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnIniciarSesion.setBounds(252, 192, 102, 32);
		contentPane.add(btnIniciarSesion);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(176, 83, 142, 19);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(196, 139, 122, 19);
		contentPane.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
	            Inicio iniciowindow = new Inicio();
	            iniciowindow.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnNewButton.setBounds(64, 196, 102, 28);
		contentPane.add(btnNewButton);
	}

	private Usuario verificar(String usuario, String contraseña) {
	    try {
	        File archivo = new File("usuarios.txt");
	        Scanner scanner = new Scanner(archivo);

	        while (scanner.hasNextLine()) {
	            String linea = scanner.nextLine();
	            String[] partes = linea.split(",");

	            if (partes.length == 4) {
	                String usuarioArchivo = partes[0].trim();
	                String contraseñaArchivo = partes[1].trim();
	                String nombreArchivo = partes[2].trim();
	                String correoArchivo = partes[3].trim();

	                if (usuario.equals(usuarioArchivo) && contraseña.equals(contraseñaArchivo)) {
	                    scanner.close();
	                    return new Usuario(nombreArchivo, usuarioArchivo, correoArchivo, contraseñaArchivo);
	                }
	            }
	        }

	        scanner.close();
	    } catch (FileNotFoundException ex) {
	        JOptionPane.showMessageDialog(contentPane, "Archivo de usuarios no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    return null;
	}

}
