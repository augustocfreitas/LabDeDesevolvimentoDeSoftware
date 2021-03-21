package com.matricula.Model;

public class Secretaria extends Usuario {
    public Secretaria(int matricula, String senha, String rg, String nome) {
        super(matricula, senha, rg, nome);
    }

    public Secretaria(String string) {
        super(string);
    }
}
