package uipacontroleadotantes.banco.animais;

import uipacontroleadotantes.banco.adotantes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import uipacontroleadotantes.banco.Conexao;

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

    public String excluir(int codAnimal) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "delete from animal where CodAnimal = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(codAnimal));
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

    public List<AnimaisBean> listarTodos() throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from animal";
        ResultSet rs = null;
        List<AnimaisBean> listaAnimais = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AnimaisBean animaisBean = new AnimaisBean();
                    animaisBean.setCodAnimal(Integer.parseInt(rs.getString("CodAnimal")));
                    animaisBean.setNome(rs.getString("Nome"));
                    animaisBean.setEspecie(rs.getString("Especie"));
                    animaisBean.setSexo(rs.getString("Sexo").toCharArray());
                    animaisBean.setDataNasc(LocalDate.parse(rs.getString("DataNasc")));
                    animaisBean.setPorte(rs.getString("Porte").toCharArray());
                    animaisBean.setCastrado(rs.getString("Castrado").toCharArray());
                    animaisBean.setCodAdotante(rs.getInt("CodAdotante"));
                    animaisBean.setDataAdocao(LocalDate.parse(rs.getString("DataAdocao")));
                    listaAnimais.add(animaisBean);
                }
                System.out.println("Listado com sucesso!");
                return listaAnimais;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

    public AnimaisBean pesquisarPorCodAnimal(String codAnimal) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from animal where CodAnimal = ?";
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codAnimal);
            rs = ps.executeQuery();
            if (rs != null) {
                AnimaisBean animaisBean = new AnimaisBean();
                animaisBean.setCodAnimal(Integer.parseInt(rs.getString("CodAnimal")));
                animaisBean.setNome(rs.getString("Nome"));
                animaisBean.setEspecie(rs.getString("Especie"));
                animaisBean.setSexo(rs.getString("Sexo").toCharArray());
                animaisBean.setDataNasc(LocalDate.parse(rs.getString("DataNasc")));
                animaisBean.setPorte(rs.getString("Porte").toCharArray());
                animaisBean.setCastrado(rs.getString("Castrado").toCharArray());
                animaisBean.setCodAdotante(rs.getInt("CodAdotante"));
                animaisBean.setDataAdocao(LocalDate.parse(rs.getString("DataAdocao")));
                System.out.println("Localizado com sucesso!");
                return animaisBean;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

    public List<AnimaisBean> pesquisarPorCodAdotante(String codAdotante) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from animal where CodAdotante = ?";
        ResultSet rs = null;
        List<AnimaisBean> listaAnimais = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codAdotante);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AnimaisBean animaisBean = new AnimaisBean();
                    animaisBean.setCodAnimal(Integer.parseInt(rs.getString("CodAnimal")));
                    animaisBean.setNome(rs.getString("Nome"));
                    animaisBean.setEspecie(rs.getString("Especie"));
                    animaisBean.setSexo(rs.getString("Sexo").toCharArray());
                    animaisBean.setDataNasc(LocalDate.parse(rs.getString("DataNasc")));
                    animaisBean.setPorte(rs.getString("Porte").toCharArray());
                    animaisBean.setCastrado(rs.getString("Castrado").toCharArray());
                    animaisBean.setCodAdotante(rs.getInt("CodAdotante"));
                    animaisBean.setDataAdocao(LocalDate.parse(rs.getString("DataAdocao")));
                    listaAnimais.add(animaisBean);
                }
                System.out.println("Localizado com sucesso!");
                return listaAnimais;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

    public List<AnimaisBean> pesquisarPorNome(String nome) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from animal where Nome like ?";
        ResultSet rs = null;
        List<AnimaisBean> listaAnimais = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AnimaisBean animaisBean = new AnimaisBean();
                    animaisBean.setCodAnimal(Integer.parseInt(rs.getString("CodAnimal")));
                    animaisBean.setNome(rs.getString("Nome"));
                    animaisBean.setEspecie(rs.getString("Especie"));
                    animaisBean.setSexo(rs.getString("Sexo").toCharArray());
                    animaisBean.setDataNasc(LocalDate.parse(rs.getString("DataNasc")));
                    animaisBean.setPorte(rs.getString("Porte").toCharArray());
                    animaisBean.setCastrado(rs.getString("Castrado").toCharArray());
                    animaisBean.setCodAdotante(rs.getInt("CodAdotante"));
                    animaisBean.setDataAdocao(LocalDate.parse(rs.getString("DataAdocao")));
                    listaAnimais.add(animaisBean);
                }
                System.out.println("Listado com sucesso!");
                return listaAnimais;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

}
