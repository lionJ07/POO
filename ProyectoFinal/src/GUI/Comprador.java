/**
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 */
package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Ventana de Comprador
 */
public class Comprador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public Comprador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * Botones del menú de la ventana de comprador
		 */
		JLabel lblNewLabel = new JLabel("¿ Que deseas realizar?");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel.setBounds(133, 22, 193, 22);
		contentPane.add(lblNewLabel);
		/**
		 * Botón para abrir la ventana de carrito de compras 
		 */
		JButton btnCarrito = new JButton("Carrito de compras");
		btnCarrito.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose ();
				Carrito carritowindow = new Carrito();
				carritowindow.setVisible(true);
			}
		});
		btnCarrito.setBounds(122, 116, 186, 29);
		contentPane.add(btnCarrito);
		/**
		 * Botón para comprar los productos disponibles e deir los productos que se han agregado 
		 */
		JButton btnProductoDisponibles = new JButton("Comprar productos disponibles\r\n");
		btnProductoDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Comprar comprarwindow = new Comprar();
				comprarwindow.setVisible(true);
				}
		});
		btnProductoDisponibles.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnProductoDisponibles.setBounds(78, 65, 266, 29);
		contentPane.add(btnProductoDisponibles);
		/**
		 * Botón para regresar a la ventana de seleccion de roles 
		 */
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Seleccion seleccionwindow = new Seleccion();
				seleccionwindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(159, 167, 117, 29);
		contentPane.add(btnRegresar);
	}

}
