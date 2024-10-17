package br.com.fuctura.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fuctura.jpa.Interfaces.InterfaceDAO;
import br.com.fuctura.jpa.models.Livro;

public class LivroDAO implements InterfaceDAO{

	private EntityManagerFactory emf;

	public LivroDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}
	
	@Override
	public void inserir(Livro livro) {
		try {
			EntityManager em = emf.createEntityManager();
			//Abrir a transação 
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
			em.close();
			
			System.out.println("\n Livro inserido com sucesso!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Livro listarPorID(Integer id) {
		try {
			EntityManager em = emf.createEntityManager();
			Livro livro = new Livro();
			livro = em.find(Livro.class, id);
			
			if(livro != null) {
				System.out.println(livro);
				return livro;
			}
			else {
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println("Erro ao listar.");
		}
		return null;
	}
	@Override
	public Livro listarPorTitulo(String titulo) {
		try {
			EntityManager em = emf.createEntityManager();
			return null;
		}
		catch(Exception e) {
			System.out.println("Erro ao listar");
		}
		return null;
	}

	@Override
	public void atualiarLivro(Livro livro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Livro livro) {
		// TODO Auto-generated method stub
		
	}

}
