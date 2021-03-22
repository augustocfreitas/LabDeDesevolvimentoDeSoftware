package com.matricula.Utils;

public class Session {
    private static int matricula;

    public static int getMatricula() {
        return matricula;
    }

    public static void setMatricula(int matricula) {
        Session.matricula = matricula;
    }
}
