#!/bin/bash

echo "🐾 Compilando Sistema de Adoção de Animais..."

# Verificar se javac está disponível
if ! command -v javac &> /dev/null; then
    echo "❌ javac não encontrado!"
    echo "📦 Instale o JDK com: sudo dnf install java-21-openjdk-devel"
    echo "   ou: sudo apt install openjdk-21-jdk (Ubuntu/Debian)"
    exit 1
fi

# Criar diretório de classes se não existir
mkdir -p classes

# Compilar todas as classes
echo "🔨 Compilando classes..."
javac -d classes src/*.java src/*/*.java

if [ $? -eq 0 ]; then
    echo "✅ Compilação bem-sucedida!"
    echo ""
    echo "🚀 Para executar:"
    echo "   java -cp classes Main"
    echo ""
    echo "🌐 Para testar socket TCP:"
    echo "   Terminal 1: java -cp classes network.ServidorAdocao"
    echo "   Terminal 2: java -cp classes network.ClienteAdocao"
else
    echo "❌ Erro na compilação!"
    exit 1
fi
