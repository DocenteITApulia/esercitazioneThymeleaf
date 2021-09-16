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

	public boolean saveUser(UtenteDTO utente)
	{
		if(!this.verifyEmail(utente.getEmail())){
			this.similDB.put(utente.getEmail(),utente);
			return true;//l'utente viene salvato tramite l'email
		}
		return false; //c'è già un utente
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
