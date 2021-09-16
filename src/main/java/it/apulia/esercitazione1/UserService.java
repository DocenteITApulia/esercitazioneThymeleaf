package it.apulia.esercitazione1;


import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public boolean verificaPassword(String psw, String vpsw) {
		return psw.equals(vpsw);
	}
}
