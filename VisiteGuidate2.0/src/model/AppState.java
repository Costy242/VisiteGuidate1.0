package model;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import storage.*;

public class AppState implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, TipoVisita> tipiVisita = new LinkedHashMap<>();
	private Map<String, Luogo> luoghi = new LinkedHashMap<>();
	private Map<String, Visita> visite = new LinkedHashMap<>();
	private Map<String, Utente> utenti = new LinkedHashMap<>();

	public AppState() {
	}

	private transient DataStore dataStore;
	private transient Utente utenteLoggato;

	public void setDataStore(DataStore ds) {
		this.dataStore = ds;
	}

	public static AppState carica(DataStore ds){
		AppState s = ds.caricaOCrea();
		s.setDataStore(ds);
		return s;
	}

	public void salva() throws IOException {
		if(dataStore == null) throw new IllegalStateException("DataStore non impostato");
		dataStore.salvaUnchecked(this);
	}

	public void salvaUnchecked() {
		if(dataStore == null) throw new IllegalStateException("DataStore non impostato");
		dataStore.salvaUnchecked(this);
	}

	public DataStore getDataStore() {
		return dataStore;
	}

	public Map<String, TipoVisita> getTipiVisita() {
		return tipiVisita;
	}

	public Map<String, Luogo> getLuoghi() {
		return luoghi;
	}

	public Map<String, Visita> getVisite() {
		return visite;
	}

	public Map<String, Utente> getUtenti() {
		return utenti;
	}

	public Utente getUtenteLoggato() {
		return utenteLoggato;
	}

	public void setLoggedUser(Utente user) {
		this.utenteLoggato = user;
	}

	public void aggiungiTipoVisita(TipoVisita tipoVisita) {
		if(tipoVisita == null) return;
		tipiVisita.put(tipoVisita.getId(), tipoVisita);
	}

	public TipoVisita getTipoVisitaById(String id) {
		return tipiVisita.get(id);
	}

	public void aggiungiVisita(Visita v) {
		if(v == null) return;
		visite.put(v.getIdVisita(), v);
	}

	public void aggiungiLuogo(Luogo l) {
		if(l == null) return;
		luoghi.put(l.getDescrizione(), l);
	}

	public void aggiungiUtente(Utente user) {
		if(user == null) return;
		utenti.put(user.getUsername(), user);
	}

}
