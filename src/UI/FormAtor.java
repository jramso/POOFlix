package UI;

import java.io.Console;

import CDU.CDUcadastrarAtor;

public class FormAtor implements Form {

    private String id;
    private String nome;
    private String nacionalidade;
    private String performance;

    FormPerformance formPf;

    private CDUcadastrarAtor cduca;

    public void setcdu(CDUcadastrarAtor cduca) {
        this.cduca = cduca;
    }

    public void exibe() {

        Console c = System.console();
        boolean termina = false;
        String continuar;
        boolean leserie = true;
        boolean leepisodio = false;
        String nomeAtor = null;

        System.out.println("CADASTRANDO UM ATOR\n");

        while (!termina) {
            if (leserie) {
                id = c.readLine("Qual Ator?(id): ");
                nome = c.readLine("Qual o nome do Ator?");
                nacionalidade = c.readLine("Qual a Nacionalidade?");
                leepisodio = nome != null && id != null && nacionalidade != null;
                nomeAtor = nome;

                leepisodio = nomeAtor != null;

                if (nomeAtor == null) {
                    System.err.println("!!Ator inválido !!");
                    leserie = true;
                    leepisodio = false;
                    termina = false;
                }
            }

            if (leepisodio) {

                formPf.setIdAtor(Integer.parseInt(id));
                formPf.exibe();
                continuar = c.readLine("(S)erie (E)pisodio (T)erminar): ");

                if (continuar.toLowerCase().equals("s")) {
                    leserie = true;
                    leepisodio = false;
                    termina = false;
                } else if (continuar.toLowerCase().equals("e")) {
                    // salvar episodio no banco de dados.
                    cduca.salvarAtor(); // EM OBRAS.
                    leserie = false;
                    leepisodio = true;
                    termina = false;
                } else
                    termina = true;
            } // if(episodio)
        } // while ..

    }// Fim EXIBE()

}
