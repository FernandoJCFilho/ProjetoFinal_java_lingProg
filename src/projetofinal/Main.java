import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaOficina {
    public static void main(String[] args) {
        ArrayList<String> servicos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

switch (opcao) {
                case 1:
                    cadastrarServico(servicos, scanner);
                    break;
                case 2:
                    listarServicos(servicos);
                    break;
                case 3:
                    imprimirServicos(servicos);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }


        do {
            System.out.println("MENU OFICINA");
            System.out.println("1 - Cadastrar serviço");
            System.out.println("2 - Listar serviços");
            System.out.println("3 - Imprimir serviços (Tela e TXT)");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

     } while (opcao != 4);

