// src/network/ServidorAdocao.java

package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import stream.AnimalInputStream;

public class ServidorAdocao {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(5000)) {
            System.out.println("Servidor de adoção aguardando conexão...");

            // Loop para aceitar múltiplas conexões (melhor prática)
            while (true) {
                // O try-with-resources garante que o socket e os streams sejam fechados
                try (Socket cliente = servidor.accept();
                     AnimalInputStream entrada = new AnimalInputStream(cliente.getInputStream());
                     OutputStream saida = cliente.getOutputStream()) { // Stream para enviar a resposta

                    System.out.println("Cliente conectado de: " + cliente.getInetAddress().getHostAddress());

                    // 1. Servidor desempacota a requisição do cliente
                    System.out.println("Recebendo dados de animais do cliente...");
                    entrada.lerProximoAnimal(); // Chama o método que desserializa e exibe os animais

                    // 2. Servidor empacota e envia a mensagem de reply
                    String reply = "Servidor: Dados de animais recebidos e processados com sucesso!";
                    
                    // Usamos DataOutputStream para empacotar o tamanho e os dados
                    DataOutputStream dos = new DataOutputStream(saida);
                    byte[] replyBytes = reply.getBytes("UTF-8");
                    
                    // Empacotamento: Envia o tamanho da mensagem (int), seguido pelos bytes da mensagem
                    dos.writeInt(replyBytes.length); 
                    dos.write(replyBytes);          
                    dos.flush();

                    System.out.println("Resposta de reply enviada ao cliente. Conexão encerrada.");
                } catch (IOException e) {
                    System.err.println("Erro na comunicação com o cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
