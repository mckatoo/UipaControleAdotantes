package uipacontroleadotantes.banco.vacinas;

import uipacontroleadotantes.banco.adotantes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uipacontroleadotantes.banco.Conexao;
import uipacontroleadotantes.uteis.Sanitize;

/**
 * VacinasDAO
 */
public class VacinasDAO {

    private PreparedStatement ps = null;

    public int inserir(VacinasBean vacina) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into vacina(Nome, Descricao)values(?, ?)";
        ResultSet rs;
        int id = 0;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vacina.getNome());
            ps.setString(2, vacina.getDescricao());
            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                id = rs.getInt(1);
                rs.close();
                System.out.println("Inserido com sucesso!" + "ID = " + id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
        return id;
    }

    public void alterar(VacinasBean vacina) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "update vacina set Nome = ?, Descricao = ?";
        sql += " where CodVacina = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vacina.getNome());
            ps.setString(2, vacina.getDescricao());
            ps.setString(3, Integer.toString(vacina.getCodVacina()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public String excluir(int codVacina) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "delete from vacina where CodVacina = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(codVacina));
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            Conexao.fecharConexao(con, ps);
        }
        return null;
    }

    public List<VacinasBean> listarTodos() throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from vacina ";
        ResultSet rs = null;
        List<VacinasBean> listaVacinas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VacinasBean adotantesBean = new VacinasBean();
                    adotantesBean.setCodVacina(rs.getInt("CodVacina"));
                    adotantesBean.setNome(rs.getString("Nome"));
                    adotantesBean.setDescricao(rs.getString("Descricao"));
                    listaVacinas.add(adotantesBean);
                }
                System.out.println("Listado com sucesso!");
                return listaVacinas;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

    public List<VacinasBean> pesquisarPorCodigo(String codVacina) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from vacina where CodVacina = ?";
        ResultSet rs = null;
        List<VacinasBean> listaVacinas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codVacina);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VacinasBean adotantesBean = new VacinasBean();
                    adotantesBean.setCodVacina(rs.getInt("CodVacina"));
                    adotantesBean.setNome(rs.getString("Nome"));
                    listaVacinas.add(adotantesBean);
                }
                System.out.println("Localizado com sucesso!");
                return listaVacinas;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }
    
     public List<VacinasBean> pesquisarPorNome(String nome) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from vacina where Nome like ?";
        ResultSet rs = null;
        List<VacinasBean> listaVacinas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VacinasBean adotantesBean = new VacinasBean();
                    adotantesBean.setCodVacina(rs.getInt("CodVacina"));
                    adotantesBean.setNome(rs.getString("Nome"));
                    adotantesBean.setDescricao(rs.getString("Descricao"));
                    listaVacinas.add(adotantesBean);
                }
                System.out.println("Listado com sucesso!");
                return listaVacinas;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

}
