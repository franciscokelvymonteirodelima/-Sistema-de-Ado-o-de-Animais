package model;

public class Cachorro extends Animal {
    private boolean vacinado;
    private boolean castrado;

    public Cachorro(String nome, int idade, String raca, boolean vacinado) {
        super(nome, idade, raca);
        this.vacinado = vacinado;
        this.castrado = castrado;
    }


    public boolean isCastrado() {
        return castrado;
    }

    @Override
    public String toString() {
        return "Cachorro: " + super.toString() + ", vacinado=" + vacinado;
    }
}
