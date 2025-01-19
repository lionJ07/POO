package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblNewLabel.setBounds(180, 10, 91, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_1.setBounds(83, 52, 69, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Correo:");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_2.setBounds(83, 84, 60, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario:");
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_3.setBounds(83, 118, 69, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contraseña");
		lblNewLabel_4.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_4.setBounds(83, 151, 81, 26);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(155, 54, 193, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 88, 195, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 122, 193, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 153, 168, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JRadioButton rdbtnVendedor = new JRadioButton("Vendedor");
		rdbtnVendedor.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		rdbtnVendedor.setBounds(82, 183, 114, 19);
		contentPane.add(rdbtnVendedor);
		
		JRadioButton rdbtnComprador = new JRadioButton("Comprador");
		rdbtnComprador.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		rdbtnComprador.setBounds(234, 182, 114, 21);
		contentPane.add(rdbtnComprador);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAventanaPrincipal();
			}
			private void volverAventanaPrincipal() {
				dispose();
				Inicio iniciowindow = new Inicio ();
				iniciowindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(83, 216, 113, 19);
		contentPane.add(btnRegresar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarse.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegistrarse.setBounds(226, 216, 122, 19);
		contentPane.add(btnRegistrarse);
	}
}
