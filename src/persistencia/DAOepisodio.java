package persistencia;

import java.sql.*;
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
            try (PreparedStatement ps = conexaobd.prepareStatement("insert into Episodio(numep,temporada,titulo,resumo) values (?, ?, ?, ?)")) {
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<OBJPOOFlix> lista() {
        // TODO Auto-generated method stub
        return null;
    }

}
