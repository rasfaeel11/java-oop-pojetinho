package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        int opcao;

        System.out.println("Sistema Cadastro Produtos");
        System.out.println("==========================");

        do {
            System.out.println("==========MENU============= ");
            System.out.println("[1] Cadastrar Novo Produto");
            System.out.println("[2] Listar Todos Os Produtos");
            System.out.println("[3] Buscar Produto pelo Nome");
            System.out.println("[4] Remover Produto pelo Nome");
            System.out.println("[0] Sair ");
            System.out.print("Qual opcao voce deseja? ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto(listaProdutos, input);
                    break;
                case 2:
                    listarProdutos(listaProdutos);
                    break;
                case 3:
                    buscarProduto(listaProdutos, input);
                    break;
                case 4:
                    removerProduto(listaProdutos, input);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        input.close();
    }

    public static void cadastrarProduto(ArrayList<Produto> listaProdutos, Scanner input) {
        System.out.print("Digite o nome do Produto: ");
        String nome = input.nextLine();
        System.out.print("Digite o preço do Produto: ");
        double preco = input.nextDouble();
        System.out.print("Digite a quantidade em Estoque do Produto: ");
        int estoque = input.nextInt();
        input.nextLine(); 

        listaProdutos.add(new Produto(nome, preco, estoque));
        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void listarProdutos(ArrayList<Produto> listaProdutos) {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : listaProdutos) {
                System.out.println(produto); 
            }
        }
    }

    public static void buscarProduto(ArrayList<Produto> listaProdutos, Scanner input) {
        System.out.print("Digite o nome do produto para buscar: ");
        String busca = input.nextLine();
        boolean encontrado = false;

        for (Produto produto : listaProdutos) {
            if (produto.getNome().equalsIgnoreCase(busca)) {
                System.out.println("Produto encontrado: " + produto);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void removerProduto(ArrayList<Produto> listaProdutos, Scanner input) {
        System.out.print("Digite o nome do produto para remover: ");
        String removerProduto = input.nextLine();
        boolean removido = false;

        for (Produto produto : listaProdutos) {
            if (produto.getNome().equalsIgnoreCase(removerProduto)) {
                listaProdutos.remove(produto);
                System.out.println("Produto removido com sucesso.");
                removido = true;
                break;
            }
        }

        if (!removido) {
            System.out.println("Produto não encontrado.");
        }
    }
}