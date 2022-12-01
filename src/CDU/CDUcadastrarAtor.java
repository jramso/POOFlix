package CDU;

import UI.FormAtor;
import domain.*;
import persistencia.DAOator;

public class CDUcadastrarAtor extends CDU{
    private Ator ator;
    private FormAtor formator;

    public CDUcadastrarAtor(FormAtor formator) {
        this.formator = formator;
        this.formator.setcdu(this);
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

}
