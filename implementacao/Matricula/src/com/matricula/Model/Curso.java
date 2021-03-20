package com.matricula.Model;

public class Curso extends DAO implements ObjectWithID {
    private int id;
    private String nome;

    Curso() {
        super("curso.bin");
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
