package domain;

/**
 * Classe para objetos do tipo Atores, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author Josue Ramos souza
 * @version 3.4
 * @jramso
 */
public class Ator implements OBJPOOFlix {
    // doc

    private int id;
    private String nome;
    private String nacionalidade;

    public Ator(int id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public Ator() {
        // Using hibernate Library
    }

    // Getters

    /**
     * Metodo para retorno do Nome do ator
     * 
     * @return <Strong>String</Strong> nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo para retorno do ID do ator
     * 
     * @return <Strong>Int</Strong> id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Metodo para retorno da Nacionalidade do ator
     * 
     * @return <Strong>String</Strong> nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * Metodo para definir a nacionalidade do ator
     * 
     * @deprecated substituida pelo constructor()
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

}