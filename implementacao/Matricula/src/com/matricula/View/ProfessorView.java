package com.matricula.View;

import com.matricula.Controller.AlunoController;
import com.matricula.Controller.DisciplinaController;
import com.matricula.Controller.OfertaController;
import com.matricula.Model.Disciplina;
import com.matricula.Utils.Session;

import java.util.Scanner;

public class ProfessorView {
    private static Scanner sc = new Scanner(System.in);

    public static void listarDisciplinas() {
        OfertaController.getAll()
            .stream()
            .filter(oferta -> oferta.getMatriculaProfessor() == Session.getMatricula())
            .forEach(oferta -> {
                if (oferta.getMatriculasAlunos().size() <= 3) {
                    return;
                }

                Disciplina d = DisciplinaController.get(oferta.getIdDisciplina());

                System.out.println("Disciplina: " + d.getNome());
                oferta.getMatriculasAlunos().forEach(matricula -> {
                    var aluno = AlunoController.get(matricula);
                    System.out.println("Matricula: " + aluno.getMatricula() + " | Nome: " + aluno.getNome());
                });
                System.out.println("\n");
            });
    }

    public static void initialize() {
        while(true) {
            System.out.println("Escolha uma opção");
            System.out.println("1. Listar Disciplinas e Alunos");

            var option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    listarDisciplinas();
                    break;
            }
        }
    }
}
