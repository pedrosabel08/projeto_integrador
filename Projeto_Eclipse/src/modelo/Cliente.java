package modelo;

public class Cliente {
	private String id;
	private String Nome;
	private String CPF;
	private String Nasc;
	private String RG;
	private String data_nascimento;
	private String Venda_idVenda;
	
	
	public Cliente() {
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public String getNasc() {
		return Nasc;
	}


	public void setNasc(String nasc) {
		Nasc = nasc;
	}


	public String getRG() {
		return RG;
	}


	public void setRG(String rG) {
		RG = rG;
	}


	public String getData_nascimento() {
		return data_nascimento;
	}


	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}


	public String getVenda_idVenda() {
		return Venda_idVenda;
	}


	public void setVenda_idVenda(String venda_idVenda) {
		Venda_idVenda = venda_idVenda;
	}
	
	
	
	
}
