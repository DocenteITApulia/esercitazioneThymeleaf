package it.apulia.esercitazione1;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/*fornendo un insieme di dati quali nome, cognome, indirizzo email,
password prescelta (inserita due volte per verifica) e consenso di accettazione delle
norme sulla privacy. 
*/
@Data
public class UtenteDTO {

	@Size(min = 10, max = 200, message
			= "About Me must be between 10 and 200 characters")
	String nome;
	@Size(min = 10, max = 200, message
			= "About Me must be between 10 and 200 characters")
	String cognome;
	@Email(message = "Email should be valid")
	String email;
	@Size(min = 6, max = 25, message
			= "About Me must be between 6 and 25 characters")
	String password;
	String vpassword;
	@AssertTrue //TODO da verificare
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
