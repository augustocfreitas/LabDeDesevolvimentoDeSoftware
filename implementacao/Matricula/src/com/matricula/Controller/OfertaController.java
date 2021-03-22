package com.matricula.Controller;

import com.matricula.Model.Curso;
import com.matricula.Model.DAO;
import com.matricula.Model.Oferta;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OfertaController {
    private static ArrayList<Oferta> ofertas = new ArrayList<>();
    private static final String filename = "ofertas.csv";

    public static void create(int id, int matriculaProfessor, int idDisciplina, int idCurso) {
        var oferta = new Oferta(id, matriculaProfessor, idDisciplina, idCurso);
        getAll();
        ofertas.add(oferta);
        DAO.writeToFile(filename, ofertas);
    }

    public static ArrayList<Oferta> getAll() {
        var string = DAO.readFromFile(filename);
        ofertas = new ArrayList<>();

        if (string != null) {
            string.forEach(element -> {
                ofertas.add(new Oferta(element));
            });
        }

        return ofertas;
    }

    public static Oferta get(int id) {
        getAll();

        return ofertas
                .stream()
                .filter(oferta -> oferta.getId() == id)
                .collect(Collectors.toList()).get(0);
    }

    public static void addAluno(int id, int matricula) {
        get(id).getMatriculasAlunos().add(matricula);
        DAO.writeToFile(filename, ofertas);
    }

    public static void removeAluno(int id, int matricula) {
        get(id).getMatriculasAlunos().remove(Integer.valueOf(matricula));
        DAO.writeToFile(filename, ofertas);
    }
}
