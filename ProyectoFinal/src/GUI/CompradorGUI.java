/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Logica.CarritoCompras;
import Logica.Comprador;
import Logica.Usuario;
import java.io.*;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompradorGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CarritoCompras carrito;
    private Comprador comprador;

    /**
     * Constructor de la ventana del comprador
     */
    public CompradorGUI(CarritoCompras carrito, Usuario usuario) {
        // Verificar si el usuario es un Comprador en el archivo
        Usuario usuarioVerificado = Usuario.verificar(usuario.getUsuario(), usuario.getContraseña());

        if (usuarioVerificado instanceof Comprador) {
            this.comprador = (Comprador) usuarioVerificado;
        } else {
            // Si el usuario no es Comprador, actualizarlo y guardarlo en el archivo
            actualizarUsuarioAComprador(usuario);
            this.comprador = new Comprador(usuario.getNombre(), usuario.getUsuario(), usuario.getCorreo(), usuario.getContraseña());
        }

        this.carrito = carrito;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(157, 226, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("¿Qué deseas realizar?");
        lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
        lblNewLabel.setBounds(133, 22, 193, 22);
        contentPane.add(lblNewLabel);
        
        JButton btnCarrito = new JButton("Tu Carrito de Compras");
        btnCarrito.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Carrito carritowindow = new Carrito(carrito, comprador);
                carritowindow.setVisible(true);
            }
        });
        btnCarrito.setBounds(96, 120, 243, 29);
        contentPane.add(btnCarrito);
        
        JButton btnProductoDisponibles = new JButton("Ver Productos disponibles");
        btnProductoDisponibles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Comprar comprarwindow;
				try {
					comprarwindow = new Comprar(carrito, comprador);
					comprarwindow.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        btnProductoDisponibles.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnProductoDisponibles.setBounds(96, 68, 243, 29);
        contentPane.add(btnProductoDisponibles);
        
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Seleccion seleccionwindow = new Seleccion();
                seleccionwindow.setVisible(true);
            }
        });
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegresar.setBounds(156, 208, 117, 29);
        contentPane.add(btnRegresar);
        
        JButton btnHistorial = new JButton("Historial de Compras");
        btnHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Historial historialwindow = new Historial(comprador, carrito);
                historialwindow.setVisible(true);
            }
        });

        btnHistorial.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnHistorial.setBounds(96, 169, 241, 29);
        contentPane.add(btnHistorial);
    }
    /**
     * Método para actualizar un usuario a Comprador en el archivo.
     */
    private void actualizarUsuarioAComprador(Usuario usuario) {
        File archivo = new File("usuarios.txt");
        File archivoTemp = new File("usuarios_temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 5 && datos[1].equals(usuario.getUsuario())) {
                    // Actualizar tipo de usuario a Comprador
                    linea = datos[0] + "," + datos[1] + "," + datos[2] + "," + datos[3] + ",Comprador";
                }

                bw.write(linea + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el actualizado
        if (archivo.delete() && archivoTemp.renameTo(archivo)) {
        	
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
