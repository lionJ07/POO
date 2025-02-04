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
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Creación de la ventana de Mostrar para evidenciar las ventas realizadas 
 */
public class Mostrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Mostrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balance Total:");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblNewLabel.setBounds(148, 10, 147, 26);
		contentPane.add(lblNewLabel);
		/**
		 * Botón que permite ver el balance de las ventas realizadas 
		 */
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnMostrar.setBounds(158, 36, 111, 26);
		contentPane.add(btnMostrar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 72, 353, 133);
		contentPane.add(textArea);
		/**
		 * Botón que regresa a la ventana de vendedor y su menú de opciones
		 */
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose ();
				VendedorGUI vendedorwindow = new VendedorGUI ();
				vendedorwindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(280, 221, 111, 21);
		contentPane.add(btnRegresar);
	}
}
