package CDU;

import domain.*;
import persistencia.*;

import java.sql.Connection;

import UI.FormSerie2;

public class CDUcadastrarSerie extends CDU {
    private Serie serie;
    private FormSerie2 formSerie;

    public CDUcadastrarSerie(FormSerie2 formSerie, Connection conexaobd) {
        this.formSerie = formSerie;
        this.formSerie.setcdu(this);
        this.conexaobd = conexaobd;
    }

    public void exec() {
        formSerie.exibe();
    }

    public void salvarSerie() {
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        int idade = Integer.valueOf(formSerie.getidademin());

        serie = new Serie(Integer.parseInt(id), titulo);

        System.out.println("Salvando no banco de dados.." + serie);
        DAOSerie dao = new DAOSerie(conexaobd);
        dao.adiciona(serie);

    }
}