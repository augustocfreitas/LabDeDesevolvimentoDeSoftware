package sistemaDeMatriculas.Model;

import java.util.ArrayList;

public class Oferta extends DAO implements ObjectWithID {
    private int id;
    private ArrayList<Aluno> alunos;
    private Professor professor;
    private Disciplina disciplina;
    private Curso curso;

    Oferta() {
        super("oferta.bin");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
