package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Livros;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.util.Cores;

public class Main {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ProdutoController produtos = new ProdutoController();
        int opcao, tipo, id;
        String nome, genero;
        float preco;

        // Inicializar um livro de exemplo
        Livros r3 = new Livros(produtos.gerarId(), "branca de neve e os 7 Anoes", 2, 4.00f, "Romance");
        produtos.cadastrar(r3);
        produtos.listarTodos();
        Livros r1 = new Livros(produtos.gerarId(), "Teste", 2, 2.00f, "Romance");
        produtos.cadastrar(r1);

        while (true) {
        	System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                LIVRARIA DO SEU ZÉ                   ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Produto Livro                  ");
            System.out.println("            2 - Listar todos Livros                  ");
            System.out.println("            3 - Buscar Livro por Id                  ");
            System.out.println("            4 - Atualizar Livros                    ");
            System.out.println("            5 - Listar livro Por Nome               ");
            System.out.println("            6 - Apagar Produto Livros               ");
            System.out.println("            0 - Sair                                ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                         ");
            System.out.println("                                                     ");
            System.out.println(Cores.TEXT_RESET);
             opcao = leia.nextInt();

             if (opcao == 0) {
                    System.out.println("\nLivraria do Seu Zé - a melhor livraria para um amante de livros");
                    sobre();
                    leia.close();
                    System.exit(0);
                }

            switch (opcao) {
                    case 1:
                        System.out.println(Cores.TEXT_WHITE + "Criar Produto\n\n");
                        leia.nextLine(); // limpar o consoler
                        System.out.println("Digite o nome do Produto:");
                        nome = leia.nextLine();

                        do {
                            System.out.println("Digite o tipo do livro (1-Ficção, 2-Romance, 3-Fantasia, 4-Suspense):");
                            tipo = leia.nextInt();
                            if (tipo < 1 || tipo > 4) {
                                System.out.println("Tipo inválido! Escolha entre 1 e 4.");
                            }
                        } while (tipo < 1 || tipo > 4);

                        System.out.println("Digite o preço do livro:");
                        preco = leia.nextFloat();

                        leia.nextLine(); // limpar o consoler
                        System.out.println("Digite o gênero do livro:");
                        genero = leia.nextLine();

                        produtos.cadastrar(new Livros(produtos.gerarId(), nome, tipo, preco, genero));
                        keyPress();
                        break;

                    case 2:
                        System.out.println("Listar todos os livros\n\n");
                        produtos.listarTodos();
                        keyPress();
                        break;

                    case 3:
                        System.out.println("Consultar livros - por Id\n\n");
                        System.out.println("Digite o ID do livro:");
                        id = leia.nextInt();
                        Optional<Produto> produto = produtos.procuraPorId(id);
                        if (produto.isPresent()) {
                            produto.get().visualizar();
                        } else {
                            System.out.printf("\nO Produto ID %d não foi encontrado.\n", id);
                        }
                        keyPress();
                        break;

                    case 4:
                        System.out.println("Atualizar dados dos livros\n\n");
                        System.out.println("Digite o ID do livro:");
                        id = leia.nextInt();
                        leia.nextLine(); // limpar o consoler
                        Optional<Produto> produtoExistente = produtos.procuraPorId(id);
                        if (produtoExistente.isPresent()) {
                            System.out.println("Digite o novo nome do Produto:");
                            nome = leia.nextLine();
                            do {
                                System.out.println("Digite o tipo do livro (1-Ficção, 2-Romance, 3-Fantasia, 4-Suspense):");
                                tipo = leia.nextInt();
                                if (tipo < 1 || tipo > 4) {
                                    System.out.println("Tipo inválido! Escolha entre 1 e 4.");
                                }
                            } while (tipo < 1 || tipo > 4);
                            System.out.println("Digite o novo preço do livro:");
                            preco = leia.nextFloat();
                            leia.nextLine(); //limpar o consoler
                            System.out.println("Digite o novo gênero do livro:");
                            genero = leia.nextLine();
                            produtos.atualizar(new Livros(id, nome, tipo, preco, genero));
                        } else {
                            System.out.printf("\nO Produto ID %d não foi encontrado.\n", id);
                        }
                        keyPress();
                        break;

                    case 5:
                        System.out.println("Listar livros por Nome\n\n");
                        leia.nextLine(); // Clear buffer
                        System.out.println("Digite o nome do livro:");
                        nome = leia.nextLine();
                        produtos.listarPorNome(nome);
                        keyPress();
                        break;

                    case 6:
                        System.out.println("Apagar o livros\n\n");
                        System.out.println("Digite o ID do livro:");
                        id = leia.nextInt();
                        produtos.deletar(id);
                        keyPress();
                        break;

                    default:
                        System.out.println("\nOpção Inválida!\n");
                        keyPress();
                        break;
                	} 
            	}
            }
  
    public static void keyPress() {

		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");

			// Lê apenas a tecla Enter e ignora outras teclas
			int input;
			while ((input = System.in.read()) != '\n') {
				// Ignora qualquer outra tecla diferente do Enter
				if (input == -1) {
					throw new IOException("Entrada encerrada inesperadamente");
				}
			}

		} catch (IOException e) {
			System.err.println("Erro de entrada/saída: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
		}
	}

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("by junior");
        System.out.println("*********************************************************");
    }
}