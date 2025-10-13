package model;

import java.io.Serializable;

public class Passaro implements Serializable {
    private String nome;
    private int idade;
    private String raca;
    private int id;

    public Passaro(String nome, int idade, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.id = 0;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getRaca() { return raca; }
    public int getId() { return id; }

    @Override
    public String toString() {
        return "Passaro{" + "nome='" + nome + '\'' + ", idade=" + idade + ", raca='" + raca + '\'' + '}';
    }
    
}
