package br.com.fuctura.jpa.Interfaces;

import br.com.fuctura.jpa.models.Livro;

public interface InterfaceDAO {
	public void inserir(Livro livro);
	public Livro listarPorID(Integer id);
	public Livro listarPorTitulo(String titulo);
	public void atualiarLivro(Livro livro);
	public void excluir(Livro livro);
}
