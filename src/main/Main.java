package main;
import java.util.Scanner;

import model.Produto;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        int opcao;


        System.out.println("Sistema Cadastro Produtos");
        System.out.println("==========================");

        do{
            System.out.println("==========MENU============= ");
            System.out.println("[1] Cadastrar Novo Produto");
            System.out.println("[2] Listar Todos Os Produtos: ");
            System.out.println("[3] Buscar Produto pelo Nome ");
            System.out.println("[4] Remover Produto pelo Nome ");
            System.out.println("[0] Sair ");
            System.out.println("Qual opcao voce deseja? ");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do Produto para Cadastro: ");
                    String nome = input.nextLine();
                    System.out.println("Digite o preco do Produto para Cadastro: ");
                    double preco = input.nextDouble();
                    System.out.println("Digite a quantidade em Estoque do Produto: ");
                    int estoque = input.nextInt();

                    listaProdutos.add(new Produto(nome, preco, estoque));
                    break;
                case 2:
                    for (Produto produto : listaProdutos) {
                        System.out.println(produto);
                    }

                    break;
                case 3:
                    System.out.println("Qual produto voce quer Buscar: ");
                    String busca = input.nextLine();
                    for( Produto produto : listaProdutos){
                        if(produto.getNome().equalsIgnoreCase(busca)){
                            System.out.println("Produto Encontrado");
                            break;
                        }else{
                            System.out.println("Produto nao encontrado");
                        }
                    }
                    break;
                case 4:

                    break;
            
                default:
                    break;
            }

        } while (opcao != 0);
        

        input.close();
    }
}