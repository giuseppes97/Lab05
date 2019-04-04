package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

import java.util.*;
public class Model {
	AnagrammaDAO dao=new AnagrammaDAO();
	String parolainiziale;
List<String> listanagra=new ArrayList<String>();
List<String> listaerrati=new ArrayList<String>();
Map<Character,Integer> lettereparola=new HashMap<Character,Integer>();
public List<String> getAnagrammi(String s) {
	listaerrati.clear();
	lettereparola.clear();
	listanagra.clear();
	parolainiziale=s;
	for(int a=0;a<parolainiziale.length();a++)
	{ 
		if(lettereparola.containsKey(parolainiziale.charAt(a)))
		{int l=lettereparola.get(parolainiziale.charAt(a));
		lettereparola.remove(parolainiziale.charAt(a));
		lettereparola.put(parolainiziale.charAt(a), l+1);
		}
		else {lettereparola.put(parolainiziale.charAt(a), 1);}
	}
	
	
	this.trovaAnagrammiRicorsione(s,0,"");
	
	
	return listanagra;
}

private void trovaAnagrammiRicorsione(String parola, int livello, String parziale ) {
	
	
	if(livello==parola.length()) {
		if(dao.isCorrect(parziale))
		{   if(listanagra.contains(parziale)==false)
			listanagra.add(parziale);}
		else {if(listaerrati.contains(parziale)==false) listaerrati.add(parziale);}
		return;
	}
	 
	for(int j=0;j<parola.length();j++) {
		
		parziale=parziale+parola.charAt(j);
		if(controllaoccorrenze(parziale)) {
		trovaAnagrammiRicorsione(parola,livello+1,parziale);}
		parziale = parziale.substring(0, parziale.length()-1);
	}	
	
}

public boolean controllaoccorrenze(String par) {
	int flag=0;
	Map<Character,Integer> occorrenze=new HashMap<Character,Integer>();
	for(int g=0;g<par.length();g++) {
		if(occorrenze.containsKey(par.charAt(g)))
		{int l=occorrenze.get(par.charAt(g));
		occorrenze.remove(par.charAt(g));
		occorrenze.put(par.charAt(g), l+1);
		}
		else {occorrenze.put(par.charAt(g), 1);}
	}
	for(char c:occorrenze.keySet()) {
		
		if(occorrenze.get(c)>lettereparola.get(c)) {flag=1;}
		
	}
	if(flag==0) {return true;} else return false;
}

public List<String> getErrati() {

	return listaerrati;
}

}
