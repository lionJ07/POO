package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Logica.Usuario;

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

        JButton btnRegresar = new JButton("Atras");
        btnRegresar.addActionListener(e -> {
            dispose();
            Inicio iniciowindow = new Inicio();
            iniciowindow.setVisible(true);
        });
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegresar.setBounds(83, 199, 113, 36);
        contentPane.add(btnRegresar);

        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	String nombre = textFieldNombre.getText().trim();
                    String correo = textFieldCorreo.getText().trim();
                    String usuario = textFieldUsuario.getText().trim();
                    String contraseña = textFieldContraseña.getText().trim();
                    if (nombre.isEmpty() || correo.isEmpty() || usuario.isEmpty() || contraseña.isEmpty()) throw new Exception("Todos los campos deben de estar llenos");
                    if (!correo.contains("@")) throw new Exception("El correo no es válido.");
                    if (!correo.contains("gmail") && !correo.contains("hotmail")) throw new Exception("El correo no es válido. (Falta gmail/hotmail)");
                    if (!correo.contains(".com") && !correo.contains(".es")) throw new Exception("El correo no es válido. (Falta .com/.es).");
                    if (contraseña.length() < 6) throw new Exception("La contraseña debe tener al menos 6 caracteres.");

                   Usuario user = new Usuario(nombre, usuario, correo, contraseña);
                   user.guardarUsuario();
                    JOptionPane.showMessageDialog(contentPane, "¡Registro exitoso!");
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

