package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Comprar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public Comprar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Comprar productos ");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel.setBounds(145, 10, 167, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Método de pago:");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_1.setBounds(157, 143, 118, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnFinalizarCompra = new JButton("Finalizar compra ");
		btnFinalizarCompra.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnFinalizarCompra.setBounds(236, 208, 159, 22);
		contentPane.add(btnFinalizarCompra);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CompradorGUI compradorwindow = new CompradorGUI();
				compradorwindow.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnRegresar.setBounds(69, 208, 118, 23);
		contentPane.add(btnRegresar);
		
		JRadioButton rdbtnEfectivo = new JRadioButton("Efectivo");
		rdbtnEfectivo.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		rdbtnEfectivo.setBounds(84, 169, 103, 21);
		contentPane.add(rdbtnEfectivo);
		
		JRadioButton rdbtnTarjeta = new JRadioButton("Tarjeta ");
		rdbtnTarjeta.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		rdbtnTarjeta.setBounds(236, 169, 103, 21);
		contentPane.add(rdbtnTarjeta);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione el producto a comprar: ");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_2.setBounds(102, 42, 246, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad:");
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		lblNewLabel_3.setBounds(176, 93, 79, 22);
		contentPane.add(lblNewLabel_3);
	}
}
