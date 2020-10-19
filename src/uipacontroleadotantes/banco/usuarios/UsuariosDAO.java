package uipacontroleadotantes.banco.usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import uipacontroleadotantes.banco.Conexao;
import uipacontroleadotantes.uteis.Seguranca;

/**
 * UsuariosDAO
 */
public class UsuariosDAO {

  private PreparedStatement ps = null;

  public int count() {
    Connection con = Conexao.abrirConexao();
    String sql = "select count(*) as rowcount from usuario;";
    ResultSet rs;
    int count = 0;

    try {
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      rs.next();
      count = rs.getInt("rowcount");
      rs.close();
      con.close();
    } catch (SQLException e) {
      System.out.println(e);
    }

    return count;
  }

  public int inserir(UsuariosBean usuarios) throws SQLException {
    Connection con = Conexao.abrirConexao();
    String sql = "insert into usuario(login, senha)values(?,?)";
    ResultSet rs;
    int id = 0;

    try {
      ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, usuarios.getLogin());
      ps.setString(2, Seguranca.criptografar(usuarios.getSenha()));
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

  public void alterarSenha(UsuariosBean usuarios) throws SQLException {
    Connection con = Conexao.abrirConexao();
    String sql = "update usuario set senha = ?";
    sql += " where codUsuario = ?";

    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, usuarios.getLogin());
      ps.setString(2, String.valueOf(usuarios.getCodUsuario()));
      if (ps.executeUpdate() > 0) {
        System.out.println("Atualizado com sucesso!");
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      Conexao.fecharConexao(con, ps);
    }
  }

  public String excluir(int codUsuario) throws SQLException {
    Connection con = Conexao.abrirConexao();
    String sql = "delete from usuario where codUsuario = ?";
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, String.valueOf(codUsuario));
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

  public List<UsuariosBean> listarTodos() throws SQLException {
    Connection con = Conexao.abrirConexao();
    String sql = "select * from usuario ";
    ResultSet rs = null;
    List<UsuariosBean> listaUsuarios = new ArrayList<>();
    try {
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      if (rs != null) {
        while (rs.next()) {
          UsuariosBean cb = new UsuariosBean();
          cb.setCodUsuario(rs.getInt("codUsuario"));
          cb.setLogin(rs.getString("login"));
          listaUsuarios.add(cb);
        }
        System.out.println("Listado com sucesso!");
        return listaUsuarios;
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      Conexao.fecharConexao(con, ps, rs);
    }
    return null;
  }

  public List<UsuariosBean> listarUsuarios(String nome) {
    Connection con = Conexao.abrirConexao();
    String sql = "select * from usuario where nome like ?";
    ResultSet rs = null;
    List<UsuariosBean> listaUsuarios = new ArrayList<>();
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, "%" + nome + "%");
      rs = ps.executeQuery();
      if (rs != null) {
        while (rs.next()) {
          UsuariosBean cb = new UsuariosBean();
          cb.setCodUsuario(rs.getInt("codUsuario"));
          cb.setLogin(rs.getString("login"));
          listaUsuarios.add(cb);
        }
        System.out.println("Listado com sucesso!");
        return listaUsuarios;
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      Conexao.fecharConexao(con, ps, rs);
    }
    return null;
  }

  public UsuariosBean pesquisarPorCodigo(String codUsuario) {
    Connection con = Conexao.abrirConexao();
    String sql = "select * from usuario where codUsuario = ?";
    ResultSet rs = null;
    UsuariosBean usuario = new UsuariosBean();
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, codUsuario);
      rs = ps.executeQuery();
      if (rs != null) {
        while (rs.next()) {
          usuario.setCodUsuario(rs.getInt("codUsuario"));
          usuario.setLogin(rs.getString("login"));
          usuario.setSenha(rs.getString("senha"));
        }
        System.out.println("Localizado com sucesso!");
        return usuario;
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      Conexao.fecharConexao(con, ps, rs);
    }
    return null;
  }

  public UsuariosBean pesquisarPorUsuario(String login) {
    Connection con = Conexao.abrirConexao();
    String sql = "select * from usuario where login = ?";
    ResultSet rs = null;
    UsuariosBean usuario = new UsuariosBean();
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, login);
      rs = ps.executeQuery();
      if (rs != null) {
        while (rs.next()) {
          usuario.setCodUsuario(rs.getInt("codUsuario"));
          usuario.setLogin(rs.getString("login"));
          usuario.setSenha(rs.getString("senha"));
        }
        System.out.println("Listado com sucesso!");
        return usuario;
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      Conexao.fecharConexao(con, ps, rs);
    }
    return null;
  }

  public Future<Boolean> login(String login, String senha) {
    return CompletableFuture.supplyAsync(() -> {
      UsuariosBean usuario = pesquisarPorUsuario(login);
      String agora = LocalDateTime.now().toString();
      String data = agora.split("T")[0];
      String hora = agora.split("T")[1];
      System.out.println(data + " - " + hora + ": " + usuario.getLogin() + " entrou no sistema.");
      if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
        return true;
      }
      System.out.println(data + " - " + hora + ": " + usuario.getLogin() + " - tentativa de acesso negada.");
      return false;
    });
  }

}
