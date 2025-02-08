/**
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Logica.Producto;
import Logica.SesionIniciada;

public class Editar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> productosComboBox;
    private JTextField textFieldCodigoNuevo;
    private JTextField textFieldNombreNuevo;
    private JTextField textFieldPrecioNuevo;
    private JTextField textFieldCantidadNuevo;
    private JTextField textFieldDescripcionNuevo;
    private List<Producto> productosUsuario;

    public Editar() throws ParseException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(157, 226, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Editar Producto");
        lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
        lblNewLabel.setBounds(146, 10, 164, 36);
        contentPane.add(lblNewLabel);

        JLabel lblCodigo = new JLabel("Seleccione el producto a editar:");
        lblCodigo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCodigo.setBounds(34, 46, 250, 20);
        contentPane.add(lblCodigo);

        productosComboBox = new JComboBox<>();
        productosComboBox.setBounds(34, 70, 360, 25);
        contentPane.add(productosComboBox);

        if (SesionIniciada.getUsuarioActual() == null) {
        	
            JOptionPane.showMessageDialog(null, "No hay usuario en sesión.", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        String usuarioActual = SesionIniciada.getUsuarioActual().getNombre();
        productosUsuario = Producto.obtenerProductosPorUsuario(usuarioActual);

        if (productosUsuario == null || productosUsuario.isEmpty()) {
        	Icon imagen = new ImageIcon(getClass().getResource("/Imagenes/gatitoo.png"));
        	JOptionPane.showMessageDialog(contentPane, "No tienes productos para editar", "Éxito", JOptionPane.PLAIN_MESSAGE,imagen);
            dispose();
            return;
        }

        for (Producto producto : productosUsuario) {
            productosComboBox.addItem(producto.getNombreprod() + " - " + producto.getCodigo());
        }

        productosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosProductoSeleccionado();
            }
        });
        JLabel lblCodigoNuevo = new JLabel("Nuevo Código:");
        lblCodigoNuevo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCodigoNuevo.setBounds(34, 100, 150, 20);
        contentPane.add(lblCodigoNuevo);

        textFieldCodigoNuevo = new JTextField();
        textFieldCodigoNuevo.setBounds(180, 100, 214, 19);
        contentPane.add(textFieldCodigoNuevo);

        JLabel lblNombreNuevo = new JLabel("Nuevo Nombre:");
        lblNombreNuevo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblNombreNuevo.setBounds(34, 130, 150, 20);
        contentPane.add(lblNombreNuevo);

        textFieldNombreNuevo = new JTextField();
        textFieldNombreNuevo.setBounds(180, 130, 214, 19);
        contentPane.add(textFieldNombreNuevo);

        JLabel lblPrecioNuevo = new JLabel("Nuevo Precio:");
        lblPrecioNuevo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblPrecioNuevo.setBounds(34, 160, 150, 20);
        contentPane.add(lblPrecioNuevo);

        textFieldPrecioNuevo = new JTextField();
        textFieldPrecioNuevo.setBounds(180, 160, 214, 19);
        contentPane.add(textFieldPrecioNuevo);

        JLabel lblCantidadNuevo = new JLabel("Nueva Cantidad:");
        lblCantidadNuevo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCantidadNuevo.setBounds(34, 190, 150, 20);
        contentPane.add(lblCantidadNuevo);

        textFieldCantidadNuevo = new JTextField();
        textFieldCantidadNuevo.setBounds(180, 190, 214, 19);
        contentPane.add(textFieldCantidadNuevo);

        JLabel lblDescripcionNuevo = new JLabel("Nueva Descripción:");
        lblDescripcionNuevo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblDescripcionNuevo.setBounds(34, 220, 150, 20);
        contentPane.add(lblDescripcionNuevo);

        textFieldDescripcionNuevo = new JTextField();
        textFieldDescripcionNuevo.setBounds(180, 220, 214, 19);
        contentPane.add(textFieldDescripcionNuevo);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                VendedorGUI vendedorwindow = new VendedorGUI();
                vendedorwindow.setVisible(true);
            }
        });
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegresar.setBounds(80, 260, 102, 27);
        contentPane.add(btnRegresar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnEditar.setBounds(265, 260, 93, 27);
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String itemSeleccionado = (String) productosComboBox.getSelectedItem();
                    if (itemSeleccionado == null) {
                    	Icon imagen1 = new ImageIcon(getClass().getResource("/Imagenes/gatocaja2.png"));
                    	JOptionPane.showMessageDialog(contentPane, "Seleccione el producto a editar", "Éxito", JOptionPane.PLAIN_MESSAGE,imagen1);
                        return;
                    }

                    int codigo = Integer.parseInt(itemSeleccionado.split(" - ")[1]);
                    String nuevoNombre = textFieldNombreNuevo.getText();
                    double nuevoPrecio = Double.parseDouble(textFieldPrecioNuevo.getText().replace(",", ".")); // 🔹 Convertir si hay coma
                    int nuevaCantidad = Integer.parseInt(textFieldCantidadNuevo.getText());
                    String nuevaDescripcion = textFieldDescripcionNuevo.getText();

                    boolean actualizado = Producto.editarProducto(codigo, nuevoNombre, nuevoPrecio, nuevaCantidad, nuevaDescripcion);

                    if (actualizado) {
                    	Icon imagen2 = new ImageIcon(getClass().getResource("/Imagenes/gatipower2.png"));
                    	JOptionPane.showMessageDialog(contentPane, "Producto actualizado exitosamente", "Éxito", JOptionPane.PLAIN_MESSAGE,imagen2);
                    } else {
                    	Icon imagen3 = new ImageIcon(getClass().getResource("/Imagenes/gatriste.png"));
                    	JOptionPane.showMessageDialog(contentPane, "Producto actualizado exitosamente", "Éxito", JOptionPane.PLAIN_MESSAGE,imagen3);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        contentPane.add(btnEditar);
        setVisible(true);
    }
    private void cargarDatosProductoSeleccionado() {
        int selectedIndex = productosComboBox.getSelectedIndex();
        if (selectedIndex != -1) {
            Producto productoSeleccionado = productosUsuario.get(selectedIndex);
            textFieldCodigoNuevo.setText(String.valueOf(productoSeleccionado.getCodigo()));
            textFieldNombreNuevo.setText(productoSeleccionado.getNombreprod());
            textFieldPrecioNuevo.setText(String.format(Locale.US, "%.2f", productoSeleccionado.getPrecioprod())); // 🔹 Formato corregido
            textFieldCantidadNuevo.setText(String.valueOf(productoSeleccionado.getCantprod()));
            textFieldDescripcionNuevo.setText(productoSeleccionado.getDescripcionprod());
        }
    }
}
