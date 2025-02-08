/**
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 */
package GUI;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Logica.Usuario;
/**
 * Ventana para que los nuevos usuarios se puedan registrar al programa 
 */
public class Registro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JTextField textFieldUsuario;
    private JTextField textFieldContraseña;
    public Registro() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(157, 226, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Registro");
        lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
        lblTitulo.setBounds(180, 10, 91, 36);
        contentPane.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblNombre.setBounds(83, 52, 69, 26);
        contentPane.add(lblNombre);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCorreo.setBounds(83, 84, 60, 24);
        contentPane.add(lblCorreo);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblUsuario.setBounds(83, 118, 69, 23);
        contentPane.add(lblUsuario);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblContraseña.setBounds(83, 151, 100, 26);
        contentPane.add(lblContraseña);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(155, 54, 193, 19);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldCorreo = new JTextField();
        textFieldCorreo.setBounds(155, 88, 193, 19);
        contentPane.add(textFieldCorreo);
        textFieldCorreo.setColumns(10);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(155, 122, 193, 19);
        contentPane.add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        textFieldContraseña = new JTextField();
        textFieldContraseña.setBounds(180, 153, 168, 19);
        contentPane.add(textFieldContraseña);
        textFieldContraseña.setColumns(10);
        /**
         * Botón para regresar a la ventana de Inicio 
         */
        JButton btnRegresar = new JButton("Atras");
        btnRegresar.addActionListener(e -> {
            dispose();
            Inicio iniciowindow = new Inicio();
            iniciowindow.setVisible(true);
        });
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegresar.setBounds(83, 199, 113, 36);
        contentPane.add(btnRegresar);
        /**
         * Botón para  el registro del usuario 
         */
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	/**
            	 * Excepción para que el registro sea exitoso y si no se muestre un error 
            	 */
            	
                try {
                	String nombre = textFieldNombre.getText().trim();
                    String correo = textFieldCorreo.getText().trim();
                    String usuario = textFieldUsuario.getText().trim();
                    String contraseña = textFieldContraseña.getText().trim();
                    // Validacion para que los campos esten completos 
                    if (nombre.isEmpty() || correo.isEmpty() || usuario.isEmpty() || contraseña.isEmpty()) {
                        Icon imagen = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
                        JOptionPane.showMessageDialog(rootPane, "Todos los campos deben estar completados", "Mensaje", JOptionPane.PLAIN_MESSAGE, imagen);
                        return; 
                    }
                    // Validacion del correo 
                    if (!correo.contains("@")) {
                        Icon imagen2 = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
                        JOptionPane.showMessageDialog(rootPane, "El correo no es válido", "Mensaje", JOptionPane.PLAIN_MESSAGE, imagen2);
                        return; 
                    }    
                    // Validacion correo completo 
                    if (!correo.contains("gmail") && !correo.contains("hotmail")) {
                        Icon imagen4 = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
                        JOptionPane.showMessageDialog(rootPane, "El correo no es válido (Falta gmail/hotmail)", "Mensaje", JOptionPane.PLAIN_MESSAGE, imagen4);
                        return; 
                    }
                    // Validacion correo
                    if (!correo.contains(".com") && !correo.contains(".es")) {
                        Icon imagen5 = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
                        JOptionPane.showMessageDialog(rootPane, "El correo no es válido (Falta .es/.com)", "Mensaje", JOptionPane.PLAIN_MESSAGE, imagen5);
                        return; 
                    }
                    // Validacion contraseña
                    if (contraseña.length() < 6) {
                        Icon imagen3 = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
                        JOptionPane.showMessageDialog(rootPane, "La contraseña debe tener al menos 6 caracteres", "Mensaje", JOptionPane.PLAIN_MESSAGE, imagen3);
                        return; 
                    }
                    // Objeto 
                   Usuario user = new Usuario(nombre, usuario, correo, contraseña);
                   user.guardarUsuario();
                   //Mensaje de exito 
                   Icon icono = new ImageIcon(getClass().getResource("/Imagenes/gatipower2.png"));
                   JOptionPane.showMessageDialog(rootPane,"¡Registro exitoso!","Mensaje", JOptionPane.PLAIN_MESSAGE,icono);
                   // Manda al usuario a la ventana de iniciar sesión
                   dispose();
                   IniciarSesion iniciarsesion = new IniciarSesion();
                   iniciarsesion.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRegistrarse.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegistrarse.setBounds(226, 199, 122, 36);
        contentPane.add(btnRegistrarse);
    }
}


