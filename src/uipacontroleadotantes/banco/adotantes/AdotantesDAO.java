package uipacontroleadotantes.banco.adotantes;

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
 * AdotantesDAO
 */
public class AdotantesDAO {

    private PreparedStatement ps = null;

    public int inserir(AdotantesBean adotante) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into adotante(Nome, Telefone, Celular, CEP, Endereco, Bairro, Cidade, UF, CPF, RG, Sexo, Email)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs;
        int id = 0;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, adotante.getNome());
            ps.setString(2, adotante.getTelefone());
            ps.setString(3, adotante.getCelular());
            ps.setString(4, adotante.getCep());
            ps.setString(5, adotante.getEndereco());
            ps.setString(6, adotante.getBairro());
            ps.setString(7, adotante.getCidade());
            ps.setString(8, adotante.getUf());
            ps.setString(9, adotante.getCpf());
            ps.setString(10, adotante.getRg());
            ps.setString(11, Sanitize.sanitizar(adotante.getSexo()));
            ps.setString(12, adotante.getEmail());
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

    public void alterar(AdotantesBean adotante) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "update adotante set Nome=?, Telefone=?, Celular=?, CEP=?, Endereco=?, Bairro=?, Cidade=?, UF=?, CPF=?, RG=?, Sexo=?, Email=?";
        sql += " where codAdotante=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, adotante.getNome());
            ps.setString(2, adotante.getTelefone());
            ps.setString(3, adotante.getCelular());
            ps.setString(4, adotante.getCep());
            ps.setString(5, adotante.getEndereco());
            ps.setString(6, adotante.getBairro());
            ps.setString(7, adotante.getCidade());
            ps.setString(8, adotante.getUf());
            ps.setString(9, adotante.getCpf());
            ps.setString(10, adotante.getRg());
            ps.setString(11, Sanitize.sanitizar(adotante.getSexo()));
            ps.setString(12, adotante.getEmail());
            ps.setString(13, Integer.toString(adotante.getCodAdotante()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public String excluir(int CodAdotante) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "delete from adotante where CodAdotante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(CodAdotante));
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

    public List<AdotantesBean> listarTodos() throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from adotante ";
        ResultSet rs = null;
        List<AdotantesBean> listaAdotantes = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AdotantesBean adotantesBean = new AdotantesBean();
                    adotantesBean.setCodAdotante(rs.getInt("CodAdotante"));
                    adotantesBean.setNome(rs.getString("Nome"));
                    adotantesBean.setTelefone(rs.getString("Telefone"));
                    adotantesBean.setCelular(rs.getString("Celular"));
                    adotantesBean.setCep(rs.getString("CEP"));
                    adotantesBean.setEndereco(rs.getString("Endereco"));
                    adotantesBean.setBairro(rs.getString("Bairro"));
                    adotantesBean.setCidade(rs.getString("Cidade"));
                    adotantesBean.setUf(rs.getString("UF"));
                    adotantesBean.setCpf(rs.getString("CPF"));
                    adotantesBean.setRg(rs.getString("RG"));
                    adotantesBean.setSexo(rs.getString("Sexo").toCharArray());
                    adotantesBean.setEmail(rs.getString("Email"));
                    listaAdotantes.add(adotantesBean);
                }
                System.out.println("Listado com sucesso!");
                return listaAdotantes;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

    public AdotantesBean pesquisarPorCodigo(String CodAdotante) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from adotante where CodAdotante = ?";
        ResultSet rs = null;
        AdotantesBean adotantesBean = new AdotantesBean();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, CodAdotante);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    adotantesBean.setCodAdotante(rs.getInt("CodAdotante"));
                    adotantesBean.setNome(rs.getString("Nome"));
                    adotantesBean.setTelefone(rs.getString("Telefone"));
                    adotantesBean.setCelular(rs.getString("Celular"));
                    adotantesBean.setCep(rs.getString("CEP"));
                    adotantesBean.setEndereco(rs.getString("Endereco"));
                    adotantesBean.setBairro(rs.getString("Bairro"));
                    adotantesBean.setCidade(rs.getString("Cidade"));
                    adotantesBean.setUf(rs.getString("UF"));
                    adotantesBean.setCpf(rs.getString("CPF"));
                    adotantesBean.setRg(rs.getString("RG"));
                    adotantesBean.setSexo(rs.getString("Sexo").toCharArray());
                    adotantesBean.setEmail(rs.getString("Email"));
                }
                System.out.println("Localizado com sucesso!");
                return adotantesBean;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

    public List<AdotantesBean> pesquisarPorNome(String nome) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from adotante where Nome like ?";
        ResultSet rs = null;
        List<AdotantesBean> listaAdotantes = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AdotantesBean adotantesBean = new AdotantesBean();
                    adotantesBean.setCodAdotante(rs.getInt("CodAdotante"));
                    adotantesBean.setNome(rs.getString("Nome"));
                    adotantesBean.setTelefone(rs.getString("Telefone"));
                    adotantesBean.setCelular(rs.getString("Celular"));
                    adotantesBean.setCep(rs.getString("CEP"));
                    adotantesBean.setEndereco(rs.getString("Endereco"));
                    adotantesBean.setBairro(rs.getString("Bairro"));
                    adotantesBean.setCidade(rs.getString("Cidade"));
                    adotantesBean.setUf(rs.getString("UF"));
                    adotantesBean.setCpf(rs.getString("CPF"));
                    adotantesBean.setRg(rs.getString("RG"));
                    adotantesBean.setSexo(rs.getString("Sexo").toCharArray());
                    adotantesBean.setEmail(rs.getString("Email"));
                    listaAdotantes.add(adotantesBean);
                }
                System.out.println("Listado com sucesso!");
                return listaAdotantes;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

}
