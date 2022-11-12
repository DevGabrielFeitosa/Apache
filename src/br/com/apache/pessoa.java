package br.com.apache;

public class pessoa {

    @Override
    public String toString() {
        return "pessoa [nome=" + nome + ", idade=" + idade + ", email=" + email + "]";
    }

    private String nome;

    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;


}

