package projetofinal;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String[][] pecas = new String[100][2];
    private static int contPecas = 0; 

    public static void cadastrarPeca(){
        String[] peca = new String[2];
        peca[0] = String.valueOf(contPecas + 1);
        System.out.println("----------- Cadastrar Peca -----------------");
        System.out.println("Digite o nome da peça:");
        scanner.nextLine();
        peca[1] = scanner.nextLine();
        pecas[contPecas][0] = peca[0];
        pecas[contPecas][1] = peca[1]; 
        contPecas++;
    }

    public static void main(String[] args) {
        int opcao = 0;
        do {
            
            System.out.println("------------ MENU OFICINA --------------");
            System.out.println("1 - Cadastrar peca");
            System.out.println("2 - Cadastrat servicos");
            System.out.println("3 - Imprimir serviços (Tela e TXT)");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                    case 1:
                        cadastrarPeca();
                        break;
                    case 2:
                        //cadastrarServico();
                        break;
                    case 3:
                        //imprimirServicos();
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
