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
import javax.swing.JTextPane;

public class Agregar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombreProducto;
	private JTextField textFieldPrecio;
	private JTextField textFieldCantidad;
	/**
	 * Create the frame.
	 */
	public Agregar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnAgregar.setBounds(253, 203, 103, 41);
		contentPane.add(btnAgregar);
		
		JTextPane textPaneDescripcipn = new JTextPane();
		textPaneDescripcipn.setBounds(118, 152, 296, 41);
		contentPane.add(textPaneDescripcipn);
	}
}
