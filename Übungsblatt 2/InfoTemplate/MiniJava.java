import java.util.Scanner;

/**
 * Hilfsklasse fuer die Erstellung von Algorithmen im Kurs "Einfuehrung in die Informatik" (Informatik 1).
 * 
 * Die in diesem Projekt enthaltene Dateien InfoTemplate und Minijava werden den Studenten im oben genannten Kurs
 * fuer die Erstellung von Algorithmen zur Verfuegung gestellt. Inhalte der Dateien:
 * 
 *     - MiniJava: Bereitstellung von Lese- und Schreibmethoden zur Vereinfachung selbiger Funktionen.
 *     - InfoTemplate: Hauptklasse zur Erstellung der Alogrithmen. Bietet die Lese- und Schreibmethoden aus MiniJava an
 * 
 * Da es sich nicht um einen Java-Kurs handelt, werden wesentliche Java-spezifische Mechnismen durch MiniJava
 * kaskadiert und koennen somit vereinfacht in InfoTemplate verwendet werden.
 * 
 * @author SSE
 * @since Version 1.0
 * @version 1.0
 *
 */
public class MiniJava {

    /**
     * Ein Scanner zum Einlesen von Benutzereingaben auf der Kommandozeile / Konsole.
     */
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Ausgabe-Texte fuer die Eingabeaufforderungen unterschiedlicher Werte fuer die
     * einzelnen Hilfsmethoden.
     */
    private static final String BOOLEAN_INPUT = "Bitte geben Sie einen Wahrheitswert ein: ";
    private static final String INT_INPUT = "Bitte geben Sie eine ganze Zahl ein: ";
    private static final String DOUBLE_INPUT = "Bitte geben Sie eine Fliesskommazahl ein: ";
    private static final String STRING_INPUT = "Bitte geben Sie einen Text ein: ";
    
    /**
     * Fehlermeldungen fuer fehlerhafte Eingaben fuer die einzelnen Hilfsmethoden.
     */
    private static final String INPUT_ERROR = "Fehlerhafte Eingabe!";
    private static final String BOOLEAN_INPUT_ERROR = INPUT_ERROR
        + "\nDie Eingabe entspricht keinem gueltigen Warheitswert.\n\n";
    private static final String INT_INPUT_ERROR = INPUT_ERROR
        + "\nDie Eingabe entspricht keiner gueltigen ganzen Zahl.\n\n";
    private static final String DOUBLE_INPUT_ERROR = INPUT_ERROR
        + "\nDie Eingabe entspricht keiner gueltigen Fliesskommazahl.\n\n"
        + "Hinweis: Anstatt eines Kommas muss ein Punkt zur Trennung des Vor- und Nachkommaneils"
        + " verwendet werden, bspw. \"3.14159\" (ohne Anfuehrungszeichen).\n\n";
    
    private static final String OUTPUT_ERROR = "Fehlerhafte Ausgabe!"
        + "\nDer uebergebene Wert zur Ausgabe ist leer bzw. nicht definiert.\n\n";

    /**
     * Liest die Eingabe eines Boole'schen Wertes von Kommandozeile ein.
     * Entspricht die Eingabe nicht einem Boole'schen Wert, so wird die Abfrage erneut durchgefuehrt bis die Eingabe
     * korrekt ist.
     * 
     * @return Der Boole'sche Wert, der auf der Kommandzeile eingegeben wurde. 
     */
    public static boolean readBoolean() {
        boolean boolWert = false;
        boolean inputCorrect = false;
        while (!inputCorrect) {
            System.out.print(BOOLEAN_INPUT);
            String input = scanner.nextLine();
            String trimmedInput = input.trim();
            if (trimmedInput.equalsIgnoreCase("true")) {
                boolWert = true;
                inputCorrect = true;
            } else if (trimmedInput.equalsIgnoreCase("false")) {
                inputCorrect = true;
            } else {
                System.out.println(BOOLEAN_INPUT_ERROR);
            }
        }
        return boolWert;
    }
    
    /**
     * Liest die Eingabe eines Integer-Wertes von Kommandozeile ein.
     * Entspricht die Eingabe nicht einem Integer-Wert, so wird die Abfrage erneut durchgefuehrt bis die Eingabe
     * korrekt ist.
     * 
     * @return Der Integer-Wert, der auf der Kommandzeile eingegeben wurde. 
     */
    public static int readInt() {
        int intWert = 0;
        boolean inputCorrect = false;
        while (!inputCorrect) {
            System.out.print(INT_INPUT);
            String input = scanner.nextLine();
            String trimmedInput = input.trim();
            if (trimmedInput.contains(".") || trimmedInput.contains(",")) {
                System.out.println(INT_INPUT_ERROR);
            } else {
                try {
                    intWert = Integer.parseInt(trimmedInput);
                    inputCorrect = true;
                } catch (NumberFormatException nfe) {
                    System.out.println(INT_INPUT_ERROR);
                }
            }
        }
        return intWert;
    }
    
    /**
     * Liest die Eingabe eines Double-Wertes von Kommandozeile ein.
     * Entspricht die Eingabe nicht einem Double-Wert, so wird die Abfrage erneut durchgefuehrt bis die Eingabe
     * korrekt ist.
     * 
     * @return Der Double-Wert, der auf der Kommandzeile eingegeben wurde. 
     */
    public static double readDouble() {
        double doubleWert = 0.0;
        boolean inputCorrect = false;
        while (!inputCorrect) {
            System.out.print(DOUBLE_INPUT);
            String input = scanner.nextLine();
            String trimmedInput = input.trim();
            if (!trimmedInput.contains(".")) {
                System.out.println(DOUBLE_INPUT_ERROR);
            } else {
                try {
                    doubleWert = Double.parseDouble(trimmedInput);
                    inputCorrect = true;
                } catch (NumberFormatException nfe) {
                    System.out.println(DOUBLE_INPUT_ERROR);
                }
            }
        }
        return doubleWert;
    }
    
    /**
     * Liest die Eingabe eines String-Wertes von Kommandozeile ein.
     * Entspricht die Eingabe nicht einem String-Wert, so wird die Abfrage erneut durchgefuehrt bis die Eingabe
     * korrekt ist.
     * 
     * @return Der String-Wert, der auf der Kommandzeile eingegeben wurde. 
     */
    public static String readString() {
        String stringWert = "";
        System.out.print(STRING_INPUT);
        String input = scanner.nextLine();
        stringWert = input.trim();
        return stringWert;
    }
    
    /**
     * Gibt den Text aus dem Uebergabeparameter auf der Kommandozeile / Konsole aus.
     * 
     * @param text Der String-Wert, der auf der Kommandozeile / Konsole ausgegeben werden soll.
     * @param linebreak <code>True</code>, wenn ein Zeilenumbruch nach der Ausgabe erfolgen soll.
     * <code>False</code> in allen anderen Faellen.
     */
    private static void write(String text, boolean linebreak) {
        if (text != null && !text.isEmpty()) {
            String ausgabe = text;
            // Bei Ausgaben von Listen und Feldern, kann somit gesteuert werden, dass dies in einer Zeile erfolgt.
            if (linebreak) {
                ausgabe = ausgabe + "\n";
            }
            System.out.print(ausgabe);
        } else {
            System.out.println(OUTPUT_ERROR);
        }
    }
    
    /**
     * Gibt den Text aus dem Uebergabeparameter auf der Kommandozeile / Konsole aus.
     * 
     * @param text Der String-Wert, der auf der Kommandozeile / Konsole ausgegeben werden soll.
     */
    public static void write(String text) {
        write(text, true);
    }
    
    /**
     * Gibt den Boole'schen Wert aus dem Uebergabeparameter auf der Kommandozeile / Konsole aus.
     * 
     * @param boolWert Der Boole'sche Wert, der auf der Kommandozeile / Konsole ausgegeben werden soll.
     */
    public static void write(boolean boolWert) {
        write("" + boolWert, true);
    }
    
    /**
     * Gibt den Integer-Wert aus dem Uebergabeparameter auf der Kommandozeile / Konsole aus.
     * 
     * @param intWert Der Integer-Wert, der auf der Kommandozeile / Konsole ausgegeben werden soll.
     */
    public static void write(int intWert) {
        write("" + intWert, true);
    }
    
    /**
     * Gibt den Double-Wert aus dem Uebergabeparameter auf der Kommandozeile / Konsole aus.
     * 
     * @param doubleWert Der Double-Wert, der auf der Kommandozeile / Konsole ausgegeben werden soll.
     */
    public static void write(double doubleWert) {
        write("" + doubleWert, true);
    }
}
