package domain;

/**
 * Classe para objetos do tipo Performance, onde serão contidos, valores e
 * métodos
 * para o mesmo.
 * 
 * @author Josue Ramos souza
 * @version 3.1
 * @jramso
 */
public class Performance implements OBJPOOFlix {
    private Episodio episodio;
    private Personagem personagem;
    private Ator ator;

    private int idEpisodio;
    private int idPers;
    private int idAtor;
    private int id;

    /**
     * Metodo para retorno do id do Episodio da PERFORMANCE
     * 
     * @return <Strong>int</Strong> idEpisodio
     */
    public int getIdEpisodio() {
        return idEpisodio;
    }

    /**
     * Metodo para retorno do id do Personagem da PERFORMANCE
     * 
     * @return <Strong>int</Strong> idPers
     */
    public int getIdPers() {
        return idPers;
    }

    /**
     * Metodo para retorno do id do Ator da PERFORMANCE
     * 
     * @return <Strong>int</Strong> idAtor
     */
    public int getIdAtor() {
        return idAtor;
    }

    /**
     * Metodo para retorno do id da PERFORMANCE
     * 
     * @return <Strong>int</Strong> id
     */
    public int getId() {
        return id;
    }

    public Performance(Episodio idep, Personagem idepers, Ator ator) {
        this.episodio = idep;
        this.personagem = idepers;
        this.ator = ator;

    }

    /**
     * Metodo Construtor
     * 
     * @param id      Inteiro
     * @param idep    Inteiro
     * @param idepers Inteiro
     * @param ator    Inteiro
     */
    public Performance(int id, int idep, int idepers, int ator) {
        this.idEpisodio = idep;
        this.idAtor = ator;
        this.idPers = idepers;
        this.id = id;
    }

    public void setEpisodio(Episodio episodio) {
        this.episodio = episodio;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    /**
     * Metodo para retorno do Episodio
     * 
     * @return <Strong>Episodio</Strong> id
     */
    public Episodio getidep() {
        return episodio;
    }

    /**
     * Metodo para retorno do Personagem
     * 
     * @return <Strong>Personagem</Strong> personagem
     */
    public Personagem getidperson() {
        return personagem;
    }

    /**
     * Metodo para retorno do Ator
     * 
     * @return <Strong>Ator</Strong> ator
     */
    public Ator getator() {
        return ator;
    }

}
