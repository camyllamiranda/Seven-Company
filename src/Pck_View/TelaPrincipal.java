
package Pck_View;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipalView extends JFrame {

    public TelaPrincipalView() {

        setTitle("Seven Company");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6, 1, 10, 10));

        JLabel titulo = new JLabel("SEVEN COMPANY", SwingConstants.CENTER);

        JButton btnPecas = new JButton("Peças");
        JButton btnCompras = new JButton("Compras");
        JButton btnVendas = new JButton("Vendas");
        JButton btnLucros = new JButton("Lucros");
        JButton btnSair = new JButton("Sair");
        btnPecas.addActionListener(e -> {
            PecaView tela = new PecaView();
            tela.setVisible(true);
        });
        btnCompras.addActionListener(e -> {
            CompraView tela = new CompraView();
            tela.setVisible(true);
        });
        btnVendas.addActionListener(e -> {
            VendaView tela = new VendaView();
            tela.setVisible(true);
        });
        btnLucros.addActionListener(e -> {
            LucroView tela = new LucroView();
            tela.setVisible(true);
        });

        painel.add(titulo);
        painel.add(btnPecas);
        painel.add(btnCompras);
        painel.add(btnVendas);
        painel.add(btnLucros);
        painel.add(btnSair);

        add(painel);

        btnSair.addActionListener(e -> dispose());
    }
}
