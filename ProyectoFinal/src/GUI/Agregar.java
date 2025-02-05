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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.Producto;
import Logica.SesionIniciada;
import Logica.Vendedor;

/**
 * Ventana para agregar un nuevo producto
 */
public class Agregar extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCodigo;
    private JTextField textFieldNombreProducto;
    private JTextField textFieldPrecio;
    private JTextField textFieldCantidad;
    private JTextPane textPaneDescripcion;

    public Agregar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(157, 226, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Agregar Producto:");
        lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
        lblNewLabel.setBounds(129, 10, 173, 23);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Código del Producto:");
        lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblNewLabel_1.setBounds(26, 32, 147, 23);
        contentPane.add(lblNewLabel_1);
        
        textFieldCodigo = new JTextField();
        textFieldCodigo.setBounds(180, 32, 234, 19);
        contentPane.add(textFieldCodigo);
        textFieldCodigo.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Nombre del Producto:");
        lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblNewLabel_2.setBounds(26, 61, 163, 23);
        contentPane.add(lblNewLabel_2);
        
        textFieldNombreProducto = new JTextField();
        textFieldNombreProducto.setBounds(190, 61, 224, 19);
        contentPane.add(textFieldNombreProducto);
        textFieldNombreProducto.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Precio del Producto:");
        lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblNewLabel_3.setBounds(26, 90, 147, 23);
        contentPane.add(lblNewLabel_3);
        
        textFieldPrecio = new JTextField();
        textFieldPrecio.setBounds(178, 90, 236, 19);
        contentPane.add(textFieldPrecio);
        textFieldPrecio.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Cantidad del Producto:");
        lblNewLabel_4.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblNewLabel_4.setBounds(26, 119, 173, 23);
        contentPane.add(lblNewLabel_4);
        
        textFieldCantidad = new JTextField();
        textFieldCantidad.setBounds(198, 119, 216, 19);
        contentPane.add(textFieldCantidad);
        textFieldCantidad.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Descripción:");
        lblNewLabel_5.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblNewLabel_5.setBounds(26, 152, 109, 29);
        contentPane.add(lblNewLabel_5);
        
        // Campo de texto para descripción
        textPaneDescripcion = new JTextPane();
        textPaneDescripcion.setBounds(118, 152, 296, 41);
        contentPane.add(textPaneDescripcion);

        /**
         * Botón para regresar a la ventana vendedor 
         */
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> {
            dispose();
            VendedorGUI vendedorwindow = new VendedorGUI();
            vendedorwindow.setVisible(true);
        });
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegresar.setBounds(89, 203, 85, 41);
        contentPane.add(btnRegresar);

        /**
         * Botón para agregar un producto
         */
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> {
            try {
                String codigoTexto = textFieldCodigo.getText().trim();
                String producto = textFieldNombreProducto.getText().trim();
                String precioTexto = textFieldPrecio.getText().trim();
                String cantidadTexto = textFieldCantidad.getText().trim();
                String descripcion = textPaneDescripcion.getText().trim();
                // Validación de campos vacíos
                if (codigoTexto.isEmpty() || producto.isEmpty() || precioTexto.isEmpty() || cantidadTexto.isEmpty() || descripcion.isEmpty()) {
                	Icon imagen1 = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
                	JOptionPane.showMessageDialog(rootPane, "Todos los campos deben estar llenos", "Mensaje", JOptionPane.PLAIN_MESSAGE, imagen1);
                }
                // Validación de la descripción 
                if (descripcion.length() < 6) {
                	Icon imagen = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
                	JOptionPane.showMessageDialog(rootPane, "La descripción debe tener al menos 6 caracteres", "Mensaje", JOptionPane.PLAIN_MESSAGE, imagen);
                }
                int codigo = Integer.parseInt(codigoTexto);
                double precio = Double.parseDouble(precioTexto);
                int cantidad = Integer.parseInt(cantidadTexto);
                // Creación del producto
                Producto prod = new Producto(codigo, producto, precio, cantidad, descripcion);
                // Verificar si hay un vendedor en sesión
                if (!SesionIniciada.esVendedor()) {
                    throw new Exception("Error: No hay un vendedor en sesión.");
                }
                /**Obtener el vendedor actual y agregar el producto
                 */
                Vendedor vendedor = (Vendedor) SesionIniciada.getUsuarioActual();
                vendedor.agregarProducto(prod);
                Icon imagen2 = new ImageIcon(getClass().getResource("/Imagenes/gatipower2.png"));
                JOptionPane.showMessageDialog(rootPane, "Producto registrado con exito", "Mensaje", JOptionPane.PLAIN_MESSAGE, imagen2);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(contentPane, "Error en formato de número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnAgregar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnAgregar.setBounds(253, 203, 103, 41);
        contentPane.add(btnAgregar);
    }
}
