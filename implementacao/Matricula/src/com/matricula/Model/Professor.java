package com.matricula.Model;

import java.io.FileWriter;

public class Professor extends Usuario {
    public Professor(int matricula, String senha, String rg, String nome) {
        super(matricula, senha, rg, nome);
    }

    public Professor(String string) {
        super(string);
    }
}
