package com.matricula;

import com.matricula.View.LoginView;
import com.matricula.View.AlunoView;
import com.matricula.View.ProfessorView;
import com.matricula.View.SecretariaView;

public class Main {

    public static void main(String[] args) {
        var role = LoginView.initialize();

        switch (role) {
            case "Professor":
                ProfessorView.initialize();
                break;
            case "Aluno":
                AlunoView.initialize();
                break;
            case "Secretaria":
                SecretariaView.initialize();
                break;
            default:
                System.out.println("Login inválido");
        }
    }
}
