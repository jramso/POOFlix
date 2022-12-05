package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Episodio;
import domain.OBJPOOFlix;

public class DAOepisodio extends DAOPOOFlix{
    
    private Connection conexaobd;
    
    public DAOepisodio(Connection cnx) {
        conexaobd = cnx;
    }

    @Override
    public int adiciona(OBJPOOFlix objpooflix) {
        try {
            Episodio episodio = (Episodio) objpooflix;
            try (PreparedStatement ps = conexaobd.prepareStatement("insert into Episodio values ((select MAX(e.id)+1 from episodio as e),?, ?, ?, ?)")) {
                ps.setInt(1, (episodio.getNumEP()));
                ps.setInt(2, (episodio.getTemporada()));
                ps.setString(3, episodio.getTitulo());
                ps.setString(4, episodio.getResumo());
                ps.execute();
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOepisodio.adiciona" + e.getMessage());
            return -1;
        }
    }

    @Override
    public int atualiza(OBJPOOFlix objpooflix) {
        try {
            Episodio episodio = (Episodio) objpooflix;
            try (PreparedStatement ps = conexaobd.prepareStatement("UPDATE Episodio SET numep=?, temporada=?, titulo=?, resumo=?  WHERE id=?")) {
                ps.setInt(1, (episodio.getNumEP()));
                ps.setInt(2, (episodio.getTemporada()));
                ps.setString(3, episodio.getTitulo());
                ps.setString(4, episodio.getResumo());
                ps.setInt(5, (episodio.getId()));
                ps.executeUpdate();
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOepisodio.atualiza" + e.getMessage());
            return -1;
        }
    }

    @Override
    public int deleta(OBJPOOFlix objpooflix) {
        try {
            Episodio episodio = (Episodio) objpooflix;
            try (PreparedStatement ps = conexaobd.prepareStatement("delete from Episodio where id=?")) {
                ps.setInt(1, episodio.getId());
                ps.executeUpdate();
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em "+this.getClass().getSimpleName()+".deleta" + e.getMessage());
            return -1;
        }
    }

    @Override
    public List<OBJPOOFlix> lista() {
        try {
            List<OBJPOOFlix> Eps = new ArrayList<OBJPOOFlix>();

            try (PreparedStatement ps = conexaobd.prepareStatement("select id, numep, temporada, titulo, resumo from episodio")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String id = String.valueOf(rs.getInt("id"));
                    String numep = String.valueOf(rs.getInt("numep"));
                    String temp = String.valueOf(rs.getInt("temporada"));
                    String titulo = rs.getString("titulo");
                    String resumo = rs.getString("resumo");
                    Episodio ep = new Episodio(Integer.parseInt(id),Integer.parseInt(numep), Integer.parseInt(temp), titulo, resumo);
                    Eps.add(ep);
                }
                rs.close();
            }

            return Eps;
        } catch (SQLException e) {
            System.out.println("Problemas em "+this.getClass().getSimpleName()+".lista" + e.getMessage());
            return null;
        }
    }

}
