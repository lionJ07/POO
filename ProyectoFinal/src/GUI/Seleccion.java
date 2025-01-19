package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Seleccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccion frame = new Seleccion();
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
	public Seleccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione un rol");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblNewLabel.setBounds(137, 21, 182, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnVendedor = new JButton("Vendedor");
		btnVendedor.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnVendedor.setBounds(159, 80, 127, 36);
		contentPane.add(btnVendedor);
		
		JButton btnComprador = new JButton("Comprador ");
		btnComprador.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnComprador.setBounds(159, 149, 127, 36);
		contentPane.add(btnComprador);
	}

}
