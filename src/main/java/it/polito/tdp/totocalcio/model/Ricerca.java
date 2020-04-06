package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

//Classe in cui implemento l'algoritmo di ricerca
public class Ricerca {
	private Pronostico pronostico;
	private int N;
	private List <Risultato> soluzione;

	//Dato un pronostico costruisce una lista di risultati
	//NON e' ancroa questa funzione che fa la ricorsione, ma è quella che si interfaccia verso l'esterno
	public List<Risultato> cerca(Pronostico pronostico) { //Questo metodo rea l'ambiente affinche il metodo ricorsivo poi possa lavorare al meglio
		
		this.pronostico=pronostico;
		this.N=pronostico.size();
		
		//chiamo la funzione ricorsiva
		List<RisultatoPartita> parziale = new ArrayList <>(); //creo una lista esistente, ma vuota
		int livello=0;
		
		this.soluzione= new ArrayList <Risultato>(); //inizializzo una soluzione vuota
		
		ricorsiva(parziale, livello);
		
		return this.soluzione; //array lista che la procedura ricorsiva ha riemptio ogni volta che ha trovato una struttura terminale
	}
	
	//Funzione PRIVATA che fa la ricorsione che riceve come minimo la soluzione parziale e il livello in cui deve andare a lavorare
	private void ricorsiva(List <RisultatoPartita> parziale, int livello) {
		//caso terminale?
		if (livello==N) { //N è la lunghezza del pronostico, quindi questa variabile ricorsiva deve conoscere il pronostico 
			//System.out.println(parziale); //questa soluzione parziale è una soluzione completa
			
			this.soluzione.add(new Risultato(parziale)); //Aggiungo a questa lista di soluzioni un nuovo oggetto risultato che ottengo prendendo la lista parziale
		} else {
			//caso generale
			
			//[parziale da 0 a livello-1] //gia deccisa [livello] //io devo pensare solo al mio livello [livello+1 in poi] //ci pensera qualcun altro a questi
			PronosticoPartita pp=pronostico.get(livello); //[ "2X", "1", "1X2", "12" ] quando viene chiamata a 0 mi da "2X"
			//pp sono i sottoproblemi da provare, per 0, quello che comincia con 2 e quello che comincia con X
			
			for (RisultatoPartita ris: pp.getRisultati()) { //itero sugli elementi del set che mi da getRisultati, che sono dei risultatipartita
				//provo a mettere 'ris' nella posizione livello della soluzione parziale
				
				//Costruzione della soluzione parziale, il sottoproblema
				parziale.add(ris); //ho provato a mettere il primo risultato possibile nella prima posizione del risultato parziale
				
				//chiamata ricorsiva
				ricorsiva(parziale, livello+1); //prendi la soluzione parziale a cui ho aggiunto il mio pezzo, spostati al livello successivo
				
				//backtracking
				parziale.remove(parziale.size()-1); //l'ultimo che ho messo lo tolgo
				
			}
			
		}
			
		
	}
	
	/*
	 * livello della ricorsione = numero di partite che sto considerando
	 * Le partite da a livello-1 sono già state decise
	 * la partita di indice livello la devo decidere io
	 * le partite da livello+1 in poi le decideranno le procedure ricorsive sottostanti
	 * 
	 * Soluzione parziale = elenco di RisultatoPartita di lunghezza pari al livello
	 * 
	 * Soluzione totale: ho N risultati
	 * 
	 * Condizione di terminazione: livello == N
	 * 
	 * Generazione nuove soluzioni del livello: provando tutti i pronostici definiti per quel livello
	 */

}
