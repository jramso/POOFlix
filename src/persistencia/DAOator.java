package persistencia;

import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOator extends DAOPOOFlix {
        private Connection conexaobd;
    
        public DAOator(Connection cnx) {
            conexaobd = cnx;
        }
    
    /**
     * Recebe um objpooflix
     * como parametro e insere um novo Ator no banco de dados
     * caso consiga inserir retorna 0
     * caso não consiga inserir retorna 1
     * 
     * @param objpooflix
     * @return 0,-1
     */
    @Override
        public int adiciona(OBJPOOFlix objpooflix) {
            try {
                Ator ator = (Ator) objpooflix;
                try (PreparedStatement ps = conexaobd.prepareStatement("insert into Ator(id, nome) values (?, ?)")) {
                    ps.setInt(1, (ator.getId()));
                    ps.setString(2, ator.getNome());
                    ps.execute();
                }
                return 0;
            } catch (SQLException e) {
                System.out.println("Problemas em DAOator.adiciona" + e.getMessage());
                return -1;
            }
        }
    
        public int atualiza(OBJPOOFlix objpooflix) {
            try {
                Ator ator = (Ator) objpooflix;
                try (PreparedStatement ps = conexaobd.prepareStatement("update Ator set nome=? where id=?")) {
                    ps.setInt(2, (ator.getId()));
                    ps.setString(1, ator.getNome());
                    ps.executeUpdate();
                }
                return 0;
            } catch (SQLException e) {
                System.out.println("Problemas em DAOator.atualiza" + e.getMessage());
                return -1;
            }
        }
    
        public int deleta(OBJPOOFlix objpooflix) {
            try {
                Ator ator = (Ator) objpooflix;
                try (PreparedStatement ps = conexaobd.prepareStatement("delete from Ator where id=?")) {
                    ps.setInt(1, ator.getId());
                    ps.executeUpdate();
                }
                return 0;
            } catch (SQLException e) {
                System.out.println("Problemas em DAOator.deleta" + e.getMessage());
                return -1;
            }
        }
    
        public List<OBJPOOFlix> lista() {
            try {
                List<OBJPOOFlix> Ators = new ArrayList<OBJPOOFlix>();
    
                try (PreparedStatement ps = conexaobd.prepareStatement("select id, titulo, nacionalidade from Ator")) {
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        String id = String.valueOf(rs.getInt("id"));
                        String titulo = rs.getString("titulo");
                        String nacio = rs.getString("nacionalidade");
                        Ator ator = new Ator(Integer.parseInt(id), titulo,nacio);
                        Ators.add(ator);
                    }
                    
                    rs.close();
                }
    
                return Ators;
            } catch (SQLException e) {
                System.out.println("Problemas em DAOator.lista" + e.getMessage());
                return null;
            }
        }
} // DAOator
    
