package sistemaDeMatriculas.Model;

public class Disciplina {
    private int id;
    private String nome;
    private int creditos;
    private boolean obrigatoria;

    public Disciplina(int id, String nome, int creditos, boolean obrigatoria) {
        setId(id);
        setNome(nome);
        setCreditos(creditos);
        setObrigatoria(obrigatoria);
    }

    public Disciplina(String string) {
        var strings = string.split(";");

        setId(Integer.parseInt(strings[0]));
        setNome(strings[1]);
        setCreditos(Integer.parseInt(strings[2]));
        setObrigatoria(strings[3].equals("true"));
    }

    public String toString() {
        return "" + getId() + ";" + getNome() + ";" + getCreditos();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public boolean isObrigatoria() {
        return obrigatoria;
    }

    public void setObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }
}
