# 🔐 Sistema de Login em Java

Sistema de login via terminal desenvolvido em Java, com autenticação, limite de tentativas e gerenciamento de dados do usuário.

## 📋 Funcionalidades

- Autenticação com email e senha
- Bloqueio de acesso após 3 tentativas incorretas
- Visualização de dados do perfil
- Alteração de senha com validação

## 🏗️ Estrutura do Código

| Classe / Elemento | Responsabilidade |
|---|---|
| `Dados` | Armazena os dados do usuário |
| `Itens` (enum) | Centraliza as opções de interação |
| `opcoes()` | Gerencia prompts e leitura de entrada |
| `alterarSenha()` | Lógica de alteração de senha isolada |
| `Menu()` | Exibe o menu de opções |

## 💡 Conceitos Aplicados

- **Enum com uso semântico** — `Itens` organiza todas as interações do sistema
- **Separação de responsabilidades** — cada método tem um papel claro, deixando o `main` limpo
- **Switch com arrow** `->` — sintaxe moderna do Java
- **Controle de fluxo** — uso de `do-while` com condição composta ao invés de `break`
- **Instância e `this`** — uso correto de objetos e referência ao próprio objeto

## 🚀 Como executar

1. Clone o repositório
2. Compile o arquivo:
   ```bash
   javac Login.java
   ```
3. Execute:
   ```bash
   java Projetos.Login
   ```

## 🔄 Versões

- **v1** — Lógica centralizada no `main`, switch com `case:` + `break`
- **v2** — Código refatorado com enum, métodos separados e `main` limpo
