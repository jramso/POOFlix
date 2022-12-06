package domain;

/**
 * Classe para objetos do tipo Episodio, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author Josue Ramos souza
 * @version 2.0
 * @jramso
 */
public class Episodio implements OBJPOOFlix {

    private int id;
    private int numEP;
    private String titulo;
    private String resumo;
    private int temporada;

    /**
     * Metodo Construtor
     * 
     * @param id     Inteiro
     * @param numEp  Inteiro
     * @param temp   Inteiro
     * @param title  String
     * @param resumo String
     */
    public Episodio(int id, int numEP, int temp, String title, String resumo) {
        this.id = id;
        this.numEP = numEP;
        this.temporada = temp;
        this.titulo = title;
        this.resumo = resumo;
    }

    public String toString() {
        return "Episodio [id=" + id + ", numEP=" + numEP + ", titulo=" + titulo + ", resumo=" + resumo + ", temporada="
                + temporada + "]";
    }

    /**
     * Metodo para definir o id do Episodio
     * 
     * @deprecated substituida pelo constructor()
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo para definir o numero do Episodio
     * 
     * @deprecated substituida pelo constructor()
     */
    public void setNumEP(int numEP) {
        this.numEP = numEP;
    }

    /**
     * Metodo para definir o titulo do Episodio
     * 
     * @deprecated substituida pelo constructor()
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo para definir o numero da temporada do Episodio
     * 
     * @deprecated substituida pelo constructor()
     */
    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    /**
     * Metodo para retorno do Numero do Episodio
     * 
     * @return <Strong>Int</Strong> numEp
     */
    public int getNumEP() {
        return numEP;
    }

    /**
     * Metodo para retorno do ID do Episodio
     * 
     * @return <Strong>Int</Strong> id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Metodo para retorno do Titulo do Episodio
     * 
     * @return <Strong>String</Strong> titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo para retorno do Resumo do Episodio
     * 
     * @return <Strong>String</Strong> resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * Metodo para definir o resumo do Episodio
     * 
     * @deprecated substituida pelo constructor()
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * Metodo para retorno do numero da Temporada do Episodio
     * 
     * @return <Strong>int</Strong> temporada
     */
    public int getTemporada() {
        return temporada;
    }
}