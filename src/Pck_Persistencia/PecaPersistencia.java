package Pck_Persistencia;

import Pck_DAO.ConexaoMySql;
import Pck_Model.PecaModel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PecaPersistencia {

    public void inserir(PecaModel item) throws SQLException {
        String chamada =
                "{CALL PROC_INS_PECA_01(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conexao = ConexaoMySql.conectar();
             CallableStatement comando = conexao.prepareCall(chamada)) {

            if (item.getIdEnvio() == null) {
                comando.setNull(1, Types.INTEGER);
            } else {
                comando.setInt(1, item.getIdEnvio());
            }

            comando.setString(2, item.getNome());
            comando.setString(3, item.getMarca());
            comando.setString(4, item.getCategoria());
            comando.setString(5, item.getModelo());
            comando.setString(6, item.getCor());
            comando.setString(7, item.getTamanho());
            comando.setString(8, item.getCondicao());
            comando.setBigDecimal(9, item.getPesoGramas());
            comando.setBigDecimal(10, item.getMargemPercentual());
            comando.setBigDecimal(11, item.getPrecoVenda());
            comando.setString(12, item.getSituacao());

            comando.executeUpdate();
        }
    }

    public List<PecaModel> consultar() throws SQLException {
        List<PecaModel> lista = new ArrayList<>();
        String chamada = "{CALL PROC_SEL_PECA_02()}";

        try (Connection conexao = ConexaoMySql.conectar();
             CallableStatement comando = conexao.prepareCall(chamada);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                PecaModel item = new PecaModel();

                item.setIdPeca(resultado.getInt("id_peca"));

                int idEnvio = resultado.getInt("id_envio");

                if (resultado.wasNull()) {
                    item.setIdEnvio(null);
                } else {
                    item.setIdEnvio(idEnvio);
                }

                item.setNome(resultado.getString("nome"));
                item.setMarca(resultado.getString("marca"));
                item.setCategoria(resultado.getString("categoria"));
                item.setModelo(resultado.getString("modelo"));
                item.setCor(resultado.getString("cor"));
                item.setTamanho(resultado.getString("tamanho"));
                item.setCondicao(resultado.getString("condicao"));
                item.setPesoGramas(resultado.getBigDecimal("peso_gramas"));

                item.setMargemPercentual(
                        resultado.getBigDecimal("margem_percentual"));

                item.setPrecoVenda(resultado.getBigDecimal("preco_venda"));
                item.setSituacao(resultado.getString("situacao"));

                lista.add(item);
            }
        }

        return lista;
    }

    public void alterar(PecaModel item) throws SQLException {
        String chamada =
                "{CALL PROC_UPD_PECA_03(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conexao = ConexaoMySql.conectar();
             CallableStatement comando = conexao.prepareCall(chamada)) {

            comando.setInt(1, item.getIdPeca());

            if (item.getIdEnvio() == null) {
                comando.setNull(2, Types.INTEGER);
            } else {
                comando.setInt(2, item.getIdEnvio());
            }

            comando.setString(3, item.getNome());
            comando.setString(4, item.getMarca());
            comando.setString(5, item.getCategoria());
            comando.setString(6, item.getModelo());
            comando.setString(7, item.getCor());
            comando.setString(8, item.getTamanho());
            comando.setString(9, item.getCondicao());
            comando.setBigDecimal(10, item.getPesoGramas());
            comando.setBigDecimal(11, item.getMargemPercentual());
            comando.setBigDecimal(12, item.getPrecoVenda());
            comando.setString(13, item.getSituacao());

            comando.executeUpdate();
        }
    }

    public void remover(int idPeca) throws SQLException {
        String chamada = "{CALL PROC_DEL_PECA_04(?)}";

        try (Connection conexao = ConexaoMySql.conectar();
             CallableStatement comando = conexao.prepareCall(chamada)) {

            comando.setInt(1, idPeca);
            comando.executeUpdate();
        }
    }

    public int consultarTotal() throws SQLException {
        String sql = "SELECT FN_TOTAL_PECA_05() AS total";

        try (Connection conexao = ConexaoMySql.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            if (resultado.next()) {
                return resultado.getInt("total");
            }
        }

        return 0;
    }
}