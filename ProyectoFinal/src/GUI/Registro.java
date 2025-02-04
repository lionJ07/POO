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
         * Botón para confirmar el registro del usuario 
         */
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	/**
            	 * Excepción para que el registro sea exitoso y si no se muestre un error 
            	 */
                try {
                    validarDatos();
                    Icon icono = new ImageIcon(getClass().getResource("/Imagenes/gatipower2.png"));
                    JOptionPane.showMessageDialog(rootPane,"¡Registro exitoso!","Mensaje", JOptionPane.PLAIN_MESSAGE,icono);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRegistrarse.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegistrarse.setBounds(226, 199, 122, 36);
        contentPane.add(btnRegistrarse);
    }
    /**
     * Validación de datos para que todos los espacios esten completados
     */
    private void validarDatos() throws Exception {
        String nombre = textFieldNombre.getText().trim();
        String correo = textFieldCorreo.getText().trim();
        String usuario = textFieldUsuario.getText().trim();
        String contraseña = textFieldContraseña.getText().trim();
        Icon imagen = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
        if (nombre.isEmpty() || correo.isEmpty() || usuario.isEmpty() || contraseña.isEmpty()) 
        	JOptionPane.showMessageDialog(rootPane,"Todos los campos deben estar completados","Mensaje", JOptionPane.PLAIN_MESSAGE,imagen);
        Icon imagen2 = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
        if (!correo.contains("@")) 
        	JOptionPane.showMessageDialog(rootPane,"El correo debe tener @","Mensaje", JOptionPane.PLAIN_MESSAGE,imagen2);
        Icon imagen3 = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
        if (contraseña.length() < 6)
        	JOptionPane.showMessageDialog(rootPane,"La contraseña debe tener 6 caracteres","Mensaje", JOptionPane.PLAIN_MESSAGE,imagen3);
 
    }
}

