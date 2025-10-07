package storage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import model.AppState;

public class FileDataStore implements DataStore {
	
	private final Path path;
	
	public FileDataStore(String path) {
		this.path = Path.of(path);
	}

	
	@Override public AppState caricaOCrea() {
		try {
			if(Files.exists(path))
				try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
					return (AppState) in.readObject();
				}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new AppState();
	}

	@Override public void salva(AppState state) throws IOException {
		Files.createDirectories(path.getParent());
		try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
			out.writeObject(state);
		}
	}

	@Override public void salvaUnchecked(AppState state) {
		try {
			salva(state);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

}
