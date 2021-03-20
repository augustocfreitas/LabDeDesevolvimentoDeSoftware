package com.matricula.Model;

public class Disciplina extends DAO implements ObjectWithID {
    private int id;
    private String nome;

    Disciplina() {
        super("disciplina.bin");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
