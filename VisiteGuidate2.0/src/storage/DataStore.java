package storage;

import java.io.IOException;

import model.*;

public interface DataStore {
	
	AppState caricaOCrea();
	
	void salva(AppState state) throws IOException;
	
	void salvaUnchecked(AppState state);

}
