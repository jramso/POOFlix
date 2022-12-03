package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conecta {

    private Connection conn = null;
    private String user, senha, banco, url;
    private String txt;

    public Conecta(String fullURL) {
        this.txt = fullURL;
        try {
            setUrl(txt);

        } catch (Exception ex) {
            System.out.println("Problemas com a conexão:\n\n" + ex);
        }
    }

    public Conecta(String user, String senha, String banco) {
        try {
            setBanco(banco);
            setUser(user);
            setSenha(senha);
            setUrl("jdbc:postgresql://motty.db.elephantsql.com/" + banco);
        } catch (Exception e) {
            System.out.println("Erro de tipo de dados no constructor");
        }
    }

    public Connection connectDB() {
        Properties props = new Properties();
        props.setProperty("user", getUser());
        props.setProperty("password", getSenha());
        try {
            Connection conn = DriverManager.getConnection(getUrl(), props);
            setConn(conn);
            System.out.println("Conexao sucedida:" + this.toString());
        } catch (SQLException sqle) {
            System.err.println(sqle);
            sqle.printStackTrace();
        }
        return conn;
    }

    public void disconnectDB() {
        try {
            conn.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
            sqle.printStackTrace();
        }
    }

    public String queryDB(String query) {
        String res;
        try {
            Statement st = getConn().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            res = rs.getString(1);
            st.close();
            return res;
        } catch (SQLException sqle) {
            System.err.println(sqle);
            sqle.printStackTrace();
            return "SQLException";
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public String getTxt() {
        return txt;
    }

    public String getBanco() {
        return banco;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

}
