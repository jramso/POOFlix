package CDU;

import domain.*;
import persistencia.DAOepisodio;

import java.sql.Connection;

import UI.FormEpisodio;

public class CDUcadastrarEpis extends CDU {
    private Episodio episodio = null;
    private FormEpisodio formEpisodio;

    public void exec() {
        formEpisodio.exibe();
    }

    public CDUcadastrarEpis(FormEpisodio formEpisodio, Connection conn) {
        this.formEpisodio = formEpisodio;
        this.formEpisodio.setcdu(this);
        this.conexaobd = conn;
    }

    public String getNomeSerie(int idserie) {
        // Serie serie = bd.getSerie(idserie); EM OBRAS.
        // return serie.gettitulo();
        return "Black Mirror";
    }

    public void salvarEpisodio() {
        String id = formEpisodio.getid();
        String numEP = formEpisodio.getnumEP();
        // String idserie = formEpisodio.getidserie();
        String temporada = formEpisodio.gettemporada();
        String titulo = formEpisodio.gettitulo();
        String resumo = formEpisodio.getresumo();

        episodio = new Episodio(
                Integer.parseInt(id),
                Integer.parseInt(numEP),
                Integer.parseInt(temporada),
                titulo,
                resumo);

        // bd.salvarEpisodio(episodio);
        System.out.println("Salvando no banco de dados.." + episodio);
        
        DAOepisodio dao = new DAOepisodio(conexaobd);
        dao.adiciona(episodio);
        formEpisodio.setVisible(false);
    }
}