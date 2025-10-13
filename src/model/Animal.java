package model;

import java.io.Serializable;

public class Animal implements Serializable, Adotavel {
    private String nome;
    private int idade;
    private String raca;
    private int id;

    public Animal(String nome, int idade, String raca) {
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
    public void solicitarAdocao() {
        System.out.println(nome + " foi solicitado para adoção.");
    }

    @Override
    public void confirmarAdocao() {
        System.out.println("Adoção de " + nome + " confirmada!");
    }

    @Override
    public String toString() {
        return "Animal{" + "nome='" + nome + '\'' + ", idade=" + idade + ", raca='" + raca + '\'' + '}';
    }
}

/*
 *  como ele esta implementando o serializable, não seria necessario implementar a interface Serializable?
 *  rever essa questao do metodo pois ele se encontra vazio.
 * 
 * implementar mais tipos de animais. ex.: pasarros, coelhos, etc.
 */