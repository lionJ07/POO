/**
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 */
package GUI;

import Logica.Producto;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Ventana para eliminar un producto 
 */
public class Eliminar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Create the frame.
     */
    public Eliminar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(157, 226, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /**
         * Se le solicita al usuario ingresar el codigo del producto para eliminarlo
         */
        JLabel lblTitulo = new JLabel("Eliminar Producto ");
        lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
        lblTitulo.setBounds(135, 32, 164, 31);
        contentPane.add(lblTitulo);

        JLabel lblCodigo = new JLabel("Indica el código del producto a eliminar: ");
        lblCodigo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCodigo.setBounds(76, 89, 291, 28);
        contentPane.add(lblCodigo);

        textField = new JTextField();
        textField.setBounds(162, 115, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        /**
         * Botón para eliminar algun producto (filtro por codigo)
         */
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnEliminar.setBounds(262, 185, 105, 31);
        contentPane.add(btnEliminar);

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    try {
                        String codigoStr = textField.getText().trim();
                        if (!codigoStr.matches("\\d+")) {
                            JOptionPane.showMessageDialog(null, "Ingrese un código numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        int codigo = Integer.parseInt(codigoStr);

                        List<Producto> productos = Producto.cargarProductos();
                        List<Producto> productosActualizados = productos.stream()
                                .filter(p -> p.getCodigo() != codigo)
                                .collect(Collectors.toList());

                        if (productos.size() == productosActualizados.size()) {
                            JOptionPane.showMessageDialog(null, "No se encontró el producto.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
                            for (Producto p : productosActualizados) {
                                writer.write(String.format("%d,%s,%.2f,%d,%s\n", 
                                        p.getCodigo(), p.getNombreprod(), p.getPrecioprod(), p.getCantprod(), p.getDescripcionprod()));
                            }
                        }

                        JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });

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
    }


}

