/**
 * Template fuer die Erstellung von Algorithmen im Kurs "Einfuehrung in die Informatik" (Informatik 1).
 * 
 * @author SSE
 * @since Version 1.0
 * @version 1.0
 *
 */
 /**
 * Teilnehmer:
 *     <Paul Conrad>, <358940>
 *     <Marc Palfner>, <359899>
 *     <Patricia Schwarma>, <359551>
 */
public class InfoTemplate extends MiniJava {

    /**
     * Dies ist der Einstiegspunkt in Ihren Algorithmus. Alle Anweisungen innerhalb der geschweiften Klammern
     * werden ausgefuehrt.
     * 
     * WICHTIG: Definieren Sie Ihren Algorithmus ausschliesslich in dem dafuer gekennzeichneten Bereich!
     * 
     * @param args Eine Menge zusaetzlicher Parameter, die beim Aufruf des Programms mit uebergeben werden
     * koennen. Diese Menge ist in der Regel leer und wird nur bei expliziter Nennenung in einer Aufgabenstellung
     * verwendet.
     */
    public static void main(String[] args) {	
        /* >>>> Beginn des Bereichs zur Definition von Algorithmen >>>> */

        int eingabe = readInt();
        int ausgabe;
        if(eingabe > 0) {
            ausgabe = eingabe;
        } else {
            ausgabe = eingabe * -1;
        }
        System.out.println("Der Betrag ist:");
        write(ausgabe);



        /* >>>>  Ende des Bereichs zur Definition von Algorithmen  >>>> */
    }
} 