package network;

import java.io.IOException;
import java.net.Socket;
import model.*;
import stream.AnimalOutputStream;

public class ClienteAdocao {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             AnimalOutputStream out = new AnimalOutputStream(
                 socket.getOutputStream(), 
                 new Animal[] {
                     new Cachorro("Rex", 3, "Vira-lata", true),
                     new Gato("Mimi", 2, "Siamês", true)
                 },
                 2, // número de objetos a serem enviados
                 new String[]{"nome", "idade", "raca"}, // atributos a serem enviados
                 20 // número de bytes por atributo
             )) {
            out.enviar();
            System.out.println("Animais enviados para o servidor.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
