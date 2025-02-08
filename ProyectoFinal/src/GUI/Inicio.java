/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
/**
 * Ventana de Inicio 
 */
public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * Botón que manda a los usuarios a la ventana de registro
		 */
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro registrowindow = new Registro();
				registrowindow.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(140, 72, 150, 41);
		contentPane.add(btnRegistro);
		/**
		 * Botón para que los usuarios ya registrados solo inicien sesión 
		 */
		JButton btnInicioSesion = new JButton("Iniciar Sesión");
		btnInicioSesion.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarSesion iniciarwindow = new IniciarSesion();
				iniciarwindow.setVisible(true);
				dispose();
			}
		});
		btnInicioSesion.setBounds(140, 123, 150, 37);
		contentPane.add(btnInicioSesion);
		
		/**
		 * Botón para salir del programa
		 */
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(140, 170, 150, 39);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("GATICOMMERCE");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		lblNewLabel_1.setBounds(124, 24, 201, 38);
		contentPane.add(lblNewLabel_1);
		/**
		 * Objetos que permiten el uso de las imagenes y la visualización de las mismas 
		 */
		ImageIcon stickerIcon = new ImageIcon(getClass().getResource("/Imagenes/sticker.png"));
		JLabel stickerLabel = new JLabel(stickerIcon);
		stickerLabel.setBounds(306, 153, 120, 110);
		contentPane.add(stickerLabel);
		
		ImageIcon sticker = new ImageIcon(getClass().getResource("/Imagenes/gatocaja2.png"));
		JLabel StickerLabel = new JLabel(sticker);
		StickerLabel.setBounds(0, 25, 92, 88);
		contentPane.add(StickerLabel);
		
		ImageIcon sticker2 = new ImageIcon(getClass().getResource("/Imagenes/patitas.png"));
		JLabel Sticker2Label = new JLabel(sticker2);
		Sticker2Label.setBounds(30, 195, 45, 35);
		contentPane.add(Sticker2Label);
		
		JLabel Sticker2Label_1 = new JLabel(new ImageIcon(Inicio.class.getResource("/Imagenes/patitas.png")));
		Sticker2Label_1.setBounds(318, 82, 45, 35);
		contentPane.add(Sticker2Label_1);
		
		JLabel Sticker2Label_2 = new JLabel(new ImageIcon(Inicio.class.getResource("/Imagenes/patitas.png")));
		Sticker2Label_2.setBounds(218, 228, 45, 35);
		contentPane.add(Sticker2Label_2);
		
		JLabel Sticker2Label_3 = new JLabel(new ImageIcon(Inicio.class.getResource("/Imagenes/patitas.png")));
		Sticker2Label_3.setBounds(85, 82, 45, 35);
		contentPane.add(Sticker2Label_3);
		
		JLabel Sticker2Label_4 = new JLabel(new ImageIcon(Inicio.class.getResource("/Imagenes/patitas.png")));
		Sticker2Label_4.setBounds(381, 0, 45, 35);
		contentPane.add(Sticker2Label_4);
		
		JLabel Sticker2Label_5 = new JLabel(new ImageIcon(Inicio.class.getResource("/Imagenes/patitas.png")));
		Sticker2Label_5.setBounds(30, 0, 45, 35);
		contentPane.add(Sticker2Label_5);
		
		JLabel Sticker2Label_6 = new JLabel(new ImageIcon(Inicio.class.getResource("/Imagenes/patitas.png")));
		Sticker2Label_6.setBounds(198, -15, 45, 35);
		contentPane.add(Sticker2Label_6);
	}
}
