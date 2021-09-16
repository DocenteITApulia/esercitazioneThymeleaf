package it.apulia.esercitazione1;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
	HashMap<String, UtenteDTO>similDB;

	public UserService() {
		this.similDB = new HashMap<String, UtenteDTO>();
	}
	public boolean verifyEmail(String email) {
		return this.similDB.containsKey(email);
	}

	public boolean verifyPassword(UtenteDTO utente) {
		//controllo ceh l'utente sia presente all'interno dell'hashmap
		if(this.verifyEmail(utente.getEmail())){
			//verifica che le password siano uguali
			if(this.similDB.get(utente.getEmail()).equals(utente.getPassword())) {
				//login corrente
			}
			return false; //password errata
		}
		return false; //L'utente non è presente all'interno del sistema
	}




	public boolean verificaPassword(String psw, String vpsw) {
		return psw.equals(vpsw);
	}
}
