package domain;

public class Episodio implements OBJPOOFlix {

    private int id;
    private int numEP;
    private String titulo;
    private String resumo;
    private int temporada;

    public Episodio(int id, int numEP, int temp, String title, String resumo) {
        this.id = id;
        this.numEP = numEP;
        this.temporada = temp;
        this.titulo = title;
        this.resumo=resumo;
    }

    public String toString() {
        return "Episodio [id=" + id + ", numEP=" + numEP + ", titulo=" + titulo + ", resumo=" + resumo + ", temporada="
                + temporada + "]";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumEP(int numEP) {
        this.numEP = numEP;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getNumEP() {
        return numEP;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getTemporada() {
        return temporada;
    }
    // connect JPA
}