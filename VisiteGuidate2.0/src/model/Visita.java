package model;

import java.io.Serializable;
import java.time.MonthDay;

public class Visita implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String idVisita;
	private MonthDay data;
	private String nickVolontario;
	private StatoVisita stato;
	
	public Visita(String id, MonthDay data, String nick, StatoVisita stato) {
		this.idVisita = id;
		this.data = data;
		this.nickVolontario = nick;
		this.stato = stato;
	}

	public String getIdVisita() {
		return idVisita;
	}
	
	public StatoVisita getState() { 
    	return stato; 
    }
    
    public void setState(StatoVisita stato) { 
    	this.stato = stato; 
    }
    
    @Override public String toString() { 
    	return data + " id: " + idVisita + " volontario: " + nickVolontario + "  " + stato; 
    }

}
