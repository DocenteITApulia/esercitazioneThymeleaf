package it.apulia.esercitazione1;


import lombok.Data;

/*fornendo un insieme di dati quali nome, cognome, indirizzo email,
password prescelta (inserita due volte per verifica) e consenso di accettazione delle
norme sulla privacy. 
*/
@Data
public class UtenteDTO {
	String nome;
	String cognome;
	String email;
	String password;
	String vpassword;
	boolean privacy = false;
	/*
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVpassword() {
		return vpassword;
	}
	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
	}
	public boolean isPrivacy() {
		return privacy;
	}
	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}
*/
}
