package UI;

import java.io.Console;

import CDU.CDUcadastrarPf;

public class FormPerformance extends Form {
    private int idPf;
    private int idAtor = -1;
    private int idPers;
    private CDUcadastrarPf cduPf;

    public void setcdu(CDUcadastrarPf cduPf) {
        this.cduPf = cduPf;
    }

    public void setIdPf(int idPf) {
        this.idPf = idPf;
    }

    public void setIdAtor(int idAtor) {
        this.idAtor = idAtor;
    }

    public void setIdPers(int idPers) {
        this.idPers = idPers;
    }

    public int getIdAtor() {
        return idAtor;
    }

    public int getIdPers() {
        return idPers;
    }

    public void exibe() {
        Console c = System.console();
        boolean termina = false;
        String continuar;
        boolean leserie = true;
        boolean leepisodio = false;
        String codAtor = null;

        System.out.println("CADASTRANDO PERFORMANCE\n");

        while (!termina) {
            if (leserie) {
                if (idAtor == -1) {
                    idAtor = Integer.parseInt(c.readLine("Qual Ator?(id): "));
                    // FIX checar se existe o ator

                } else {
                    idPers = Integer.parseInt(c.readLine("Qual o Personagem?(id)"));
                    // FIX checar se existe o personagem;
                }
                idPf = Integer.parseInt(c.readLine("Qual o id da performance?(id)"));
                codAtor = String.valueOf(idAtor);
                leepisodio = codAtor != null;

                if (codAtor == null) {
                    System.err.println("!!série não existe !!");
                    leserie = true;
                    leepisodio = false;
                    termina = false;
                }
            }

        }

    }

}
