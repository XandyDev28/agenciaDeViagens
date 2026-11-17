package exercicio;

import java.util.Scanner;
import model.Hospedagem;
import model.Locacao;
import model.Passeio;

public class ExercicioAgencia {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("========= Agência de Viagens =========");
            System.out.println("1 - Cadastrar hospedagem");
            System.out.println("2 - Cadastrar passeio");
            System.out.println("3 - cadastrar locacao");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try{
                opcao = Integer.parseInt(ler.nextLine().trim());
            } catch (NumberFormatException e) {
                opcao = -1;
            }


            try {
                switch (opcao) {
                    case 1:
                        cadastrarHospedagem(ler);
                        break;
                    case 2:
                        cadastrarPasseio(ler);
                        break;
                    case 3:
                        cadastrarLocacao(ler);
                        break;
                    case 0:
                        System.out.println("Encerrando sistema...");
                        break;
                    default:
                        System.out.println("Opção invalida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: digite um numero valido!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.println();
        } while (opcao != 0);

        ler.close();
    }

    private static double lerDouble(Scanner ler){
        return Double.parseDouble(ler.nextLine().trim().replace(',', '.'));
    }

    private static int lerInt(Scanner ler){
        return Integer.parseInt(ler.nextLine().trim());
    }

    private static void cadastrarHospedagem(Scanner ler){
        System.out.println("=== Cadastro de Hospedagem ===");
        System.out.print("Codigo: ");
        int cod = lerInt(ler);

        System.out.print("Hospede: ");
        String hospede = ler.nextLine();

        System.out.print("Valor da Diaria: ");
        double valorDiaria = lerDouble(ler);

        System.out.print("Quantidade de Dias: ");
        int qtdDias = lerInt(ler);

        System.out.print("Taxa percentual de serviço: ");
        double percent = lerDouble(ler);

        Hospedagem h = new Hospedagem(cod, hospede, valorDiaria, qtdDias, percent);
        System.out.println("Hospedagem cadastrada: " + h);
    }

    private static void cadastrarPasseio(Scanner ler){
        System.out.println("=== Cadastro de Passeio ===");
        System.out.print("Codigo: ");
        int cod = lerInt(ler);

        System.out.print("Descrição: ");
        String desc = ler.nextLine();

        System.out.print("Preço por pessoa: ");
        double precoPessoa = lerDouble(ler);

        System.out.print("Quantidade de pessoas: ");
        int qtdPessoa = lerInt(ler);

        System.out.print("Percentual de desconto: ");
        double percent = lerDouble(ler);

        Passeio p = new Passeio(cod, desc, precoPessoa, qtdPessoa, percent);
        System.out.println("Passeio cadastrado: " + p);
    }

    private static void cadastrarLocacao(Scanner ler){
        System.out.println("=== Cadastro de Locação ===");
        System.out.print("Codigo: ");
        int cod = lerInt(ler);

        System.out.print("Modelo do veiculo: ");
        String modelo = ler.nextLine();

        System.out.print("Valor da diaria: ");
        double valorDiaria = lerDouble(ler);

        System.out.print("Quantidade de dias: ");
        int qtdDias = lerInt(ler);

        System.out.print("Quilometros rodados: ");
        double km = lerDouble(ler);

        Locacao l = new Locacao(cod, modelo, valorDiaria, qtdDias, km);
        System.out.println("Locacao Cadastrada:" + l);
    }


}
