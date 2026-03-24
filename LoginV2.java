package Projetos;
import java.util.Scanner;

public class Login {

    static class Dados{
        String nome = "Filipe";
        String email = "filipegabriel123@gmail.com";
        String senha = "@gabriel_filipe123";
    }

    public enum Itens{
        NOME, EMAIL, SENHA, MOSTRAR_DADOS, ALTERAR_SENHA
    }

    public String opcoes(Itens itens, Dados dados, Scanner entrada){

        switch(itens){

            case NOME -> System.out.print("Digite seu nome: ");
            case EMAIL -> System.out.print("Digite seu email: ");
            case SENHA -> System.out.print("Digite sua senha: ");
            case ALTERAR_SENHA -> System.out.print("Digite sua senha atual: ");
            case MOSTRAR_DADOS -> {
                System.out.println("Nome: " + dados.nome + "\nEmail: " + dados.email + "\nSenha: " + dados.senha + "\n");
                return "";
            }
        }

        return entrada.nextLine();
    }

    static void Menu(){
        System.out.println("===== MENU =====");
        System.out.println("1 - Mostrar dados");
        System.out.println("2 - Alterar senha");
        System.out.println("0 - Sair\n");
        System.out.print("Opção escolhida: ");
    }

    public String alterarSenha(Dados dados, Scanner entrada){
        String senhaAtual = this.opcoes(Itens.ALTERAR_SENHA, dados, entrada);
                    
        if (!senhaAtual.equals(dados.senha)){
            return "Senha incorreta.\n"; 
        } 
        
        else {
            dados.senha = this.opcoes(Itens.SENHA, dados, entrada);
            return "\nSenha alterada com sucesso!\n";
        }
    }

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Login login = new Login();
        Dados dados = new Dados();

        int tentativas = 3;
        boolean logado = false;

        do{
            System.out.println("===== LOGIN =====\n");
            String email = login.opcoes(Itens.EMAIL, dados, entrada);
            String senha = login.opcoes(Itens.SENHA, dados, entrada);

            if (email.equals(dados.email) && senha.equals(dados.senha)){
                System.out.println("\nSeja bem vindo(a), " + dados.nome + "!\n");
                logado = true;
                break;
            } 
            
            else {
                System.out.println("\nEmail ou senha inválidos. Tentativas restantes: " + --tentativas);
            }
        }

        while (tentativas > 0);

        if (!logado){
            System.out.println("ACESSO BLOQUEADO.");
            entrada.close();
            return;
        }

        int opcaoDoSwitch;
        
        do {

            Menu();
            opcaoDoSwitch = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcaoDoSwitch){

                case 1 -> login.opcoes(Itens.MOSTRAR_DADOS, dados, entrada);

                case 2 -> System.out.println(login.alterarSenha(dados, entrada));

                case 0 -> System.out.println("\nSaindo...\n");

                default -> System.out.println("Opção inválida.\n");       
            }
        } 
        
        while (opcaoDoSwitch != 0);
        entrada.close();
    }
}
