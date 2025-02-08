/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * Ventana del vendedor
 */
public class VendedorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 */
	public VendedorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Botón para Agregar un nuevo producto 
		 */
		JButton btnAgregar = new JButton("Agregar Producto");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Agregar agregarwindow = new Agregar();
				agregarwindow.setVisible(true);
			}
		});
		btnAgregar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnAgregar.setBounds(145, 60, 175, 29);
		contentPane.add(btnAgregar);
		/**
		 * Botón para editar el producto 
		 */
		JButton btnEditar = new JButton("Editar Producto");
		btnEditar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Editar editarwindow;
				try {
					editarwindow = new Editar();
					editarwindow.setVisible(true);

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnEditar.setBounds(145, 99, 175, 29);
		contentPane.add(btnEditar);
		/**
		 * Botón para eliminar el producto seleccionado
		 */
		JButton btnEliminar = new JButton("Eliminar Producto");
		btnEliminar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Eliminar eliminarwindow;
				try {
					eliminarwindow = new Eliminar();
					eliminarwindow.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setBounds(145, 138, 175, 29);
		contentPane.add(btnEliminar);
		/**
		 * Botón para ver el balance de los productos 
		 */
		JButton btnBalance = new JButton("Ver Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Mostrar mostrarwindow = new Mostrar();
				mostrarwindow.setVisible(true);
			}
		});
		btnBalance.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnBalance.setBounds(167, 177, 128, 29);
		contentPane.add(btnBalance);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Seleccion seleccionwindow= new Seleccion();
				seleccionwindow.setVisible(true);
			}
		});
		
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(26, 203, 106, 34);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel = new JLabel("¿Que deseas realizar?");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel.setBounds(145, 26, 175, 24);
		contentPane.add(lblNewLabel);
	}
}
