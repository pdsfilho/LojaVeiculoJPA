package br.com.fuctura;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura.jpa.dao.LivroDAO;
import br.com.fuctura.jpa.models.Escritor;
import br.com.fuctura.jpa.models.Livro;

public class Main {

	public static int leiaInt(String num) {
		int n = 0;
		
		while(true) {
			try {
				n = Integer.valueOf(num);
			}
			catch(Exception e) {
				System.out.println("Erro. Digite apenas números inteiros.");
			}
			return n;
		}
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
		
		Scanner scan = new Scanner(System.in);
		
		int opc;
		
		while(true) {
			System.out.println("\n Escolha a opção");	

			
			System.out.println("|---------------------------|");
			System.out.println("|   1 - Inserir Livro       |");
			System.out.println("|   2 - Listar livro        |");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");
			
			System.out.println("Opção ");
			opc = leiaInt(scan.nextLine());
			
			if ( opc == 1 ) {
				
				br.com.fuctura.jpa.models.Escritor escritor = new Escritor();
				Livro livro = new Livro();				
				
				System.out.println("-----------");
				System.out.println("  INSERIR  ");
				System.out.println("-----------");
				
				System.out.println("\nDigite o título do livro ");
				livro.setTitulo(scan.nextLine());
				
				
				System.out.println("\nDigite o gênero do livro ");
				livro.setGenero(scan.nextLine());
				
				
				System.out.println("\nDigite a editora do livro ");
				livro.setEditora(scan.nextLine());
				
				
				System.out.println("\nDigite o nome do escritor ");
				escritor.setNome(scan.nextLine());
				
			
				System.out.println("\nDigite a nacionalidade do escritor ");
				escritor.setNacionalidade(scan.nextLine());
				
				
				System.out.println("\nDigite o e-mail do escritor ");
				escritor.setEmail(scan.nextLine());
				
				
				livro.setEscritor(escritor);
				
				LivroDAO ld = new LivroDAO(emf);
				
				ld.inserir(livro);
				}
			else if (opc == 2) {
				
				System.out.println("-----------");
				System.out.println("  INSERIR  ");
				System.out.println("-----------");
				
				System.out.println("Digite o ID do livro: ");
				Integer id = scan.nextInt();
				scan.nextLine();
				
				LivroDAO ld = new LivroDAO(emf);
				ld.listarPorID(id);
				
			}
			}
		}
	}
