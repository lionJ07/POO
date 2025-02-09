package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.ParseException;

import Logica.CarritoCompras;
import Logica.Producto;
import Logica.Usuario;

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
        setLocationRelativeTo(null);

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

        JComboBox<String> comboPago = new JComboBox<>(new String[]{"Tarjeta", "Efectivo"});
        comboPago.setBounds(250, 290, 100, 22);
        contentPane.add(comboPago);

        JButton btnFinalizar = new JButton("Finalizar Compra");
        btnFinalizar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnFinalizar.setBounds(260, 323, 214, 30);
        contentPane.add(btnFinalizar);
        btnFinalizar.addActionListener(e -> {
			try {
				finalizarCompra(comboPago.getSelectedItem().toString());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

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


    private void finalizarCompra(String metodoPago) throws ParseException {
        List<Producto> productos = manejoCarrito.obtenerProductosCarrito(usuario.getUsuario());

        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter historialWriter = new BufferedWriter(new FileWriter("historial.txt", true))) {
            List<Producto> productosActualizados = Producto.cargarProductos(); // Cargar productos actuales
            NumberFormat formatter = NumberFormat.getInstance(Locale.US);
            formatter.setMinimumFractionDigits(2);
            formatter.setMaximumFractionDigits(2);

            for (Producto p : productos) {
                int cantidadComprada = p.getCantprod();
                String precioFormateado = String.format(Locale.US, "%.2f", p.getPrecioprod());

                historialWriter.write(String.format("%d,%s,%s,%d,%s,%s,%s\n",
                        p.getCodigo(), p.getNombreprod(), precioFormateado,
                        cantidadComprada, p.getDescripcionprod(),
                        p.getNombreVendedor(), usuario.getUsuario()));

                // Restar la cantidad comprada del stock global
                for (Producto prod : productosActualizados) {
                    if (prod.getCodigo() == p.getCodigo()) {
                        int nuevaCantidad = prod.getCantprod() - cantidadComprada;
                        prod.setCantprod(Math.max(nuevaCantidad, 0)); // Evitar números negativos
                        break;
                    }
                }
            }

            historialWriter.flush(); // Asegurar que los datos se escriban correctamente

            // Guardar los productos actualizados en productos.txt
            try (BufferedWriter productosWriter = new BufferedWriter(new FileWriter("productos.txt", false))) {
                for (int i = 0; i < productosActualizados.size(); i++) {
                    Producto prod = productosActualizados.get(i);
                    String precioFormateado = String.format(Locale.US, "%.2f", prod.getPrecioprod());

                    String linea = String.format("%d,%s,%s,%d,%s,%s",
                            prod.getCodigo(), prod.getNombreprod(), precioFormateado,
                            prod.getCantprod(), prod.getDescripcionprod(), prod.getNombreVendedor());

                    System.out.println("Escribiendo en productos.txt: " + linea); // Agrega esta línea para ver qué se guarda
                    productosWriter.write(linea);
                    if (i < productosActualizados.size() - 1) {
                        productosWriter.newLine();
                    }
                }
            }

            // Confirmación de compra
            JOptionPane.showMessageDialog(this, "Compra finalizada con " + metodoPago, "Compra Exitosa", JOptionPane.INFORMATION_MESSAGE);

            // Vaciar solo el carrito del usuario
            manejoCarrito.vaciarCarrito(usuario.getUsuario());

            // Recargar productos en la interfaz de compra
            Producto.recargarProductos();

            dispose();
            new CompradorGUI(manejoCarrito, usuario).setVisible(true);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al procesar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
