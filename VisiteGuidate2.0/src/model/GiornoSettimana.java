package model;

import java.util.EnumSet;
import java.util.Set;

public enum GiornoSettimana {
	LUN, MAR, MER, GIO, VEN, SAB, DOM;
	
	 public static Set<GiornoSettimana> parseCommaSeparated(String s) {
	        Set<GiornoSettimana> set = EnumSet.noneOf(GiornoSettimana.class);
	        for (String p : s.split(",")) { 
	        	if (p.isBlank()) continue; 
	        	set.add(GiornoSettimana.valueOf(p.trim().toUpperCase())); 
	        }
	        if (set.isEmpty()) throw new IllegalArgumentException("Almeno un giorno");
	        return set;
	    }
	    
}
