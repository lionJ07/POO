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
import Logica.Comprador;
import Logica.SesionIniciada;

public class Historial extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;
    private Comprador compradorActual;
    private CarritoCompras carrito; 

    public Historial(Usuario usuario, CarritoCompras carrito) {
        if (!(usuario instanceof Comprador)) {
            System.out.println("Error: Solo los compradores pueden acceder al historial.");
            dispose();
            return;
        }

        this.compradorActual = (Comprador) usuario; 
        this.carrito = carrito;

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
        
        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
        btnMostrar.setBounds(158, 56, 104, 22);
        contentPane.add(btnMostrar);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(10, 88, 414, 132);
        contentPane.add(textArea);
        
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CompradorGUI compradorwindow = new CompradorGUI(carrito, compradorActual);
                compradorwindow.setVisible(true);
            }
        });

        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 10));
        btnRegresar.setBounds(315, 230, 85, 21);
        contentPane.add(btnRegresar);

        // Acción del botón "Mostrar"
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(compradorActual.cargarHistorial());
            }
        });
    }
}
