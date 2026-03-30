package Test;

import Dominio.Produto;
import java.util.Scanner;

public class Loja {

    static Produto[] produtos = new Produto[10];
    static int contadorProdutos = 0;
    static double totalVendido = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n===== MENU LOJA =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Vender produto");
            System.out.println("4 - Mostrar total vendido");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    // cadastrar produto
                    if (contadorProdutos < produtos.length) {
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();

                        System.out.print("Preço do produto: ");
                        double preco = scanner.nextDouble();

                        System.out.print("Quantidade em estoque: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();

                        produtos[contadorProdutos] = new Produto(nome, preco, quantidade);
                        contadorProdutos++;

                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de produtos atingido!");
                    }
                    break;

                case 2:
                    // listar produtos
                    if (contadorProdutos == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (int i = 0; i < contadorProdutos; i++) {
                            produtos[i].imprimirProduto();
                        }
                    }
                    break;

                case 3:
                    // vender produto
                    System.out.print("Digite o nome do produto: ");
                    String nomeBusca = scanner.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < contadorProdutos; i++) {
                        if (produtos[i].getNomeProduto().equalsIgnoreCase(nomeBusca)) {
                            System.out.print("Quantidade desejada: ");
                            int qtd = scanner.nextInt();
                            scanner.nextLine();

                            if (produtos[i].vender(qtd)) {
                                totalVendido += produtos[i].getPrecoProduto() * qtd;
                                System.out.println("Venda realizada com sucesso!");
                            }

                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    // colocar o total vendido
                    System.out.println("Total vendido: R$ " + totalVendido);
                    break;

                case 5:
                    // fechar o sistema
                    System.out.println("Saindo...");
                    break;

                default:
                    // caso coloque uma opção que não seja de 1 a 5:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
