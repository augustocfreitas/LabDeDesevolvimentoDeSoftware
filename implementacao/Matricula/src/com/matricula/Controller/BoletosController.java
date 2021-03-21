package com.matricula.Controller;

import com.matricula.Model.Boleto;
import com.matricula.Model.DAO;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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
}
