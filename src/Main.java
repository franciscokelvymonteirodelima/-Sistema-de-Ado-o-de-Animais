import model.*;
import stream.AnimalOutputStream;
import java.io.*;
import java.util.Scanner;

/**
 * Classe principal do sistema de adoção de animais
 * Demonstra os testes sugeridos: System.out, arquivo e socket
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE ADOÇÃO DE ANIMAIS ===");
        System.out.println("Demonstração dos testes sugeridos");
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    testeSaidaPadrao();
                    break;
                case 2:
                    testeArquivo();
                    break;
                case 3:
                    testeSocket();
                    break;
                case 4:
                    demonstrarPOO();
                    break;
                case 5:
                    System.out.println("Obrigado por usar o sistema de adoção!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== MENU DE TESTES ===");
        System.out.println("1. Teste Saída Padrão (System.out)");
        System.out.println("2. Teste Arquivo");
        System.out.println("3. Teste Socket TCP");
        System.out.println("4. Demonstrar POO (Herança, Interface, Agregação)");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Teste 1: Saída padrão - Use AnimalOutputStream(System.out, lista)
     */
    private static void testeSaidaPadrao() {
        System.out.println("\n=== TESTE 1: SAÍDA PADRÃO ===");
        
        Animal[] lista = {
            new Cachorro("Rex", 3, "Vira-lata", true),
            new Gato("Mimi", 2, "Siamês", true),
            new Cachorro("Bella", 1, "Golden Retriever", false)
        };

        //ovos parametros: enviar 2 objetos, com 3 atributos (nome, idade, raca) e 20 bytes por atributo
        String[] atributosParaEnviar = {"nome", "idade", "raca"};
        int numBytesPorAtributo = 20;

        try (AnimalOutputStream out = new AnimalOutputStream(System.out, lista, lista.length, atributos, bytesPorAtributo)) {
            System.out.println("Enviando animais para System.out:");
            out.enviar();
            System.out.println("✓ Teste de saída padrão concluído!");
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    /**
     * Teste 2: Arquivo - Use FileOutputStream("animais.txt")
     */
    private static void testeArquivo() {
        System.out.println("\n=== TESTE 2: ARQUIVO ===");
        
        Animal[] lista = {
            new Cachorro("Max", 4, "Bulldog", true),
            new Gato("Felix", 3, "Persa", false),
            new Cachorro("Luna", 2, "Pastor Alemão", true)
        };
        
        String[] atributosParaEnviar = {"nome", "idade", "raca"};
        int numBytesPorAtributo = 20;

        try (AnimalOutputStream out = new AnimalOutputStream(new FileOutputStream("animais.txt"), lista, lista.length, atributosParaEnviar, numBytesPorAtributo)) {
            out.enviar();
            
            System.out.println("✓ Arquivo 'animais.txt' criado com sucesso!");
            System.out.println("Conteúdo do arquivo:");
            
            // Ler e exibir o arquivo criado
            BufferedReader reader = new BufferedReader(new FileReader("animais.txt"));
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println("  " + linha);
            }
            reader.close();
            
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    /**
     * Teste 3: Socket TCP - Execute ServidorAdocao e depois ClienteAdocao
     */
    private static void testeSocket() {
        System.out.println("\n=== TESTE 3: SOCKET TCP ===");
        System.out.println("Para testar o socket:");
        System.out.println("1. Abra um terminal e execute: java network.ServidorAdocao");
        System.out.println("2. Abra outro terminal e execute: java network.ClienteAdocao");
        System.out.println("3. O servidor receberá os dados e exibirá no console");
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Demonstração dos conceitos de POO
     */
    private static void demonstrarPOO() {
        System.out.println("\n=== DEMONSTRAÇÃO POO ===");
        
        // 1. HERANÇA: Cachorro e Gato herdam de Animal
        System.out.println("1. HERANÇA:");
        Animal animal = new Animal("Animal Genérico", 5, "Misto");
        Cachorro cachorro = new Cachorro("Rex", 3, "Vira-lata", true);
        Gato gato = new Gato("Mimi", 2, "Siamês", false);
        
        System.out.println("   " + animal.toString());
        System.out.println("   " + cachorro.toString());
        System.out.println("   " + gato.toString());
        
        // 2. INTERFACE: Animal implementa Adotavel
        System.out.println("\n2. INTERFACE (Adotavel):");
        animal.solicitarAdocao();
        animal.confirmarAdocao();
        cachorro.solicitarAdocao();
        gato.confirmarAdocao();
        
        // 3. AGREGAÇÃO: Abrigo contém uma lista de animais
        System.out.println("\n3. AGREGAÇÃO:");
        Abrigo abrigo = new Abrigo("Abrigo dos Amigos");
        abrigo.adicionarAnimal(cachorro);
        abrigo.adicionarAnimal(gato);
        abrigo.adicionarAnimal(new Cachorro("Bella", 1, "Golden Retriever", false));
        
        System.out.println("   Animais no abrigo:");
        for (Animal a : abrigo.getAnimais()) {
            System.out.println("   - " + a.toString());
        }
        
        // 4. POLIMORFISMO: Tratamento uniforme de diferentes tipos
        System.out.println("\n4. POLIMORFISMO:");
        Animal[] animais = {cachorro, gato, new Cachorro("Max", 4, "Bulldog", true)};
        for (Animal a : animais) {
            System.out.println("   " + a.getClass().getSimpleName() + ": " + a.toString());
        }
        
        System.out.println("\n✓ Demonstração POO concluída!");
    }
}
