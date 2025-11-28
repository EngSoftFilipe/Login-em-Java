package Teste;
import java.util.Scanner;

public class Login {

    // Classe 'static' para evitar criar instâncias
    static class Dados{
        String nome = "Filipe";
        String email = "filipegabriel123@gmail.com";
        String senha = "@gabriel_filipe123";
    }

    // O uso do 'static void' para apenas colocar o método futuramente
    static void perfil(Dados dados){
        System.out.println("\n===== PERFIL =====\n");
        System.out.println("Nome: " + dados.nome);
        System.out.println("Email: " + dados.email);
        System.out.println("Senha: " + dados.senha + "\n");
    }

    // Método main
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Dados dados = new Dados();

        // Número de tentativas para inserir os dados corretos
        int tentativas = 3;
        boolean logado = false;

        // Login
        do{
            System.out.println("===== LOGIN =====\n");
            System.out.print("Digite o seu email: ");
            String email = entrada.nextLine();

            System.out.print("Digite a sua senha: ");
            String senha = entrada.nextLine();

            // Uso do 'equals' pois o sinal de '=' não se aplica em String
            if (email.equals(dados.email) && senha.equals(dados.senha)){
                System.out.println("\nSeja bem vindo(a), " + dados.nome + "!\n");
                logado = true;
                break; 

            } 
            
            // Em caso de dados incorretos, o número de tentativas vai diminuindo, até chegar em 0 e negar o acesso
            else {
                System.out.println("\nEmail ou senha inválidos. Tentativas restantes: " + --tentativas);
            } // Não declarando qual foi o erro, por segurança 
        }

        while (tentativas > 0);

        if (!logado){
            System.out.println("ACESSO BLOQUEADO.");
            entrada.close(); // Scanner fechado aqui em caso de acesso bloqueado
            return; // encerra o método main em caso de acesso bloqueado
        }

        // Menu, caso o login dê certo
        int opcao;
        
        do {
            System.out.println("===== MENU =====");
            System.out.println("1 - Mostrar dados");
            System.out.println("2 - Alterar senha");
            System.out.println("0 - Sair\n");
            System.out.print("Opção escolhida: ");
                opcao = entrada.nextInt();
                entrada.nextLine(); // limpa buffer. Após o nextInt dá erro no código prosseguir sem o nextLine

            switch (opcao){

                case 1:
                    perfil(dados); // Uso do void
                    break;

                case 2:
                    System.out.print("Digite sua senha atual: "); // Validação
                    String senhaAtual = entrada.nextLine();
                    
                    if (!senhaAtual.equals(dados.senha)){
                        System.out.println("Senha incorreta.\n"); // Erro, caso a senha seja diferente da senha da classe

                    } 
                    
                    else {
                        System.out.print("Digite a nova senha: ");
                        dados.senha = entrada.nextLine();
                        System.out.println("\nSenha alterada com sucesso!\n");
                    } break;

                case 0:
                    System.out.println("\nSaindo...\n");
                    break;

                default:
                    System.out.println("Opção inválida.\n");
            }

        } 
        
        while (opcao != 0);

        entrada.close();
    }
}
