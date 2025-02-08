package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.Usuario;
import Logica.CarritoCompras;
public class Historial extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final Usuario Usuario = null;
	protected static final CarritoCompras CarritoCompras = null;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Historial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(157, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Historial de compras");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		lblNewLabel.setBounds(117, 22, 205, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Mostrar");
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnNewButton.setBounds(158, 56, 104, 22);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(66, 88, 298, 132);
		contentPane.add(textArea);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CompradorGUI compradorwindow = new CompradorGUI(CarritoCompras, Usuario);
				compradorwindow.setVisible(true);
				
			}
		});
		btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 10));
		btnRegresar.setBounds(315, 230, 85, 21);
		contentPane.add(btnRegresar);
	}
}
