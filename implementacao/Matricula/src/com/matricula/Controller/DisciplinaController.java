package com.matricula.Controller;

import com.matricula.Model.Curso;
import com.matricula.Model.DAO;
import com.matricula.Model.Disciplina;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DisciplinaController {
    private static ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private static final String filename = "disciplinas.csv";

    public static void create(int id, String nome, int creditos, boolean obrigatoria) {
        var disciplina = new Disciplina(id, nome, creditos, obrigatoria);
        getAll();
        disciplinas.add(disciplina);
        DAO.writeToFile(filename, disciplinas);
    }

    public static ArrayList<Disciplina> getAll() {
        var string = DAO.readFromFile(filename);
        disciplinas = new ArrayList<>();

        if (string != null) {
            string.forEach(element -> {
                disciplinas.add(new Disciplina(element));
            });
        }

        return disciplinas;
    }

    public static Disciplina get(int id) {
        getAll();

        return disciplinas
                .stream()
                .filter(disciplina -> disciplina.getId() == id)
                .collect(Collectors.toList()).get(0);
    }
}
