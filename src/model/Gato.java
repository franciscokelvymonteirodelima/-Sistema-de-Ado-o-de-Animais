package model;

public class Gato extends Animal {
    private boolean castrado;
    private boolean vacinado;

    public Gato(String nome, int idade, String raca, boolean castrado) {
        super(nome, idade, raca);
        this.castrado = castrado;
        this.vacinado = vacinado;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public boolean isCastrado() {
        return castrado;
    }

    @Override
    public String toString() {
        return "Gato: " + super.toString() + ", castrado=" + castrado;
    }
}
