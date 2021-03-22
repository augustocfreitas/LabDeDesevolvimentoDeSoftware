package com.matricula.View;

import com.matricula.Controller.AlunoController;
import com.matricula.Controller.OfertaController;
import com.matricula.Utils.Session;

import java.util.Scanner;

public class ProfessorView {
    private static Scanner sc = new Scanner(System.in);

    public static void listarDisciplinas() {
        OfertaController.getAll()
            .stream()
            .filter(oferta -> oferta.getMatriculaProfessor() == Session.getMatricula())
            .forEach(oferta -> {
                oferta.getMatriculasAlunos().forEach(matricula -> {
                    var aluno = AlunoController.get(matricula);
                    System.out.println("Matricula: " + aluno.getMatricula() + " | Nome: " + aluno.getNome());
                });
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
