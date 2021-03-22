package sistemaDeMatriculas.Model;

public class Curso {
    private int id;
    private String nome;

    public Curso(int id, String nome) {
        setId(id);
        setNome(nome);
    }

    public Curso(String string) {
        var strings = string.split(";");

        setId(Integer.parseInt(strings[0]));
        setNome(strings[1]);
    }

    public String toString() {
        return "" + getId() + ";" + getNome();
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
}
