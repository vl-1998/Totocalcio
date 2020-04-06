package it.polito.tdp.totocalcio.model;

import java.util.List;

public class TestRicerca {

	//Voglio provare a partire da un pronostico 
	public static void main(String[] args) {
		//dato un pronostico pari a [ "2X", "1", "1X2", "12" ], troviamo tutti i risultati corrispondenti
		
		//HO DEFINITO IL PRONOSTICO
		Pronostico pronostico = new Pronostico();
		pronostico.add(new PronosticoPartita("2X"));
		pronostico.add(new PronosticoPartita("1"));
		pronostico.add(new PronosticoPartita("1X2"));
		pronostico.add(new PronosticoPartita("12"));
		
		System.out.println(pronostico);

		Ricerca r = new Ricerca();
		
		List <Risultato> risultati = r.cerca(pronostico);
		System.out.println(risultati);

		
	}

}
