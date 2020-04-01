package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {
	
	private Pronostico pronostico ;
	private int N ;
	private List<Risultato> soluzione ;

	public List<Risultato> cerca(Pronostico pronostico) {

		this.pronostico = pronostico ;
		this.N = pronostico.size() ;
		
		List<RisultatoPartita> parziale = new ArrayList<>() ;
		int livello = 0 ;
		
		this.soluzione = new ArrayList<Risultato>() ;
		
		ricorsiva(parziale, livello) ;
		
		return this.soluzione ; 
	
	}
	
	private void ricorsiva(List<RisultatoPartita> parziale, int livello) {
		
		// caso terminale?
		if(livello==N) {
			// questa soluzione parziale è una soluzione completa
			// System.out.println(parziale) ;
			this.soluzione.add(new Risultato(parziale)) ;
		} else {
			//caso generale
			
			// [ parziale da 0 a livello-1 ] [livello] [livello+1 in poi]
			PronosticoPartita pp = pronostico.get(livello) ;
			// pp sono i sotto-problemi da provare
			
			for(RisultatoPartita ris : pp.getRisultati()) {
				// provo a mettere 'ris' nella posizione 'livello'
				// della soluzione parziale

				// costruzione soluzione parziale (sottoproblema) 
				parziale.add(ris) ;
				// chiamata ricorsiva
				ricorsiva(parziale, livello+1);
				// backtracking
				parziale.remove(parziale.size()-1) ;
				
			}
		}
		
		
	}

}

/*
 * Livello = numero di partita che sto considerando
 * le partite da a livello-1 sono già state decise
 * la partita di indice livello la devo decidere io
 * le partite da livello+1 in poi le decideranno le procedure ricorsive sottostanti
 * 
 * Soluzione parziale: un elenco di RisultatoPartita di lunghezza pari
 * al livello. 
 * 
 * Soluzione totale: ho N risultati
 * 
 * Condizione di terminazione: livello == N
 * 
 * Generazione delle soluzioni del livello: provando tutte i pronostici
 * definiti per quel livello.
 * 
 */
/*
[ "2X", "1", "1X2", "12" ]
		
	2	 ?     X      2    []
		
[ "2X" ] + [ "1", "1X2", "12" ]
		   [ "1", "1X2", "12" ]
		   [ "1" ] + [ "1X2", "12" ]
*/