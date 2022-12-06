package domain;

import java.util.LinkedList;

/**
 * Classe para objetos do tipo Personagens, onde serão contidos, valores e
 * métodos
 * para o mesmo.
 * 
 * @author Josue Ramos souza
 * @version 3.0
 * @jramso
 */
public class Personagem implements OBJPOOFlix {

    private int id;
    private String nome;
    private LinkedList<Performance> perfomances;

    /**
     * Metodo Constructor
     * 
     * @param id   int (id do Personagem)
     * @param nome String (nome do Personagem)
     */
    public Personagem(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void adperformance(Performance p) {
        perfomances.add(p);
    }

    /**
     * Metodo para retorno do ID do Personagem
     * 
     * @return <Strong>Int</Strong> id
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo para retorno do Nome do Personagem
     * 
     * @return <Strong>String</Strong> nome
     */
    public String getNome() {
        return nome;
    }

}
