/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package GUI;

import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import Logica.CarritoCompras;
import Logica.Producto;
import Logica.Usuario;
/**
 * Ventana para comprar 
 */
public class Comprar extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBox;
    private JLabel lblCantidadDisponible;
    private JLabel lblDescripcion;
    private JTextField txtCantidad;
    private CarritoCompras manejoCarrito;
    private List<Producto> productos;
    private Usuario usuarioActual; // Usuario que está comprando

    public Comprar(CarritoCompras manejoCarrito, Usuario usuarioActual) throws ParseException {
        this.manejoCarrito = manejoCarrito;
        this.usuarioActual = usuarioActual;
        this.productos = Producto.cargarProductos();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(157, 226, 230));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Comprar productos");
        lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
        lblTitulo.setBounds(145, 10, 167, 22);
        contentPane.add(lblTitulo);

        JLabel lblSeleccionarProducto = new JLabel("Seleccione el producto:");
        lblSeleccionarProducto.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblSeleccionarProducto.setBounds(40, 50, 200, 22);
        contentPane.add(lblSeleccionarProducto);

        comboBox = new JComboBox<>();
        comboBox.setBounds(230, 50, 170, 22);
        contentPane.add(comboBox);
        
        lblCantidadDisponible = new JLabel("Cantidad Disponible: ");
        lblCantidadDisponible.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCantidadDisponible.setBounds(40, 90, 350, 22);
        contentPane.add(lblCantidadDisponible);

        lblDescripcion = new JLabel("Descripción: ");
        lblDescripcion.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblDescripcion.setBounds(40, 120, 350, 22);
        contentPane.add(lblDescripcion);

        JLabel lblCantidad = new JLabel("Cantidad a comprar:");
        lblCantidad.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCantidad.setBounds(40, 160, 200, 22);
        contentPane.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(230, 160, 100, 22);
        contentPane.add(txtCantidad);
        /**
         * Botón para regresar a la ventana de comprador
         */
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CompradorGUI seleccionwindow = new CompradorGUI(manejoCarrito, usuarioActual);
                seleccionwindow.setVisible(true);
            }
        });
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegresar.setBounds(40, 201, 117, 29);
        contentPane.add(btnRegresar);

        JButton btnAgregarCarrito = new JButton("Añadir al Carrito");
        btnAgregarCarrito.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnAgregarCarrito.setBounds(230, 200, 170, 30);
        contentPane.add(btnAgregarCarrito);

        btnAgregarCarrito.addActionListener(e -> agregarAlCarrito());
        // Llenar comboBox y asignar listener
        llenarComboBox();
        comboBox.addActionListener(e -> actualizarDetallesProducto());
    }

    private void llenarComboBox() throws ParseException {
        productos = Producto.cargarProductos(); // 🔹 Asegurarnos de obtener los productos más recientes

        comboBox.removeAllItems(); // Limpiar la lista antes de agregar nuevos productos
        if (productos != null && !productos.isEmpty()) {
            for (Producto p : productos) {
                comboBox.addItem(p.getCodigo() + " - " + p.getNombreprod() + " - $" + p.getPrecioprod());
            }
            comboBox.setSelectedIndex(0);
            actualizarDetallesProducto();
        } else {
            lblCantidadDisponible.setText("No hay productos disponibles.");
            lblDescripcion.setText("");
        }
    }

    private void actualizarDetallesProducto() {
        int selectedIndex = comboBox.getSelectedIndex();
        if (productos != null && selectedIndex >= 0) {
            Producto p = productos.get(selectedIndex);
            lblCantidadDisponible.setText("Cantidad Disponible: " + p.getCantprod());
            lblDescripcion.setText("Descripción: " + p.getDescripcionprod());
        }
    }
    /**
     * Método para agregar al carrito 
     */

    private void agregarAlCarrito() {
        int selectedIndex = comboBox.getSelectedIndex();
        if (selectedIndex < 0 || productos == null || productos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Producto productoSeleccionado = productos.get(selectedIndex);
        try {
            int cantidadComprada = Integer.parseInt(txtCantidad.getText().trim());
            if (cantidadComprada <= 0 || cantidadComprada > productoSeleccionado.getCantprod()) {
            	Icon imagen1 = new ImageIcon (getClass().getResource("/Imagenes/gatitoo.png"));
            	JOptionPane.showMessageDialog(contentPane, "Cantidad Invalida", "Error", JOptionPane.PLAIN_MESSAGE,imagen1);
                return;
            }
            manejoCarrito.agregarProductoAlCarrito(productoSeleccionado, cantidadComprada, usuarioActual.getUsuario());
            Icon imagen2 = new ImageIcon (getClass().getResource("/Imagenes/gatipower2.png"));
            JOptionPane.showMessageDialog(contentPane, "Producto añadido al carrito", "Éxito", JOptionPane.PLAIN_MESSAGE,imagen2);
        } catch (NumberFormatException ex) {
        	Icon imagen3 =  new ImageIcon (getClass().getResource("/Imagenes/gatitoo.png"));
        	JOptionPane.showMessageDialog(contentPane, "Ingrese una cantidad valida", "Érror", JOptionPane.PLAIN_MESSAGE,imagen3);
        }
    }
}
