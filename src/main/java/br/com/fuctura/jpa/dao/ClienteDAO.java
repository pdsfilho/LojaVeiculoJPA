package br.com.fuctura.jpa.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.com.fuctura.jpa.Interfaces.ClienteInterface;
import br.com.fuctura.jpa.models.Cliente;
import br.com.fuctura.jpa.models.Endereco;

public class ClienteDAO implements ClienteInterface{
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public ClienteDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}
	
	
	@Override
	public void insert(Cliente cliente) {
		try {
			em = emf.createEntityManager();
			//Abrir a transação 
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			em.close();
			
			System.out.println("\n Cliente inserido com sucesso!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Cliente findById(Integer id) {
		try {
			em = emf.createEntityManager();
			Cliente cliente = new Cliente();
			cliente = em.find(Cliente.class, id);
			
			if(cliente != null) {
				System.out.println(cliente);
				return cliente;
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
	public Cliente findByCpf(String cpf) {	
		try {
			
			TypedQuery<Cliente> cliente = em.createNamedQuery("Cliente.findByCpf", Cliente.class);
			cliente.setParameter("cpf", cpf);
			return cliente.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public void findAll() {
		TypedQuery<Cliente> listClientes = em.createQuery("Select c from Cliente c", 
				Cliente.class);
		List<Cliente> clientes = listClientes.getResultList();
		
		if(clientes.isEmpty()) {
			System.out.println("\n Nenhum cliente encontrado");
		}else {
			for(Cliente c : clientes) {
				System.out.println(c);
			}
		}
	}
	
	
	@Override
	public void update(Cliente cliente) {
		Scanner entrada = new Scanner(System.in);

		Endereco endereco = cliente.getEndereco();

		System.out.println("\nDigite o novo nome: ");
		cliente.setNome(entrada.nextLine());

		System.out.println("\nDigite o novo telefone: ");
		cliente.setTelefone(entrada.nextLine());

		cliente.setEndereco(endereco);

		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();

		em.close();

		System.out.println("\nDados alterados com sucesso!!!\n");
		
	}

	@Override
	public void delete(Cliente cliente) {
		try {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
			
			em.close();
			
			System.out.println("\nLivro excluido com sucesso!!!\n");
			
		} catch (Exception e) {
			// TODO: handle exception
			}
		}
	
}
