package projetofinal;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    // Variaveis principais
    public static Scanner scanner = new Scanner(System.in);
    public static String[][] pecas = new String[100][2];
    private static int contPecas = 0; 
    public static String[][] servicos = new String[100][5];
    private static int contServicos = 0; 
    private static final String nomeArquivo = "Relatorio_Servicos.txt";
    
    // Cadastro de Peca
    public static void cadastrarPeca(){
        // Vetor temporario da peca
        String[] peca = new String[2];
        // Inserção de dados ao vetor
        peca[0] = String.valueOf(contPecas + 1);
        System.out.println("----------- Cadastrar Peca -----------------");
        System.out.println("Digite o nome da peça:");
        scanner.nextLine();
        peca[1] = scanner.nextLine();
        // Adiciona a peca na matriz principal de pecas e aumenta o contador de pecas
        pecas[contPecas][0] = peca[0];
        pecas[contPecas][1] = peca[1]; 
        contPecas++;
        // Mensagem de confirmação do cadastro de peca
        System.out.println("Peca cadastrada com sucesso! Codigo: " + peca[0] + ",Nome: " + peca[1]); 
    }

    // Cadastro de Servico
    public static void cadastrarServico(){
        System.out.println("----------- Cadastrar Servico -----------------");
        // Verifica se a pecas cadastradas no sistema
        if (pecas[0][0] == null) {
            System.out.println("Nao e possivel cadastrar um servico sem uma peca desponivel");
        } else {
            // matriz temp de servico
            String[][] servico = new String[4][1];
            scanner.nextLine();
            // Inseção de dados no vetor sevico
            servico[0][0] = String.valueOf(contServicos + 1);
            System.out.println("Digite a descricao do servico: ");
            servico[1][0] = scanner.nextLine();
            System.out.println("Digite o valor do servico");
            double valor = scanner.nextDouble();
            servico[2][0] = String.valueOf(valor);
            System.out.println("Pecas cadastradas: ");
            for (int i = 0; i < pecas.length; i++){
                if (pecas[i][0] == null) {
                    continue;
                } else {
                    System.out.println(pecas[i][0] + " - " + pecas[i][1]);
                }
            }
            System.out.println("Digite o codigo da peca utilizada: ");
            int codPeca = scanner.nextInt();
            String[] servicoPeca = {pecas[codPeca - 1][0], pecas[codPeca - 1][1]}; 
            servico[3] = servicoPeca;
            // Adiciona o servico a matriz de servicos
            servicos[contServicos][0] = servico[0][0];
            servicos[contServicos][1] = servico[1][0];
            servicos[contServicos][2] = servico[2][0];
            servicos[contServicos][3] = servico[3][0];
            servicos[contServicos][4] = servico[3][1];
            contServicos++;
            // mensagem confirmando o cadastro
            System.out.println("Servico cadastrado com sucesso! Peca utilizada: " + servico[3][1]);        
        }
    }
    
    //  Mostra os servicos cadastrados e cria um arquivo na raiz do projeto.
    public static void imprimirServicos(){
        // Verifica se a servicos cadastrados antes de mostra-los.
        // Se nao tem servicos cadastrados, o sistema avisa.
        if (servicos[0][0] == null) {
            System.out.println("Não tem nenhum servico cadastrado, Cadastre-os antes!");
        } else{
        //Se há servicos cadastrados, Mostra todos os servicos.
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println("                Servicos Cadastrados");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < servicos.length;i++) {
                if (servicos[i][0] != null) {
                    System.out.println(" Codigo: " + servicos[i][0] + " | Descricao: " + servicos[i][1] + " | Valor: R$ " + servicos[i][2] + " | Peca: [Codigo: " + servicos[i][3] + ", Nome: " +  servicos[i][4] + "]" );
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                }
            }


            // Cria o arquivo e coloca os servicos cadastrados dentro do arquivo
            File arquivo = new File(nomeArquivo);
            try {
                // cria o arquivo
                if (arquivo.createNewFile()){
                    System.out.println("Relatorio do servicos criado com sucesso");
                    System.out.println("Arquvio: " + arquivo.getName() + ", Localizado na raiz do projeto.");
                }
                // coloca o conteudo
                try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo, false))) {
                    writer.print("--------------------------------------------------------------------------------------------------------------\n");
                    writer.print("                Relatorio de Servicos Cadastrados\n");
                    writer.print("--------------------------------------------------------------------------------------------------------------\n");
                    for (int i = 0; i < servicos.length;i++) {
                        if (servicos[i][0] != null) {
                        writer.print(" Codigo: " + servicos[i][0] + " | Descricao: " + servicos[i][1] + " | Valor: R$ " + servicos[i][2] + " | Peca: [Codigo: " + servicos[i][3] + ", Nome: " +  servicos[i][4] + "]\n" );
                        writer.print("--------------------------------------------------------------------------------------------------------------\n");
                    }
            }
                }
            }catch (IOException e) {
                System.err.println("Erro ao escrever o arquivo: " + arquivo.getName());
            }
        }
    }

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("------------ MENU OFICINA --------------");
            System.out.println("1 - Cadastrar peca");
            System.out.println("2 - Cadastrar servicos");
            System.out.println("3 - Imprimir serviços (Tela e TXT)");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                    case 1:
                        cadastrarPeca();
                        break;
                    case 2:
                        cadastrarServico();
                        break;
                    case 3:
                        imprimirServicos();
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
     } while (opcao != 4);
    }
}
