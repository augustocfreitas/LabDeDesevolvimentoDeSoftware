package com.matricula.Model;

public class Boleto {
    private int matriculaAluno;
    private int codigo;

    public Boleto(int id, int codigo) {
        setMatriculaAluno(id);
        setCodigo(codigo);
    }

    public Boleto(String string) {
        var strings = string.split(";");

        setMatriculaAluno(Integer.parseInt(strings[0]));
        setCodigo(Integer.parseInt(strings[1]));
    }

    public String toString() {
        return "" + getMatriculaAluno() + ";" + getCodigo();
    }

    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
