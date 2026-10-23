package Pck_View;

import Pck_Control.PecaControl;
import Pck_Model.PecaModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class PecaView extends JFrame {

    private final PecaControl control = new PecaControl();

    private final JTextField txtIdPeca = new JTextField(10);
    private final JTextField txtIdEnvio = new JTextField(10);
    private final JTextField txtNome = new JTextField(20);
    private final JTextField txtMarca = new JTextField(20);
    private final JTextField txtCategoria = new JTextField(20);
    private final JTextField txtModelo = new JTextField(20);
    private final JTextField txtCor = new JTextField(20);
    private final JTextField txtTamanho = new JTextField(10);
    private final JTextField txtCondicao = new JTextField(20);
    private final JTextField txtPeso = new JTextField(10);
    private final JTextField txtMargem = new JTextField(10);
    private final JTextField txtPrecoVenda = new JTextField(10);

    private final JComboBox<String> cbSituacao = new JComboBox<>(
            new String[]{
                    "COMPRADA", "ARMAZEM", "EM_TRANSITO",
                    "DISPONIVEL", "RESERVADA", "VENDIDA"
            }
    );

    private final JButton btnInserir = new JButton("Inserir");
    private final JButton btnConsultar = new JButton("Consultar");
    private final JButton btnAlterar = new JButton("Alterar");
    private final JButton btnRemover = new JButton("Remover");

    private final DefaultTableModel modeloTabela = new DefaultTableModel(
            new Object[]{
                    "Código", "Envio", "Nome", "Marca", "Categoria",
                    "Modelo", "Cor", "Tamanho", "Condição", "Peso (g)",
                    "Margem (%)", "Preço de venda", "Situação"
            }, 0
    ) {
        @Override
        public boolean isCellEditable(int linha, int coluna) {
            return false;
        }
    };

    private final JTable tabela = new JTable(modeloTabela);
    private final JLabel lblTotal = new JLabel("Total armazenado: 0");

    public PecaView() {
        setTitle("Seven Company - Cadastro de Peças");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        txtIdPeca.setEditable(false);

        JPanel painelCampos = new JPanel(new GridLayout(7, 4, 8, 8));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelCampos.add(new JLabel("Código:"));
        painelCampos.add(txtIdPeca);
        painelCampos.add(new JLabel("Envio (opcional):"));
        painelCampos.add(txtIdEnvio);
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(txtNome);
        painelCampos.add(new JLabel("Marca:"));
        painelCampos.add(txtMarca);
        painelCampos.add(new JLabel("Categoria:"));
        painelCampos.add(txtCategoria);
        painelCampos.add(new JLabel("Modelo (opcional):"));
        painelCampos.add(txtModelo);
        painelCampos.add(new JLabel("Cor:"));
        painelCampos.add(txtCor);
        painelCampos.add(new JLabel("Tamanho:"));
        painelCampos.add(txtTamanho);
        painelCampos.add(new JLabel("Condição:"));
        painelCampos.add(txtCondicao);
        painelCampos.add(new JLabel("Peso em gramas (opcional):"));
        painelCampos.add(txtPeso);
        painelCampos.add(new JLabel("Margem em % (opcional):"));
        painelCampos.add(txtMargem);
        painelCampos.add(new JLabel("Preço de venda (opcional):"));
        painelCampos.add(txtPrecoVenda);
        painelCampos.add(new JLabel("Situação:"));
        painelCampos.add(cbSituacao);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnInserir);

    }

}