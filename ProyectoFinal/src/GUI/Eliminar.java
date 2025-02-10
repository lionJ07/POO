/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package GUI;

import Logica.Producto;
import Logica.SesionIniciada;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.util.List;

/**
 * Ventana para eliminar un producto 
 */
public class Eliminar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> productosComboBox;

    /**
     * Create the frame.
     * @throws ParseException 
     */
    public Eliminar() throws ParseException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(157, 226, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /**
         * Se le solicita al usuario seleccionar el producto a eliminar
         */
        JLabel lblTitulo = new JLabel("Eliminar Producto ");
        lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
        lblTitulo.setBounds(135, 32, 164, 31);
        contentPane.add(lblTitulo);

        JLabel lblCodigo = new JLabel("Seleccione el producto a eliminar: ");
        lblCodigo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCodigo.setBounds(76, 89, 291, 28);
        contentPane.add(lblCodigo);
        
        /**
         * Botón para regresar al menú de la ventana de vendedor 
         */
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                VendedorGUI vendedorwindow = new VendedorGUI();
                vendedorwindow.setVisible(true);
            }
        });
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegresar.setBounds(58, 185, 105, 31);
        contentPane.add(btnRegresar);
        

        productosComboBox = new JComboBox<>();
        productosComboBox.setBounds(76, 120, 300, 25);
        contentPane.add(productosComboBox);
        
        if (SesionIniciada.getUsuarioActual() == null) {
            JOptionPane.showMessageDialog(null, "No hay usuario en sesión.", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }
        String usuarioActual = SesionIniciada.getUsuarioActual().getNombre();
        List<Producto> productosUsuario = Producto.obtenerProductosPorUsuario(usuarioActual);
        
        if (productosUsuario == null || productosUsuario.isEmpty()) {
        	Icon imagen = new ImageIcon(getClass().getResource("/Imagenes/gatriste.png"));
        	JOptionPane.showMessageDialog(contentPane, "No tienes productos para eliminar", "Información", JOptionPane.PLAIN_MESSAGE,imagen);
        	dispose();
        	return;
        }
        
        for (Producto producto : productosUsuario) {
            productosComboBox.addItem(producto.getNombreprod() + " - " + producto.getCodigo());
        }
        
        /**
         * Botón para eliminar un producto seleccionado de la lista
         */
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnEliminar.setBounds(262, 185, 105, 31);
        contentPane.add(btnEliminar);

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productosComboBox.getSelectedIndex();
                if (selectedIndex != -1) {
                    Producto productoSeleccionado = productosUsuario.get(selectedIndex);
                    try {
						Producto.eliminarProducto(productoSeleccionado);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    Icon imagen = new ImageIcon(getClass().getResource("/Imagenes/gatipower2.png"));
                    JOptionPane.showMessageDialog(contentPane, "Producto eliminado exitosamente", "Éxito", JOptionPane.PLAIN_MESSAGE,imagen);
                    productosComboBox.removeItemAt(selectedIndex);
                } else {
                	Icon imagen1 = new ImageIcon (getClass().getResource("/Imagenes/gatipower2.png"));
                	 JOptionPane.showMessageDialog(contentPane, "Seleccione un producto para eliminar", "Érror", JOptionPane.PLAIN_MESSAGE,imagen1);
                }
            }
        });
         }
}
