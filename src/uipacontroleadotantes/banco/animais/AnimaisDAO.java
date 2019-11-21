package uipacontroleadotantes.banco.animais;

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
 * AnimaisDAO
 */
public class AnimaisDAO {

    private PreparedStatement ps = null;

    public int inserir(AnimaisBean animal) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into animal(Nome, Especie, Sexo, DataNasc, Porte, Castrado, CodAdotante, DataAdocao)values(?, ?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs;
        int id = 0;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, animal.getNome());
            ps.setString(2, animal.getEspecie());
            ps.setString(3, String.valueOf(animal.getSexo()));
            ps.setString(4, String.valueOf(animal.getDataNasc()));
            ps.setString(5, String.valueOf(animal.getPorte()));
            ps.setString(6, String.valueOf(animal.getCastrado()));
            ps.setString(7, String.valueOf(animal.getCodAdotante()));
            ps.setString(8, String.valueOf(animal.getDataAdocao()));
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

    public void alterar(AnimaisBean animal) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "update animal set Nome=?, Especie=?, Sexo=?, DataNasc=?, Porte=?, Castrado=?, CodAdotante=?, DataAdocao=?";
        sql += " where CodAnimal = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, animal.getNome());
            ps.setString(2, animal.getEspecie());
            ps.setString(3, String.valueOf(animal.getSexo()));
            ps.setString(4, String.valueOf(animal.getDataNasc()));
            ps.setString(5, String.valueOf(animal.getPorte()));
            ps.setString(6, String.valueOf(animal.getCastrado()));
            ps.setString(7, String.valueOf(animal.getCodAdotante()));
            ps.setString(8, String.valueOf(animal.getDataAdocao()));
            ps.setString(9, String.valueOf(animal.getCodAnimal()));
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
                    adotantesBean.setEndereco(rs.getString("Endereco"));
                    adotantesBean.setBairro(rs.getString("Bairro"));
                    adotantesBean.setCidade(rs.getString("Cidade"));
                    adotantesBean.setUF(rs.getString("UF"));
                    adotantesBean.setCPF(rs.getString("CPF"));
                    adotantesBean.setRG(rs.getString("RG"));
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

    public List<AdotantesBean> pesquisarPorCodigo(String CodAdotante) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from adotante where CodAdotante = ?";
        ResultSet rs = null;
        List<AdotantesBean> listaAdotantes = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, CodAdotante);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AdotantesBean adotantesBean = new AdotantesBean();
                    adotantesBean.setCodAdotante(rs.getInt("CodAdotante"));
                    adotantesBean.setNome(rs.getString("Nome"));
                    adotantesBean.setTelefone(rs.getString("Telefone"));
                    adotantesBean.setCelular(rs.getString("Celular"));
                    adotantesBean.setEndereco(rs.getString("Endereco"));
                    adotantesBean.setBairro(rs.getString("Bairro"));
                    adotantesBean.setCidade(rs.getString("Cidade"));
                    adotantesBean.setUF(rs.getString("UF"));
                    adotantesBean.setCPF(rs.getString("CPF"));
                    adotantesBean.setRG(rs.getString("RG"));
                    adotantesBean.setSexo(rs.getString("Sexo").toCharArray());
                    adotantesBean.setEmail(rs.getString("Email"));
                    listaAdotantes.add(adotantesBean);
                }
                System.out.println("Localizado com sucesso!");
                return listaAdotantes;
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
                    adotantesBean.setEndereco(rs.getString("Endereco"));
                    adotantesBean.setBairro(rs.getString("Bairro"));
                    adotantesBean.setCidade(rs.getString("Cidade"));
                    adotantesBean.setUF(rs.getString("UF"));
                    adotantesBean.setCPF(rs.getString("CPF"));
                    adotantesBean.setRG(rs.getString("RG"));
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
