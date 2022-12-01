package domain;

import java.util.LinkedList;

public class Personagem implements OBJPOOFlix {

    private int id;
    private String nome;
    private LinkedList<Performance> perfomances;

    public Personagem(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void adperformance(Performance p) {
        perfomances.add(p);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void salvarPersonagem() {
        // String str = "insert into Personagem"
        // TODO
    }

}
