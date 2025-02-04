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
<<<<<<< HEAD
import javax.swing.JTextPane;
/**
 * Ventana para agregar un nuevo producto
 */
=======

import Logica.Producto;
import Logica.SesionIniciada;
import Logica.Vendedor;

>>>>>>> branch 'main' of https://github.com/lionJ07/POO.git
public class Agregar extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCodigo;
    private JTextField textFieldNombreProducto;
    private JTextField textFieldPrecio;
    private JTextField textFieldCantidad;

    public Agregar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(157, 226, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

<<<<<<< HEAD
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
		
		JLabel lblNewLabel_2 = new JLabel("Nombre del Producto:");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_2.setBounds(26, 61, 163, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio del Producto:");
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_3.setBounds(26, 90, 147, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad del Producto:");
		lblNewLabel_4.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_4.setBounds(26, 119, 173, 23);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripción:");
		lblNewLabel_5.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_5.setBounds(26, 152, 109, 29);
		contentPane.add(lblNewLabel_5);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(180, 32, 234, 19);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldNombreProducto = new JTextField();
		textFieldNombreProducto.setBounds(190, 61, 224, 19);
		contentPane.add(textFieldNombreProducto);
		textFieldNombreProducto.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(178, 90, 236, 19);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(198, 119, 216, 19);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		/**
		 * Botón para regresar a la ventana de vendedor con el respectivo menu de opciones 
		 */
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose ();
				Vendedor vendedorwindow= new Vendedor();
				vendedorwindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(89, 203, 85, 41);
		contentPane.add(btnRegresar);
		/**
		 * Botón para editar el producto con exito 
		 */
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnAgregar.setBounds(253, 203, 103, 41);
		contentPane.add(btnAgregar);
		
		JTextPane textPaneDescripcipn = new JTextPane();
		textPaneDescripcipn.setBounds(118, 152, 296, 41);
		contentPane.add(textPaneDescripcipn);
	}
=======
        JLabel lblTitulo = new JLabel("Agregar Producto:");
        lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
        lblTitulo.setBounds(129, 10, 200, 23);
        contentPane.add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código del Producto:");
        lblCodigo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCodigo.setBounds(26, 32, 160, 23);
        contentPane.add(lblCodigo);

        JLabel lblNombre = new JLabel("Nombre del Producto:");
        lblNombre.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblNombre.setBounds(26, 61, 170, 23);
        contentPane.add(lblNombre);

        JLabel lblPrecio = new JLabel("Precio del Producto:");
        lblPrecio.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblPrecio.setBounds(26, 90, 160, 23);
        contentPane.add(lblPrecio);

        JLabel lblCantidad = new JLabel("Cantidad del Producto:");
        lblCantidad.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblCantidad.setBounds(26, 119, 170, 23);
        contentPane.add(lblCantidad);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        lblDescripcion.setBounds(26, 152, 120, 29);
        contentPane.add(lblDescripcion);

        textFieldCodigo = new JTextField();
        textFieldCodigo.setBounds(180, 32, 234, 19);
        contentPane.add(textFieldCodigo);

        textFieldNombreProducto = new JTextField();
        textFieldNombreProducto.setBounds(190, 61, 224, 19);
        contentPane.add(textFieldNombreProducto);

        textFieldPrecio = new JTextField();
        textFieldPrecio.setBounds(178, 90, 236, 19);
        contentPane.add(textFieldPrecio);

        textFieldCantidad = new JTextField();
        textFieldCantidad.setBounds(198, 119, 216, 19);
        contentPane.add(textFieldCantidad);

        JTextPane textPaneDescripcion = new JTextPane();
        textPaneDescripcion.setBounds(118, 152, 296, 41);
        contentPane.add(textPaneDescripcion);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> {
            dispose();
            VendedorGUI menuVendedor = new VendedorGUI();
            menuVendedor.setVisible(true);
        });
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnRegresar.setBounds(89, 203, 85, 41);
        contentPane.add(btnRegresar);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> {
            try {
                String codigoTexto = textFieldCodigo.getText().trim();
                String producto = textFieldNombreProducto.getText().trim();
                String precioTexto = textFieldPrecio.getText().trim();
                String cantidadTexto = textFieldCantidad.getText().trim();
                String descripcion = textPaneDescripcion.getText().trim();

                if (codigoTexto.isEmpty() || producto.isEmpty() || precioTexto.isEmpty() || cantidadTexto.isEmpty() || descripcion.isEmpty()) {
                    throw new Exception("Todos los campos deben estar llenos");
                }

                if (descripcion.length() < 6) {
                    throw new Exception("La descripción debe tener al menos 6 caracteres.");
                }

                int codigo = Integer.parseInt(codigoTexto);
                double precio = Double.parseDouble(precioTexto);
                int cantidad = Integer.parseInt(cantidadTexto);

                Producto prod = new Producto(codigo, producto, precio, cantidad, descripcion);

                if (!SesionIniciada.esVendedor()) {
                    throw new Exception("Error: No hay un vendedor en sesión.");
                }

                Vendedor vendedor = (Vendedor) SesionIniciada.getUsuarioActual();
                vendedor.agregarProducto(prod);

                JOptionPane.showMessageDialog(contentPane, "¡Registro del producto exitoso!");

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
>>>>>>> branch 'main' of https://github.com/lionJ07/POO.git
}
