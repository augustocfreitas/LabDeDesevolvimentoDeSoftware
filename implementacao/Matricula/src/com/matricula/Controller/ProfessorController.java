package com.matricula.Controller;

import com.matricula.Model.DAO;
import com.matricula.Model.Professor;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProfessorController {
    private static ArrayList<Professor> professores = new ArrayList<>();
    private static final String filename = "professores.csv";

    public static boolean autenticar(int matricula, String senha) {
        AtomicBoolean auth = new AtomicBoolean(false);
        getAll();

        professores.forEach(professor -> {
            if (professor.getMatricula() == matricula && professor.getSenha().equals(senha)) {
                auth.set(true);
            }
        });

        return auth.get();
    }

    public static void create(int matricula, String senha, String rg, String nome) {
        var professor = new Professor(matricula, senha, rg, nome);
        getAll();
        professores.add(professor);
        DAO.writeToFile(filename, professores);
    }

    public static ArrayList<Professor> getAll() {
        var professoresString = DAO.readFromFile(filename);
        professores = new ArrayList<>();

        if (professoresString != null) {
            professoresString.forEach(professorString -> {
                professores.add(new Professor(professorString));
            });
        }

        return professores;
    }
}
