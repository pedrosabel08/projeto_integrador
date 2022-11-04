package modelo;

public class Venda {
	
	private int id;
	private String forma_pagamento;
	private double valor;
	private String data;
	private int cadastro;
	private int usuario;
	private int produto;
	private String nome_produto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}
	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getCadastro() {
		return cadastro;
	}
	public void setCadastro(int cadastro) {
		this.cadastro = cadastro;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getProduto() {
		return produto;
	}
	public void setProduto(int produto) {
		this.produto = produto;
	}
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	

}
