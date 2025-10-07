package model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.MonthDay;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class TipoVisita implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;		//individua la visita univocamente
	private String luogo;
	private String titolo;
	private String descrizione;
	private String puntoIncontro;
	private MonthDay dataInizio;
	private MonthDay dataFine;
	private Set<GiornoSettimana> giorniVisita;
	private LocalTime oraInizio;
	private int durata;
	private boolean bigliettoNecessario;
	private int minPartecipanti;
	private int maxPartecipanti;
	private Set<String> volontari = new LinkedHashSet<>();
	
	private TipoVisita(String id, String luogo, String titolo, String desc, String incontro,
							MonthDay inizio, MonthDay fine, Set<GiornoSettimana> giorni,
							 LocalTime oraInizio, int durata, boolean biglietto, int minP, int maxP) 
	{
		this.id = id; this.luogo = luogo; this.titolo = titolo; this.descrizione = desc;
		this.puntoIncontro = incontro; this.dataInizio = inizio; this.dataFine = fine;
		this.giorniVisita = EnumSet.copyOf(giorni); this.oraInizio = oraInizio;
		this.durata = durata; this.bigliettoNecessario = biglietto; this.minPartecipanti = minP;
		this.maxPartecipanti = maxP;
		if(minP < 1 || maxP < minP) throw new IllegalArgumentException("Attenzione al numero di partecipanti");
	}
	
	public static TipoVisita crea(String luogo, String titolo, String desc, String incontro,
			MonthDay inizio, MonthDay fine, Set<GiornoSettimana> giorni,
			 LocalTime oraInizio, int durata, boolean biglietto, int minP, int maxP) {
		Objects.requireNonNull(luogo); Objects.requireNonNull(titolo); Objects.requireNonNull(incontro); 
		Objects.requireNonNull(inizio); Objects.requireNonNull(fine); Objects.requireNonNull(giorni);
		if(durata <= 0) throw new IllegalArgumentException("durata deve essere > 0");
		if(inizio.isAfter(fine)) throw new IllegalArgumentException("periodo non valido");
		return new TipoVisita(Ids.next(), luogo, titolo, desc, incontro, inizio, fine, giorni, oraInizio, durata, biglietto, minP, maxP);
	}

	public String getId() {
		return id;
	}

	public String getLuogo() {
		return luogo;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public String getPuntoIncontro() {
		return puntoIncontro;
	}

	public MonthDay getDataInizio() {
		return dataInizio;
	}

	public MonthDay getDataFine() {
		return dataFine;
	}

	public Set<GiornoSettimana> getGiorniVisita() {
		return giorniVisita;
	}

	public LocalTime getOraInizio() {
		return oraInizio;
	}

	public int getDurata() {
		return durata;
	}

	public boolean isBigliettoNecessario() {
		return bigliettoNecessario;
	}

	public int getMinPartecipanti() {
		return minPartecipanti;
	}

	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}

	public Set<String> getVolontari() {
		return volontari;
	}
		
}
