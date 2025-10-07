package model;

import java.io.Serial;
import java.io.Serializable;

public class Utente implements Serializable{
	
	@Serial private static final long serialVersionUID = 1L;
	
	private String username;
	private String pass;
	private boolean cambioPassObbligatorio;		// true al primo accesso
	
	public Utente(String username, String pass, boolean cambioPass) {
		this.username = username;
		this.pass = pass;
		this.cambioPassObbligatorio = cambioPass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isCambioPassObbligatorio() {
		return cambioPassObbligatorio;
	}

	public void setCambioPassObbligatorio(boolean cambioPassObbligatorio) {
		this.cambioPassObbligatorio = cambioPassObbligatorio;
	}
	
}
