package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	String parolainiziale;
List<String> listanagra=new ArrayList<String>();

public List<String> getAnagrammi(String s) {
	parolainiziale=s;
	this.trovaAnagrammiRicorsione(s,0,"");
	return listanagra;
}

private void trovaAnagrammiRicorsione(String parola, int livello, String parziale ) {
	
	
	if(livello==parola.length()) {
		listanagra.add(parziale);
		return;
	}
	 
	for(int j=0;j<parola.length();j++) {
		
		parziale=parziale+parola.charAt(j);
		trovaAnagrammiRicorsione(parola,livello+1,parziale);
		parziale = parziale.substring(0, parziale.length()-1);
	}	
	
}

}
