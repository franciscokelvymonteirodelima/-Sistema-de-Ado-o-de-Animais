package stream;

import model.Animal;
import java.io.IOException;
import java.io.OutputStream;

public class AnimalOutputStream extends OutputStream {
    private OutputStream destino;
    private Animal[] animais;
    private int numeroObjetosParaEnviar;
    private String[] atributosParaEnviar;
    private int numBytesPorAtributo;

    public AnimalOutputStream(OutputStream destino, Animal[] animais, int numeroObjetosParaEnviar, String[] atributosParaEnviar, int numBytesPorAtributo) {
        this.destino = destino;
        this.animais = animais;
        this.numeroObjetosParaEnviar = numeroObjetosParaEnviar;
        this.atributosParaEnviar = atributosParaEnviar;
        this.numBytesPorAtributo = numBytesPorAtributo;
    }

    @Override
    public void write(int b) throws IOException {
        destino.write(b);
    }

    public void enviar() throws IOException {
        for (Animal a : animais) {
            String dados = a.getNome() + "," + a.getIdade() + "," + a.getRaca() + "\n";
            destino.write(dados.getBytes());
        }
    }
}
