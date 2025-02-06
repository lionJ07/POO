package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

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
		
		JButton btnEditar = new JButton("Editar Producto");
		btnEditar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Editar editarwindow = new Editar();
				editarwindow.setVisible(true);
			}
		});
		btnEditar.setBounds(145, 99, 175, 29);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar Producto");
		btnEliminar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Eliminar eliminarwindow = new Eliminar();
				eliminarwindow.setVisible(true);
			}
		});
		btnEliminar.setBounds(145, 138, 175, 29);
		contentPane.add(btnEliminar);
		
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
