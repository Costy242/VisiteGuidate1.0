package model;

import java.io.Serializable;

public class Luogo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String descrizione;
	private String infoAggiuntive;
	private String collocazione;
	
	public Luogo(String desc, String info, String pos) {
		this.descrizione = desc; 		//lo individua univocamente
		this.infoAggiuntive = info; 	//opzionale
		this.collocazione = pos;
	}

	public Luogo(String desc, String pos) {
		this.descrizione = desc; 		//lo individua univocamente
		this.collocazione = pos;
	}
	
	public static Luogo crea(String desc, String info, String pos) {
		return new Luogo(desc, info, pos);
	}

	public static Luogo crea(String desc, String pos) {
		return new Luogo(desc, pos);
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getInfoAggiuntive() {
		return infoAggiuntive;
	}

	public void setInfoAggiuntive(String infoAggiuntive) {
		this.infoAggiuntive = infoAggiuntive;
	}

	public String getCollocazione() {
		return collocazione;
	}

	public void setCollocazione(String collocazione) {
		this.collocazione = collocazione;
	}

}