package it.polito.tdp.totocalcio.model;

//Classe particolare che non ha bisogno di un costruttore
public enum RisultatoPartita {
	UNO, DUE, ICS ; //implementato come enumerazione, contiene un insieme definito di valori 
	
	public static RisultatoPartita valueOf(char c) { //prende come parametro la stringa, se corrisponde a "case", restituisce i vari return 
		switch(c) {
		case '1':
			return RisultatoPartita.UNO ;
		case '2':
			return RisultatoPartita.DUE ;
		case 'X':
		case 'x':
			return RisultatoPartita.ICS ;
		default:
			throw new IllegalArgumentException("Illegal character "+c+" in string") ;				
		}
	}
	
	public String toString() {
		switch(this) {
		case UNO: //quando il valore di questa classe è UNP, retornami 1
			return "1" ;
		case DUE:
			return "2" ;
		case ICS:
			return "X" ;
		}
		return null ;
	}
	
	
}
