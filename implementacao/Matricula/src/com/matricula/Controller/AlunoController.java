package com.matricula.Controller;

import com.matricula.Model.Aluno;
import com.matricula.Model.DAO;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class AlunoController {
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static final String filename = "alunos.csv";

    public static boolean autenticar(int matricula, String senha) {
        AtomicBoolean auth = new AtomicBoolean(false);
        getAll();

        alunos.forEach(aluno -> {
            if (aluno.getMatricula() == matricula && aluno.getSenha().equals(senha)) {
                auth.set(true);
            }
        });

        return auth.get();
    }

    public static void create(int matricula, String senha, String rg, String nome) {
        var aluno = new Aluno(matricula, senha, rg, nome);
        getAll();
        alunos.add(aluno);
        DAO.writeToFile(filename, alunos);
    }

    public static ArrayList<Aluno> getAll() {
        var alunoString = DAO.readFromFile(filename);
        alunos = new ArrayList<>();

        if (alunoString != null) {
            alunoString.forEach(string -> {
                alunos.add(new Aluno(string));
            });
        }

        return alunos;
    }
}
