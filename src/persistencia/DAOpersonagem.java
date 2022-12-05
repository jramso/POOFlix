package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.OBJPOOFlix;
import domain.Personagem;

public class DAOpersonagem extends DAOPOOFlix {

    public DAOpersonagem(Connection cnx) {
        this.conexaobd = cnx;
    }

    @Override
    public int adiciona(OBJPOOFlix objpooflix) {
        try {
            Personagem personagem = (Personagem) objpooflix;
            try (PreparedStatement ps = conexaobd.prepareStatement("insert into personagem(id,nome) values (?, ?)")) {
                ps.setInt(1, personagem.getId());
                ps.setString(2, personagem.getNome());
                ps.execute();
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em " + this.getClass().getSimpleName() + ".adiciona" + e.getMessage());
            return -1;
        }
    }// adiciona

    @Override
    public int atualiza(OBJPOOFlix objpooflix) {
        try {
            Personagem personagem = (Personagem) objpooflix;
            try (PreparedStatement ps = conexaobd.prepareStatement("update personagem set nome=? where id=?")) {
                ps.setInt(2, (personagem.getId()));
                ps.setString(1, personagem.getNome());
                ps.executeUpdate();
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em " + this.getClass().getSimpleName() + ".atualiza" + e.getMessage());
            return -1;
        }
    }// atualiza

    @Override
    public int deleta(OBJPOOFlix objpooflix) {
        try {
            Personagem personagem = (Personagem) objpooflix;
            try (PreparedStatement ps = conexaobd.prepareStatement("delete from Personagem where id=? and nome=?")) {
                ps.setInt(1, personagem.getId());
                ps.setString(2, personagem.getNome());
                ps.executeUpdate();
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em " + this.getClass().getSimpleName() + ".deleta" + e.getMessage());
            return -1;
        }
    }// deleta

    @Override
    public List<OBJPOOFlix> lista() {
        try {
            List<OBJPOOFlix> Person = new ArrayList<OBJPOOFlix>();

            try (PreparedStatement ps = conexaobd.prepareStatement("select id, nome from Personagem")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String id = String.valueOf(rs.getInt("id"));
                    String nome = rs.getString("numep");
                    ;
                    Personagem ep = new Personagem(Integer.parseInt(id), nome);
                    Person.add(ep);
                }
                rs.close();
            }

            return Person;
        } catch (SQLException e) {
            System.out.println("Problemas em " + this.getClass().getSimpleName() + ".lista" + e.getMessage());
            return null;
        } // try catch
    }// lista()

}// Fim classe
