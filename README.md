# 🐾 Sistema de Adoção de Animais

## 📋 Descrição

Sistema distribuído para cadastro e adoção de animais, desenvolvido em Java para demonstrar conceitos de **Programação Orientada a Objetos**, **Streams**, **Sockets TCP** e **Serialização**.

## 🎯 Objetivo

Permitir que um **cliente** envie informações de animais disponíveis para adoção a um **servidor**, que processa e confirma o recebimento. Os dados são enviados por **streams personalizados** e podem ser salvos em arquivo, exibidos na tela, ou transmitidos via **socket TCP**.

## 🏗️ Estrutura do Projeto

```
/src
│
├── model/
│   ├── Animal.java          # Classe base (implementa Serializable e Adotavel)
│   ├── Cachorro.java        # Subclasse de Animal
│   ├── Gato.java           # Subclasse de Animal
│   ├── Abrigo.java         # Agregação - contém lista de animais
│   └── Adotavel.java       # Interface para animais adotáveis
│
├── stream/
│   ├── AnimalOutputStream.java  # Herda de OutputStream
│   └── AnimalInputStream.java   # Herda de InputStream
│
├── network/
│   ├── ServidorAdocao.java      # Servidor TCP (porta 5000)
│   └── ClienteAdocao.java       # Cliente TCP
│
└── Main.java               # Classe principal com testes
```

## 🧱 Conceitos de POO Implementados

| Conceito | Implementação | Exemplo |
|----------|---------------|---------|
| **Herança** | `Cachorro` e `Gato` herdam de `Animal` | `class Cachorro extends Animal` |
| **Interface** | `Animal` implementa `Adotavel` | `class Animal implements Adotavel` |
| **Agregação** | `Abrigo` contém lista de `Animal` | `List<Animal> animais` |
| **Polimorfismo** | Tratamento uniforme de diferentes tipos | `Animal[] animais = {cachorro, gato}` |

## 🚀 Como Executar

### 1. Compilar o Projeto
```bash
javac -d . src/*.java src/*/*.java
```

### 2. Executar Testes
```bash
java Main
```

### 3. Testar Comunicação TCP
```bash
# Terminal 1 - Servidor
java network.ServidorAdocao

# Terminal 2 - Cliente
java network.ClienteAdocao
```

## 🧪 Testes Implementados

### 1. **Saída Padrão** (`System.out`)
- Usa `AnimalOutputStream(System.out, lista)`
- Mostra dados dos animais no console

### 2. **Arquivo** (`FileOutputStream`)
- Usa `FileOutputStream("animais.txt")`
- Gera arquivo com lista dos animais

### 3. **Socket TCP**
- Execute `ServidorAdocao` e depois `ClienteAdocao`
- Servidor recebe dados e exibe no console

## 📊 Requisitos Atendidos

| Requisito | Status | Implementação |
|-----------|--------|---------------|
| **POO** (classe, herança, interface, agregação) | ✅ | `Animal`, `Cachorro`, `Gato`, `Abrigo`, `Adotavel` |
| **Subclasses de OutputStream/InputStream** | ✅ | `AnimalOutputStream`, `AnimalInputStream` |
| **Comunicação TCP (Sockets)** | ✅ | `ServidorAdocao`, `ClienteAdocao` |
| **Serialização simplificada** | ✅ | Strings/bytes nos streams |
| **Testes com System.out, arquivo e socket** | ✅ | Menu interativo no `Main.java` |
| **Projeto didático e funcional** | ✅ | Sistema completo de adoção |
| **Tema original** | ✅ | Fora do PDF do professor |

## 🎮 Menu de Testes

O `Main.java` oferece um menu interativo com:

1. **Teste Saída Padrão** - Demonstra envio para `System.out`
2. **Teste Arquivo** - Cria arquivo `animais.txt` com dados
3. **Teste Socket TCP** - Instruções para testar comunicação
4. **Demonstrar POO** - Mostra herança, interface, agregação e polimorfismo

## 📝 Exemplo de Uso

```java
// Criar animais
Animal[] lista = {
    new Cachorro("Rex", 3, "Vira-lata", true),
    new Gato("Mimi", 2, "Siamês", true)
};

// Enviar para saída padrão
AnimalOutputStream out = new AnimalOutputStream(System.out, lista);
out.enviar();

// Enviar para arquivo
FileOutputStream arquivo = new FileOutputStream("animais.txt");
AnimalOutputStream outFile = new AnimalOutputStream(arquivo, lista);
outFile.enviar();
```

## 🏆 Características do Projeto

- ✅ **Fácil de implementar**
- ✅ **Tema original** (fora do PDF do professor)
- ✅ **Cobre todos os pontos obrigatórios** de Sistemas Distribuídos
- ✅ **Código limpo e bem documentado**
- ✅ **Pronto para GitHub**

## 👨‍💻 Desenvolvido por

Sistema desenvolvido para trabalho de **Sistemas Distribuídos** - demonstrando POO, Streams, Sockets e Serialização em Java.
