package UI;

import javax.annotation.processing.Generated;

import CDU.CDUcadastrarAtor;

/**
 * Classe para Formularios do tipo Atores,
 * onde serão contidos valores e metodos para o mesmo.
 * @author Josué Ramos Souza
 * @version 2.0
 * @jramso
 * 
 */

public class FormAtor implements Form {

    private String id;
    private String nome;
    private String nacionalidade;
    private String performance;

    FormPerformance formPf;

    private CDUcadastrarAtor cduca;

    /**Metodo para indicar o Controlador de caso de uso <Strong>(CDU)</Strong> do Ator*/
    public void setcdu(CDUcadastrarAtor cduca) {
        this.cduca = cduca;
    }

    @Override
    public void exibe() {

        Console c = new Console();
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
                continuar = c.readLine("(A)tor (P)erformance (T)erminar): ");

                if (continuar.toLowerCase().equals("a")) {
                    leserie = true;
                    leepisodio = false;
                    termina = false;
                } else if (continuar.toLowerCase().equals("P")) {
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
    /**
     * Metodo para retorno do Id
     * @return <Strong>String</Strong> id
     */
    public String getId() {
        return id;
    }
    /**
     * Metodo para retorno do Nome
     * @return <Strong>String</Strong> nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo para retorno da Nacionalidade
     * @return <Strong>String</Strong> nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

}
