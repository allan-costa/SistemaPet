package model;



public class Animal {
	private int id;
	private String nome;
	private String especie;
	private String raca;
	private String cor;
	private String sexo;
	private String dtNasc = null;
	private String obs;
	private int idDono;
	private Cliente dono = null;
	
	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	
	public Cliente getDono() {
		return dono;
	}
	
	public int getIdDono() {
		return idDono;
	}
	public void setIdDono(int idDono) {
		this.idDono = idDono;
	}
	
	//-------------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	
}
