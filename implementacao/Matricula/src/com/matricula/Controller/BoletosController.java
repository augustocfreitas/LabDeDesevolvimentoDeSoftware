package com.matricula.Controller;

import com.matricula.Model.Boleto;
import com.matricula.Model.Curso;
import com.matricula.Model.DAO;
import com.matricula.Model.Oferta;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class BoletosController {
    private static ArrayList<Boleto> boletos = new ArrayList<>();
    private static final String filename = "boletos.csv";

    public static void generate() {
        var alunos = AlunoController.getAll();
        boletos = new ArrayList<>();

        alunos.forEach(aluno -> {
            boletos.add(new Boleto(aluno.getMatricula(), ThreadLocalRandom.current().nextInt(0, 100000)));
        });

        DAO.writeToFile(filename, boletos);
    }

    public static ArrayList<Boleto> getAll() {
        var string = DAO.readFromFile(filename);
        boletos = new ArrayList<>();

        if (string != null) {
            string.forEach(element -> {
                boletos.add(new Boleto(element));
            });
        }

        return boletos;
    }

    public static Boleto get(int matriculaAluno) {
        getAll();

        return boletos
                .stream()
                .filter(boleto -> boleto.getMatriculaAluno() == matriculaAluno)
                .collect(Collectors.toList())
                .get(0);
    }
}
