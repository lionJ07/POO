package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.SesionIniciada;
import Logica.Usuario;
import Logica.Vendedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Seleccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		
		JLabel lblNewLabel = new JLabel("Seleccione una opción");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblNewLabel.setBounds(125, 22, 210, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnVendedor = new JButton("Vendedor");
		btnVendedor.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Usuario usuario = SesionIniciada.getUsuarioActual();

		        if (usuario instanceof Vendedor) {
		            dispose();
		            VendedorGUI vendedorwindow = new VendedorGUI();
		            vendedorwindow.setVisible(true);
		        } else {
		            JOptionPane.showMessageDialog(null, "No hay un vendedor iniciado. Inicie sesión como vendedor.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		btnVendedor.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnVendedor.setBounds(159, 80, 127, 36);
		contentPane.add(btnVendedor);
		
		JButton btnComprador = new JButton("Comprador");
		btnComprador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CompradorGUI compradorwindow = new CompradorGUI();
				compradorwindow.setVisible(true);
			}
		});
		btnComprador.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnComprador.setBounds(159, 136, 127, 36);
		contentPane.add(btnComprador);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio iniciowindow = new Inicio();
				iniciowindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(159, 195, 127, 36);
		contentPane.add(btnRegresar);
	}

}
