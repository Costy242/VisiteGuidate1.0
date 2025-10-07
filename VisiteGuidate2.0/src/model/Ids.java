package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Ids { 
	private static final AtomicInteger SEQ = new AtomicInteger(1);
	
	static String next() { 
		return String.format("ID: %d ", SEQ.getAndIncrement()); 
	} 
	
}
