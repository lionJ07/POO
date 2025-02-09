/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package GUI;

import java.awt.Color;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Logica.CarritoCompras;
import Logica.Comprador;
import Logica.SesionIniciada;
import Logica.Usuario;
import Logica.Vendedor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana para iniciar sesión
 */
public class IniciarSesion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldUsuario;
    private JTextField textFieldContraseña;

    /**
     * Constructor: crea la ventana de inicio de sesión
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

        /**
         * Botón para iniciar sesión
         */
        JButton btnIniciarSesion = new JButton("Ingresar ");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción de iniciar sesión
				try {String usuario = textFieldUsuario.getText().trim();
				String contraseña = textFieldContraseña.getText().trim();
				// Verificar que los campos no estén vacíos
				if (usuario.isEmpty() || contraseña.isEmpty()) {
					Icon imagen = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
					JOptionPane.showMessageDialog(rootPane, "Todos los campos deben estar completados", "Mensaje", JOptionPane.PLAIN_MESSAGE, imagen);
					return;
				}
				// Verificar usuario y contraseña
				Usuario usuarioLogueado = verificar(usuario, contraseña);
				if (usuarioLogueado == null) {
					Icon imagen1 = new ImageIcon(getClass().getResource("/Imagenes/gatriste.png"));
					JOptionPane.showMessageDialog(contentPane, "Usuario o contraseña incorrectos.", "Error", JOptionPane.PLAIN_MESSAGE,imagen1);
					return;
				} else {
					// Iniciar sesión si todo es correcto
					SesionIniciada.iniciarSesion(usuarioLogueado);
					Icon imagen2 = new ImageIcon(getClass().getResource("/Imagenes/gatipower2.png"));
					JOptionPane.showMessageDialog(contentPane, "Inicio de sesión exitoso", "Éxito", JOptionPane.PLAIN_MESSAGE,imagen2);
					Seleccion seleccionwindow = new Seleccion();
					seleccionwindow.setVisible(true);
					dispose(); // Cierra la ventana de inicio de sesión
				} 
				}catch (Exception ex) {
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

        /**
         * Botón para regresar a la ventana de inicio
         */
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

    /**
     * Verifica las credenciales del usuario leyendo el archivo usuarios.txt
     */
    private Usuario verificar(String usuario, String contraseña) {
        try {
            File archivo = new File("usuarios.txt");
            if (!archivo.exists()) {
                JOptionPane.showMessageDialog(contentPane, "El archivo de usuarios no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
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
