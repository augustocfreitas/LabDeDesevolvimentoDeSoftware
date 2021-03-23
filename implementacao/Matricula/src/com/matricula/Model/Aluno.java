package com.matricula.Model;

public class Aluno extends Usuario {
    public Aluno(int matricula, String senha, String rg, String nome) {
        super(matricula, senha, rg, nome);
    }

    public Aluno(String string) {
        super(string);
    }
}
