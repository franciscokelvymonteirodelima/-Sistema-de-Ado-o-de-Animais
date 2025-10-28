package stream;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.Animal;

public class AnimalInputStream extends InputStream {
    private InputStream origem;

    public AnimalInputStream(InputStream origem) {
        this.origem = origem;
    }

    @Override
    public int read() throws IOException {
        return origem.read();
    }

    // Exemplo de como deveria ser a lógica de leitura (simplificada)
    public Animal lerProximoAnimal() throws IOException {
        DataInputStream dis = new DataInputStream(origem);
        
        try {
            // 1. Desempacotar Nome
            int nomeLen = dis.readInt();
            byte[] nomeBytes = new byte[nomeLen];
            dis.readFully(nomeBytes);
            String nome = new String(nomeBytes, "UTF-8");
            
            // 2. Desempacotar Idade
            int idade = dis.readInt();
            
            // 3. Desempacotar Raça
            int racaLen = dis.readInt();
            byte[] racaBytes = new byte[racaLen];
            dis.readFully(racaBytes);
            String raca = new String(racaBytes, "UTF-8");
            
            return new Animal(nome, idade, raca);
        } catch (EOFException e) {
            return null; // Fim do Stream
        }
    }

}
