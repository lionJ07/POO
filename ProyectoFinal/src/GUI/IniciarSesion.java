/**
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 */
package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
/**
 * Ventana para iniciar sesión 
 */
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
		/**
		 * Botón para ingresar con el usuario y la contraseña 
		 */
		JButton btnIniciarSesion = new JButton("Ingresar ");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Validación para que el usuario y la contraseña estan correctas el programa mande al usuario a la ventana de selección
				 */
				try {
					validarInicio();
					Seleccion seleccionwindow = new Seleccion();
					seleccionwindow.setVisible(true);
					dispose();
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
	 * Validación parra que los campos requerido esten completos 
	 * @throws Exception por si el usuario y la contraseña llegan a ser incorrectos 
	 */
	private void validarInicio() throws Exception {
		String usuario = textFieldUsuario.getText().trim();
        String contraseña = textFieldContraseña.getText().trim();Icon 
        imagen = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
        if (usuario.isEmpty()|| contraseña.isEmpty()) throw new Exception("Todos los campos deben estar llenos");
        JOptionPane.showMessageDialog(rootPane,"Todos los campos deben estar completados","Mensaje", JOptionPane.PLAIN_MESSAGE,imagen);
        // Poner excepcion de usuario y contraseña incorrecta 

		
		
	}

}
