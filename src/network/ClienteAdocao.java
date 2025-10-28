// src/network/ClienteAdocao.java

package network;

import java.io.DataInputStream; // Adicionar esta importação
import java.io.IOException;
import java.io.InputStream;
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
             );
             InputStream in = socket.getInputStream()) { // Stream para receber a resposta
            
            // 1. Cliente empacota e envia a mensagem de request (objetos Animal)
            out.enviar();
            System.out.println("Animais enviados para o servidor.");
            
            // 2. Cliente desempacota a mensagem de reply do servidor
            DataInputStream dis = new DataInputStream(in);
            
            // Desempacotamento: Primeiro, lê o tamanho da mensagem (o int que o servidor enviou)
            int bytesParaLer = dis.readInt();
            byte[] buffer = new byte[bytesParaLer];
            
            // Em seguida, lê exatamente o número de bytes da mensagem
            dis.readFully(buffer); 
            
            // Converte os bytes lidos para String (o reply)
            String resposta = new String(buffer, "UTF-8");
            
            System.out.println("Resposta do Servidor (Reply Desempacotado): " + resposta);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
