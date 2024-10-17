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
@Table(name = "vendedor")
public class Vendedor extends Pessoa {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private int qtdVendas;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Venda venda;
	
	public Vendedor() {}
	
	public Vendedor(Integer id, int qtdVendas, Venda venda) {
		this.id = id;
		this.qtdVendas = qtdVendas;
		this.venda = venda;
	}
	

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQtdVendas() {
		return qtdVendas;
	}

	public void setQtdVendas(int qtdVendas) {
		this.qtdVendas = qtdVendas;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
}
