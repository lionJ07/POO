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

public class Vendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendedor frame = new Vendedor();
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
	public Vendedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Agregar Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Agregar agregarwindow = new Agregar();
				agregarwindow.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnNewButton.setBounds(145, 60, 175, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar Producto");
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(145, 99, 175, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar Producto");
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(145, 138, 175, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ver Balance");
		btnNewButton_3.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnNewButton_3.setBounds(167, 177, 128, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Regresar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Seleccion seleccionwindow= new Seleccion();
				seleccionwindow.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnNewButton_4.setBounds(26, 203, 106, 34);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("¿Que deseas realizar?");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel.setBounds(145, 26, 175, 24);
		contentPane.add(lblNewLabel);
	}

}
