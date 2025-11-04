package model;

import java.util.ArrayList;
import java.util.List;

public class Abrigo {
    private String nome;
    private List<Animal> animais;
    private int id;
    private String endereco;
    private String telefone;
    private String email;

    public Abrigo(String nome) {
        this.nome = nome;
        this.animais = new ArrayList<>();
        this.id = 0; 
        this.endereco = ""; 
        this.telefone = "";
        this.email = ""; 
    }
    
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    /*
     * como poderia ser feito a questao do set id, endereco, telefone, email?
     * devemos ter um cliente admin para setar esses valores? ou um servidor para setar esses valores?
    */

    public void adicionarAnimal(Animal a) {
        animais.add(a);
    }

    public List<Animal> getAnimais() {
        return animais;
    }
}

/*
 *  recursos adicionais: id do abrigo, dono do abrigo, endereço do abrigo, 
 * telefone do abrigo, email do abrigo.
 */