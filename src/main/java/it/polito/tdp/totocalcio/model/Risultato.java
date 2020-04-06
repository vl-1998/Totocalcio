package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta il risultato di una singola partita (un valore per ciascuna
 * partita)
 * 
 * @author Fulvio
 *
 */
public class Risultato {

	private List<RisultatoPartita> risultati = new ArrayList<>(); //Il risultato e' un array list dei risultati delle partite

	public Risultato(String colonna) {
		for (int i = 0; i < colonna.length(); i++) {
			risultati.add(RisultatoPartita.valueOf(colonna.charAt(i)));
		}
	}
	
	//Altro costruttore che parte da una lista di RisultatoPartita
	public Risultato (List <RisultatoPartita> lista) {
		risultati.addAll(lista);
	}
	
	public String toString() {
		return this.risultati.toString() ;
	}

}
