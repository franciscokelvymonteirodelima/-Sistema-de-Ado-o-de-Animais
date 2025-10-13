package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import stream.AnimalInputStream;

public class ServidorAdocao {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(5000);
             Socket cliente = servidor.accept();
             AnimalInputStream entrada = new AnimalInputStream(cliente.getInputStream())) {
            System.out.println("Servidor de adoção aguardando conexão...");
            System.out.println("Cliente conectado!");

            entrada.ler();

            System.out.println("Conexão encerrada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
