package com.matricula.View;

import com.matricula.Controller.*;

import java.time.Instant;
import java.util.Scanner;

public class SecretariaView {
    private static Scanner sc = new Scanner(System.in);

    static void cadastrarProfessor() {
        var matricula = (int)Instant.now().getEpochSecond();

        System.out.println("Digite a senha do professor");
        var senha = sc.nextLine();

        System.out.println("Digite o RG do professor");
        var rg = sc.nextLine();

        System.out.println("Digite o nome do professor");
        var nome = sc.nextLine();

        ProfessorController.create(matricula, senha, rg, nome);
        System.out.println("Cadastro realizado!");
    }

    static void cadastrarAluno() {
        var matricula = (int)Instant.now().getEpochSecond();

        System.out.println("Digite a senha do aluno");
        var senha = sc.nextLine();

        System.out.println("Digite o RG do aluno");
        var rg = sc.nextLine();

        System.out.println("Digite o nome do aluno");
        var nome = sc.nextLine();

        AlunoController.create(matricula, senha, rg, nome);
        System.out.println("Cadastro realizado!");
    }

    static void cadastrarCurso() {
        var id = (int)Instant.now().getEpochSecond();

        System.out.println("Digite o nome do curso");
        var nome = sc.nextLine();

        CursoController.create(id, nome);
        System.out.println("Cadastro realizado!");
    }

    static void cadastrarDisciplina() {
        var id = (int)Instant.now().getEpochSecond();

        System.out.println("Digite o nome da disciplina");
        var nome = sc.nextLine();

        System.out.println("Digite os creditos da disciplina");
        var creditos = Integer.parseInt(sc.nextLine());

        System.out.println("É obrigatória? (s/n)");
        var obrigatoria = sc.nextLine().equals("s");

        DisciplinaController.create(id, nome, creditos, obrigatoria);
    }

    static void gerarCurriculo() {
        var id = (int)Instant.now().getEpochSecond();
        var disciplinas = DisciplinaController.getAll();
        var professores = ProfessorController.getAll();
        var cursos = CursoController.getAll();

        if (disciplinas.size() == 0 || professores.size() == 0) {
            return;
        }

        System.out.println("Professores disponíveis para criar oferta:");
        professores.forEach(professor -> {
            System.out.println("Matrícula: " + professor.getMatricula() + " | Nome: " + professor.getNome());
        });
        System.out.println("Digite a matricula do professor");
        var matriculaProfessor = Integer.parseInt(sc.nextLine());

        System.out.println("Disciplinas disponíveis para criar oferta:");
        disciplinas.forEach(disciplina -> {
            System.out.println("ID: " + disciplina.getId() + " | Nome: " + disciplina.getNome() + " | Créditos: " + disciplina.getCreditos());
        });
        System.out.println("Digite o ID da disciplina");
        var idDisciplina = Integer.parseInt(sc.nextLine());

        System.out.println("Cursos disponíveis para criar oferta:");
        cursos.forEach(curso -> {
            System.out.println("ID: " + curso.getId() + " | Nome: " + curso.getNome());
        });
        System.out.println("Digite o ID do curso");
        var idCurso = Integer.parseInt(sc.nextLine());

        OfertaController.create(id, matriculaProfessor, idDisciplina, idCurso);
    }

    static void gerarBoletos() {
        BoletosController.generate();
    }

    public static void initialize() {
        while(true) {
            System.out.println("Escolha uma opção");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Cadastrar Curso");
            System.out.println("4. Cadastrar Disciplina");
            System.out.println("5. Gerar Curriculo");
            System.out.println("6. Gerar Boletos");

            var option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    cadastrarAluno();
                    break;
                case 3:
                    cadastrarCurso();
                    break;
                case 4:
                    cadastrarDisciplina();
                    break;
                case 5:
                    gerarCurriculo();
                    break;
                case 6:
                    gerarBoletos();
                    break;
            }
        }
    }
}
