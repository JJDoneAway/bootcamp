package de.hoehne.bootcamp;

/**
 * Hier fundest Du nur nur die Basisfunktionalitäten von Java
 * 
 * * Variablen
 * 
 * * Verzweigungen
 * 
 * * Schleifen
 * 
 * ==> Aber keine Objekte
 * 
 * @author jhoehne
 *
 */
public class EinfacheStatischeKlasse {

	public static void main(String[] args) {

		variablenDemo();

		arrayDemo();

		verschachtelteArrays();

		verzweigungsDemo();

		schleifenDemo();

		operatorenDemo();

		exceptionDemo();

		String rueckgabe = methodeMitRueckgabeDemo("hallo", 2);
		System.out.println("Der Rückgabewert der Methode: " + rueckgabe);

	}

	/**
	 * Diese statische Methode zeigt, wie man mit den Java Basistypen variablen
	 * belegt
	 * 
	 * Hier eine Liste mit allen Basistypen, die es in Java derzeit gibt:
	 * 
	 * https://de.wikibooks.org/wiki/Java_Standard:_Primitive_Datentypen
	 * 
	 * Die wichtigsten sind aber int, double, boolean
	 */
	private static void variablenDemo() {
		System.out.println("--------  Variablen -------------");
		// ein basis Integer
		int meinInt = 1;
		// auf der Konsole muss eine 1 erscheinen
		System.out.println(meinInt);
		// man kann mit ihm auch rechnen
		meinInt = (meinInt + 12) * 3;
		// auf der Konsole muss 39 erscheinen
		System.out.println(meinInt);

		// eine Kommazahl
		double meinDouble = 1.2;
		System.out.println(meinDouble);

		// ein boolean
		boolean meinBoolean = true;
		meinBoolean = false;
		System.out.println(meinBoolean);

		// man kann ein kleineres Format immer in das größere umcasten
		byte a = 1;
		short b = (short) a;
		int c = (int) b;
		long d = (long) c;
		float e = (float) d;
		double f = (double) e;
		System.out.println("Ich war mal ein byte: " + f);

		// Buchstaben kann man sich bei den Basistypen nur einzeln merken
		char einBuchstabe = 'A';
		System.out.println("Ich bin ein Char: " + einBuchstabe);

	}

	/**
	 * bei den einfachen Datentypen, gibt es Array mit einer festen
	 * vorzudefinierenden Länge.
	 * 
	 * Das ist eher scheiße, deshalb arbeitet man mit Arrays nur sehr selten
	 */
	private static void arrayDemo() {
		System.out.println("--------  Variablen -------------");
		// definiert ein Array mit integern, in das genau fünf Elemente passen und zwar
		// für immer. Man kann die Größe nachträglich nicht mehr ändern
		int[] i = new int[5];
		System.out.println("Gibt die Speicheradresse aus und nicht den inhalt" + i);
		// einen Wert an die dritte Stelle setzen (es wird von null an gezählt nicht von
		// eins)
		i[2] = 5;
		System.out.println("Das dritte Element " + i[2]);
		System.out.println("Die länge des Arrays: " + i.length);

		// Einen String aufteilen
		String text = "Hallo,wie,geht,es,5";
		String[] meineWerte = text.split(",");
		System.out.println(meineWerte[0]);
		System.out.println(meineWerte[1]);
		System.out.println(meineWerte[2]);
		System.out.println(meineWerte[3]);
		int letzterWert = Integer.parseInt(meineWerte[4]);
		System.out.println("Letzter Wert ist eine Zahl: " + letzterWert);

	}

	/**
	 * Es gibt mehrdimensionale arrays um zum beispiel Matrizen besser abspeichern
	 * zu können
	 */
	private static void verschachtelteArrays() {
		System.out.println("--------  Verzweigungen -------------");
		// 1d array mit fordefinierten Werten
		char[] zeichen = new char[] { ' ', 'x', 'o' };

		// 2d array
		char[][] pos = new char[3][3];
		// per Schleife mit werten belegen
		for (int i = 0; i < pos.length; i++) {
			char[] cs = pos[i];
			for (int j = 0; j < cs.length; j++) {
				cs[j] = zeichen[(i + j) % 3];
			}
		}

		// und nochmal
		for (int i = 0; i < pos.length; i++) {
			char[] cs = pos[i];
			System.out.print("| ");

			for (int j = 0; j < cs.length; j++) {
				char c = cs[j];
				System.out.print(c + " |");
			}

			System.out.println("");
		}

	}

	/**
	 * Bei Verzweigungen kann man das Programm in unterschiedliche Richtungen laufen
	 * lassen: Wenn das dann dies
	 * 
	 * Es gibt in Java zwei verschieden Möglichkeiten:
	 * 
	 * Das if statement (sehr gebräuchlich)
	 * 
	 * Das switch statement (extrem chic aber eher selten)
	 */
	private static void verzweigungsDemo() {
		System.out.println("--------  Verzweigungen -------------");
		// ein normales if
		boolean rechtsIsFrei = true;

		if (rechtsIsFrei) {
			System.out.println("Du kannst fahren");
		} else {
			System.out.println("Es zahlt Deine Versicherung");
		}
		// BTW: es gibt auch noch ein else if. Das macht aber keinen Sinn und ist
		// schlechter Geschmack

		// ein switch ist gut, wenn es viele verzweigungen gibt
		String name = "Johannes";

		switch (name.trim().toLowerCase()) {
		case "frank":
			System.out.println("Du bist der Frank");
			break;
		case "johannes":
			System.out.println("Du bist der Johannes");
			break;
		default:
			System.out.println("Dich kenn ich nicht");
			break;
		}

	}

	/**
	 * es gibt in Java drei verschieden Schleifen
	 * 
	 * die for Schleife (fast immer die richtige Wahl)
	 * 
	 * die while Schleife (schon eher selten)
	 * 
	 * die do while Schleife (sehr selten)
	 */
	private static void schleifenDemo() {
		System.out.println("--------  Schleifen -------------");
		// Die for Schleife gibt es in vielen auspräfungen. Der Standart aber hier
		// in der Klammer stehen drei Argumente (was wird iteriert ; bis wann wird
		// iteriert ; wie ändert sich das was je durchlauf)
		for (int i = 0; i < 5; i++) {
			// BTW i++ ist eine kurze Schreibweise für i = i + 1
			System.out.println("Das ist Durchgang: " + i);
		}

		// die while Schleife durchläuft den Body solange, die Bedingung in der Klammer
		// true ist
		boolean weiterlaufen = true;
		while (weiterlaufen) {
			System.out.println("Ich bin in der while schleife und schalte sie nun ab");
			weiterlaufen = false;
		}

		// die do while Schleife ist eigentlich genauso wie die while Schleife, nur dass
		// sie immer mindestens einmal durchlaufen wird
		weiterlaufen = false;
		do {
			System.out.println("Ich bin in der do while Schleife, obwohl die Bedingung false ist");
		} while (weiterlaufen);

	}

	/**
	 * Es gibt in JAVA die üblichen Operatoren und sie funktionieren auch wie
	 * üblich.
	 * 
	 * Neben den üblichen Operatoren gibt es natürlich noch eine ganze Menge mehr
	 * (e.g.: Bitweises verodern)
	 * 
	 * https://de.wikibooks.org/wiki/Kurzeinstieg_Java:_Operatoren
	 * 
	 * Außerdem gint es noch ein wenig syntaktischen Zucker, der das Leben einfacher
	 * macht
	 */
	private static void operatorenDemo() {
		System.out.println("--------  Operatoren -------------");
		double a = 7;
		double b = 2;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("+: " + (a + b));
		System.out.println("-: " + (a - b));
		System.out.println("*: " + (a * b));
		System.out.println("/: " + (a / b));
		// der Modulo operatore teilt durch die Zahl und gibt den Rest. Das braucht man
		// um zum Beispiel nur die durch zwei teilbaren Zahlen zu bekommen
		System.out.println("%: " + (a % b));

		boolean c = true;
		boolean d = false;
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("!a: " + (!c));
		System.out.println("or: " + (c | d));
		System.out.println("and: " + (c & d));
		// exklusives oder bei der ersten bedingung, die wahr ist, wird die überprüfung
		// abgebrochen
		System.out.println("||: " + (c || d));
		// exklusives und bei der ersten bedingung, die false ist, wird die überprüfung
		// abgebrochen
		System.out.println("&&: " + (c && d));

		char e = 'e';
		char f = 'f';
		System.out.println("Die Summe von zwei Chars ist kein Buchstabe!: " + (e + f));

	}

	/**
	 * Java hat die Möglichkeit Fehler im Programablauf zu fangen und zu behandeln
	 */
	private static void exceptionDemo() {
		System.out.println("--------  Exceptions -------------");
		// durch ein try{}catch(){}final{} kann man einen möglichen Fehler behandeln und
		// weitermachen
		try {
			System.out.println(10 / 0);
			System.out.println("Das hier wird man nie sehen, da man eine Zahl nicht durch 0 teilen kann");
		} catch (ArithmeticException e) {
			System.out.println("Das ist der Fehler, den wir gefangen haben: " + e.getLocalizedMessage());
		} finally {
			System.out.println("Fehler oder nicht, dieser optionale Block wird immer durchlaufen");
		}

	}

	/**
	 * Methoden lagern Programteile aus und können werte zurückgeben
	 * 
	 * Das private bezeichnet die Sichtbarkeit der Methode:
	 * 
	 * private: Kann nur in dieser Klasse aufgerufen werden
	 * 
	 * public : kann von überall aufgerufen werden
	 * 
	 * [leer]: kann aus dem gleichen Packet aufgerufen werden (eher selten)
	 * 
	 * protected: Kann nur von der Klasse und ihren Kindern aufgerufen werden
	 * (wichtig bei Vererbung)
	 * 
	 * 
	 * 
	 * static heißt, dass die Methode zur Klasse gehört und nicht zu einer Instaz
	 * (kommt später)
	 * 
	 * "String" heißt, dass die Methode einen String zurückgibt.
	 * 
	 * in den Klammern stehen die variablen (Argumente), die die Methode zum
	 * arbeiten braucht
	 * 
	 * 
	 * @return
	 */
	private static String methodeMitRueckgabeDemo(String text, int position) {
		System.out.println("--------  Variablen -------------");
		String ergebnis = text.substring(position, position + 1);
		return ergebnis;
	}

}
