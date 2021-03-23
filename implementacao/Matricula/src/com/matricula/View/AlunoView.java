package com.matricula.View;

import com.matricula.Controller.BoletosController;
import com.matricula.Controller.DisciplinaController;
import com.matricula.Controller.OfertaController;
import com.matricula.Controller.ProfessorController;
import com.matricula.Utils.Session;

import java.util.Scanner;

public class AlunoView {
    private static Scanner sc = new Scanner(System.in);
    private static int countObrigatorias = 0;
    private static int countOptativas = 0;

    private static void updateCounts() {
        var ofertas = OfertaController.getAll();

        if (ofertas.size() == 0) {
            return;
        }

        ofertas
                .stream()
                .filter(oferta -> oferta.getMatriculasAlunos().contains(Session.getMatricula()))
                .forEach(oferta -> {
                    var disciplina = DisciplinaController.get(oferta.getIdDisciplina());

                    if (disciplina.isObrigatoria()) {
                        countObrigatorias++;
                    } else {
                        countOptativas++;
                    }
                });
    }

    private static void matricularEmDisciplina() {
        var ofertas = OfertaController.getAll();

        if (ofertas.size() == 0) {
            return;
        }

        System.out.println("Ofertas de disciplinas disponíveis para matrícula:");
        ofertas
            .stream()
            .filter(oferta -> !oferta.getMatriculasAlunos().contains(Session.getMatricula()))
            .filter(oferta -> {
                var disciplina = DisciplinaController.get(oferta.getIdDisciplina());

                if (disciplina.isObrigatoria() && countObrigatorias == 4) {
                    return false;
                }

                if (!disciplina.isObrigatoria() && countOptativas == 2) {
                    return false;
                }

                return true;
            })
            .forEach(oferta -> {
                var professor = ProfessorController.get(oferta.getMatriculaProfessor());
                var disciplina = DisciplinaController.get(oferta.getIdDisciplina());

                System.out.println("ID:" + oferta.getId() + "| Disciplina:" + disciplina.getNome() + " | Professor: " + professor.getNome() + " | Obrigatória: " + (disciplina.isObrigatoria() ? "sim" : "não"));
            });
        System.out.println("Digite o id da oferta");
        var id = Integer.parseInt(sc.nextLine());

        OfertaController.addAluno(id, Session.getMatricula());
        System.out.println("Matriculado com sucesso!");
    }

    private static void cancelarMatricula() {
        var ofertas = OfertaController.getAll();

        if (ofertas.size() == 0) {
            return;
        }

        System.out.println("Ofertas de disciplinas em que você está matriculado:");
        ofertas
                .stream()
                .filter(oferta -> oferta.getMatriculasAlunos().contains(Session.getMatricula()))
                .forEach(oferta -> {
                    if (oferta.getMatriculasAlunos().size() >= 60) {
                        return;
                    }

                    var professor = ProfessorController.get(oferta.getMatriculaProfessor());
                    var disciplina = DisciplinaController.get(oferta.getIdDisciplina());

                    System.out.println("ID:" + oferta.getId() + "| Disciplina: " + disciplina.getNome() + " | Professor: " + professor.getNome() + " | Obrigatória: " + (disciplina.isObrigatoria() ? "sim" : "não"));
                });
        System.out.println("Digite o id da oferta");
        var id = Integer.parseInt(sc.nextLine());

        OfertaController.removeAluno(id, Session.getMatricula());
        System.out.println("Matricula cancelada com sucesso!");
    }

    private static void visualizarBoleto() {
        var boleto = BoletosController.get(Session.getMatricula());

        if (boleto != null) {
            System.out.println("Número do boleto: " + boleto.getCodigo());
        } else {
            System.out.println("Boleto não gerado");
        }

    }

    public static void initialize() {
        while(true) {
            System.out.println("Escolha uma opção");
            System.out.println("1. Matricular em Disciplina");
            System.out.println("2. Cancelar Matrícula");
            System.out.println("3. Visualizar Boleto");

            var option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    matricularEmDisciplina();
                    break;
                case 2:
                    cancelarMatricula();
                    break;
                case 3:
                    visualizarBoleto();
            }
        }
    }
}
