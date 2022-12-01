package persistencia;

import java.sql.PreparedStatement;
import java.sql.*;

import domain.*;
import java.util.ArrayList;
import java.util.List;

public class DAOperformance extends DAOPOOFlix{
    private Connection conexaobd;

	public DAOperformance(Connection cnx) {
		conexaobd = cnx;
	}

	public int adiciona(OBJPOOFlix objpooflix) {
		try {
			Performance ator_personagem = (Performance) objpooflix;
                    try (PreparedStatement ps = conexaobd.prepareStatement("insert into performance(idep, idpers, idator ) values (?, ?, ?)")) {
                        ps.setInt(1, (ator_personagem.getidep().getId()));
                        ps.setInt(2, (ator_personagem.getidperson().getId()));
                        ps.setInt(3, (ator_personagem.getator().getId()));
                        ps.execute();
                    }
			return 0;
		} catch (SQLException e) {
			System.out.println("Problemas em DAOperformance.adiciona" + e.getMessage());
			return -1;
		}
	}
	// Separar o que o atualiza pode atualizar idep, idpers e idator
    @Override
	public int atualiza(OBJPOOFlix objpooflix) {
		try {
			Performance perf = (Performance) objpooflix;
                    try (PreparedStatement ps = conexaobd.prepareStatement("update performance set idep=? where id=?")) {
                        ps.setInt(1, (perf.getidep().getId()));
                        //ps.setString(2, perf.());
                        ps.executeUpdate();
                    }
			return 0;
		} catch (SQLException e) {
			System.out.println("Problemas em DAOperformance.atualiza" + e.getMessage());
			return -1;
		}
	}

	public int deleta(OBJPOOFlix objpooflix) {
		try {
			Performance Perf = (Performance) objpooflix;
                    try (PreparedStatement ps = conexaobd.prepareStatement("delete from Performance where idep=? and idpers =? and idator=?")) {
                        ps.setInt(1, Perf.getidep().getId());
                        ps.setInt(2, Perf.getidperson().getId());
                        ps.setInt(1, Perf.getator().getId());
                        ps.executeUpdate();
                    }
			return 0;
		} catch (SQLException e) {
			System.out.println("Problemas em DAOperformance.deleta" + e.getMessage());
			return -1;
		}
	}

    @Override
	public List<OBJPOOFlix> lista() {
		try {
			List<OBJPOOFlix> Performances = new ArrayList<OBJPOOFlix>();

                    try (PreparedStatement ps = conexaobd.prepareStatement(
                            "select e.id as eid,e.numep,e.temporada,e.titulo,e.resumo"
                                    + "p.id as pid,p.nome as pnome,"
                                    + "a.id as aid,a.nome as anome a.nacionalidade as anacion from Performance as pf "
                                    + "join Episodio as e on(pf.idep=e.id)"
                                    + "join personagem as p on(p.id=pf.idpers)"
                                    + "join ator as a on(a.id=pf.idator);")) {
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            //Episodio
                            int eid = rs.getInt("eid");
                            int idep = (rs.getInt("numep"));
                            int tempEp = rs.getInt("temporada");
                            String titep = rs.getString("titulo");
                            String resep = rs.getString("resumo");
                            Episodio ep = new Episodio(eid,idep, tempEp, titep, resep);
                            //Personagem
                            int idp = rs.getInt("pid");
                            String pnome = rs.getString("pnome");
                            Personagem pe = new Personagem(idp, pnome);
                            //Ator
                            int aid = rs.getInt("aid");
                            String anome = rs.getString("anome");
                            String anacion = rs.getString("anacion");
                            Ator at = new Ator(aid, anome,anacion);
                            //Performance
                            Performance performance = new Performance(ep, pe, at);
                            //Lista de Performances
                            Performances.add(performance);
                        }
                        
                        rs.close();
                    }

			return Performances;
		} catch (SQLException e) {
			System.out.println("Problemas em DAOperformance.lista" + e.getMessage());
			return null;
		}
	}
}
