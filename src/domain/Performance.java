package domain;

public class Performance implements OBJPOOFlix {
    private Episodio episodio;
    private Personagem personagem;
    private Ator ator;

    private int idEpisodio;
    private int idPers;
    private int idAtor;
    private int id;

    public int getIdEpisodio() {
        return idEpisodio;
    }

    public int getIdPers() {
        return idPers;
    }

    public int getIdAtor() {
        return idAtor;
    }

    public int getId() {
        return id;
    }

    public Performance(Episodio idep, Personagem idepers, Ator ator) {
        this.episodio = idep;
        this.personagem = idepers;
        this.ator = ator;

    }

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

    public Episodio getidep() {
        return episodio;
    }

    public Personagem getidperson() {
        return personagem;
    }

    public Ator getator() {
        return ator;
    }

}
