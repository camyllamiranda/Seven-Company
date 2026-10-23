package Pck_Control;

import Pck_Model.PecaModel;
import Pck_Persistencia.PecaPersistencia;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class PecaControl {

    private final PecaPersistencia persistencia =
            new PecaPersistencia();

    public void inserir(
            Integer idEnvio,
            String nome,
            String marca,
            String categoria,
            String modelo,
            String cor,
            String tamanho,
            String condicao,
            BigDecimal pesoGramas,
            BigDecimal margemPercentual,
            BigDecimal precoVenda,
            String situacao
    ) throws SQLException {

        PecaModel item = new PecaModel();

        item.setIdEnvio(idEnvio);
        item.setNome(nome);
        item.setMarca(marca);
        item.setCategoria(categoria);
        item.setModelo(modelo);
        item.setCor(cor);
        item.setTamanho(tamanho);
        item.setCondicao(condicao);
        item.setPesoGramas(pesoGramas);
        item.setMargemPercentual(margemPercentual);
        item.setPrecoVenda(precoVenda);
        item.setSituacao(situacao);

        persistencia.inserir(item);
    }

    public List<PecaModel> consultar() throws SQLException {
        return persistencia.consultar();
    }

    public void alterar(
            int idPeca,
            Integer idEnvio,
            String nome,
            String marca,
            String categoria,
            String modelo,
            String cor,
            String tamanho,
            String condicao,
            BigDecimal pesoGramas,
            BigDecimal margemPercentual,
            BigDecimal precoVenda,
            String situacao
    ) throws SQLException {

        PecaModel item = new PecaModel();

        item.setIdPeca(idPeca);
        item.setIdEnvio(idEnvio);
        item.setNome(nome);
        item.setMarca(marca);
        item.setCategoria(categoria);
        item.setModelo(modelo);
        item.setCor(cor);
        item.setTamanho(tamanho);
        item.setCondicao(condicao);
        item.setPesoGramas(pesoGramas);
        item.setMargemPercentual(margemPercentual);
        item.setPrecoVenda(precoVenda);
        item.setSituacao(situacao);

        persistencia.alterar(item);
    }

    public void remover(int idPeca) throws SQLException {
        persistencia.remover(idPeca);
    }

    public int consultarTotal() throws SQLException {
        return persistencia.consultarTotal();
    }
}