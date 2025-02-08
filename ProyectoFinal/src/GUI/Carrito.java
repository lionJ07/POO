/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import Logica.CarritoCompras;
import Logica.Producto;
import Logica.Usuario;
/**
 * Ventana del carrito
 */
public class Carrito extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;
    private JLabel lblTotal;
    private CarritoCompras manejoCarrito;
    private Usuario usuario;

    public Carrito(CarritoCompras manejoCarrito, Usuario usuario) {
        this.manejoCarrito = manejoCarrito;
        this.usuario = usuario;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(157, 226, 230));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Carrito de Compras");
        lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
        lblTitulo.setBounds(170, 10, 200, 22);
        contentPane.add(lblTitulo);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30, 50, 420, 200);
        contentPane.add(scrollPane);

        lblTotal = new JLabel("Total: $0.0");
        lblTotal.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblTotal.setBounds(30, 260, 200, 22);
        contentPane.add(lblTotal);

        JLabel lblMetodoPago = new JLabel("Seleccione método de pago:");
        lblMetodoPago.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblMetodoPago.setBounds(30, 290, 200, 22);
        contentPane.add(lblMetodoPago);
        /**
         * Botón para seleccionar el método de pago 
         */
        JComboBox<String> comboPago = new JComboBox<>(new String[]{"Tarjeta", "Efectivo"});
        comboPago.setBounds(250, 290, 100, 22);
        contentPane.add(comboPago);
        /**
         * Botón para finalizar la compra 
         */
        JButton btnFinalizar = new JButton("Finalizar Compra");
        btnFinalizar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnFinalizar.setBounds(260, 323, 214, 30);
        contentPane.add(btnFinalizar);
        btnFinalizar.addActionListener(e -> finalizarCompra(comboPago.getSelectedItem().toString()));
        /**
         * Botón para regresar a la ventana de comprador  
         */
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegresar.setBounds(30, 323, 120, 30);
        contentPane.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CompradorGUI compradorwindow = new CompradorGUI(manejoCarrito, usuario);
                compradorwindow.setVisible(true);
            }
        });

        cargarCarrito();
    }
    /**
     * Método para cargar los productos al carrito 
     */
    private void cargarCarrito() {
        List<Producto> productos = manejoCarrito.obtenerProductosCarrito(usuario.getUsuario()); // Filtrar por usuario
        if (productos.isEmpty()) {
            textArea.setText("El carrito está vacío.");
            lblTotal.setText("Total: $0.0");
            return;
        }
        
        double total = 0;
        StringBuilder contenido = new StringBuilder();
        for (Producto p : productos) {
            contenido.append("Código: ").append(p.getCodigo())
                     .append(" | ").append(p.getNombreprod())
                     .append(" | Precio: $").append(p.getPrecioprod())
                     .append(" | Cantidad: ").append(p.getCantprod())
                     .append(" | ").append(p.getDescripcionprod()).append("\n");
            total += p.getPrecioprod() * p.getCantprod();
        }
        textArea.setText(contenido.toString());
        lblTotal.setText("Total: $" + total);
    }
    /**
     * Método para finalizar la compra 
     * @param metodoPago
     */
    private void finalizarCompra(String metodoPago) {
        JOptionPane.showMessageDialog(this, "Compra finalizada con " + metodoPago, "Compra Exitosa", JOptionPane.INFORMATION_MESSAGE);
        manejoCarrito.vaciarCarrito(usuario.getUsuario()); // Vaciar solo el carrito del usuario
        dispose();
        new CompradorGUI(manejoCarrito, usuario).setVisible(true);
    }
}
