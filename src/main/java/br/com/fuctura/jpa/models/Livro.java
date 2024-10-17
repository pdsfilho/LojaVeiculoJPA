package br.com.fuctura.jpa.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Livro")
public class Livro {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String titulo;
	@Column
	private String genero;
	@Column
	private String editora;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Escritor escritor;
	
	public Livro() {}
	
	public Livro(Integer id, String titulo, String genero, String editora, Escritor escritor) {
		
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.editora = editora;
		this.escritor = escritor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Escritor getEscritor() {
		return escritor;
	}

	public void setEscritor(Escritor escritor) {
		this.escritor = escritor;
	}

	@Override
	public String toString() {
		return "\n------------------------------------------------------"
				+ "Livro [id=" + id + 
				",\n titulo=" + titulo + 
				",\n genero=" + genero + 
				",\n editora=" + editora + 
				",\n escritor="+ escritor.getNome() + "] +" +
				"\n-----------------------------------------------------";
	}
	
	
}
