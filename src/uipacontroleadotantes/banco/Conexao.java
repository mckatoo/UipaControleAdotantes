package uipacontroleadotantes.banco;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Conexao
 */
public class Conexao {

    private static String HOST = "campus1-iesi.ddns.net";
    private static String PORTA = "9005";
    private static String BANCO = "cc1";
    private static String USER = "mckatoo";
    private static String PASS = "123456";

    public static String getHOST() {
        return HOST;
    }

    public static void setHOST(String HOST) {
        Conexao.HOST = HOST;
    }

    public static String getPORTA() {
        return PORTA;
    }

    public static void setPORTA(String PORTA) {
        Conexao.PORTA = PORTA;
    }

    public static String getBANCO() {
        return BANCO;
    }

    public static void setBANCO(String BANCO) {
        Conexao.BANCO = BANCO;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        Conexao.USER = USER;
    }

    public static String getPASS() {
        return PASS;
    }

    public static void setPASS(String PASS) {
        Conexao.PASS = PASS;
    }

    public static Connection abrirConexao() {
        String URL = "jdbc:mysql://" + HOST + ":" + PORTA + "/" + BANCO;
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            HOST = "10.201.84.200";
            PORTA = "3306";
            URL = "jdbc:mysql://" + HOST + ":" + PORTA + "/" + BANCO;
            try {
                con = DriverManager.getConnection(URL, USER, PASS);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void fecharConexao(Connection con) {
        try {
            con.close();
            System.out.println("Conexão fechada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement ps) {
        fecharConexao(con);
        try {
            if (ps != null) {
                ps.close();
            }
            System.out.println("PrepareStatment fechada.");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement ps, ResultSet rs) {
        fecharConexao(con, ps);
        try {
            if (rs != null) {
                rs.close();
            }
            System.out.println("RecordSet fechada.");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
