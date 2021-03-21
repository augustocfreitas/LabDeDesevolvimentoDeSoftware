package com.matricula.Controller;

import com.matricula.Model.DAO;
import com.matricula.Model.Secretaria;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class SecretariaController {
    private static ArrayList<Secretaria> secretarias = new ArrayList<>();
    private static final String filename = "secretarias.csv";

    public static boolean autenticar(int matricula, String senha) {
        AtomicBoolean auth = new AtomicBoolean(false);
        getAll();

        secretarias.forEach(secretaria -> {
            if (secretaria.getMatricula() == matricula && secretaria.getSenha().equals(senha)) {
                auth.set(true);
            }
        });

        return auth.get();
    }

    public static ArrayList<Secretaria> getAll() {
        var secretariaString = DAO.readFromFile(filename);
        secretarias = new ArrayList<>();

        if (secretariaString != null) {
            secretariaString.forEach(string -> {
                secretarias.add(new Secretaria(string));
            });
        }

        return secretarias;
    }
}
