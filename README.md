# 📌 Sistema de Login em Java (Console)

Este projeto é um sistema simples de **login via terminal**, desenvolvido em Java, com autenticação, limite de tentativas e um menu interativo após o usuário acessar a conta.

---

## 🚀 Funcionalidades

- Validação de email e senha  
- Limite de **3 tentativas** antes de bloquear o acesso  
- Exibição de perfil do usuário  
- Opção para alterar a senha  
- Menu interativo após o login  
- Uso adequado de `Scanner`, `equals()` e métodos estáticos  

---

## 🧩 Estrutura do Projeto

### **🔸 Classe interna `Dados`**
Armazena informações do usuário:

- Nome  
- Email  
- Senha  

Como é `static`, não precisa de múltiplas instâncias.

---

### **🔸 Método `perfil()`**
Exibe todos os dados do usuário logado.

---

### **🔸 Método `main()`**
Responsável por:

- Leitura de email e senha  
- Controle de tentativas  
- Exibição de mensagens de erro  
- Bloqueio após 3 falhas  
- Menu pós-login  
- Alteração da senha  

---

## 🔐 Fluxo do Login

1. O usuário digita email e senha.  
2. Se ambos estiverem corretos → **login autorizado**.  
3. Se estiver errado → mensagem de erro e redução de tentativas.  
4. Após 3 erros → **ACESSO BLOQUEADO**.

A comparação é feita com `equals()` (necessária para Strings em Java).

---

## 📋 Menu de Opções

Após o login, o usuário pode:


