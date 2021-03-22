package com.matricula.View;

import com.matricula.Controller.AlunoController;
import com.matricula.Controller.ProfessorController;
import com.matricula.Controller.SecretariaController;
import com.matricula.Utils.Session;

import java.util.Scanner;

public class LoginView {
    public static String initialize() {
        var sc = new Scanner(System.in);

        System.out.println("Digite a matricula: ");
        var matricula = Integer.parseInt(sc.nextLine());
        System.out.println("Digite a senha: ");
        var senha = sc.nextLine();

        var isProfessor = ProfessorController.autenticar(matricula, senha);
        var isAluno = AlunoController.autenticar(matricula, senha);
        var isSecretaria = SecretariaController.autenticar(matricula, senha);

        Session.setMatricula(matricula);

        if (isProfessor) {
            return "Professor";
        } else if (isAluno) {
            return "Aluno";
        } else if (isSecretaria) {
            return "Secretaria";
        }

        return null;
    }
}
