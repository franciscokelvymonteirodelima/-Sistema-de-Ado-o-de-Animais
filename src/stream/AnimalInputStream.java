package stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AnimalInputStream extends InputStream {
    private InputStream origem;

    public AnimalInputStream(InputStream origem) {
        this.origem = origem;
    }

    @Override
    public int read() throws IOException {
        return origem.read();
    }

    public void ler() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(origem));
        String linha;
        while ((linha = reader.readLine()) != null) {
            System.out.println("Recebido: " + linha);
        }
    }
}
