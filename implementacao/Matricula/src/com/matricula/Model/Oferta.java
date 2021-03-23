package com.matricula.Model;

import java.util.ArrayList;

public class Oferta {
    private int id;
    private int matriculaProfessor;
    private int idDisciplina;
    private int idCurso;
    private ArrayList<Integer> matriculasAlunos;

    public Oferta(int id, int matriculaProfessor, int idDisciplina, int idCurso) {
        setId(id);
        setMatriculaProfessor(matriculaProfessor);
        setIdDisciplina(idDisciplina);
        setIdCurso(idCurso);
        matriculasAlunos = new ArrayList<>();
    }

    public Oferta(String string) {
        var strings = string.split(";");

        setId(Integer.parseInt(strings[0]));
        setMatriculaProfessor(Integer.parseInt(strings[1]));
        setIdDisciplina(Integer.parseInt(strings[2]));
        setIdCurso(Integer.parseInt(strings[3]));
        setMatriculasAlunos(new ArrayList<>());

        for (int i = 4; i < strings.length; i++) {
            matriculasAlunos.add(Integer.parseInt(strings[i]));
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("" + getId() + ";" + getMatriculaProfessor() + ";" + getIdDisciplina() + ";" + getIdCurso() + ";");

        matriculasAlunos.forEach(aluno -> {
            stringBuffer.append("" + aluno + ";");
        });

        return stringBuffer.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatriculaProfessor() {
        return matriculaProfessor;
    }

    public void setMatriculaProfessor(int matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public ArrayList<Integer> getMatriculasAlunos() {
        return matriculasAlunos;
    }

    public void setMatriculasAlunos(ArrayList<Integer> matriculasAlunos) {
        this.matriculasAlunos = matriculasAlunos;
    }
}
