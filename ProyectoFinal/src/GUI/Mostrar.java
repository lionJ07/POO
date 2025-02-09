package GUI;
import javax.swing.*;

import Logica.Producto;
import Logica.Vendedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Mostrar extends JFrame {
    private JTextArea textArea;
    private JLabel lblTotalVentas, lblTotalProductos;
    private Vendedor vendedor;

    public Mostrar(Vendedor vendedor) {
        this.vendedor = vendedor;
        setTitle("Balance de Ventas");
        setSize(500, 420); // Ajuste de altura para acomodar todo
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(157, 226, 230));

        // Título en la parte superior
        JLabel lblTitulo = new JLabel("Ver Balance", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
        panel.add(lblTitulo, BorderLayout.NORTH);

        // Panel para centrar el JTextArea
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new FlowLayout());
        panelTexto.setOpaque(false);

        textArea = new JTextArea(10, 28);
        textArea.setEditable(false);
        textArea.setBackground(Color.WHITE);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        textArea.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(380, 180));
        panelTexto.add(scrollPane);

        panel.add(panelTexto, BorderLayout.CENTER);

        // Panel de totales
        JPanel panelTotales = new JPanel(new GridLayout(2, 1));
        panelTotales.setOpaque(false);

        lblTotalVentas = new JLabel("Total vendido: $0.0", SwingConstants.CENTER);
        lblTotalVentas.setFont(new Font("Sitka Subheading", Font.BOLD, 14));

        lblTotalProductos = new JLabel("Total productos vendidos: 0", SwingConstants.CENTER);
        lblTotalProductos.setFont(new Font("Sitka Subheading", Font.BOLD, 14));

        panelTotales.add(lblTotalVentas);
        panelTotales.add(lblTotalProductos);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setOpaque(false);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarBalanceVentas();
            }
        });

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendedorGUI vendedorGUI = new VendedorGUI();
                vendedorGUI.setVisible(true);
                dispose();
            }
        });

        panelBotones.add(btnActualizar);
        panelBotones.add(btnRegresar);

        // Nuevo panel para agrupar los totales y los botones
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setOpaque(false);
        panelInferior.add(panelTotales, BorderLayout.NORTH);
        panelInferior.add(panelBotones, BorderLayout.SOUTH);

        // Agregar este nuevo panel al BorderLayout.SOUTH
        panel.add(panelInferior, BorderLayout.SOUTH);

        add(panel);
        mostrarBalanceVentas();
    }

    private void mostrarBalanceVentas() {
        List<Producto> ventas = vendedor.obtenerVentas();

        if (ventas.isEmpty()) {
            textArea.setText("No hay ventas registradas.");
            lblTotalVentas.setText("Total vendido: $0.0");
            lblTotalProductos.setText("Total productos vendidos: 0");
            return;
        }

        double totalVendido = 0;
        int totalProductos = 0;
        StringBuilder contenido = new StringBuilder();

        for (Producto p : ventas) {
            contenido.append("Código: ").append(p.getCodigo())
                     .append(" | ").append(p.getNombreprod())
                     .append(" | Precio: $").append(p.getPrecioprod())
                     .append(" | Cantidad: ").append(p.getCantprod())
                     .append("\n");
            totalVendido += p.getPrecioprod() * p.getCantprod();
            totalProductos += p.getCantprod();
        }

        textArea.setText(contenido.toString());
        lblTotalVentas.setText("Total vendido: $" + totalVendido);
        lblTotalProductos.setText("Total productos vendidos: " + totalProductos);
    }
}
