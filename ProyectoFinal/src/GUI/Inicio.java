package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(198, 25, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro registrowindow = new Registro();
				registrowindow.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(158, 72, 115, 41);
		contentPane.add(btnRegistro);
		
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
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(158, 170, 115, 39);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(198, 37, 45, 13);
		contentPane.add(lblNewLabel_1);
	}
}
