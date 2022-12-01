package domain;


public class Ator implements OBJPOOFlix {
//doc

    private int id;
    private String nome;
    private String nacionalidade;

    public Ator(int id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade=nacionalidade;
    }

    public Ator() {
        // Using hibernate Library
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getId() {
        return this.id;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    // Setters
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

}