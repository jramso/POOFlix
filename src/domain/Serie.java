package domain;

/**
 * Classe para objetos do tipo Serie, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author Josue Ramos souza
 * @version 3.0
 * @jramso
 */
public class Serie implements OBJPOOFlix {
    private int id;
    private String titulo;
    private int idade;

    public Serie(int id, String titulo, Integer idade) {
        this.id = id;
        this.titulo = titulo;
        this.idade = idade;
    }

    /**
     * Metodo Constructor
     * 
     * @param id     int
     * @param titulo String
     */
    public Serie(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    // public Serie();
    /**
     * Metodo para retorno do ID da Série
     * 
     * @return <Strong>Int</Strong> id
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo para retorno do titulo da Série
     * 
     * @return <Strong>String</Strong> titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo para retorno do idade da série
     * 
     * @return <Strong>Int</Strong> idade
     */
    public int getIdade() {
        return idade;
    }

}
