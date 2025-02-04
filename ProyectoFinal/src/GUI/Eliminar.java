package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Eliminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Indica el código del producto a eliminar: ");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_1.setBounds(76, 89, 291, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Eliminar Producto ");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		lblNewLabel.setBounds(135, 32, 164, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(162, 115, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnEliminar.setBounds(262, 185, 105, 31);
		contentPane.add(btnEliminar);
		
		JButton btnRegresar = new JButton("Regresar\r\n");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VendedorGUI vendedorwindow = new VendedorGUI();
				vendedorwindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(58, 185, 105, 31);
		contentPane.add(btnRegresar);
	}
}
