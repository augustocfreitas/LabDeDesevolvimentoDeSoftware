package sistemaDeMatriculas.Model;

public class Usuario {
    private int matricula;
    private String senha;
    private String rg;
    private String nome;

    public Usuario() {}

    public Usuario(int matricula, String senha, String rg, String nome) {
        setMatricula(matricula);
        setSenha(senha);
        setRg(rg);
        setNome(nome);
    }

    public Usuario(String string) {
        var strings = string.split(";");
        setMatricula(Integer.parseInt(strings[0]));
        setSenha(strings[1]);
        setRg(strings[2]);
        setNome(strings[3]);
    }

    public String toString() {
        return "" + getMatricula() + ";" + getSenha() + ";" + getRg() + ";" + getNome();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
