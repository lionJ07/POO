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
 * Estaventana es la que permite al usuario seleccionar el rol que desea ser
 */
public class Seleccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Seleccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione una opción");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblNewLabel.setBounds(125, 22, 210, 36);
		contentPane.add(lblNewLabel);
		/**
		 * Este boton dirige al usuario a la ventana de vendedor
		 */
		JButton btnVendedor = new JButton("Vendedor");
		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vendedor vendedorwindow = new Vendedor();
				vendedorwindow.setVisible(true);
			}
		});
		btnVendedor.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnVendedor.setBounds(159, 80, 127, 36);
		contentPane.add(btnVendedor);
		/**
		 * Este botón lo dirige a la ventana de comprador 
		 */
		JButton btnComprador = new JButton("Comprador");
		btnComprador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Comprador compradorwindow = new Comprador();
				compradorwindow.setVisible(true);
			}
		});
		btnComprador.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnComprador.setBounds(159, 136, 127, 36);
		contentPane.add(btnComprador);
		/**
		 * Botón para regresar a la ventana de inicio 
		 */
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio iniciowindow = new Inicio();
				iniciowindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(159, 195, 127, 36);
		contentPane.add(btnRegresar);
	}

}
