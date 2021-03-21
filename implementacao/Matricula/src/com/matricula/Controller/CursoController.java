package com.matricula.Controller;

import com.matricula.Model.Curso;
import com.matricula.Model.DAO;

import java.util.ArrayList;

public class CursoController {
    private static ArrayList<Curso> cursos = new ArrayList<>();
    private static final String filename = "cursos.csv";

    public static void create(int id, String nome) {
        var curso = new Curso(id, nome);
        getAll();
        cursos.add(curso);
        DAO.writeToFile(filename, cursos);
    }

    public static ArrayList<Curso> getAll() {
        var string = DAO.readFromFile(filename);
        cursos = new ArrayList<>();

        if (string != null) {
            string.forEach(element -> {
                cursos.add(new Curso(element));
            });
        }

        return cursos;
    }
}
