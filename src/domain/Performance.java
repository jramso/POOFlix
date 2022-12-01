package domain;

public class Performance implements OBJPOOFlix {
    private Episodio episodio;
    private Personagem personagem;
    private Ator ator;

    public Performance(Episodio idep, Personagem idepers, Ator ator) {
        this.episodio = idep;
        this.personagem = idepers;
        this.ator = ator;

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
