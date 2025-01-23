package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldCodigoNuevo;
	private JTextField textFieldNombreNuevo;
	private JTextField textFieldPrecioNuevo;
	private JTextField textFieldCantidadNuevo;
	private JTextField textFieldDescripcionNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editar frame = new Editar();
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
	public Editar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Producto");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblNewLabel.setBounds(146, 10, 164, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Código del producto a editar: ");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_1.setBounds(34, 46, 217, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Indique el código nuevo:");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_2.setBounds(34, 76, 197, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre del nuevo producto: ");
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_3.setBounds(34, 106, 208, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio del nuevo producto:");
		lblNewLabel_4.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_4.setBounds(34, 136, 197, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad del nuevo producto:");
		lblNewLabel_5.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_5.setBounds(34, 166, 217, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Descripción del nuevo producto:");
		lblNewLabel_6.setFont(new Font("Sitka Subheading", Font.BOLD, 15) );
		lblNewLabel_6.setBounds(34, 196, 239, 20);
		contentPane.add(lblNewLabel_6);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vendedor vendedorwindow = new Vendedor();
				vendedorwindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(80, 226, 102, 27);
		contentPane.add(btnRegresar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnEditar.setBounds(265, 226, 93, 27);
		contentPane.add(btnEditar);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(245, 45, 164, 19);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldCodigoNuevo = new JTextField();
		textFieldCodigoNuevo.setBounds(214, 76, 195, 19);
		contentPane.add(textFieldCodigoNuevo);
		textFieldCodigoNuevo.setColumns(10);
		
		textFieldNombreNuevo = new JTextField();
		textFieldNombreNuevo.setBounds(238, 105, 171, 19);
		contentPane.add(textFieldNombreNuevo);
		textFieldNombreNuevo.setColumns(10);
		
		textFieldPrecioNuevo = new JTextField();
		textFieldPrecioNuevo.setBounds(230, 135, 179, 19);
		contentPane.add(textFieldPrecioNuevo);
		textFieldPrecioNuevo.setColumns(10);
		
		textFieldCantidadNuevo = new JTextField();
		textFieldCantidadNuevo.setBounds(245, 165, 164, 19);
		contentPane.add(textFieldCantidadNuevo);
		textFieldCantidadNuevo.setColumns(10);
		
		textFieldDescripcionNuevo = new JTextField();
		textFieldDescripcionNuevo.setBounds(272, 195, 137, 19);
		contentPane.add(textFieldDescripcionNuevo);
		textFieldDescripcionNuevo.setColumns(10);
	}
}
