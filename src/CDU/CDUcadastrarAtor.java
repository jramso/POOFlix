package CDU;

import UI.FormAtor;
import domain.*;
import persistencia.DAOator;
import java.sql.Connection;

public class CDUcadastrarAtor extends CDU {
    private Ator ator;
    private FormAtor formator;

    public CDUcadastrarAtor(FormAtor formator, Connection conn) {
        this.formator = formator;
        this.formator.setcdu(this);
        this.conexaobd = conn;
    }

    public void exec() {
        formator.exibe();
    }

    // TOdo
    public void salvarAtor() {
        String id = formator.getId();
        String nome = formator.getNome();
        String nacionalidade = formator.getNacionalidade();

        ator = new Ator(Integer.parseInt(id), nome, nacionalidade);

        System.out.println("Salvando no banco de dados.." + ator);
        DAOator dao = new DAOator(conexaobd);
        dao.adiciona(ator);
    }

    public void atualizarAtor() {
        int id = Integer.parseInt(formator.getId());
        String nome = formator.getNome();
        String nacionalidade = formator.getNacionalidade();

        ator = new Ator(id, nome, nacionalidade);

        System.out.println("Atualizando no banco de dados.." + ator);
        DAOator dao = new DAOator(conexaobd);
        dao.atualiza(ator);
        formator.setVisible(false);

    }

    public void deletarAtor() {
        int id = Integer.parseInt(formator.getId());
        String nome = formator.getNome();
        String nacionalidade = formator.getNacionalidade();


        ator = new Ator(id, nome, nacionalidade);

        System.out.println("Atualizando no banco de dados.." + ator);
        DAOator dao = new DAOator(conexaobd);
        dao.deleta(ator);
        formator.setVisible(false);

    }

}
