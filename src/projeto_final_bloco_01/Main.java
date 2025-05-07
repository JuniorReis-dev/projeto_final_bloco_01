package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;


public class Main {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto Livro                  ");
			System.out.println("            2 - Listar todos Livros                  ");
			System.out.println("            3 - Buscar Livro por Id                  ");
			System.out.println("            4 - Atualizar Livros		             ");
			System.out.println("            4 - Listar livro Por Nome		         ");
			System.out.println("            5 - Apagar Produto Livros                ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("\nLivraria do seu zé");
				sobre();
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Criar livros\n\n");

					break;
				case 2:
					System.out.println("Listar todas as livros\n\n");

					break;
				case 3:
					System.out.println("Consultar livros - por Id \n\n");

					break;
				case 4:
					System.out.println("Atualizar dados dos livros\n\n");

					break;
				case 5:
					System.out.println("Apagar o livros\n\n");

					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					break;
			}
		}
	}
    
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("by junior");
		System.out.println("*********************************************************");
	}
	
}
