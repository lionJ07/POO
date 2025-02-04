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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Ventana de Carrito 
 */
public class Carrito extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Carrito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Carrito de Compras:");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel.setBounds(140, 20, 157, 28);
		contentPane.add(lblNewLabel);
		/**
		 * Botón para mostrar el listado de las compras realizadas 
		 */
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnMostrar.setBounds(166, 47, 100, 28);
		contentPane.add(btnMostrar);
		/**
		 * Botón para regresar a la ventana de comprador
		 */
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CompradorGUI compradorwindow = new CompradorGUI();
				compradorwindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(166, 221, 100, 32);
		contentPane.add(btnRegresar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 85, 319, 126);
		contentPane.add(scrollPane);
	}
}
