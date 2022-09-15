package modelo;

public class Produto {
	private String ID;
	private String Nome, Marca, Tamanho, Cor;
	private String preco;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getTamanho() {
		return Tamanho;
	}
	public void setTamanho(String tamanho) {
		Tamanho = tamanho;
	}
	public String getCor() {
		return Cor;
	}
	public void setCor(String cor) {
		Cor = cor;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
}
