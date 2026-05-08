package Projetos;
import java.util.Scanner;

public class Login {

    static class Dados{
        private String nome = "Filipe";
        private String email = "filipegabriel123@gmail.com";
        private String senha = "@gabriel_filipe123";

        public String getNome(){ return nome; }
        public String getEmail(){ return email; }
        public String getSenha(){ return senha; }
        public void setSenha(String senha){ this.senha = senha; } 
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
                System.out.println("Nome: " + dados.getNome() + "\nEmail: " + dados.getEmail() + "\nSenha: " + dados.getSenha() + "\n");
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
                    
        if (!senhaAtual.equals(dados.getSenha())){
            return "Senha incorreta.\n";
        } 
        
        else {
            dados.setSenha(this.opcoes(Itens.SENHA, dados, entrada));
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

            if (email.equals(dados.getEmail()) && senha.equals(dados.getSenha())){
                System.out.println("\nSeja bem vindo(a), " + dados.getNome() + "!\n");
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
            String input = entrada.nextLine();
            
            try{
                opcaoDoSwitch = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Opção inválida.\n");
                opcaoDoSwitch = -1;
                continue;
            }
            
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
