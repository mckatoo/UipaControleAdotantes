package uipacontroleadotantes.banco.vacinados;

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
 * AdotantesDAO
 */
public class VacinadosDAO {

    private PreparedStatement ps = null;

    public int inserir(VacinadosBean vacinado) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into vacinado(CodAnimal, CodVacina, dtVac, Obs)values(?, ?, ?, ?)";
        ResultSet rs;
        int id = 0;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, String.valueOf(vacinado.getCodAnimal()));
            ps.setString(2, String.valueOf(vacinado.getCodVacina()));
            ps.setString(3, String.valueOf(vacinado.getDtVac()));
            ps.setString(4, vacinado.getObs());
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

    public void alterar(VacinadosBean vacinado) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "update vacinado set CodAnimal=?, CodVacina=?, dtVac=?, Obs=?";
        sql += " where CodVacinado=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(vacinado.getCodAnimal()));
            ps.setString(2, String.valueOf(vacinado.getCodVacina()));
            ps.setString(3, String.valueOf(vacinado.getDtVac()));
            ps.setString(4, vacinado.getObs());
            ps.setString(5, String.valueOf(vacinado.getCodVacinado()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public String excluir(int codVacinado) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "delete from vacinado where CodVacinado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(codVacinado));
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

    public List<VacinadosBean> listarTodos() throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from vacinado ";
        ResultSet rs = null;
        List<VacinadosBean> listaVacinados = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VacinadosBean vacinadoBean = new VacinadosBean();
                    vacinadoBean.setCodVacinado(rs.getInt("CodVacinado"));
                    vacinadoBean.setCodAnimal(rs.getInt("CodAnimal"));
                    vacinadoBean.setCodVacina(rs.getInt("CodVacina"));
                    vacinadoBean.setDtVac(LocalDate.parse(rs.getString("dtVac")));
                    vacinadoBean.setObs(rs.getString("Obs"));
                    listaVacinados.add(vacinadoBean);
                }
                System.out.println("Listado com sucesso!");
                return listaVacinados;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

    public VacinadosBean pesquisarPorCodigo(String codVacinado) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from vacinado where CodVacinado = ?";
        VacinadosBean vacinadosBean = new VacinadosBean();
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codVacinado);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    vacinadosBean.setCodVacinado(rs.getInt("CodVacinado"));
                    vacinadosBean.setCodAnimal(rs.getInt("CodAnimal"));
                    vacinadosBean.setCodVacina(rs.getInt("CodVacina"));
                    vacinadosBean.setDtVac(LocalDate.parse(rs.getString("dtVac")));
                    vacinadosBean.setObs(rs.getString("Obs"));
                }
                System.out.println("Localizado com sucesso!");
                return vacinadosBean;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

    public List<VacinadosBean> pesquisarPorNome(String nome) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from adotante where Nome like ?";
        ResultSet rs = null;
        List<VacinadosBean> listaAdotantes = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VacinadosBean vacinadosBean = new VacinadosBean();
//                    vacinadosBean.setCodAdotante(rs.getInt("CodAdotante"));
//                    vacinadosBean.setNome(rs.getString("Nome"));
//                    vacinadosBean.setTelefone(rs.getString("Telefone"));
//                    adotantesBean.setCelular(rs.getString("Celular"));
//                    adotantesBean.setEndereco(rs.getString("Endereco"));
//                    adotantesBean.setBairro(rs.getString("Bairro"));
//                    adotantesBean.setCidade(rs.getString("Cidade"));
//                    adotantesBean.setUF(rs.getString("UF"));
//                    adotantesBean.setCPF(rs.getString("CPF"));
//                    adotantesBean.setRG(rs.getString("RG"));
//                    adotantesBean.setSexo(rs.getString("Sexo").toCharArray());
//                    adotantesBean.setEmail(rs.getString("Email"));
                    listaAdotantes.add(vacinadosBean);
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
