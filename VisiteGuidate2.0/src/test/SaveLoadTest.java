package test;

import java.io.IOException;
import java.time.MonthDay;
import java.time.LocalTime;
import java.util.EnumSet;

import model.AppState;
import model.GiornoSettimana;
import model.Luogo;
import model.TipoVisita;
import model.Utente;
import storage.FileDataStore;

public class SaveLoadTest {

    public static void main(String[] args) throws IOException {
        String path = "./data/test-appstate.bin";
        FileDataStore ds = new FileDataStore(path);

        // crea uno stato di prova
        AppState st = new AppState();
        st.setDataStore(ds);

        Utente u = new Utente("alice", "pass", false);
        st.aggiungiUtente(u);

        Luogo l = Luogo.crea("Museo", "Via Roma 1");
        st.aggiungiLuogo(l);

        TipoVisita tv = TipoVisita.crea("Museo", "Tour1", "desc", "ingresso", MonthDay.of(1, 1), MonthDay.of(12, 31), EnumSet.of(GiornoSettimana.LUNEDI), LocalTime.of(10,0), 60, false, 1, 10);
        st.aggiungiTipoVisita(tv);

        // salva
        st.salvaUnchecked();
        System.out.println("Saved state to " + path);

        // ricarica
        AppState loaded = FileDataStore.class.cast(ds).caricaOCrea();
        // assicurati che il DataStore sia settato per l'oggetto caricato
        loaded.setDataStore(ds);

        System.out.println("Loaded utenti: " + loaded.getUtenti().keySet());
        System.out.println("Loaded luoghi: " + loaded.getLuoghi().keySet());
        System.out.println("Loaded tipiVisita: " + loaded.getTipiVisita().keySet());
    }
}
