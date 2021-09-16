package it.apulia.esercitazione1;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
	HashMap<String, UtenteDTO> similDB;

	public UserService() {
		this.similDB = new HashMap<String,UtenteDTO>();
	}

	public boolean verifyEmail(String email) {
		return this.similDB.containsKey(email);
	}

	public boolean verifyPasswordUtente(UtenteDTO utente) {
		if(this.verifyEmail(utente.getEmail()))
		{
			//l'utente esiste
			if(this.similDB.get(utente.getEmail()).getPassword().equals(utente.getPassword()))
			{
				//login corretto
			}
			return false; //password errata
		}
		return false;
	}


	public boolean verificaPassword(String psw, String vpsw) {
		return psw.equals(vpsw);
	}
}
