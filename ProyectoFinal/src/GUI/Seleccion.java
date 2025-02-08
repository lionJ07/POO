/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.CarritoCompras;
import Logica.SesionIniciada;
import Logica.Usuario;
import Logica.Vendedor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Esta ventana permite al usuario seleccionar el rol que desea ser
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
		 * Este botón dirige al usuario a la ventana de vendedor
		 */
		JButton btnVendedor = new JButton("Vendedor");
		btnVendedor.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Usuario usuario = SesionIniciada.getUsuarioActual();
		        if (!(usuario instanceof Vendedor)) {
		        	usuario = new Vendedor(usuario.getNombre(), usuario.getUsuario(), usuario.getCorreo(), usuario.getContraseña());
		            SesionIniciada.setUsuarioActual(usuario);
		        }
		        dispose();
		        VendedorGUI vendedorwindow = new VendedorGUI();
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
		        Usuario usuario = SesionIniciada.getUsuarioActual(); // Obtener usuario actual
		        CompradorGUI compradorwindow = new CompradorGUI(new CarritoCompras(), usuario); // Pasar usuario
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
